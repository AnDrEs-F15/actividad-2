package com.trad.trad.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class GenerateDateId {
    public static int generateDateId (Date date ){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String dateId = String.valueOf(localDate.getMonth().getValue()) + String.valueOf(localDate.getYear());
        return Integer.parseInt(dateId);
    }
}
