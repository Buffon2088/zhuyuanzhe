package zhiyuanzhe.funtion.objectInfo;

import org.springframework.beans.factory.annotation.Autowired;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.service.IActiveService;

import java.util.HashMap;
import java.util.Map;

public class AjaxResult {

    public Map<String, String> emailResult(Boolean emailState) {
        //存放ajax返回结果
        Map<String, String> resultMap = new HashMap<>();
        //根据返回类型存入map中
        if (emailState == true) {
            resultMap.put("res", "0");
        } else {
            resultMap.put("res", "1");
        }
        return resultMap;
    }


}
