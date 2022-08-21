package zhiyuanzhe.controller;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhiyuanzhe.funtion.SendEmail;
import zhiyuanzhe.pojo.AdminInfo;
import zhiyuanzhe.pojo.EmailInfo;
import zhiyuanzhe.service.IAdminService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/goSendEmail")
    public String goSendEmail(Model model,HttpSession session){

        return "/jsp/email/send_email";
    }
    /**
     * 邮箱发送方法
     * */
    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(String consignee,String addressOr,String otherInformation,String information,String imgInformation,String txtInformation) throws MessagingException, GeneralSecurityException {
           SendEmail sendEmail=new SendEmail();
           EmailInfo emailInfo=new EmailInfo();
           Map<String, String> map = new HashMap<>();
           emailInfo.setConsignee(consignee);
           emailInfo.setAddressOr(addressOr);
           emailInfo.setOtherInformation(otherInformation);
           emailInfo.setInformation(information);
           emailInfo.setImgInformation(imgInformation);
           emailInfo.setTxtInformation(txtInformation);
           boolean emailState = sendEmail.sendEmail(emailInfo);
            if (emailState==true){
                map.put("res","0");
            }else {
                map.put("res","1");
            }
            String json = JSONObject.toJSONString(map);
            return json;
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
