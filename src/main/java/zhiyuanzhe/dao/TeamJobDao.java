package zhiyuanzhe.dao;

import zhiyuanzhe.pojo.TeamJobInfo;

import java.util.List;

public interface TeamJobDao {

    List<TeamJobInfo> findALLTeamJ ();
    TeamJobInfo findTeamJob (TeamJobInfo teamJobInfo);
    int addTeamJob (TeamJobInfo teamJobInfo);
    int updateTeamJob(TeamJobInfo teamJobInfo);
    int deleteTeamJob(TeamJobInfo teamJobInfo);

}
