package zhiyuanzhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zhiyuanzhe.annotaion.LogInfoAnnotaion;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.pojo.ActiveTypeInfo;
import zhiyuanzhe.service.IActiveService;
import zhiyuanzhe.service.IActiveTypeService;

import java.util.HashMap;
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
    @LogInfoAnnotaion(methodName = "遍历活动")
    @RequestMapping("/findActiveList")
     public String findActiveList(Model model){
        List<ActiveTypeInfo> activeInfoList = activeTypeService.findAllActiveType();
        String countNums = String.valueOf(activeService.countNum());
        model.addAttribute("countNums",countNums);
        model.addAttribute(activeInfoList);
        return "/active/active_show";
     }
    /**
     * 遍历所有活动
     */
    @RequestMapping("/ActiveList")
    public String ActiveList(Model model){
        List<ActiveInfo> activeInfoList = activeService.activeList();
        model.addAttribute(activeInfoList);
        return "/active/active_show";
    }

     @RequestMapping("/findActiveType")
     public String findActiveType(int activeTypeId,Model model){
         List<ActiveInfo> activeTypeInfoList1 = activeService.activeList();
        //查看当前类型下的活动
         List<ActiveInfo> activeTypeInfoList = activeService.activeList(activeTypeId);
         //发送界面集合
         model.addAttribute(activeTypeInfoList);
         return "/active/active_show";
     }


}
