package com.example.demo.service;

import com.example.demo.exception.NonRetryableException;
import com.example.demo.exception.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sksingh created on 21/11/23
 */
@Slf4j
@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    @Retryable(
            retryFor = {RuntimeException.class},
            noRetryFor = {NonRetryableException.class},
            maxAttempts = 3,
            backoff = @Backoff(random = true, delay = 500, maxDelay = 5000, multiplier = 3)
    )
    public String sayIt() {
        log.info("SayIt executed by: {}, time: {}", Thread.currentThread().getName(), Instant.now().toEpochMilli());

        int i = ThreadLocalRandom.current().nextInt(1, 10);

        if (i % 2 == 0) {
            log.error("Even Number");
            throw new NonRetryableException();
        } else {
            log.error("Odd Number");
            throw new RetryableException();
        }
    }
}
