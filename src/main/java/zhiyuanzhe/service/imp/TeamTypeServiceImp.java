package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.TeamTypeDao;
import zhiyuanzhe.pojo.TeamTypeInfo;
import zhiyuanzhe.service.ITeamTypeService;

import java.util.List;

@Service
@Transactional
public class TeamTypeServiceImp implements ITeamTypeService {

    @Autowired
    private TeamTypeDao teamTypeDao;

    @Override
    public List<TeamTypeInfo> findAll() {
        return teamTypeDao.findAllTeamT();
    }

    @Override
    public TeamTypeInfo findTeamType(TeamTypeInfo teamTypeInfo) {
        return teamTypeDao.findTeamType(teamTypeInfo);
    }

    @Override
    public boolean addTeamType(TeamTypeInfo teamTypeInfo) {
        return teamTypeDao.addTeamType(teamTypeInfo)>0;
    }

    @Override
    public boolean updateTeamType(TeamTypeInfo teamTypeInfo) {
        return teamTypeDao.updateTeamType(teamTypeInfo)>0;
    }

    @Override
    public boolean deleteTeamType(TeamTypeInfo teamTypeInfo) {
        return teamTypeDao.deleteTeamType(teamTypeInfo)>0;
    }
}
