package com.qdd.scheduledtest.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@Slf4j
public class Timer {

    private static  int count1=0;
    private static  int count2=0;
    private static  int count3=0;
    private static  int count4=0;

    /**
     * 根据corn表达式执行
     */
    @Scheduled(cron = "10 * * * * ?")
    @Async("asyncExecutor")// 使用asyncExecutor方法创建的线程池
    public void timer() throws InterruptedException{
        long start = System.currentTimeMillis();
//        count1=count1+1;
//        log.info("cron定时任务执行次数："+count1);
        // 使用线程sleep来模拟此方法运行时所需时间(为了更加直观的进行说明,这里定的时间较大)
//        Thread.sleep(6000);
        Calendar calendar = Calendar.getInstance();
        System.out.println("One>>>" + calendar.get(Calendar.MINUTE) + "分"
                + calendar.get(Calendar.SECOND) + "秒");
        long end = System.currentTimeMillis();
        System.out.println("耗时---------------" + (end - start) + "毫秒\n");
    }

    /**
     * 定时计划Two
     */
    @Scheduled(cron = "0/5 * * * * ?")
    @Async("asyncExecutor") // 使用asyncExecutor方法创建的线程池
    public void scheduledTestTwo() {
        long start = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        System.out.println("Two>>>" + calendar.get(Calendar.MINUTE) + "分"
                + calendar.get(Calendar.SECOND) + "秒");
        long end = System.currentTimeMillis();
        System.out.println("耗时---------------" + (end - start) + "毫秒\n");
    }
    /**
     * 相隔两秒执行一次
     */
//    @Scheduled(fixedRate  = 2000)
    public void fixedRate (){
        count2=count2+1;
        log.info("fixedRate定时任务执行次数："+count2);
    }


    /**
     * 上次执行后3秒开始
     */
//    @Scheduled(fixedDelay=3000)
    public void fixedDelay(){
        count3=count3+1;
        log.info("fixedDelay定时任务执行次数："+count3);
    }


    /**
     * 第一次执行延迟1秒，执行完毕时间点3秒执行
     */
//    @Scheduled(initialDelay=1000, fixedDelay=3000)
    public void initialDelay(){
        count4=count4+1;
        log.info("initialDelay定时任务执行次数："+count4);
    }
}
