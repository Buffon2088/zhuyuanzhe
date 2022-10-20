package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.TeamDao;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.ITeamService;

import java.util.List;

@Service
@Transactional
public class TeamServiceImp implements ITeamService {

    @Autowired
    private TeamDao teamDao;

    @Override
    public List<TeamInfo> findAllTeam() {
        return teamDao.findAllTeam();
    }

    @Override
    public List<TeamInfo> findTeamList(int teamTypeId) {
        return teamDao.findTeamList(teamTypeId);
    }

    @Override
    public TeamInfo findTeam(TeamInfo teamInfo) {
        return teamDao.findTeam(teamInfo);
    }

    @Override
    public boolean addTeam(TeamInfo teamInfo) {
        return teamDao.addTeam(teamInfo)>0;
    }

    @Override
    public boolean updateTeam(TeamInfo teamInfo) {
        return teamDao.updateTeam(teamInfo)>0;
    }

    @Override
    public boolean deleteTeam(TeamInfo teamInfo) {
        return teamDao.deleteTeam(teamInfo)>0;
    }

    @Override
    public TeamInfo findTeamMessageByTeamName(String teamName) {
        return teamDao.findTeamMessageByTeamName(teamName);
    }


}
