package com.deividsantos.challenge;

import com.deividsantos.challenge.service.EventService;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SalesMain {

    public static void main(String[] args) {
        try {
            EventService.watchAlreadyExistentFiles();
            Executors.newSingleThreadScheduledExecutor()
                    .scheduleAtFixedRate(EventService::watchModifications, 0, 50, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
