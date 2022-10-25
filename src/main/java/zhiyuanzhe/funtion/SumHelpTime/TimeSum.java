package zhiyuanzhe.funtion.SumHelpTime;

import zhiyuanzhe.pojo.ActiveInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 时间管理类
 * **/
public class TimeSum {
    /***
     * 活动时间段计算
     */
    public int activeTime(ActiveInfo activeInfo) throws ParseException {
        //获取活动开始时间
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        //获取活动开始时间转为Long
        Long startTime=df.parse(activeInfo.getActiveStartTime()).getTime();
        //获取活动结束时间
        Long endTime=df.parse(activeInfo.getActiveEndTime()).getTime();
        //进行时间段计算(转为小时)
        int activeTime = (int) (endTime-startTime)/3600000;
        return activeTime;
    }
}
