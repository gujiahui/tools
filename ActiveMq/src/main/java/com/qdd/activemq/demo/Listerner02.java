package com.qdd.activemq.demo;

import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * <p>
 * Listerner02 订阅者02的监听器
 * <p>
 */
@Slf4j
public class Listerner02 implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("订阅者02接收到消息："+((TextMessage)message).getText());
            log.info("订阅者02接收到消息：" + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}