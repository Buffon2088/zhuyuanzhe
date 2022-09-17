package zhiyuanzhe.funtion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.dao.ActiveDao;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.service.IActiveService;
import zhiyuanzhe.service.imp.ActiveServiceImp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 活动时间合法校验
 * */
@Service
@Transactional
public class JudgeActUpOrDown {
    @Autowired
    private ActiveDao activeDao;
    /**
     *校验当前时间是否小于活动开始时间
     * */
    public Map<String,String> judgeTime(ActiveInfo actResult) throws ParseException {
        String activeState=actResult.getActiveState();
        //获取活动开始时间
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        //获取活动开始时间转为Long
        Long startTime=df.parse(actResult.getActiveStartTime()).getTime();
        //获取活动结束时间转为Long
        Long endTime=df.parse(actResult.getActiveEndTime()).getTime();
        //通过date类来获取系统当前时间
        Date day=new Date();
        Long nowTime=df.parse(df.format(day)).getTime();
        //存放及校验结果的Map
        Map<String,String> errResultMap=new HashMap<>();
        //校验活动开始时间是否大于当前系统时间
        if (startTime>=nowTime){
            //判断活动结束时间是否大于活动开始时间
            if (endTime>=startTime){
                return null;
            }else {
                //该活动修改为维护中状态
                activeState="维护中";
                //存入错误Map中
                actResult.setActiveState("维护中");
                errResultMap.put("activeState",activeState);
                errResultMap.put("err","操作失败，活动开始时间不能大于活动结束时间!");
                return errResultMap;
            }
        }else {
            errResultMap.put("activeState",activeState);
            errResultMap.put("err","操作失败，活动开始时间不能小于当前系统时间!");
            return errResultMap;
        }
    }
    /**
     *校验当前活动是否有人报名
     * */
    public boolean judgeHavePeople(ActiveInfo activeInfo){
        //获取当前活动报名人数
        int nowPeople=activeInfo.getActiveJoinNum();
        //判断当前是否有人在参与该活动
        if (nowPeople>0){
            return false;
        }else {
            return true;
        }
    }
}
