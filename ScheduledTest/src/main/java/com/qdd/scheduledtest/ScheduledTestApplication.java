package com.qdd.scheduledtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduledTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledTestApplication.class, args);
    }

}
