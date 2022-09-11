package zhiyuanzhe.funtionDao;

import zhiyuanzhe.pojo.ActiveInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 判断当前活动是否符合系统时间
 * */
public class IsTimeOut {
    public Boolean isTimeOut(ActiveInfo activeInfo) throws ParseException {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        //获取活动开始时间
        Long startTime=df.parse(activeInfo.getActiveStartTime()).getTime();
        //获取活动结束时间
        Long endTime=df.parse(activeInfo.getActiveEndTime()).getTime();
        //通过date类来获取系统当前时间
        Date day=new Date();
        Long nowTime=df.parse(df.format(day)).getTime();
        //判断当前活动是否超时
        if (nowTime>endTime){
            return false;
        }else{
            return true;
        }
    }
}
class Time{
    public static void main(String[] args) throws ParseException {
        Date day=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Long nowTime=df.parse(df.format(day)).getTime();
        System.out.println(nowTime);
    }

}
