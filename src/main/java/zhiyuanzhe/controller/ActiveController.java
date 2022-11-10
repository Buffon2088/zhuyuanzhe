package zhiyuanzhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zhiyuanzhe.funtion.SumHelpTime.TimeSum;
import zhiyuanzhe.funtion.checkRule.JudgeActUpOrDown;
import zhiyuanzhe.funtion.objectInfo.MargeMessage;
import zhiyuanzhe.funtion.objectInfo.SaveImg;
import zhiyuanzhe.pojo.*;
import zhiyuanzhe.service.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/Active")
public class ActiveController {
    @Autowired
    private IActiveService activeService;
    @Autowired
    private IActiveTypeService activeTypeService;

    @Autowired
    private IActiveJoinService activeJoinService;
    @Autowired
    private ITeamService teamService;
    @Autowired
    private IUserService userService;
    //活动状态
    private static final String UP_ACTIVE = "上线";

    private static final String DOWN_ACTIVE = "下线";
    //注入团队实现方法

    //注入个人实现方法

    //注入落地类型实现方法

    /**
     * 查看所有活动
     */
    @RequestMapping("/showAllActive")
    public String showAllActive(ActiveInfo activeInfo, Model model) {
        //查询活动类型
        List<ActiveTypeInfo> activeTypeList = activeTypeService.findAllActiveType();
        model.addAttribute(activeTypeList);
        //查询所有活动
        List<ActiveInfo> activeList = activeService.activeList();
        model.addAttribute(activeList);
        return "/adminHome/admin_showActive";
    }

    /**
     * 添加活动方法
     */
    @RequestMapping("/addActive")
    public String addActive(ActiveInfo activeInfo, MultipartFile file, HttpServletRequest request, Model model) throws ParseException {
        //调用存储活动图片方法
        ActiveInfo newActiveInfo = new SaveImg().saveActImgToTarget(activeInfo, file, request);
        //计算活动时间段放入实体
        newActiveInfo.setActiveTime(new TimeSum().activeTime(activeInfo));
        if (activeService.addActive(newActiveInfo)) {
            return "redirect:/Active/showAllActive";
        } else {
            model.addAttribute("err", "数据存储异常，请联系工作人员");
            return "/public_function/errMessage";
        }
    }


    /**
     * 遍历所有活动类型
     */
    @RequestMapping("/findActiveListTest")
    public String findActiveListTest(Model model) {
        //查询活动全部类型
        List<ActiveTypeInfo> activeTypeInfoList = activeTypeService.findAllActiveType();
        //查询活动总数量
        String countNums = String.valueOf(activeService.countNum());
        model.addAttribute("countNums", countNums);
        model.addAttribute(activeTypeInfoList);
        //查询全部活动
        List<ActiveInfo> activeInfoList = activeService.activeList();
        model.addAttribute(activeInfoList);
        return "/active/active_show";
    }

    /**
     * 遍历所有活动类型
     */
    @RequestMapping("/findActiveList")
    public String findActiveList(Model model) {
        //查询活动全部类型
        List<ActiveTypeInfo> activeTypeInfoList = activeTypeService.findAllActiveType();
        //查询活动总数量
        String countNums = String.valueOf(activeService.countNum());
        model.addAttribute("countNums", countNums);
        model.addAttribute(activeTypeInfoList);
        //查询全部活动
        List<ActiveInfo> activeInfoList = activeService.activeList();
        model.addAttribute(activeInfoList);
        return "/active_jsp/show_active";
    }

    /**
     * 遍历所有活动
     */
    @RequestMapping("/ActiveList")
    public String ActiveList(Model model) {
        List<ActiveInfo> activeInfoList = activeService.activeList();
        model.addAttribute(activeInfoList);
        return "/active/active_show";
    }

    /**
     * 查看某一类型的所有活动(用户)
     */
    @RequestMapping("/findActiveType")
    public String findActiveType(int activeTypeId, Model model) {
        //查询全部活动类型
        List<ActiveTypeInfo> activeInfoList = activeTypeService.findAllActiveType();
        //查看当前类型下的活动
        List<ActiveInfo> activeTypeInfoList = activeService.activeList(activeTypeId);
        //查询活动总数量（用户）
        String countNums = String.valueOf(activeService.countNum());
        model.addAttribute("countNums", countNums);
        //发送界面集合
        model.addAttribute(activeTypeInfoList);
        model.addAttribute(activeInfoList);
        return "/active_jsp/show_active";
    }

