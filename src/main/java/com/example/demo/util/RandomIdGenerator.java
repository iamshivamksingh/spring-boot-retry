package com.example.demo.util;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sksingh created on 01/02/24
 */
public class RandomIdGenerator {

    private static final String ELEMENTS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int MULTIPLY_FACTOR = 10_000;
    private static final AtomicLong SEQ_COUNTER = new AtomicLong();

    public static String getRandomId(int length) {
        StringBuilder sb = new StringBuilder();

        long n = uniqueId();
        while (n > 0 && sb.length() < length) {
            sb.append(ELEMENTS.charAt((int) (n % 62)));
            n /= 62;
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();
        while (sb.length() < length) {
            sb.append(ELEMENTS.charAt(random.nextInt(ELEMENTS.length())));
        }

        return sb.toString();
    }

    private static long uniqueId() {
        long ts = Instant.now().toEpochMilli();
        long sequence = SEQ_COUNTER.getAndIncrement();
        int randomFactor = ThreadLocalRandom.current().nextInt(1, MULTIPLY_FACTOR);

        return (ts * randomFactor) + sequence;
    }
}
