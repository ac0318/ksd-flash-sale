package com.bdqn.controller;

import com.bdqn.config.ActiveMQHelp;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TestMQ {
    @Resource
    ActiveMQHelp mqHelp;

    @RequestMapping("/t1")
    @ResponseBody
    public Object getList(){
        //mqHelp.sentQueue("t1","消息1");
        mqHelp.sentTopic("tt1","消息1");
        return "发送成功";
    }
    @JmsListener(destination = "tt1")
    public void dd3(Object message){
        System.out.println("-----------3333333333开始监听-------------");
        System.out.println("消息"+message);
    }
    @JmsListener(destination = "tt1")
    public void dd4(Object message){
        System.out.println("-----------4444444444开始监听-------------");
        System.out.println("消息"+message);
    }

    @JmsListener(destination = "t1")
    public void dd(Object message){
        System.out.println("-----------1111111111开始监听-------------");
        System.out.println("消息"+message);
    }
    @JmsListener(destination = "t1")
    public void dd2(Object message){
        System.out.println("-----------2222222222开始监听-------------");
        System.out.println("消息"+message);
    }
}