    /**
     * 查看某一类型的所有活动(管理员)
     */
    @RequestMapping("/findActiveTypeAdmin")
    public String findActiveTypeAdmin(int activeTypeId, Model model) {
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
    public String adminFindType(Model model) {
        //查询全部活动类型
        List<ActiveTypeInfo> activeTypeInfoList = activeTypeService.findAllActiveType();
        model.addAttribute(activeTypeInfoList);
        //查询全部活动
        List<ActiveInfo> activeInfoList = activeService.activeList();
        model.addAttribute(activeInfoList);
        return "/adminHome/admin_showActive";
    }

    /**
     * 修改活动信息
     */
    @RequestMapping("/updateAct")
    public String updateAct(Model model, ActiveInfo activeInfo, MultipartFile file, HttpServletRequest request) throws IllegalAccessException, NoSuchFieldException {
        //通过获得id查询该活动信息
        ActiveInfo actResult = activeService.findActiveById(activeInfo);
        //修改活动图片,放入实体
        actResult.setImg(new SaveImg().saveActImgToTarget(activeInfo, file, request).getImg());
        //合并活动原始数据与修改数据（不包含外键实体）
        ActiveInfo newActInfo = new MargeMessage().MargeActMessage(actResult, activeInfo);
        //合并外键实体
        ActiveInfo finalActInfo = new MargeMessage().outActInfo(newActInfo, activeInfo, actResult);
        //修改其他信息，并判断是否返回成功
        if (activeService.updateActive(finalActInfo)) {
            return "redirect:/Active/showAllActive";
        } else {
            model.addAttribute("err", "数据存储异常，请联系工作人员");
            return "/public_function/errMessage";
        }
    }
    /**
     * 报名重定向详情页面
     */
    @RequestMapping("/addActiveJoin")
    public String addActiveJoin(ActiveJoinInInfo activeJoinInInfo, Model model,UserInfo userInfo) {
        //通过用户id查询团队id
        UserInfo userInfo1=userService.findUser(userInfo);
        String teamName=userInfo1.getTeamName();
        int teamId;
        if ("0".equals(teamName)){
            teamId=0;
        }else {
            teamId=teamService.findTeamMessageByTeamName(teamName).getTeamId();
        }
        //组长信息写入实体
        TeamInfo teamInfo=new TeamInfo();
        teamInfo.setTeamId(teamId);
        activeJoinInInfo.setTeamInfo(teamInfo);
        try {
            if (activeJoinService.addActiveJoin(activeJoinInInfo)) {
                return "redirect:/User/findActiveById?activeId=" + activeJoinInInfo.getActiveInfo().getActiveId() + "&userId="+userInfo.getUserId()+"";
            } else {
                model.addAttribute("err", "申请异常，请联系工作人员");
                return "/public_function/errMessage";
            }
        } catch (Exception e) {
            model.addAttribute("err", "申请异常，请联系工作人员");
            return "/public_function/errMessage";
        }
    }

    /**
     * 活动上下架以及删除方法
     */
    @RequestMapping("/upDownAct")
    public String upDownAct(String state, ActiveInfo activeInfo, Model model) throws ParseException {
        //判断是否删除该活动
        if ("delAct".equals(state)) {
            if (activeService.delActive(activeInfo)) {
                return "redirect:/Active/showAllActive";
            } else {
                model.addAttribute("err", "删除活动异常，请联系工作人员");
                return "/public_function/errMessage";
            }
        }
        //通过id查询活动信息
        ActiveInfo actResult = activeService.findActiveById(activeInfo);
        //调用活动时间校验方法
        Map<String, String> errResultMap = new JudgeActUpOrDown().judgeTime(actResult);
        //将errResultMap中的Active取出放入新的实体actResult中
        if (errResultMap == null) {
            //判断上下架状态-下架处理方法体
            if ("DownAct".equals(state)) {
                //调用校验当前活动是否有人报名方法
                boolean peopleState = new JudgeActUpOrDown().judgeHavePeople(actResult);
                if (!peopleState) {
                    model.addAttribute("err", "该活动当前有用户参与无法下架，请联系工作人员处理~");
                    return "/public_function/errMessage";
                }
                //插入活动下架状态
                actResult.setActiveState(DOWN_ACTIVE);
                if (activeService.updateActive(actResult)) {
                    return "redirect:/Active/showAllActive";
                } else {
                    model.addAttribute("err", "状态修改异常，请联系工作人员");
                    return "/public_function/errMessage";
                }
            } else {
                //插入上架状态
                actResult.setActiveState(UP_ACTIVE);
                if (activeService.updateActive(actResult)) {
                    return "redirect:/Active/showAllActive";
                } else {
                    model.addAttribute("err", "状态修改异常，请联系工作人员");
                    return "/public_function/errMessage";
                }
            }
        } else {
            actResult.setActiveState(errResultMap.get("activeState"));
            String errMessage = errResultMap.get("err");
            //修改该异常活动的状态
            if (activeService.updateActive(actResult)) {

            } else {
                model.addAttribute("err", "状态修改异常，请联系工作人员");
                return "/public_function/errMessage";
            }
            model.addAttribute("err", "活动时间校验不通过\n原因为:" + errMessage);
            return "/public_function/errMessage";
        }
    }
}