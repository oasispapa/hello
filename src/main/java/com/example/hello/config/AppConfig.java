package com.example.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfig {

    @Bean("async-thread")
    public Executor asyncThread() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setMaxPoolSize(100);
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setQueueCapacity(10);
        threadPoolExecutor.setThreadNamePrefix("Async-");
        return threadPoolExecutor;
    }

}
