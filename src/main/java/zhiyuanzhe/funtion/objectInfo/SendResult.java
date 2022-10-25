package zhiyuanzhe.funtion.objectInfo;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 *邮箱发送结果处理类
 * **/
public class SendResult {
    /**
     *管理员审核活动处理结果
     * */
    public Map<String,String> adminReqAct(boolean resultState,String message){
        Map<String,String> resultMap=new HashMap<>();
        if (resultState){
            resultMap.put("res",message);
        }else {
            resultMap.put("res","邮件发送失败");
        }
        return resultMap;
    }
}
