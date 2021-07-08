package com.qdd.activemq.demo;

import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * <p>
 * Listerner01 订阅者01的监听器
 * <p>
 */
@Slf4j
public class Listerner01 implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("订阅者01接收到消息：" + ((TextMessage)message).getText());
            log.info("订阅者01接收到消息：" + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}