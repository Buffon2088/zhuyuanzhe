package zhiyuanzhe.service;

import zhiyuanzhe.pojo.TeamTypeInfo;

import java.util.List;

public interface ITeamTypeService {

    List<TeamTypeInfo> findAll();

    TeamTypeInfo findTeamType(TeamTypeInfo teamTypeInfo);

    boolean checkName(TeamTypeInfo teamTypeInfo);

    boolean addTeamType(TeamTypeInfo teamTypeInfo);

    boolean updateTeamType(TeamTypeInfo teamTypeInfo);

    boolean deleteTeamType(TeamTypeInfo teamTypeInfo);
}
