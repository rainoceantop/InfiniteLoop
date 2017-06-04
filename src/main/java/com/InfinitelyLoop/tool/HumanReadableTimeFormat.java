package com.InfinitelyLoop.tool;

import java.util.Date;

public class HumanReadableTimeFormat {
    private final long ONE_SECOND = 1;
    private final long ONE_MINUTE = ONE_SECOND * 60;
    private final long ONE_HOUR = ONE_MINUTE * 60;
    private final long ONE_DAY = ONE_HOUR * 24;
    private final long ONE_WEEK = ONE_DAY * 7;
    private final long ONE_MONTH = ONE_DAY * 30;
    private final long ONE_YEAR = ONE_DAY * 365;
    private Date d;
    private long sec;
    public String TimeFormatByTimestamp(long timestamp){
        d = new Date();
        sec = (d.getTime() - timestamp)/1000;
        return TimeFormat(sec);
    }
    public String TimeFormatByDate(Date date){
        d = new Date();
        sec = (d.getTime() - date.getTime())/1000;
        return TimeFormat(sec);
    }
    private String TimeFormat(long seconds){
        if(seconds < ONE_MINUTE){
            return seconds + " 秒前";
        }
        else if(seconds < ONE_HOUR){
            return seconds/ONE_MINUTE + " 分钟前";
        }
        else if(seconds < ONE_DAY){
            return seconds/ONE_HOUR + " 小时前";
        }
        else if(seconds < ONE_WEEK){
            return seconds/ONE_DAY + " 天前";
        }
        else if(seconds < ONE_MONTH){
            return seconds/ONE_WEEK + " 周前";
        }
        else if(seconds < ONE_YEAR){
            return seconds/ONE_MONTH + " 个月前";
        }
        else {
            return seconds/ONE_YEAR + " 年前";
        }
    }
}
