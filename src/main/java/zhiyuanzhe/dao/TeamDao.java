package zhiyuanzhe.dao;

import zhiyuanzhe.pojo.TeamInfo;

import java.util.List;

public interface TeamDao {

    List<TeamInfo> findAllTeam();
    List<TeamInfo> findTeamList(int teamTypeId);
    TeamInfo findTeam(TeamInfo teamInfo);
    int addTeam(TeamInfo teamInfo);
    int updateTeam(TeamInfo teamInfo);
    int deleteTeam(TeamInfo teamInfo);
}
