package zhiyuanzhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.pojo.AdminInfo;
import zhiyuanzhe.service.IAdminService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @RequestMapping("/adminLogin")
    public String adminLogin(AdminInfo adminInfo, Model model, HttpSession session){
        if(adminService.adminLogin(adminInfo)){
            AdminInfo info = adminService.findAdminByLoginNameAndPwd(adminInfo);
            session.setAttribute("adminInfo",info);
            return "/secsss";
        }else{
            model.addAttribute("errorMessage","登陆失败");
            return "/error";
        }
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<AdminInfo> list = adminService.findAll();
        model.addAttribute("adminList",list);
        return "/jsp/admin_index";
    }

    @RequestMapping("/showAdd")
    public String showAdd(){
        return "/jsp/admin_add";
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(Model model,AdminInfo adminInfo){
         if(adminService.addAdmin(adminInfo)){
             return "redirect:/admin/findAll";
         }else{
             model.addAttribute("errorMessage","登陆失败");
             return "/error";
         }
    }

    @RequestMapping("/showById")
    public String showById(AdminInfo adminInfo,Model model){
        AdminInfo Info = adminService.findAdminById(adminInfo);
        model.addAttribute("adminInfo",Info);
        return "/jsp/admin_update";
    }

    @RequestMapping("/updateAdmin")
    public String updateAdmin(AdminInfo adminInfo,Model model){
        if (adminService.updateAdmin(adminInfo)){
            return "redirect:/admin/findAll";
        }else{
            model.addAttribute("errorMessage","登陆失败");
            return "/error";
        }
    }

    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(AdminInfo adminInfo,Model model){
        if(adminService.deleteAdmin(adminInfo)){
            return "redirect:/admin/findAll";
        }else{
            model.addAttribute("errorMessage","登陆失败");
            return "/error";
        }
    }
}
