package com.example.hello.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncService {

    @Async("async-thread")
    public CompletableFuture run() {
        return new AsyncResult(hello()).completable();
    }

    //@Async
    public String hello() {
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
                log.info("thread sleeping ......... ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "Async Service Hello";
    }
}
