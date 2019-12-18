package com.liuyq.utils.util;


import com.liuyq.utils.exception.BussinessRuntimeException;

import java.security.InvalidParameterException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Title: 时间公用类
 */
public class DateUtil {

    /**
     * 日期格式:yyyy-MM-dd HH:mm:ss
     */
    public static final DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 日期格式:yyyyMMddHHmmss
     */
    public static final DateFormat ymdhmsNoPFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     * 日期格式:yyyy-MM-dd HH:mm
     */
    public static final DateFormat ymdhmFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    /**
     * 日期格式:yyyy-MM-dd
     */
    public static final DateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 日期格式:yyyyMMdd
     */
    public static final DateFormat ymdNoPFormat = new SimpleDateFormat("yyyyMMdd");
    /**
     * 日期格式:yyyy-MM
     */
    public static final DateFormat ymFormat = new SimpleDateFormat("yyyy-MM");
    /**
     * 日期格式:yyyyMM
     */
    public static final DateFormat ymNoPFormat = new SimpleDateFormat("yyyyMM");
    /**
     * 日期格式:yyyy
     */
    public static final DateFormat yFormat = new SimpleDateFormat("yyyy");
    /**
     * 日期格式:MM
     */
    public static final DateFormat mFormat = new SimpleDateFormat("MM");
    /**
     * 日期格式:HH
     */
    public static final DateFormat hFormat = new SimpleDateFormat("HH");
    /**
     * 日期格式:mm
     */
    public static final DateFormat mmFormat = new SimpleDateFormat("mm");
    /**
     * 日期格式:HH:mm:ss
     */
    public static final DateFormat hmsFormat = new SimpleDateFormat("HH:mm:ss");
    /**
     * 日期格式:HHmmss
     */
    public static final DateFormat ymdhmsFormatWithCn = new SimpleDateFormat("yyyy年MM月dd日");
    /**
     * 日期格式:HHmmss
     */
    public static final DateFormat hmsNoPFormat = new SimpleDateFormat("HHmmss");
    /**
     * 比较系数：天
     */
    public static final long coefficient_D = 24 * 60 * 60 * 1000;
    /**
     * 比较系数：小时
     */
    public static final long coefficient_H = 60 * 60 * 1000;
    /**
     * 比较系数：分钟
     */
    public static final long coefficient_m = 60 * 1000;
    /**
     * 比较系数：秒
     */
    public static final long coefficient_s = 1000;
    /**
     * 周期：年
     */
    public static final int cycle_y = Calendar.DAY_OF_YEAR;
    /**
     * 周期：月
     */
    public static final int cycle_m = Calendar.DAY_OF_MONTH;
    /**
     * 周期：周
     */
    public static final int cycle_w = Calendar.DAY_OF_WEEK;

    private static final long MILLIS_IN_A_SECOND = 1000;

    private static final long SECONDS_IN_A_MINUTE = 60;

    private static final long MINUTES_IN_AN_HOUR = 60;

    private static final long HOURS_IN_A_DAY = 24;

    /**
     * 构建日期
     *
     * @param year      年份
     * @param month     月份
     * @param date      日期
     * @param hourOfDay 小时
     * @param minute    分钟
     * @param second    秒
     * @return 构建后的日期时间
     */
    public static Date buildDate(int year, int month, int date, int hourOfDay, int minute, int second) {
        Calendar gg = new GregorianCalendar(year, month - 1, date, hourOfDay, minute, second);// 用来设置 MONTH 日历字段的值。Month 值是基于 0 的。例如，0 表示 //
        // January
        return gg.getTime();
    }

    /**
     * 将标准格式的字符串转化为日期
     *
     * @param stringDate 标准规格的字符串
     * @param format     格式化标准,参考日期格式
     * @return 转换后的日期
     * @throws ParseException
     */
    public static Date string2Date(String stringDate, DateFormat format) {
        if (stringDate == null || format == null) {
            throw new BussinessRuntimeException("日期或格式不能为空！");
        }
        try {
            return format.parse(stringDate);
        } catch (ParseException e) {
            throw new BussinessRuntimeException(e);
        }
    }

