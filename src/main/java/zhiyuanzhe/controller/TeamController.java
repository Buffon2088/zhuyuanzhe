package zhiyuanzhe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.ITeamService;
import zhiyuanzhe.service.ITeamTypeService;
import zhiyuanzhe.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Team")
public class TeamController {

    @Autowired
    private ITeamService teamService;
    @Autowired
    private ITeamTypeService teamTypeService;
    @Autowired
    private IUserService userService;

    /*
    便历所有组织
    * */
    @RequestMapping("/TeamList")
    public String TeamList(Model model){
        //遍历所有组织等级信息
        List<TeamTypeInfo> teamTypeInfoList = teamTypeService.findAll();
        model.addAttribute(teamTypeInfoList);
        //遍历所有组织
        List<TeamInfo> teamInfoList = teamService.findAllTeam();
        model.addAttribute(teamInfoList);
        return "/team/team_show";
    }

    /*
    * 用户界面展示的团队类型查询
    * */
    @RequestMapping("/findTeamType")
    public String findTeamType(int teamTypeId,Model model){
        //查询所有团队类型
        List<TeamTypeInfo> teamTypeInfoList = teamTypeService.findAll();
        //查询当前类型下的所有团队
        List<TeamInfo> teamInfoList = teamService.findTeamList(teamTypeId);
        //向界面发送List集合
        model.addAttribute(teamTypeInfoList);
        model.addAttribute(teamInfoList);
        return "/team/team_show";

    }

    /*
     * 管理员界面展示的团队类型查询
     * */
    @RequestMapping("/findTeamTypeAdmin")
    public String findTeamTypeAdmin(int teamTypeId,Model model){
        //查询所有团队类型
        List<TeamTypeInfo> teamTypeInfos = teamTypeService.findAll();
        //查询当前类型下的所有团队
        List<TeamInfo> teamInfoList = teamService.findTeamList(teamTypeId);
        //向界面发送List集合
        model.addAttribute(teamTypeInfos);
        model.addAttribute(teamInfoList);
        return "/adminHome/admin_showTeam";

    }
    /*
     * 通过组织等级查询组织
     * */
    @RequestMapping("/findTeamByType")
    public String findTeamByType(Model model){
        //遍历所有组织等级信息
        List<TeamTypeInfo> typeInfoList = teamTypeService.findAll();
        model.addAttribute(typeInfoList);
        return "/team/team_show";
    }


    /*
     * 跳转到创建组织的方法
     * */
    @RequestMapping("/showAdd")
    public String showAdd(){
        return "/team/add_team";
    }

    /*
     * 用户创建组织
     * */
    @RequestMapping("/addTeam")
    public String addTeam(TeamInfo teamInfo, HttpSession session,Model model){
        //从session中获取userId，并将userId强转为int类型
        int userId = (int) session.getAttribute("userId");
        //将userId放入userInfo中
        UserInfo Info = new UserInfo();
        Info.setUserId(userId);
        //将装有userId的Info放入teamInfo中
        teamInfo.setUserInfo(Info);

        if (teamService.addTeam(teamInfo)){
            return "redirect:/Team/TeamList";
        }else{
            model.addAttribute("err", "团队创建异常，请联系工作人员");
            return "/public_function/errMessage";
        }
    }





}
