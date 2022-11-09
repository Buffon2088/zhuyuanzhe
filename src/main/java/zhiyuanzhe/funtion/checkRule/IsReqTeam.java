package zhiyuanzhe.funtion.checkRule;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.pojo.TeamReqInfo;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.ITeamReqService;
import zhiyuanzhe.service.ITeamService;
import zhiyuanzhe.service.IUserService;

import java.util.HashMap;
import java.util.Map;

/**
 * Type: 组织校验类
 * Context:申请加入组织校验类
 * Date:2022/10/25
 */
@Service
@Transactional
public class IsReqTeam {
    /**
     * 初级组织所需时间
     */
    public static final int LOW_TEAM_TIME = 50;
    /**
     * 中级组织所需时间
     */
    public static final int MIDDLE_TEAM_TIME = 500;
    /**
     * 高级组织所需时间
     */
    public static final int HIGH_TEAM_TIME = 1000;

    /**
     * 校验当前是否申请
     */
    public Map<String,String> reqTeamState(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService, IUserService userService) {
        Map<String,String> errorMap=new HashMap<>();
        //初始化teamInfo
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setTeamName(teamName);
        //通过teamName查询id
        int teamId = teamService.findTeam(teamInfo).getTeamId();
        //通过条件查询记录表
        TeamReqInfo teamReqInfo = teamReqService.findReqByUserIdAndTeamName(userId, teamId);
        if (teamReqInfo == null) {
            return this.isHaveTeam(userId, teamName, teamReqService, teamService,userService,errorMap);
        } else {
            errorMap.put("N","您当前已有申请该活动~");
            return errorMap;
        }
    }
    /**
     * 校验是否已有组织
     */
    public Map<String,String> isHaveTeam(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService, IUserService userService,Map<String,String> errorMap) {
        //初始化teamInfo
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        String teamState = userService.findUser(userInfo).getTeamName();
        if (teamState.length()>0){
            errorMap.put("N","您已存在组织，若想申请，请退出该组织~");
            return errorMap;
        }else {
            return this.isTimeEnough(userId, teamName, teamReqService, teamService,errorMap);
        }
    }

    /**
     * 校验个人时长是否满足
     */
    public Map<String,String> isTimeEnough(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService,Map<String,String> errorMap) {
        //查询用户服务时长
        TeamInfo userInfo = teamService.findTeamByUserId(userId);
        String userTime = userInfo.getUserInfo().getUserHelpTime();
        int userHelpTime = Integer.parseInt(userTime);
        //获取团队相应等级的服务时长
        TeamInfo teamInfo = teamService.findTeamMessageByTeamName(teamName);
        int teamTime = Integer.parseInt(teamInfo.getTeamTypeInfo().getTeamTypeState());
        //判断是否满足时长校验条件
        if (userHelpTime >= teamTime) {
            return this.teamPeopleEnough(userId, teamName, teamReqService, teamService,errorMap);
        } else {
            errorMap.put("N","您的志愿时长不足");
            return errorMap;
        }
    }

    /**
     * 校验组织人员是否已满
     */
    public Map<String,String> teamPeopleEnough(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService,Map<String,String> errorMap) {
        //查询组织信息
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setTeamName(teamName);
        //获取组织当前人数
        int teamNowNum = Integer.valueOf(teamService.findTeam(teamInfo).getTeamNowNum());
        //获取组织最大人数
        int teamMaxNum = Integer.valueOf(teamService.findTeam(teamInfo).getTeamPeopleNum());
        if (teamMaxNum > teamNowNum) {
            errorMap.put("Y","Y");
            return errorMap;
        } else {
            errorMap.put("N","当前组织人数已满~");
            return errorMap;
        }
    }
}
