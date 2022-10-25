package zhiyuanzhe.dao;

import org.apache.ibatis.annotations.Param;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.pojo.UserInfo;

import java.util.List;

public interface TeamDao {

    List<TeamInfo> findAllTeam();
    List<TeamInfo> findTeamList(int teamTypeId);
    TeamInfo findTeam(TeamInfo teamInfo);
    int addTeam(TeamInfo teamInfo);
    int updateTeam(TeamInfo teamInfo);
    int deleteTeam(TeamInfo teamInfo);
    TeamInfo findTeamMessageByTeamName(@Param("teamName") String teamName);
    TeamInfo findTeamByUserId(@Param("userId") int userId);
    List<TeamInfo> findTeamByGrade(@Param("grade") String grade);
    List<TeamInfo> buttonFindTeamList(@Param("date") String date);
}
