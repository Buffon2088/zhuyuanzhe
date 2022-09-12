package zhiyuanzhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.annotaion.LogInfoAnnotaion;
import zhiyuanzhe.pojo.*;
import zhiyuanzhe.service.IActiveJoinService;
import zhiyuanzhe.service.IActiveService;
import zhiyuanzhe.service.IActiveTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/Active")
public class ActiveController {
    @Autowired
    private IActiveService activeService;
    @Autowired
    private IActiveTypeService activeTypeService;

    @Autowired
    private IActiveJoinService activeJoinService;
    //注入团队实现方法

    //注入个人实现方法

    //注入落地类型实现方法

    /**
     * 查看所有活动
     */
    @RequestMapping("/showAllActive")
    public String showAllActive(ActiveInfo activeInfo,Model model){
        //查询活动类型
        List<ActiveTypeInfo> activeTypeList=activeTypeService.findAllActiveType();
        model.addAttribute(activeTypeList);
        //查询所有活动
        List<ActiveInfo> activeList=activeService.activeList();
        model.addAttribute(activeList);
        return "/adminHome/admin_showActive";
    }
    /**
     * 添加活动方法
     */
    @RequestMapping("/addActive")
    public String addActive(ActiveInfo activeInfo){
       return null;
    }

    /**
     * 遍历所有活动类型
     */
    @LogInfoAnnotaion(methodName = "遍历活动")
    @RequestMapping("/findActiveList")
     public String findActiveList(Model model){
        //查询活动全部类型
        List<ActiveTypeInfo> activeInfoList = activeTypeService.findAllActiveType();
        //查询活动总数量
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
    /**
     * 查看某一类型的所有活动(用户)
     */
     @RequestMapping("/findActiveType")
     public String findActiveType(int activeTypeId,Model model){
         //查询全部活动类型
         List<ActiveTypeInfo> activeInfoList = activeTypeService.findAllActiveType();
         //查看当前类型下的活动
         List<ActiveInfo> activeTypeInfoList = activeService.activeList(activeTypeId);
         //发送界面集合
         model.addAttribute(activeTypeInfoList);
         model.addAttribute(activeInfoList);
         return "/active/active_show";
     }
    /**
     * 查看某一类型的所有活动(管理员)
     */
    @RequestMapping("/findActiveTypeAdmin")
    public String findActiveTypeAdmin(int activeTypeId,Model model){
        //查询全部活动类型
        List<ActiveTypeInfo> activeInfoList = activeTypeService.findAllActiveType();
        //查看当前类型下的活动
        List<ActiveInfo> activeTypeInfoList = activeService.activeList(activeTypeId);
        //发送界面集合
        model.addAttribute(activeTypeInfoList);
        model.addAttribute(activeInfoList);
        return "/adminHome/admin_showActive";
    }
    /**
     * 查看所有活动(管理员)
     */
    @RequestMapping("/adminFindType")
    public String adminFindType(Model model){
        //查询全部活动类型
        List<ActiveTypeInfo> activeTypeInfoList = activeTypeService.findAllActiveType();
        model.addAttribute(activeTypeInfoList);
        //查询全部活动类型
        List<ActiveInfo> activeInfoList = activeService.activeList();
        model.addAttribute(activeInfoList);
        return "/adminHome/admin_showActive";
    }
    /**
     * 报名重定向详情页面
     */
     @RequestMapping("/addActiveJoin")
     public String addActiveJoin(ActiveJoinInInfo activeJoinInInfo,Model model){
         if (activeJoinService.addActiveJoin(activeJoinInInfo)){
             return "redirect:/User/findActiveById?activeId="+activeJoinInInfo.getActiveInfo().getActiveId()+"";
         }else{
             model.addAttribute("err", "申请异常，请联系工作人员");
             return "/public_function/errMessage";
         }
     }
}
