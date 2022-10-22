package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.TeamReqDao;
import zhiyuanzhe.pojo.TeamReqInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;
import zhiyuanzhe.service.ITeamReqService;

import java.util.List;
@Service
@Transactional
public class TeamReqServiceImp implements ITeamReqService {
    @Autowired
    private TeamReqDao reqDao;
    @Override
    public List<TeamReqInfo> findAllTeam() {
        return reqDao.findAllTeam();
    }

    @Override
    public TeamTypeInfo findTeamReq(TeamReqInfo teamReqInfo) {
        return reqDao.findTeamReq(teamReqInfo);
    }

    @Override
    public boolean addTeamReq(TeamReqInfo teamReqInfo) {
        return reqDao.addTeamReq(teamReqInfo)>0;
    }

    @Override
    public boolean updateTeamReq(TeamReqInfo teamReqInfo) {
        return reqDao.updateTeamReq(teamReqInfo)>0;
    }

    @Override
    public boolean deleteTeamReq(TeamReqInfo teamReqInfo) {
        return reqDao.deleteTeamReq(teamReqInfo)>0;
    }
}
