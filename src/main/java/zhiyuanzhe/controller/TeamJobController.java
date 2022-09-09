package zhiyuanzhe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.pojo.TeamJobInfo;
import zhiyuanzhe.service.ITeamJobService;

import java.util.List;

@Controller
@RequestMapping("/TeamJob")
public class TeamJobController {

    @Autowired
    private ITeamJobService teamJobService;

    @RequestMapping("/findAllTeamJob")
    public String findAllTeamJob(Model model){
        List<TeamJobInfo> teamJobList = teamJobService.findALLTeamJ();
        model.addAttribute("teamJobList",teamJobList);
        return "/teamJob/teamJob_show";
    }

    @RequestMapping("/showAdd")
    public String showAdd(){
        return "/teamJob/teamJob_add";
    }

    @RequestMapping("/addTeamJob")
    public String addTeamJob(TeamJobInfo teamJobInfo,Model model){
        if(teamJobService.addTeamJob(teamJobInfo)){
            return "redirect:/TeamJob/findAllTeamJob";
        }else{
            model.addAttribute("errorMessage","添加失败");
            return "/teamJob/error";
        }
    }

    @RequestMapping("/updateTeamJob")
    public String updateTeamJob(TeamJobInfo teamJobInfo,Model model){
        if(teamJobService.updateTeamJob(teamJobInfo)){
            return "redirect:/TeamJob/findAllTeamJob";
        }else{
            model.addAttribute("errorMessage","添加失败");
            return "/teamJob/error";
        }
    }

    @RequestMapping("/deleteTeamJob")
    public String deleteTeamJob(TeamJobInfo teamJobInfo,Model model){
        if(teamJobService.deleteTeamJob(teamJobInfo)){
            return "redirect:/TeamJob/findAllTeamJob";
        }else{
            model.addAttribute("errorMessage","添加失败");
            return "/teamJob/error";
        }
    }
}
