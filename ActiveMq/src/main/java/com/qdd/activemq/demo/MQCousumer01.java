package com.qdd.activemq.demo;

import javax.jms.*;

import com.qdd.activemq.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * <p>
 * MQCousumer01 订阅-发布模式 订阅者01
 * <p>
 */
@Slf4j
public class MQCousumer01 {

    public static void main(String[] args) {
        // 连接工厂
        ConnectionFactory factory;
        // 连接实例
        Connection connection = null;
        // 收发的线程实例
        Session session;
        // 消息发送目标地址
        Destination destination;
        try {
            // 实例化连接工厂
            factory = new ActiveMQConnectionFactory(Constants.MQ_NAME, Constants.MQ_PASSWORD, Constants.MQ_BROKETURL);
            // 获取连接实例
            connection = factory.createConnection();
            // 启动连接
            connection.start();
            // 创建接收或发送的线程实例
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建队列（返回一个消息目的地）
            destination = session.createTopic("FirstTopic");
            // 创建消息订阅者
            MessageConsumer consumer = session.createConsumer(destination);
            // 消息发布者添加监听器
            consumer.setMessageListener(new Listerner01());
//            TextMessage message = (TextMessage) consumer.receive(1000);
//            if (null != message) {
//                System.out.println("订阅1收到消息" + message.getText());
//            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}