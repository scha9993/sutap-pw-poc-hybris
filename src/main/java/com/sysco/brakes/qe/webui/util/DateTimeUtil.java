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

    public static String getCurrentMonth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        return LocalDateTime.now(ZoneOffset.UTC).format(formatter);
    }

    public static String getCurrentYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        return LocalDateTime.now(ZoneOffset.UTC).format(formatter);
    }
}