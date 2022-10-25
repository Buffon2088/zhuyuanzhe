package zhiyuanzhe.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhiyuanzhe.annotaion.LogInfoAnnotaion;
import zhiyuanzhe.funtion.objectInfo.*;
import zhiyuanzhe.funtion.system.SendEmail;
import zhiyuanzhe.pojo.*;
import zhiyuanzhe.service.IActiveJoinService;
import zhiyuanzhe.service.IActiveService;
import zhiyuanzhe.service.IAdminService;
import zhiyuanzhe.service.IUserService;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IActiveJoinService activeJoinService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IActiveService activeService;

    @LogInfoAnnotaion(methodName = "adminLogin")
    @RequestMapping("/adminLogin")
    /**
     * 管理员登录方法
     */
    public String adminLogin(AdminInfo adminInfo, Model model, HttpSession session, HttpServletRequest request) {
        if (adminService.adminLogin(adminInfo)) {
            AdminInfo info = adminService.findAdminByLoginNameAndPwd(adminInfo);
            session.setAttribute("adminInfo", info);
            session.setAttribute("key", info.getKey());
            session.setAttribute("email", info.getEmail());
            return "/adminHome/adminIndex";
        } else {
            //获取当前请求的URL
            String contPath = request.getContextPath();
            model.addAttribute("url", contPath);
            //登陆失败提示语
            model.addAttribute("err", "登陆失败，请重新登录");
            return "/public_function/errMessage";
        }
    }

    /**
     * 退出方法
     */
    @RequestMapping("/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        String requestPath = request.getContextPath();
        response.sendRedirect(requestPath);
    }

    /**
     * 查询所有管理员类
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        //查询所有管理员
        List<AdminInfo> list = adminService.findAll();
        //将管理员发送到前端
        model.addAttribute("adminList", list);
        return "/jsp/admin_index";
    }

    @RequestMapping("/goSendEmail")
    public String goSendEmail(Model model, String key) {
        model.addAttribute(key);
        return "/email/send_email";
    }

    /**
     * 邮箱发送方法
     */
    @LogInfoAnnotaion(methodName = "sendEmail")
    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(String consignee, String addressOr, String otherInformation, String information, String imgInformation, String txtInformation, HttpSession session) throws MessagingException, GeneralSecurityException {
        //获取session中的数据
        String email = session.getAttribute("email").toString();
        String key = session.getAttribute("key").toString();
        //实例化邮箱类
        SendEmail sendEmail = new SendEmail();
        //实例邮件实体
        SetEmailMessage setEmailMessage = new SetEmailMessage();
        //初始化收件人邮箱
        String newAddressOr;
        //通过名称确认邮箱
        newAddressOr=userService.findEmailByName(addressOr);
        //将用户界面输入信息存入邮件实体
        EmailInfo emailInfo = setEmailMessage.saveEmail(consignee, newAddressOr, otherInformation, information, imgInformation, txtInformation, email, key);
        //调用邮件发送类
        boolean emailState = sendEmail.sendEmail(emailInfo);
        //实例Ajax类
        AjaxResult ajaxResult = new AjaxResult();
        //将返回给前端结果存入map
        Map<String, String> resultMap = ajaxResult.emailResult(emailState);
        //将map转为json
        String json = JSONObject.toJSONString(resultMap);
        //返回前端
        return json;
    }

    @RequestMapping("/goHome")
    public String goHome() {
        //获取当前用户信息
        return "/adminHome/adminIndex";
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(Model model, AdminInfo adminInfo) {
        if (adminService.addAdmin(adminInfo)) {
            return "redirect:/admin/findAll";
        } else {
            model.addAttribute("err", "添加失败，请联系管理员~");
            return "/public_function/errMessage";
        }
    }

    @RequestMapping("/showById")
    public String showById(AdminInfo adminInfo, Model model) {
        AdminInfo Info = adminService.findAdminById(adminInfo);
        model.addAttribute("adminInfo", Info);
        return "/jsp/admin_update";
    }

    @RequestMapping("/updateAdmin")
    public String updateAdmin(AdminInfo adminInfo, Model model) {
        if (adminService.updateAdmin(adminInfo)) {
            return "redirect:/admin/findAll";
        } else {
            model.addAttribute("err", "登录失败，请输入正确的用户名和密码");
            return "/public_function/errMessage";
        }
    }

    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(AdminInfo adminInfo, Model model) {
        if (adminService.deleteAdmin(adminInfo)) {
            return "redirect:/admin/findAll";
        } else {
            model.addAttribute("err", "删除失败，请联系管理员~");
            return "/public_function/errMessage";
        }
    }

    /**
     * 管理员查看活动申请方法
     */
    @RequestMapping("/ActRequest")
    public String ActRequest(Model model) {
        //查询所有申请,按申请时间进行排序
        List<ActiveJoinInInfo> activeJoinInInfoList = activeJoinService.findAllActJoin();
        model.addAttribute(activeJoinInInfoList);
        return "/adminHome/active_request";
    }
    /**
     * 管理员通过状态查看活动申请方法
     */



    @RequestMapping("/findActRequestByState")
    public String findActRequestByState(Model model,String activeJoinInState) {
        //初始化实体
        ActiveJoinInInfo activeJoinInInfo=new ActiveJoinInInfo();
        //存入状态进行查询
        activeJoinInInfo.setActiveJoinInState(activeJoinInState);
        //管理员通过状态查看活动申请
        List<ActiveJoinInInfo> activeJoinInInfoList=activeJoinService.findActiveJoinMessageByState(activeJoinInInfo);
        model.addAttribute(activeJoinInInfoList);
        return "/adminHome/active_request";
    }

    /**
     * 管理员审核活动方法
     */
    @RequestMapping("/ActRequestResult")
    public String ActRequestResult(Model model, ActiveJoinInInfo activeJoinInInfo, String updateState) {
        //判断是通过或者拒绝
        if ("0".equals(updateState)) {
            //执行通过申请方法
            if (activeJoinService.passReq(activeJoinInInfo)) {
                return "redirect:/admin/ActRequest";
            } else {
                model.addAttribute("err", "申请处理失败，请联系管理员~");
                return "/public_function/errMessage";
            }
        } else {
            //执行拒绝申请方法
            if (activeJoinService.refuseReq(activeJoinInInfo)) {
                return "redirect:/admin/ActRequest";
            } else {
                model.addAttribute("err", "申请处理失败，请联系管理员~");
                return "/public_function/errMessage";
            }
        }
    }

    /**
     * 管理员发送申请成功或者失败邮件
     * */
    @RequestMapping("/adminSendEmail")
    @ResponseBody
    public String adminSendEmail(UserInfo userInfo, AdminInfo adminInfo,String state,ActiveInfo activeInfo,HttpSession session) throws MessagingException, GeneralSecurityException {
        //查询收件人信息
        UserInfo userMessage=userService.findUser(userInfo);
        //查询活动信息
        ActiveInfo actInfo=activeService.findActive(activeInfo);
        //编辑发送信息
        String message=new ReqSendMessage().reqSendMessage(userMessage,actInfo,state);
        //编辑发送实体
        EmailInfo emailInfo= new AdminSengEmailByReqAct().adminSengEmailByReqAct(message,session.getAttribute("email"),session.getAttribute("key"),userMessage);
        //调用发送方法
        boolean sendState=new SendEmail().sendEmail(emailInfo);
        //返回json格式数据
        return JSONObject.toJSONString(new SendResult().adminReqAct(sendState,message));
    }
}
