package com.bdqn.biz;

import cn.bdqn.common.RedisUtils;
import cn.bdqn.mapper.QgGoodsMapper;
import cn.bdqn.pojo.QgGoods;
import com.alibaba.fastjson.JSONArray;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.Resource;

@Configuration
public class InsertGood implements ApplicationListener<ContextRefreshedEvent> {
    @Resource
    QgGoodsMapper goodsMapper;
    @Resource
    RedisUtils redisUtils;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            QgGoods goods = goodsMapper.getQgGoodsById("1");
            redisUtils.set("Good_1", JSONArray.toJSONString(goods));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
