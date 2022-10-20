package zhiyuanzhe.funtion;

import zhiyuanzhe.pojo.EmailInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

public class SetEmailMessage {
    public EmailInfo saveEmail(String consignee, String newAddressOr, String otherInformation, String information, String imgInformation, String txtInformation,String email,String key){
        EmailInfo emailInfo=new EmailInfo();
        //将用户界面输入信息存入邮件实体
        emailInfo.setConsignee(consignee);
        emailInfo.setAddressOr(newAddressOr);
        emailInfo.setOtherInformation(otherInformation);
        emailInfo.setInformation(information);
        emailInfo.setImgInformation(imgInformation);
        emailInfo.setTxtInformation(txtInformation);
        emailInfo.setKey(key);
        return emailInfo;
    }
}
