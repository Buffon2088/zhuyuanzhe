package zhiyuanzhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.funtionDao.IsTimeOut;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.IActiveService;
import zhiyuanzhe.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.Properties;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IActiveService activeService;
    /**
     * 用户登录方法
     */
    @RequestMapping("/userLogin")
    public String userLogin(UserInfo userInfo, Model model, HttpSession session,HttpServletRequest request) {
        if (userService.userLogin(userInfo)) {
            UserInfo info = userService.findUserByLoginNameAndPwd(userInfo);
            session.setAttribute("userInfo", info);
            session.setAttribute("key", info.getKey());
            session.setAttribute("email", info.getUserEmail());
            return "/userHome/user_index";
        } else {
            //获取当前请求的URL
            String contPath=request.getContextPath();
            model.addAttribute("url",contPath);
            //登陆失败提示语
            model.addAttribute("err", "登陆失败，请重新登录");
            return "/public_function/errMessage";
        }
    }
    @RequestMapping("goHome")
    public String goHome(Model modeel){
        return "/userHome/user_index";
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
     * 用户查看活动详情
     */
    @RequestMapping("/findActiveById")
    public String findActiveById(Model model,ActiveInfo activeInfo,HttpServletRequest request) throws ParseException {
        //通过id查询活动信息
        int activeId=Integer.parseInt(request.getParameter("activeId"));
        ActiveInfo info=new ActiveInfo();
        info.setActiveId(activeId);
        activeInfo=activeService.findActiveById(info);
        //发送到前台界面
        model.addAttribute("activeInfo",activeInfo);
        //校验当前活动时间
        boolean isTimeOut=new IsTimeOut().isTimeOut(activeInfo);
        if (isTimeOut){
            //判断当前活动状态

            return "/active/active_detail";
        }else {
            //活动异常提示语
            model.addAttribute("err", "该活动已经结束~");
            return "/public_function/errMessage";
        }
    }
}
