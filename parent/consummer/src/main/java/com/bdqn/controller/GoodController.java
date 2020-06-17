package com.bdqn.controller;

import cn.bdqn.RpcQgGoodsService;
import cn.bdqn.common.Dto;
import cn.bdqn.common.DtoUtil;
import cn.bdqn.pojo.QgGoods;
import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("api")
public class GoodController {
    @DubboConsumer
    RpcQgGoodsService qgGoodsService;

    @RequestMapping("/queryGoodsById")
    @ResponseBody
    public Dto<QgGoods> getById(String id, String token, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");

        if(token!=null){
            try {
                QgGoods goods = qgGoodsService.getQgGoodsById(id);
                return DtoUtil.returnDataSuccess(goods);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return DtoUtil.returnFail("没有登录","10000");
    }
}
