package zhiyuanzhe.funtionDao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.IAdminService;
import zhiyuanzhe.service.IUserService;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册公共方法类
 * */
@Controller
@RequestMapping("/publicAddPeo")
public class add_people {
    @Autowired
    private IUserService userService;
    @Autowired
    private IAdminService adminService;
    /**
     * 用户注册方法
    * */
    @RequestMapping("addUser")
    public String addUser(UserInfo userInfo,Model model){
        //判断是否注册成功
        if (userService.addUser(userInfo)){
            return "";
        }else {
            return "";
        }
    }

    /**
     * 查重名
     * */
    @RequestMapping("/isRepeatName")
    @ResponseBody
    public String isRepeatName(String userLoginName){
        //执行查重验证,返回结果resultMap
        Map<String,String> resultMap=runRepeat(userLoginName);
        //返回前端
        return JSONObject.toJSONString(resultMap);
    }
    /**
     * 查重名
     * 执行查重名
     * */
    public Map<String,String> runRepeat(String userLoginName){
        //实例用户实体
        UserInfo userInfo=new UserInfo();
        //将信息传入用户实体
        userInfo.setUserLoginName(userLoginName);
        //存放返回结果Map
        Map<String,String> resultMap=new HashMap<>();
        //调用查询方法判断是否重名
        try{
            if (userService.findUser(userInfo).getUserId()>0){
                resultMap.put("res","1");
            }else {
                resultMap.put("res","0");
            }
        }catch (Exception e){
            resultMap.put("res","0");
        }
        //返回查询结果
        return resultMap;
    }
}
