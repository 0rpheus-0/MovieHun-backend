package com.vitek.javalabs.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.service.RequestCounterService;

@Service
public class RequestCounterServiceImpl implements RequestCounterService {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void increment() {
        count.incrementAndGet();
    }

    @Override
    public int getCount() {
        return count.get();
    }
}
