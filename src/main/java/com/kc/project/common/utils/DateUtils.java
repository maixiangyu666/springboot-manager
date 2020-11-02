package com.kc.project.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理
 * @author:mxy
 * @date 2020年3月18日
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /** 时间格式(yyyyMMdd) */
    public final static String DATEPATTERN = "yyyyMMdd";

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 获取YYYY-MM-SS格式的时间戳
     * @return
     */
    public static String getNowDate(){
        String date = format(new Date(), DATE_TIME_PATTERN);
        return date;
    }
}
