package com.InfinitelyLoop.tool;

public class humanReadableTimeFormat {
    private final long ONE_SECOND = 1;
    private final long ONE_MINUTE = ONE_SECOND * 60;
    private final long ONE_HOUR = ONE_MINUTE * 60;
    private final long ONE_DAY = ONE_HOUR * 24;
    private final long ONE_WEEK = ONE_DAY * 7;
    private final long ONE_MONTH = ONE_DAY * 30;
    private final long ONE_YEAR = ONE_DAY * 365;
    public String TimeFormat(long seconds) {
        seconds = seconds/1000;
        if(seconds < ONE_MINUTE){
            return seconds + (seconds > 1 ? " seconds ago" : " second ago");
        }
        else if(seconds < ONE_HOUR){
            return seconds/ONE_MINUTE + (seconds/ONE_MINUTE > 1 ? " minutes ago" : " minute ago");
        }
        else if(seconds < ONE_DAY){
            return seconds/ONE_HOUR + (seconds/ONE_HOUR > 1 ? " hours ago" : " hour ago");
        }
        else if(seconds < ONE_WEEK){
            return seconds/ONE_DAY + (seconds/ONE_DAY > 1 ? " days ago" : " day ago");
        }
        else if(seconds < ONE_MONTH){
            return seconds/ONE_WEEK + (seconds/ONE_WEEK > 1 ? " weeks ago" : " week ago");
        }
        else if(seconds < ONE_YEAR){
            return seconds/ONE_MONTH + (seconds/ONE_MONTH > 1 ? " months ago" : " month ago");
        }
        else {
            return seconds/ONE_YEAR + (seconds/ONE_YEAR > 1 ? " years ago" : " year ago");
        }
    }
}
