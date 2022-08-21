package zhiyuanzhe.dao;

import zhiyuanzhe.pojo.TeamTypeInfo;

import java.util.List;

public interface TeamTypeDao {

    List<TeamTypeInfo> findAllTeamT();
    TeamTypeInfo findTeamType(TeamTypeInfo teamTypeInfo);
    int addTeamType(TeamTypeInfo teamTypeInfo);
    int updateTeamType(TeamTypeInfo teamTypeInfo);
    int deleteTeamType(TeamTypeInfo teamTypeInfo);
}
