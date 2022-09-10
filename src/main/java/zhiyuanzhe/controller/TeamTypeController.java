package zhiyuanzhe.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zhiyuanzhe.pojo.TeamTypeInfo;
import zhiyuanzhe.service.ITeamTypeService;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/TeamType")
public class TeamTypeController {

    @Autowired
    private ITeamTypeService teamTypeService;

    @RequestMapping("/findAllList")
    public String findAllList(Model model){
        List<TeamTypeInfo> teamTypeList = teamTypeService.findAll();
        model.addAttribute("teamTypeList",teamTypeList);
        return "/teamType/teamType_show";
    }

    @RequestMapping("/showTypeAdd")
    public String showTypeAdd(){
        return "/teamType/teamType_add";
    }

    @RequestMapping("/addTeamType")
    public String addTeamType(TeamTypeInfo teamTypeInfo,Model model){
        if(teamTypeService.addTeamType(teamTypeInfo)){
            return "redirect:/TeamType/findAllList";
        }else{
            model.addAttribute("errorMessage","添加失败");
            return "/teamType/error";
        }
    }

    @RequestMapping("/showById")
    public String showById(TeamTypeInfo teamTypeInfo,Model model){
        TeamTypeInfo Info = teamTypeService.findTeamType(teamTypeInfo);
        model.addAttribute("teamTypeInfo",Info);
        return "/teamType/teamType_update";
    }

    @RequestMapping("/updateTeamType")
    public String updateTeamType(TeamTypeInfo teamTypeInfo,Model model){
        if(teamTypeService.updateTeamType(teamTypeInfo)){
            return "redirect:/TeamType/findAllList";
        }else{
            model.addAttribute("errorMessage","修改失败");
            return "/teamType/error";
        }
    }

    @RequestMapping("/deleteTeamType")
    public String deleteTeamType(TeamTypeInfo teamTypeInfo,Model model){
        if(teamTypeService.deleteTeamType(teamTypeInfo)){
            return "redirect:/TeamType/findAllList";
        }else{
            model.addAttribute("errorMessage","删除失败");
            return "/teamType/error";
        }
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(TeamTypeInfo teamTypeInfo){
        //TeamTypeInfo TypeInfo = teamTypeService.findTeamType(teamTypeInfo);
        Map<String,String> map = new HashMap<>();
        try{
            if(teamTypeService.findTeamType(teamTypeInfo).getTeamTypeId()>0){
                map.put("res","1");
            }else{
                map.put("res","0");
            }
        }catch (Exception e){
            map.put("res","0");
        }

        String js = JSONObject.toJSONString(map);
        return js;
    }


}

