package com.sysco.brakes.qe.webui.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String getCurrentDateTime() {
        LocalDateTime currentUtcTime = LocalDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH:mm");
        return currentUtcTime.format(formatter);
    }

    public static String getCurrentMonth(){
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        return now.format(formatter);
    }

    public static String getCurrentYear(){
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm");
        return now.format(formatter);
    }
}