    /**
     * 将日期转换为标准格式的字符串输出
     *
     * @param date   需要转换的日期
     * @param format 格式化标准,参考日期格式
     * @return 日期格式化为字符串
     */
    public static String dateToString(Date date, DateFormat format) {
        if (date == null || format == null) {
            throw new BussinessRuntimeException("日期或格式不能为空！");
        }
        return format.format(date);
    }

    public static String formatString(Date date) {
        if (date == null)
            return null;
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    /**
     * 日期比较
     *
     * @param startDate   起始日期
     * @param endDate     结束日期
     * @param coefficient 比较系数（天，小时，秒），参考比较系数//不满24小时的按照0天算
     * @return 获得比较后的天，小时或秒
     */
    public static long compare(Date startDate, Date endDate, long coefficient) {
        Long num1 = startDate.getTime();
        Long num2 = endDate.getTime();
        return ((num2 - num1) / coefficient);
    }

    /**
     * 日期比较
     *
     * @param str1        字符串1日期
     * @param str1Format  字符串1日期格式化标准,参考日期格式
     * @param str2        字符串2日期
     * @param str2Format  字符串2日期格式化标准,参考日期格式
     * @param coefficient 比较系数，参考比较系数
     * @return 比较之后的值
     */
    public static long compare(String str1, DateFormat str1Format, String str2, DateFormat str2Format, long coefficient) {
        Date one = null;
        Date two = null;
        one = string2Date(str1, str1Format);
        two = string2Date(str2, str2Format);
        return compare(one, two, coefficient);
    }

    /**
     * 日期比较
     *
     * @param str1        字符串1日期
     * @param str2        字符串2日期
     * @param format      字符串日期格式化标准,参考日期格式
     * @param coefficient 比较系数，参考比较系数
     * @return 日期比较之后的数值
     */
    public static long compare(String str1, String str2, DateFormat format, long coefficient) {
        return compare(str1, format, str2, format, coefficient);
    }

    /**
     * 判断当前时间是否在其实和终止之间段之间
     *
     * @param start 起始时间
     * @param end   结束时间
     * @return 在两个时间中间的话返回true, 否则返回false
     */
    public static boolean isPeriod(Date start, Date end) {
        return start.getTime() <= System.currentTimeMillis() && end.getTime() >= System.currentTimeMillis();
    }

    /**
     * 通过date。getTime()的值反推出日期
     * <p>
     * <pre>
     * 1970 年 1 月 1 日 00:00:00 GMT 以后 time 毫秒的时间点。
     * </pre>
     *
     * @param time 长整型时间
     * @return 实际时间
     */
    public static Date getDate(long time) {
        Date d = new Date();
        d.setTime(time);
        return d;
    }

    /**
     * 日期加减
     *
     * @param date        基准日期
     * @param coefficient 计算系数
     * @param num         实际天，小时，分钟，秒
     * @return 计算后的日期
     */
    public static Date sumDate(Date date, long coefficient, int num) {
        return getDate(date.getTime() + coefficient * num);
    }


    /**
     * 输入：时间或日期， 周期：年，月，周，天数：第几天
     *
     * @param date
     * @param cycleType
     * @param days
     * @return
     */
    public static Date getCycleData(Date date, int cycleType, int days) {
        if (days <= 0) {
            throw new BussinessRuntimeException("天数必须大于0");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(cycleType, days);
        return calendar.getTime();
    }

    /**
     * 获得指定日期之后一段时期的日期。例如某日期之后3天的日期等。
     *
     * @param date      基准日期
     * @param cycleType 时间单位，如年、月、日等。用Calendar中的常量代表,Calendar.DATE这种常量
     * @param amount    时间周期数量
     * @return 指定日期之后的日期
     */

    public static Date dateAfter(Date date, int cycleType, int amount) {
        if (amount < 0) {
            throw new BussinessRuntimeException("时间周期数量必须大于0");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(cycleType, amount);
        return calendar.getTime();
    }

    /**
     * 获得指定日期之前一段时期的日期。例如某日期之前3天的日期等。
     *
     * @param date      基准日期
     * @param amount    时间周期数量
     * @param cycleType 时间单位，如年、月、日等。用Calendar中的常量代表
     * @return 指定日期之前的日期
     */

    public static Date dateBefore(Date date, int cycleType, int amount) {
        if (amount <= 0) {
            throw new BussinessRuntimeException("时间周期数量必须大于0");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(cycleType, -amount);
        return calendar.getTime();
    }

    /**
     * 获取周期内天数
     *
     * @param date
     * @param cycleType
     * @return 当前时间在某周期内的天数
     */
    public static int getCycleDays(Date date, int cycleType) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(DateUtil.cycle_y, Calendar.DAY_OF_YEAR);
        m.put(DateUtil.cycle_m, Calendar.DAY_OF_MONTH);
        m.put(DateUtil.cycle_w, Calendar.DAY_OF_WEEK);
        if (m.get(cycleType) == null) {
            throw new BussinessRuntimeException("周期设置错误！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(m.get(cycleType));
    }

    /**
     * 把日期后的时间归0 变成(yyyy-MM-dd 00:00:00:000)
     *
     * @param fullDate
     * @return
     */
    public static Date zeroConvertTime(Date fullDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fullDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 将日期后的时间填满 变成(yyyy-MM-dd 23:59:59:999)
     *
     * @param fullDate
     * @return
     */
    public static Date totalConvertTime(Date fullDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fullDate);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 将日期后的时间填满，出来毫秒值 变成(yyyy-MM-dd 23:59:59:000)
     *
     * @param fullDate
     * @return
     */
    public static Date totalConvertTimeWithoutMillisecond(Date fullDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fullDate);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 000);
        return cal.getTime();
    }

    /**
     * 日期转星期
     *
     * @param date
     * @return
     */
    public static String dateToWeek(Date date) {
        String[] weekarr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return weekarr[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }

    /**
     * 取得两个日期之间的所有日期 beginDate:开始日期 endDate : 结束日期
     */
    public static String[] getDateArray(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null) {
            return null;
        }
        if (beginDate.getTime() == endDate.getTime()) {
            return new String[]{dateToString(getDate(beginDate.getTime()),
                    ymdFormat)};
        }
        if (beginDate.getTime() > endDate.getTime()) {
            Date temp = beginDate;
            beginDate = endDate;
            endDate = temp;
        }
        List list = new ArrayList();
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(beginDate);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endDate);

        while (calBegin.getTimeInMillis() <= calEnd.getTimeInMillis()) {
            list.add(dateToString(calBegin.getTime(), ymdFormat));
            calBegin.add(Calendar.DAY_OF_YEAR, 1);
        }

        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
     * 获得当前系统时间的0时0分0秒000
     *
     * @return
     */
    public static Date getSystemDate() {
        return new Date(System.currentTimeMillis() / 86400000 * 86400000 - (23 - Calendar.ZONE_OFFSET) * 3600000);
    }

    /**
     * 判断两个日期是否为同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1 , Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }

    /**
     * 计算两个date的时间差，精确到分
     * @param date1
     * @param date2
     * @return
     */
    public static long getTimeDifference(Date date1 , Date date2){
        long diff = date2.getTime() - date1.getTime();
        long mins = diff / (1000 * 60);
        return mins;
    }




    /**
     * 判断date1是否在date2之后，忽略时间部分
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDateAfter(Date date1, Date date2) {
        Date theDate1 = org.apache.commons.lang3.time.DateUtils.truncate(date1, Calendar.DATE);
        Date theDate2 = org.apache.commons.lang3.time.DateUtils.truncate(date2, Calendar.DATE);
        return theDate1.after(theDate2);
    }

    /**
     * @param @param  date1
     * @param @param  date2
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     * @Title: isAfter
     * @Description: 判断date1是否晚于date2
     */
    public static boolean isAfter(Date date1, Date date2) {
        Calendar calendar1 = new GregorianCalendar();
        calendar1.setTime(date1);
        Calendar calendar2 = new GregorianCalendar();
        calendar2.setTime(date2);
        return calendar1.after(calendar2);
    }

    /**
     * 计算两个日期（不包括时间）之间相差的周年数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getYearDiff(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new InvalidParameterException("date1 and date2 cannot be null!");
        }
        if (date1.after(date2)) {
            throw new InvalidParameterException("date1 cannot be after date2!");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int year1 = calendar.get(Calendar.YEAR);
        int month1 = calendar.get(Calendar.MONTH);
        int day1 = calendar.get(Calendar.DATE);
        calendar.setTime(date2);
        int year2 = calendar.get(Calendar.YEAR);
        int month2 = calendar.get(Calendar.MONTH);
        int day2 = calendar.get(Calendar.DATE);
        int result = year2 - year1;
        if (month2 >= month1) {
            result++;
        }
        return result;
    }

    /**
     * 统计两个日期之间包含的天数。包含date1，但不包含date2
     *
     * @param date1
     * @param date2
     * @return
     */

    public static int getDayDiff(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new InvalidParameterException("date1 and date2 cannot be null!");

        }
        Date startDate = org.apache.commons.lang3.time.DateUtils.truncate(date1, Calendar.DATE);
        Date endDate = org.apache.commons.lang3.time.DateUtils.truncate(date2, Calendar.DATE);
        if (startDate.after(endDate)) {
            throw new InvalidParameterException("date1 cannot be after date2!");
        }
        long millSecondsInOneDay = HOURS_IN_A_DAY * MINUTES_IN_AN_HOUR * SECONDS_IN_A_MINUTE * MILLIS_IN_A_SECOND;
        return (int) ((endDate.getTime() - startDate.getTime()) / millSecondsInOneDay);
    }

    /**
     * 算两段日期中间相隔的自然天。
     * @param startTime
     * @param endTime
     * @return
     */
    public static long daysBetween(Date startTime, Date endTime) {
        if(startTime == null || endTime == null){
            throw new RuntimeException("日期或格式不能为空！");
        }
        Date startDate = DateUtil.zeroConvertTime(startTime);
        Date endDate = DateUtil.zeroConvertTime(endTime);
        return DateUtil.compare(startDate, endDate, coefficient_D) + 1;
    }

    /****
     * 店铺时间显示
     *
     * @param date
     * @return
     */
    public static String getTimeDiff(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int Cmonth = 1 + cal.get(Calendar.MONTH);//获取月份
        int Cday = cal.get(Calendar.DATE);//获取日
        Date start = date;
        Date end = new Date();
        long between = (end.getTime() - start.getTime()) / 1000;//除以1000是为了转换成秒
        long day = between / (24 * 3600);
        long hour = between % (24 * 3600) / 3600;
        long minute = between % 3600 / 60;
        long second = between;
//		System.out.println(""+day+"天"+hour+"小时"+minute+"分"+second+"秒");
        String timediff = "";
        if (day > 0) {
            if (day > 5) {
                String datstr = Cday > 9 ? String.valueOf(Cday) : "0" + Cday;
                String monthstr = Cmonth > 9 ? String.valueOf(Cmonth) : "0" + Cmonth;
                timediff = monthstr + "-" + datstr;
            } else {
                timediff = day + "天前";
            }
        } else if (hour > 0) {
            timediff = hour + "小时前";
        } else if (minute > 0) {
            timediff = minute + "分钟前";
        } else if (second > 0) {
            timediff = second + "秒前";
        } else {
            timediff = "1秒前";
        }
        return timediff;
    }

    /**
     * 获取凌晨时间
     *
     * @return
     */
    public static Date getEarlyMorning() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 取得指定天数之后的某天日期
     *
     * @param date
     * @param dayCnt
     * @return
     */
    public static Date getAfterDays(Date date, int dayCnt) {
        return org.apache.commons.lang3.time.DateUtils.addDays(date, dayCnt);
    }

    /**
     * 返回时间格式：12-15 15:30
     *
     * @param date
     * @return
     */
    public static String getDateAndTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int Cmonth = 1 + cal.get(Calendar.MONTH);// 获取月份
        int Cday = cal.get(Calendar.DATE);// 获取日
        int Chour = cal.get(Calendar.HOUR_OF_DAY);// 获取小时
        int Cminute = cal.get(Calendar.MINUTE);
        String timeStr = "";
        String datStr = Cday > 9 ? String.valueOf(Cday) : "0" + Cday;
        String monthStr = Cmonth > 9 ? String.valueOf(Cmonth) : "0" + Cmonth;
        String hourStr = Chour > 9 ? String.valueOf(Chour) : "0" + Chour;
        String minuteStr = Cminute > 9 ? String.valueOf(Cminute) : "0" + Cminute;
        timeStr = monthStr + "-" + datStr + " " + hourStr + ":" + minuteStr;
        return timeStr;
    }
}
