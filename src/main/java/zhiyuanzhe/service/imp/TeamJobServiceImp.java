package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.TeamJobDao;
import zhiyuanzhe.pojo.TeamJobInfo;
import zhiyuanzhe.service.ITeamJobService;

import java.util.List;

@Service
@Transactional
public class TeamJobServiceImp implements ITeamJobService {

    @Autowired
    private TeamJobDao teamJobDao;

    @Override
    public List<TeamJobInfo> findALLTeamJ() {
        return teamJobDao.findALLTeamJ();
    }

    @Override
    public TeamJobInfo findTeamJob(TeamJobInfo teamJobInfo) {
        return teamJobDao.findTeamJob(teamJobInfo);
    }

    @Override
    public boolean addTeamJob(TeamJobInfo teamJobInfo) {
        return teamJobDao.addTeamJob(teamJobInfo)>0;
    }

    @Override
    public boolean updateTeamJob(TeamJobInfo teamJobInfo) {
        return teamJobDao.updateTeamJob(teamJobInfo)>0;
    }

    @Override
    public boolean deleteTeamJob(TeamJobInfo teamJobInfo) {
        return teamJobDao.deleteTeamJob(teamJobInfo)>0;
    }
}
