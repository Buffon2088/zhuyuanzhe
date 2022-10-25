package zhiyuanzhe.funtion.objectInfo;

import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.pojo.UserInfo;

public class ReqSendMessage {
    /**
     * 活动申请信息编辑类
     * */
    public String reqSendMessage(UserInfo userInfo,ActiveInfo activeInfo,String state){
        String message="";
        if ("已通过".equals(state)){
            message=""+userInfo.getUserName()+"您好：您申请的<"+activeInfo.getActiveName()+">活动已通过，" +
                    "请关注您的申请记录~";
        }else if ("".equals(state)){
            message=""+userInfo.getUserName()+"您好：您申请的"+activeInfo.getActiveName()+"活动没有通过审核，" +
                    "非常抱歉~";
        }else {
            message="申请处理失败，请联系管理员~";
        }
        return message;
    }
}
