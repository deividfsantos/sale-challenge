package com.deividsantos.challenge;

import com.deividsantos.challenge.service.EventService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SalesMain {

    private static final Logger logger = LogManager.getLogger(SalesMain.class);

    public static void main(String[] args) {
        try {
            EventService.processAlreadyExistentFiles();
            Executors.newSingleThreadScheduledExecutor()
                    .scheduleAtFixedRate(EventService::processModifications, 0, 50, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            logger.error("There was an error processing the files.", e);
        }
    }
}
