package com.bdqn.controller;

import cn.bdqn.RpcQgGoodsTemp;
import cn.bdqn.common.DtoUtil;
import cn.bdqn.common.RedisUtils;
import cn.bdqn.pojo.QgGoods;
import cn.bdqn.pojo.QgUser;
import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bdqn.config.ActiveMQHelp;
import com.bdqn.config.OrderEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.ObjectMessage;

@Controller
@RequestMapping("api")
public class OrderController {
    @Resource
    RedisUtils redisUtils;

    @DubboConsumer
    RpcQgGoodsTemp goodsTemp;

    @Resource
    ActiveMQHelp mqHelp;
    
    
    //下订单接口
    @RequestMapping("/order")
    @ResponseBody
    public synchronized void order(int id, String token) throws Exception {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(id+"");
        orderEntity.setToken(token);

        mqHelp.sentQueue("order",orderEntity);
    }
    @JmsListener(destination = "order")
    public void order(Object jmsObject) throws Exception {
        ObjectMessage message = (ObjectMessage) jmsObject;
        OrderEntity orderEntity = (OrderEntity)message.getObject();

        int id = new Integer(orderEntity.getId());
        String token = orderEntity.getToken();
        while(!redisUtils.setnx("g1","lock")){
            Thread.sleep(1000);
        }


        //去redis中判断token是否存在
        String object = (String)redisUtils.get(token);
        QgUser user = JSONArray.parseObject(object,QgUser.class);
        if(user != null){

            //redis中数量需要-1
            //下了一个订单 redis中产品的数量就得-1个
            QgGoods goods = JSONArray.parseObject((String)redisUtils.get("Good_1"),QgGoods.class);

            if(goods.getCurrentStock() > 0){
                //插入订单表 goodId userId
                goodsTemp.insert(id,new Integer(user.getId()));

                goods.setCurrentStock(goods.getCurrentStock()-1);
                redisUtils.set("Good_1",JSONArray.toJSONString(goods));
                System.out.println(user.getId()+"下订单成功");
            }else{
                redisUtils.nunlock("g1");
                System.out.println(user.getId()+"下订单失败，库存不足");
            }


        }
        redisUtils.nunlock("g1");
        //return DtoUtil.returnFail("登录失败","100000");
    }
}
