package zhiyuanzhe.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
   private IUserService userService;
    /**
     * 用户登录方法
     */
    @RequestMapping("/userLogin")
    public String userLogin(UserInfo userInfo, Model model, HttpSession session) {
        if (userService.userLogin(userInfo)) {
            UserInfo info = userService.findUserByLoginNameAndPwd(userInfo);
            session.setAttribute("userInfo", info);
            session.setAttribute("key",info.getKey());
            session.setAttribute("email",info.getUserEmail());
            return "/userHome/user_index";
        } else {
            model.addAttribute("errorMessage", "登陆失败");
            return "/error";
        }
    }
    /**
     * 退出方法
     */
    @RequestMapping("/loginOut")
    public void  loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.invalidate();
        String requestPath=request.getContextPath();
        response.sendRedirect(requestPath);
    }
}
