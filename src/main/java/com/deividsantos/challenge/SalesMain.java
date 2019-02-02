package com.deividsantos.challenge;

import com.deividsantos.challenge.service.EventService;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SalesMain {

    public static void main(String[] args) {
        EventService eventService = new EventService();
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(eventService::watch, 0, 100, TimeUnit.MILLISECONDS);
    }
}
