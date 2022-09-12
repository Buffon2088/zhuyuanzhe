package zhiyuanzhe.controller;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.pojo.ActiveTypeInfo;
import zhiyuanzhe.service.IActiveTypeService;

@Controller
@RequestMapping("/activeType")
public class ActiveTypeController {
    @Autowired
    private IActiveTypeService activeTypeService;
    /**
     * 添加修改中转方法
     * */
    @RequestMapping("/addPublic")
    public String addPublic(String url,String state,ActiveTypeInfo activeTypeInfo,Model model){
        //前台发送请求路径以及操作方式（添加/修改）
        if ("update".equals(state)){
            //活动类型修改-通过Id查询该活动类型的信息，用于修改活动输入框显示
            ActiveTypeInfo activeType=activeTypeService.findActiveType(activeTypeInfo);
            model.addAttribute(activeType);
            model.addAttribute("state","update");
        }else {
            model.addAttribute("state","add");
        }
        return url;
    }
    /**
     * 添加活动类型
     * */
    @RequestMapping("/addActiveType")
    public String addActiveType(ActiveTypeInfo activeTypeInfo, Model model){
        if (activeTypeService.addActiveType(activeTypeInfo)){
            return "redirect:/Active/showAllActive";
        }else {
            model.addAttribute("err", "类型添加异常，请检查mapper!");
            return "/public_function/errMessage";
        }

    }
    /**
     * 删除活动类型
     * */
    @RequestMapping("/delActiveType")
    public String delActiveType(ActiveTypeInfo activeTypeInfo, Model model){
        if (activeTypeService.deleteActiveType(activeTypeInfo)){
            return "redirect:/Active/showAllActive";
        }else {
            model.addAttribute("err", "类型添加异常，请检查mapper!");
            return "/public_function/errMessage";
        }

    }
    /**
     * 修改活动类型
     * */
    @RequestMapping("/updateActiveType")
    public String updateActiveType(ActiveTypeInfo activeTypeInfo, Model model){
        if (activeTypeService.updateActiveType(activeTypeInfo)){
            return "redirect:/Active/showAllActive";
        }else {
            model.addAttribute("err", "类型修改异常，请检查mapper!");
            return "/public_function/errMessage";
        }
    }
    /**
     * 活动类型发布
     * */
    @RequestMapping("/publishActiveType")
    public String publishActiveType(ActiveTypeInfo activeTypeInfo,String activeTypeState,Model model){
        //通过id查询到该类型
        ActiveTypeInfo activeType=activeTypeService.findActiveType(activeTypeInfo);
        //将该活动状态进行修改
        activeType.setActiveTypeState(activeTypeState);
        if (activeTypeService.updateActiveType(activeType)){
            return "redirect:/Active/showAllActive";
        }else {
            model.addAttribute("err", "类型修改异常，请检查mapper!");
            return "/public_function/errMessage";
        }
    }
}
