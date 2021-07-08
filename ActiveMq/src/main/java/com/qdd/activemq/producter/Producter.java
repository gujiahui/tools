package com.qdd.activemq.producter;

import com.qdd.activemq.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
@Slf4j
public class Producter {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String msg){
        try{
            Destination destination = new ActiveMQQueue("active-queue");
            //使用JmsTemplate对象发送消息。
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    //创建一个消息对象并返回
                    MapMessage mapMessage=session.createMapMessage();
                    mapMessage.setString("msg", msg);
                    return mapMessage;
                }
            });
        }catch (Exception e){
            log.error("msg:"+msg+",sendAuthMessage-----ERROR---errorMsg:"+e.getMessage());
        }
    }

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
            // 创建接收或发送的线程实例（创建session的时候定义是否要启用事务，且事务类型是Auto_ACKNOWLEDGE也就是消费者成功在Listern中获得消息返回时，会话自动确定用户收到消息）
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建队列（返回一个消息目的地）
            destination = session.createTopic("test-topic");
            // 创建消息发布者
            MessageProducer producer = session.createProducer(destination);
            // 创建TextMessage消息
            MapMessage message = session.createMapMessage();
            message.setString("msg", "第一条topic");
            // 发布消息
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
