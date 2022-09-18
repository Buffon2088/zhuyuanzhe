package zhiyuanzhe.service;

import zhiyuanzhe.pojo.TeamInfo;

import java.util.List;

public interface ITeamService {
    List<TeamInfo> findAllTeam();
    List<TeamInfo> findTeamList(int teamTypeId);
    TeamInfo findTeam(TeamInfo teamInfo);
    boolean addTeam(TeamInfo teamInfo);
    boolean updateTeam(TeamInfo teamInfo);
    boolean deleteTeam(TeamInfo teamInfo);
}
