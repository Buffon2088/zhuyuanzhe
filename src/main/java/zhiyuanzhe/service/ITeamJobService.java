package zhiyuanzhe.service;

import zhiyuanzhe.pojo.TeamJobInfo;

import java.util.List;

public interface ITeamJobService {

    List<TeamJobInfo> findALLTeamJ ();

    TeamJobInfo findTeamJob (TeamJobInfo teamJobInfo);

    boolean addTeamJob (TeamJobInfo teamJobInfo);

    boolean updateTeamJob(TeamJobInfo teamJobInfo);

    boolean deleteTeamJob(TeamJobInfo teamJobInfo);

    boolean resName(TeamJobInfo teamJobInfo);
}
