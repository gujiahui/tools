package com.qdd.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/**
 * @author gjh
 */
@Configuration
public class BeanConfig {

    @Value(value = "${spring.activemq.broker-url}")
    private String brokerUrl;
    @Value(value = "${spring.activemq.username}")
    private String mqUserName;
    @Value(value = "${spring.activemq.password}")
    private String mqPassword;

    //定义存放消息的队列
//    @Bean
//    public Queue queue() {
//        return new ActiveMQQueue("login-queue");
//    }

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUserName(mqUserName);
        connectionFactory.setPassword(mqPassword);
        return connectionFactory;
    }

    @Bean
    public JmsTemplate genJmsTemplate() {
        return new JmsTemplate(connectionFactory());
    }

    @Bean
    public JmsMessagingTemplate jmsMessageTemplate() {
        return new JmsMessagingTemplate(connectionFactory());
    }
}