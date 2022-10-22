package zhiyuanzhe.dao;

import zhiyuanzhe.pojo.TeamReqInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;

import java.util.List;

public interface TeamReqDao {

    List<TeamReqInfo> findAllTeam();
    TeamTypeInfo findTeamReq(TeamReqInfo teamReqInfo);
    int addTeamReq(TeamReqInfo teamReqInfo);
    int updateTeamReq(TeamReqInfo teamReqInfo);
    int deleteTeamReq(TeamReqInfo teamReqInfo);
}
