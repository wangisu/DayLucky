package com.zaotao.daylucky.app;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.text.format.DateUtils.formatElapsedTime;

/**
 * Description DatabaseUtils
 * Created by wangisu@qq.com on 2019-08-02
 */
@SuppressLint("SimpleDateFormat")
public class DateUtils {

    public static String formatDayText(long time) {
        return new SimpleDateFormat("dd").format(time * 1000);

    }

    public static String[] WEEK_TIMES = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static String[] YEAR_TIMES = {"Jan", "Feb", "Mar", "Apr", "May", "Jun","Jul","Aug","Sept","Oct","Nov","Dec"};

    public static String formatWeekText(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        String[] week = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String weekString = new SimpleDateFormat(week[calendar.get(Calendar.DAY_OF_WEEK) - 1]).format(time * 1000);
        if (weekString.equals("星期日")) {
            weekString = "Sunday";
        } else if (weekString.equals("星期一")) {
            weekString = "Monday";
        } else if (weekString.equals("星期二")) {
            weekString = "Tuesday";
        } else if (weekString.equals("星期三")) {
            weekString = "Wednesday";
        } else if (weekString.equals("星期四")) {
            weekString = "Thursday";
        } else if (weekString.equals("星期五")) {
            weekString = "Friday";
        } else if (weekString.equals("星期六")) {
            weekString = "Saturday";
        }
        return weekString;
    }

    public static String formatMonthText(long time) {
        String monthString = new SimpleDateFormat("MM").format(time * 1000);
        if (monthString.equals("01")) {
            monthString = "January";
        } else if (monthString.equals("02")) {
            monthString = "February";
        } else if (monthString.equals("03")) {
            monthString = "March";
        } else if (monthString.equals("04")) {
            monthString = "April";
        } else if (monthString.equals("05")) {
            monthString = "May";
        } else if (monthString.equals("06")) {
            monthString = "June";
        } else if (monthString.equals("07")) {
            monthString = "July";
        } else if (monthString.equals("08")) {
            monthString = "August";
        } else if (monthString.equals("09")) {
            monthString = "September";
        } else if (monthString.equals("10")) {
            monthString = "October";
        } else if (monthString.equals("11")) {
            monthString = "November";
        } else if (monthString.equals("12")) {
            monthString = "December";
        }
        return monthString;
    }

    public static int formatCurrentDay(long currentTimeMillis) {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(new Date(currentTimeMillis));
        int currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);
        return currentDay;
    }
}
