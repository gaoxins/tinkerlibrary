package com.tinkerlibrary.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zxh on 2016/12/17.
 */

public class TimeUtils {
    public static Date curDate;//系统日期
    /**
     * 获取当前系统时间
     * @return
     */
    public static String time (){
        String strTime="";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
        curDate = new Date(System.currentTimeMillis());
        strTime = formatter.format(curDate);// 获取当前时间
        return  strTime;
    }
}
