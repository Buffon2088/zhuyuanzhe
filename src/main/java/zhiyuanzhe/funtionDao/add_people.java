package zhiyuanzhe.funtionDao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import zhiyuanzhe.funtion.SaveImg;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.IAdminService;
import zhiyuanzhe.service.IUserService;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private SaveImg saveImg;
    /**
     * 用户注册方法（图片）
    * */
    @RequestMapping("addUser")
    public String addUser(UserInfo userInfo, Model model, MultipartFile file, HttpServletRequest request){
        //处理图片存储(存储到target,后使用IO流复制到本地项目img文件夹中)
        UserInfo newUser=saveImg.saveImgToTarget(userInfo,file,request);
        //判断图片是否保存成功,是否注册成功
        if (userService.addUser(newUser) && newUser!=null){
            return "/userHome/user_login";
        }else {
            //失败跳转页面进行提示
            String err="数据库存储异常：请联系管理员";
            model.addAttribute("err",err);
            return "/public_function/errMessage";
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
