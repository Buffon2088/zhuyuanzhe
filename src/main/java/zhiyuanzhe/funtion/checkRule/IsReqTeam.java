package zhiyuanzhe.funtion.checkRule;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.pojo.TeamReqInfo;
import zhiyuanzhe.service.ITeamReqService;
import zhiyuanzhe.service.ITeamService;

import java.util.List;

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
    public boolean reqTeamState(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService) {
        //初始化teamInfo
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setTeamName(teamName);
        //通过teamName查询id
        int teamId = teamService.findTeam(teamInfo).getTeamId();
        //通过条件查询记录表
        TeamReqInfo teamReqInfo = teamReqService.findReqByUserIdAndTeamName(userId, teamId);
        if (teamReqInfo == null) {
            return this.isTimeEnough(userId, teamName, teamReqService, teamService);
        } else {
            System.out.println("您当前已有申请该活动~");
            return false;
        }
    }

    /**
     * 校验个人时长是否满足
     */
    public boolean isTimeEnough(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService) {
        //查询用户服务时长
        TeamInfo userInfo = teamService.findTeamByUserId(userId);
        String userTime = userInfo.getUserInfo().getUserHelpTime();
        int userHelpTime = Integer.parseInt(userTime);
        //获取团队相应等级的服务时长
        TeamInfo teamInfo = teamService.findTeamMessageByTeamName(teamName);
        int teamTime = Integer.parseInt(teamInfo.getTeamTypeInfo().getTeamTypeState());
        //判断是否满足时长校验条件
        if (userHelpTime >= teamTime) {
            return this.teamPeopleEnough(userId, teamName, teamReqService, teamService);
        } else {
            return false;
        }
    }

    /**
     * 校验组织人员是否已满
     */
    public boolean teamPeopleEnough(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService) {
        //查询组织信息
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setTeamName(teamName);
        //获取组织当前人数
        int teamNowNum = Integer.valueOf(teamService.findTeam(teamInfo).getTeamNowNum());
        //获取组织最大人数
        int teamMaxNum = Integer.valueOf(teamService.findTeam(teamInfo).getTeamPeopleNum());
        if (teamMaxNum > teamNowNum) {
            return true;
        } else {
            System.out.println("当前组织人数已满~");
            return false;
        }
    }
}
