package zhiyuanzhe.funtion.checkRule;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.pojo.TeamReqInfo;
import zhiyuanzhe.service.ITeamReqService;
import zhiyuanzhe.service.ITeamService;

/**
 * Type: 组织校验类
 * Context:申请加入组织校验类
 * Date:2022/10/25
 */
@Service
@Transactional
public  class  IsReqTeam {
    /**初级组织所需时间*/
    public static final int LOW_TEAM_TIME=50;
    /**中级组织所需时间*/
    public static final int MIDDLE_TEAM_TIME=500;
    /**高级组织所需时间*/
    public static final int HIGH_TEAM_TIME=1000;

    /**
     * 校验当前是否申请
     * */
    public boolean reqTeamState(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService){
        //初始化teamInfo
        TeamInfo teamInfo=new TeamInfo();
        teamInfo.setTeamName(teamName);
        //通过teamName查询id
        int teamId=teamService.findTeam(teamInfo).getTeamId();
        //通过条件查询记录表
        TeamReqInfo teamReqInfo=teamReqService.findReqByUserIdAndTeamName(userId,teamId);
        if (teamReqInfo==null){
            return this.isTimeEnough(userId,teamName,teamReqService,teamService);
        }else {
            return false;
        }
    }

    /**
     * 校验个人时长是否满足
     * */
    public boolean isTimeEnough(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService){
        //
        return this.teamPeopleEnough(userId,teamName,teamReqService,teamService);
    }

    /**
     * 校验组织人员是否已满
     * */
     public boolean teamPeopleEnough(int userId, String teamName, ITeamReqService teamReqService, ITeamService teamService){
         //
         return true;
     }
}
