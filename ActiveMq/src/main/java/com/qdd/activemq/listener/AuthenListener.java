package com.qdd.activemq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.MapMessage;

@Component
@Slf4j
public class AuthenListener {

    @JmsListener(destination = "active-queue",concurrency = "2") // 监听login-queue队列
    public void receiveQueue(MapMessage msg) {
        try{
            String message = msg.getString("msg");
            log.error("Login_Message_Received-------message: " + message);
        }catch (Exception e){
            log.error("Queue---ERROR---MSG:"+e.getMessage());
        }
    }

}
