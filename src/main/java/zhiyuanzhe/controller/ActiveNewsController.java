package zhiyuanzhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.pojo.ActiveNewsInfo;
import zhiyuanzhe.pojo.AdminInfo;
import zhiyuanzhe.service.IActiveNewsService;
import zhiyuanzhe.service.IAdminService;

import java.util.List;

@Controller
@RequestMapping("/news")
public class ActiveNewsController {
    @Autowired
    private IActiveNewsService activeNewsService;
    @Autowired
    private IAdminService adminService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<ActiveNewsInfo> newsList = activeNewsService.findAll();
        model.addAttribute("newsList",newsList);
        return "/news/news-details";
    }

    @RequestMapping("/showAdd")
    public String showAdd(Model model){
        List<AdminInfo> adminList = adminService.findAll();
        model.addAttribute("adminList",adminList);
        return "/news/news_add";
    }

    @RequestMapping("/addNews")
    public String addNews(ActiveNewsInfo activeNewsInfo,Model model){
        if(activeNewsService.addNews(activeNewsInfo)){
            return "redirect:/news/findAll";
        }else{
            model.addAttribute("errorMessage","添加失败");
            return "/news/error";
        }
    }

    @RequestMapping("deleteNews")
    public String deleteNews(ActiveNewsInfo activeNewsInfo,Model model){
        if(activeNewsService.deleteNews(activeNewsInfo)){
            return "redirect:/news/findAll";
        }else{
            model.addAttribute("errorMessage","删除失败");
            return "/news/error";
        }
    }

    @RequestMapping("updateNews")
    public String updateNews(ActiveNewsInfo activeNewsInfo,Model model){
        if(activeNewsService.updateNews(activeNewsInfo)){
            return "redirect:/news/findAll";
        }else{
            model.addAttribute("errorMessage","修改失败");
            return "/news/error";
        }
    }


}
