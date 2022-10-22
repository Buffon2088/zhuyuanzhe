package zhiyuanzhe.service;

import zhiyuanzhe.pojo.TeamReqInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;

import java.util.List;

public interface ITeamReqService {
    List<TeamReqInfo> findAllTeam();
    TeamTypeInfo findTeamReq(TeamReqInfo teamReqInfo);
    boolean addTeamReq(TeamReqInfo teamReqInfo);
    boolean updateTeamReq(TeamReqInfo teamReqInfo);
    boolean deleteTeamReq(TeamReqInfo teamReqInfo);
}
