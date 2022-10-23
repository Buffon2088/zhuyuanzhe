package zhiyuanzhe.service;

import org.apache.ibatis.annotations.Param;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.pojo.UserInfo;

import java.util.List;

public interface ITeamService {
    List<TeamInfo> findAllTeam();
    List<TeamInfo> findTeamList(int teamTypeId);
    TeamInfo findTeam(TeamInfo teamInfo);
    boolean addTeam(TeamInfo teamInfo);
    boolean updateTeam(TeamInfo teamInfo);
    boolean deleteTeam(TeamInfo teamInfo);
    TeamInfo findTeamMessageByTeamName(@Param("teamName") String teamName);
    TeamInfo findTeamByUserId(@Param("userId") int userId);
    List<TeamInfo> findTeamByGrade(@Param("grade") String grade);
}
