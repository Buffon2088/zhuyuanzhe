package zhiyuanzhe.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.pojo.ActiveTypeInfo;
import zhiyuanzhe.service.IActiveService;
import zhiyuanzhe.service.IActiveTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * zhangHong
 * 2022/09/03
 * 活动 界面处理类
 */
@Controller
@RequestMapping("/Active")
public class ActiveController {
    @Autowired
    private IActiveService activeService;
    @Autowired
    private IActiveTypeService activeTypeService;
    //注入团队实现方法

    //注入个人实现方法

    //注入落地类型实现方法

    /**
     * 遍历所有活动类型
     */
    @RequestMapping("/findActiveList")
     public String findActiveList(Model model){
        List<ActiveTypeInfo> activeInfoList = activeTypeService.findAllActiveType();
        model.addAttribute(activeInfoList);
        return "/active/active_show";
     }


     @RequestMapping("/findActiveType")
     @ResponseBody
     public String findActiveType(String activeTypeNmae){
         List<ActiveTypeInfo> activeInfoList = activeTypeService.findAllActiveType();
         String activeTypeJson = JSONObject.toJSONString(activeInfoList);
        return activeTypeJson;
     }
}
