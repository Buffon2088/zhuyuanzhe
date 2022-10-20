package zhiyuanzhe.funtion;

import zhiyuanzhe.pojo.EmailInfo;
import zhiyuanzhe.pojo.UserInfo;

/**
 * 管理员审核活动邮件发送类
 * **/
public class AdminSengEmailByReqAct {
    public EmailInfo adminSengEmailByReqAct(String message, Object adminEmail, Object adminKey, UserInfo userInfo){
        EmailInfo emailInfo=new EmailInfo();
        //存入授权码
        emailInfo.setKey(String.valueOf(adminKey));
        //存入发件箱
        emailInfo.setMailbox(String.valueOf(adminEmail));
        //存入发件人
        emailInfo.setConsignee(String.valueOf(adminEmail));
        //存入收件人
        emailInfo.setAddressOr(String.valueOf(userInfo.getUserEmail()));
        //存入收件箱
        emailInfo.setInbox(String.valueOf(userInfo.getUserEmail()));
        //存入发送消息
        emailInfo.setInformation(message);
        //返回定义好的邮箱实体
        return emailInfo;
    }
}
