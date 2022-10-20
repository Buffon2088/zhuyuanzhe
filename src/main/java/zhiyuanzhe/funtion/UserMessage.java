package zhiyuanzhe.funtion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.ITeamService;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息处理类
 * **/
@RequestMapping("/UserMessage")
@Controller
public class UserMessage {
    @Autowired
    private ITeamService teamService;

    /**
     * 主页用户信息处理类
     * **/
    @RequestMapping("/userMessage")
    public List<String> userMessage(UserInfo userInfo){
        //获取用户参与活动数量

        //获取用户所在组织人数
        int teamPeoNum=teamService.findTeamMessageByTeamName(userInfo.getTeamName()).getTeamPeopleNum();
        //获取用户所在组织服务时长
        int teamPeoTime=teamService.findTeamMessageByTeamName(userInfo.getTeamName()).getTeamHelpTime();
        //创建集合存放信息
        List<String> messageList=new ArrayList<>();
        messageList.add(String.valueOf(teamPeoTime));
        messageList.add(String.valueOf(teamPeoNum));
        return messageList;
    }
}
