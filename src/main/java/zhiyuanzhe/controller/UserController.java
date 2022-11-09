package zhiyuanzhe.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhiyuanzhe.dao.ActiveJoinDao;
import zhiyuanzhe.funtion.checkRule.IsBuildTeam;
import zhiyuanzhe.funtion.checkRule.UserLoginMessage;
import zhiyuanzhe.funtion.objectInfo.SetEmailMessage;
import zhiyuanzhe.funtion.objectInfo.SuperAdmin;
import zhiyuanzhe.funtion.system.SendEmail;
import zhiyuanzhe.funtion.system.StringUtil;
import zhiyuanzhe.funtionDao.IsTimeOut;
import zhiyuanzhe.pojo.*;
import zhiyuanzhe.service.*;

import javax.mail.MessagingException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IActiveService activeService;
    @Autowired
    private IActiveJoinService activeJoinService;
    @Autowired
    private ActiveJoinDao activeJoinDao;
    @Autowired
    private ITeamService teamService;
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IActiveTypeService activeTypeService;
    /**
     * 收件人下拉框请求
     */
    public static String ADDRESS_OR = "00";
    /**
     * 活动类型下拉框请求
     */
    public static String ACTIVE_TYPE = "01";
    /**
     * 活动下拉框请求
     */
    public static String ACTIVE = "02";
    /**
     * 组长编号（组织）
     */
    public static String HEAD_MAN = "组长";
    /**
     * 成员编号（组织）
     */
    public static String MEMBER = "成员";
    /**
     * 无组织人员编号
     */
    public static String PEOPLE = "";
    /**
     * 管理员编号（组织）
     */
    public static String ADMINISTRATOR = "管理员";
    /**
     * 个人活动（组织）
     */
    public static String ONE_ACTIVE = "个人活动";
    /**
     * 团体活动（组织）
     */
    public static String TEAM_ACTIVE = "团体活动";
    /**
     * 特殊活动（组织）
     */
    public static String SPECIAL_ACTIVE = "特殊活动";
    /**
     * 测试活动（组织）
     */
    public static String TEST_ACTIVE = "特殊活动";

    /**
     * 用户登录方法
     */
    @RequestMapping("/userLogin")
    public String userLogin(UserInfo userInfo, Model model, HttpSession session, HttpServletRequest request) {
        if (userService.userLogin(userInfo)) {
            //获取用户信息
            UserInfo user=userService.findUser(userInfo);
            //用户信息校验
            String result=new UserLoginMessage().userLoginCheck(userService,user);
            if ("Y".equals(result)){
                UserInfo info = userService.findUserByLoginNameAndPwd(userInfo);
                session.setAttribute("userInfo", info);
                session.setAttribute("userId", info.getUserId());
                session.setAttribute("key", info.getKey());
                session.setAttribute("email", info.getUserEmail());
                //系统界面信息处理
                Map<Object, Object> systemMessage = systemMessage();
                int userNum = (int) systemMessage.get("userNum");
                int activeNum = (int) systemMessage.get("activeNum");
                String hotAct = String.valueOf(systemMessage.get("hotAct"));
                int actSumTime = (int) systemMessage.get("actSumTime");
                Object threeActive = systemMessage.get("threeActive");
                model.addAttribute("userNum", userNum);
                model.addAttribute("activeNum", activeNum);
                model.addAttribute("hotAct", hotAct);
                model.addAttribute("actSumTime", actSumTime);
                model.addAttribute("threeActive", threeActive);
                //用户主页界面信息处理
                Map<Object, Object> userMessage = userMessage(info);
                int userJoinNum = (int) userMessage.get("用户参与活动数量");
                Object teamInfo = userMessage.get("组织信息");
                model.addAttribute("userInfo", info);
                model.addAttribute("teamInfo", teamInfo);
                model.addAttribute("userJoinNum", userJoinNum);
                return "/userHome/index";
            }else {
                model.addAttribute("err", "登陆失败，用户信息异常!"+result);
                return "/public_function/errMessage";
            }
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
     * 用户登录方法
     */
    @RequestMapping("/oldUserLogin")
    public String oldUserLogin(UserInfo userInfo, Model model, HttpSession session, HttpServletRequest request) {
        if (userService.userLogin(userInfo)) {
            UserInfo info = userService.findUserByLoginNameAndPwd(userInfo);
            session.setAttribute("userInfo", info);
            session.setAttribute("userId", info.getUserId());
            session.setAttribute("key", info.getKey());
            session.setAttribute("email", info.getUserEmail());
            //系统界面信息处理
            Map<Object, Object> systemMessage = systemMessage();
            int userNum = (int) systemMessage.get("userNum");
            int activeNum = (int) systemMessage.get("activeNum");
            String hotAct = String.valueOf(systemMessage.get("hotAct"));
            int actSumTime = (int) systemMessage.get("actSumTime");
            Object threeActive = systemMessage.get("threeActive");
            model.addAttribute("userNum", userNum);
            model.addAttribute("activeNum", activeNum);
            model.addAttribute("hotAct", hotAct);
            model.addAttribute("actSumTime", actSumTime);
            model.addAttribute("threeActive", threeActive);
            //用户主页界面信息处理
            Map<Object, Object> userMessage = userMessage(info);
            int userJoinNum = (int) userMessage.get("用户参与活动数量");
            Object teamInfo = userMessage.get("组织信息");
            model.addAttribute("userInfo", info);
            model.addAttribute("teamInfo", teamInfo);
            model.addAttribute("userJoinNum", userJoinNum);
            return "/userHome/user_index";
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
     * 注册发送邮箱验证码
     * */
    @RequestMapping("/sendEmailCheckCode")
    @ResponseBody
    public String sendEmailCheckCode(String addressOr, HttpSession session, ModelAndView modelAndView) throws MessagingException, GeneralSecurityException {
        //清空当前session中的验证码
        session.removeAttribute("checkCode");
        //生成UUID
        StringUtil stringUtil=new StringUtil();
        String checkCode=stringUtil.getRandomValue(6);
        //将uuid存入session中
        session.setAttribute("checkCode",checkCode);
        modelAndView.addObject("checkCode",checkCode);
        //调用管理员信息
        AdminInfo adminInfo=new SuperAdmin().superAdmin(adminService);
        //处理发送实体
        EmailInfo emailInfo=new SetEmailMessage().saveEmail(adminInfo.getEmail(),addressOr,"",checkCode,"","","",adminInfo.getKey());
        //调用邮箱发送方法
        //实例化邮箱类
        SendEmail sendEmail = new SendEmail();
        //返回发送结果与数据
        Map<String,String> resultMap=new HashMap<>();
        try {
            boolean emailState = sendEmail.sendEmail(emailInfo);
            if (emailState){
                resultMap.put("res",checkCode);
            }else {
                resultMap.put("res","N");
            }
        }catch (Exception e){
            resultMap.put("res","N");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping("goHome")
    public String goHome(Model modeel) {
        return "/userHome/user_index";
    }

    /**
     * 退出方法
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        return "/userHome/user_login";
    }

    /**
     * 用户查看活动详情
     */
    @RequestMapping("/findActiveById")
    public String findActiveById(ActiveInfo activeInfo, Model model, HttpSession session, UserInfo userInfo) throws ParseException {
        //通过id查询活动信息
        activeInfo = activeService.findActiveById(activeInfo);
        //发送到前台界面
        model.addAttribute("activeInfo", activeInfo);
        //校验当前活动时间
        boolean isTimeOut = new IsTimeOut().isTimeOut(activeInfo);
        //传该活动类型
        String activeType = activeService.findActiveById(activeInfo).getActiveTypeInfo().getActiveTypeName();
        //查询该用户身份
        UserInfo user = userService.findUser(userInfo);
        String userType = "";
        //空指针处理
       try {
           userType=user.getTeamJobInfo().getTeamJobName();
       }catch (Exception e){
           userType=PEOPLE;
       }
        //校验用户当前身份
        if ((HEAD_MAN.equals(userType) && TEAM_ACTIVE.equals(activeType)) || (MEMBER.equals(userType) && ONE_ACTIVE.equals(activeType)) || (TEST_ACTIVE.equals(activeType)) || (PEOPLE.equals(userType) && ONE_ACTIVE.equals(activeType))) {
            if (isTimeOut) {
                //判断当前活动状态
                int userId = (int) session.getAttribute("userId");
                String activeState = activeJoinService.findActiveState(activeInfo.getActiveId(), userId);
                //若状态为空则可以报名
                if (activeState == null) {
                    model.addAttribute("activeState", "立即报名");
                } else {
                    model.addAttribute("activeState", activeState);
                }
                return "/active/active_detail";
            } else {
                //活动异常提示语
                model.addAttribute("err", "该活动已经结束~");
                return "/public_function/errMessage";
            }
        } else {
            model.addAttribute("err", "您的身份不符合当前活动~");
            return "/public_function/errMessage";
        }
    }

    /**
     * 主页用户信息处理类
     **/
    @RequestMapping("/userMessage")
    public Map<Object, Object> userMessage(UserInfo userInfo) {
        //创建存放用户信息map
        Map<Object, Object> userMessageMap = new HashMap<>();
        //获取用户参与活动数量
        int activeJoinInInfo = activeJoinService.findActNumByUser(userInfo.getUserId());
        //获取用户所在组织信息
        TeamInfo teamInfo = teamService.findTeamMessageByTeamName(userInfo.getTeamName());
        //存入map
        userMessageMap.put("组织信息", teamInfo);
        userMessageMap.put("用户参与活动数量", activeJoinInInfo);
        return userMessageMap;
    }

    /**
     * 主页系统信息处理类
     **/
    @RequestMapping("/systemMessage")
    public Map<Object, Object> systemMessage() {
        //创建存放用户信息map
        Map<Object, Object> systemMessage = new HashMap<>();
        //获取所有志愿者人数
        int userNum = userService.findAll().size();
        //获取所有活动数量
        int activeNum = activeService.countNum();
        //查询最热活动
        String hotAct = String.valueOf(activeService.findHotAct().get(0).getActiveName());
        //计算活动活动总时长
        int actSumTime = activeService.sumActTime();
        //获取最新三种个人活动
        List<ActiveInfo> threeActive = activeService.activeList();
        //存入map
        systemMessage.put("userNum", userNum);
        systemMessage.put("activeNum", activeNum);
        systemMessage.put("hotAct", hotAct);
        systemMessage.put("actSumTime", actSumTime);
        systemMessage.put("threeActive", threeActive);
        return systemMessage;
    }

    /**
     * 主页用户发送邮件处理类
     */
    @RequestMapping(value = "/reasonEmail", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String reasonEmail(String chooseType, String activeType, HttpSession session) {
        //存放返回数据
        Map<String, String> resultMap = new HashMap<>();
        //判断是何种请求
        if (chooseType.equals(ADDRESS_OR)) {
            //查询收件人
            List<AdminInfo> adminInfoList = adminService.findAll();
            //查询组织组长
            List<UserInfo> teamJobList = userService.teamJob();
            int adminNum = 0;
            for (int i = 0; i < adminInfoList.size(); i++) {
                //获取管理员id和管理员姓名存入map中
                resultMap.put(String.valueOf(i), adminInfoList.get(i).getAdminLoginName());
                adminNum = i + 1;
            }
            for (int j = 0; j < teamJobList.size(); j++) {
                //获取组长姓名存入map中
                resultMap.put(String.valueOf(adminNum), teamJobList.get(j).getUserName());
                adminNum++;
            }
            return JSONObject.toJSONString(resultMap);
        } else if (chooseType.equals(ACTIVE_TYPE)) {
            //查询活动类型
            List<ActiveTypeInfo> activeTypeInfoList = activeTypeService.findAllActiveType();
            for (int i = 0; i < activeTypeInfoList.size(); i++) {
                //获取管理员id和管理员姓名存入map中
                resultMap.put(String.valueOf(i), activeTypeInfoList.get(i).getActiveTypeName());
            }
            return JSONObject.toJSONString(resultMap);
        } else if (chooseType.equals(ACTIVE)) {
            //通过活动类型查询活动
            List<ActiveInfo> activeInfoList = activeService.findActByActiveType(activeType);
            for (int i = 0; i < activeInfoList.size(); i++) {
                //获取活动名称存入map中
                resultMap.put(String.valueOf(i), activeInfoList.get(i).getActiveName());
            }
            return JSONObject.toJSONString(resultMap);
        } else {
            return null;
        }
    }

    /**
     * 用户个人中心处理
     **/
    @RequestMapping("/userIndex")
    public String userIndex() {
        //创建存放用户信息map
        Map<Object, Object> systemMessage = new HashMap<>();
        //获取所有志愿者人数
        int userNum = userService.findAll().size();
        //获取所有活动数量
        int activeNum = activeService.countNum();
        //查询最热活动
        String hotAct = String.valueOf(activeService.findHotAct().get(0).getActiveName());
        //计算活动活动总时长
        int actSumTime = activeService.sumActTime();
        //获取最新三种个人活动
        List<ActiveInfo> threeActive = activeService.activeList();
        //存入map
        systemMessage.put("userNum", userNum);
        systemMessage.put("activeNum", activeNum);
        systemMessage.put("hotAct", hotAct);
        systemMessage.put("actSumTime", actSumTime);
        systemMessage.put("threeActive", threeActive);
        return "/userHome/user_home";
    }

    /**
     * 进入创建组织界面
     **/
    @RequestMapping("/buildTeam")
    public String buildTeam() {

        return "/team/build_team";
    }

    /**
     * 异步判断是否已经创建组织或加入其他组织
     **/
    @ResponseBody
    @RequestMapping(value = "/findTeamByUserId", produces = "text/html;charset=UTF-8")
    public String findTeamByUserId(UserInfo userInfo) {
        //创建组织规则校验
        Map<String,String> resultMap=new IsBuildTeam().isBuildTeam(userService,userInfo);
        return JSONObject.toJSONString(resultMap);
    }
    /**
     * 验证码计算
     * */
    @ResponseBody
    @RequestMapping("/sumJs")
    public String sumJs(String value){
        Map<String,String> resMap=new HashMap<>();
        ScriptEngine se = new ScriptEngineManager().getEngineByName("js");
        try {
            Object result=se.eval(value);
            resMap.put("res", String.valueOf(result));
        } catch (ScriptException e) {
            resMap.put("res","N");
            e.printStackTrace();
        }
        return JSONObject.toJSONString(resMap);
    }
}

