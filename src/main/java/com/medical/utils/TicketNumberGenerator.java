package com.medical.utils;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Service
public class TicketNumberGenerator {

    private static final String PREFIX = "TCK";

    public static String generateTicketNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"); // format de la date/heure
        String timestamp = LocalDateTime.now().format(formatter); // ex: 20250730-143015
        return PREFIX + "-" + timestamp + "-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        // ex: TCK-20250730-143015-A9F2
    }

}
