package com.elina.demo.configs;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

    public static boolean checkTransfer(Date dateDeparture, Date dateArrival, int deltaMin, int deltaMax) {
        Long delta = (dateArrival.getTime() - dateDeparture.getTime()) / (1000 * 60);
        return (delta >= deltaMin && delta <= deltaMax) ? true : false;
    }

    public static Date getNextDay(String dateForNextDay) throws ParseException {
        Date date = parseToDate(dateForNextDay);
        Date newDate = new Date();
        newDate.setTime(date.getTime() + (long) 1000 * 24 * 60 * 60);
        return newDate;
    }

    public static Date getNextDay(Date date) {
        Date newDate = new Date();
        newDate.setTime(date.getTime() + (long) 1000 * 24 * 60 * 60);
        return newDate;
    }

    public static Date parseToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(date);
    }

    public static Date parseToDateTime(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(date);
    }

    public static Date getTodayDateTime() throws ParseException {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        return parseToDateTime(df.format(date));
    }
}
