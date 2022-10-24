package zhiyuanzhe.dao;

import org.apache.ibatis.annotations.Param;
import zhiyuanzhe.pojo.TeamReqInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;

import java.util.List;

public interface TeamReqDao {

    List<TeamReqInfo> findAllTeam();
    TeamTypeInfo findTeamReq(TeamReqInfo teamReqInfo);
    int addTeamReq(TeamReqInfo teamReqInfo);
    int updateTeamReq(TeamReqInfo teamReqInfo);
    int deleteTeamReq(TeamReqInfo teamReqInfo);
    TeamReqInfo findReqByUserIdAndTeamName(@Param("userId")int userId,@Param("teamId") int teamId);
}
