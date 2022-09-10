package zhiyuanzhe.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhiyuanzhe.pojo.TeamJobInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;
import zhiyuanzhe.service.ITeamJobService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("showById")
    public String showById(TeamJobInfo teamJobInfo,Model model){
        TeamJobInfo Info = teamJobService.findTeamJob(teamJobInfo);
        model.addAttribute("teamJobInfo",Info);
        return "/teamJob/teamJob_update";
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

   @RequestMapping("/resName")
   @ResponseBody
   public String resName(TeamJobInfo teamJobInfo,Model model){
        Map<String,String> map = new HashMap<>();
        try{
            if(teamJobService.findTeamJob(teamJobInfo).getTeamJobId()>0){
                map.put("res","1");
            }else{
                map.put("res","0");
            }
        }catch (Exception e){
            map.put("res","0");
        }
        return JSONObject.toJSONString(map);

    }
}
