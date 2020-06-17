package com.bdqn.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;


@Component
public class ActiveMQHelp {
    @Resource
    JmsMessagingTemplate template;

    //queue方法
    public void sentQueue(String title, Object message){
        Queue queue = new ActiveMQQueue(title);
        template.convertAndSend(queue,message);
    }

    //topic方法
    public void sentTopic(String title, Object message){
        Topic topic = new ActiveMQTopic(title);
        template.convertAndSend(topic,message);
    }
}
