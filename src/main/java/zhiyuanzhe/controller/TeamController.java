package zhiyuanzhe.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.ITeamService;
import zhiyuanzhe.service.ITeamTypeService;
import zhiyuanzhe.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Team")
public class TeamController {

    @Autowired
    private ITeamService teamService;
    @Autowired
    private ITeamTypeService teamTypeService;
    @Autowired
    private IUserService userService;

    /**
     * 便历所有组织
     */
    @RequestMapping("/TeamList")
    public String TeamList(Model model) {
        //遍历所有组织等级信息
        List<TeamTypeInfo> teamTypeInfoList = teamTypeService.findAll();
        model.addAttribute(teamTypeInfoList);
        //遍历所有组织
        List<TeamInfo> teamInfoList = teamService.findAllTeam();
        model.addAttribute(teamInfoList);
        return "/team/team_show";
    }

    /**
     * 用户界面展示的团队类型查询
     */
    @RequestMapping("/findTeamType")
    public String findTeamType(int teamTypeId, Model model) {
        //查询所有团队类型
        List<TeamTypeInfo> teamTypeInfoList = teamTypeService.findAll();
        //查询当前类型下的所有团队
        List<TeamInfo> teamInfoList = teamService.findTeamList(teamTypeId);
        //向界面发送List集合
        model.addAttribute(teamTypeInfoList);
        model.addAttribute(teamInfoList);
        return "/team/team_show";

    }

    /**
     * 管理员界面展示的团队类型查询
     */
    @RequestMapping("/findTeamTypeAdmin")
    public String findTeamTypeAdmin(int teamTypeId, Model model) {
        //查询所有团队类型
        List<TeamTypeInfo> teamTypeInfos = teamTypeService.findAll();
        //查询当前类型下的所有团队
        List<TeamInfo> teamInfoList = teamService.findTeamList(teamTypeId);
        //向界面发送List集合
        model.addAttribute(teamTypeInfos);
        model.addAttribute(teamInfoList);
        return "/adminHome/admin_showTeam";

    }

    /**
     * 通过组织等级查询组织
     */
    @RequestMapping("/findTeamByType")
    public String findTeamByType(Model model) {
        //遍历所有组织等级信息
        List<TeamTypeInfo> typeInfoList = teamTypeService.findAll();
        model.addAttribute(typeInfoList);
        return "/team/team_show";
    }


    /**
     * 跳转到创建组织的方法
     */
    @RequestMapping("/showAdd")
    public String showAdd() {
        return "/team/add_team";
    }

    /**
     * 用户创建组织
     */
    @RequestMapping("/addTeam")
    public String addTeam(TeamInfo teamInfo, HttpSession session, Model model) {
        //从session中获取userId，并将userId强转为int类型
        int userId = (int) session.getAttribute("userId");
        //将userId放入userInfo中
        UserInfo Info = new UserInfo();
        Info.setUserId(userId);
        //将装有userId的Info放入teamInfo中
        teamInfo.setUserInfo(Info);
        //默认头像
        teamInfo.setImg("770500d63c7ef49f6d09e9bf46ea865.jpg");
        if (teamService.addTeam(teamInfo)) {
            return "redirect:/Team/TeamList";
        } else {
            model.addAttribute("err", "团队创建异常，请联系工作人员");
            return "/public_function/errMessage";
        }
    }

    /**
     * 组织列表
     */
    @RequestMapping("/findTeam")
    public String findTeam(UserInfo userInfo, Model model) {
        //查询组织级别
        List<TeamTypeInfo> teamTypeInfoList = teamTypeService.findAll();
        model.addAttribute("teamTypeInfoList", teamTypeInfoList);
        //查询所有组织
        List<TeamInfo> teamInfoList = teamService.findAllTeam();
        model.addAttribute("teamInfoList", teamInfoList);
        return "/team/join_team";
    }

    /**
     * 查看我的组织
     */
    @RequestMapping("/MyTeam")
    public String myTeam(UserInfo userInfo, Model model) {
        //通过id查询组织
        try {
            TeamInfo teamInfo = teamService.findTeamByUserId(userInfo.getUserId());
            model.addAttribute("teamInfo", teamInfo);
        } catch (Exception e) {
            model.addAttribute("err", "活动组织查询异常，只能存在于一个组织之中!");
            return "/public_function/errMessage";
        }
        return "/team/team_home";
    }

    /**
     * 异步等级查询组织
     */
    @ResponseBody
    @RequestMapping(value = "/findTeamByGrade", produces = "text/html;charset=UTF-8")
    public String findTeamByGrade(String grade) {
        //存放查询结果map
        Map<String, Object> map = new HashMap<>();
        //判断等级查询还是排名查询
        if ("排名查询".equals(grade)) {
            List<TeamInfo> teamInfoList = teamService.findAllTeam();
            //只显示组织前五名
            if (teamInfoList.size() >= 4) {
                for (int i = 0; i < 4; i++) {
                    map.put(String.valueOf(i), teamInfoList.get(i));
                }
            } else {
                for (int i = 0; i < teamInfoList.size(); i++) {
                    map.put(String.valueOf(i), teamInfoList.get(i));
                }
            }
        } else {
            //根据等等级查询组织
            List<TeamInfo> teamInfoList = teamService.findTeamByGrade(grade);
            for (int i = 0; i < teamInfoList.size(); i++) {
                map.put(String.valueOf(i), teamInfoList.get(i));
            }
        }
        return JSONObject.toJSONString(map);
    }
}
