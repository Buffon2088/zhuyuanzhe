package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.ActiveJoinDao;
import zhiyuanzhe.pojo.ActiveJoinInInfo;
import zhiyuanzhe.service.IActiveJoinService;

import java.util.List;

@Service
@Transactional
public class ActiveJoinServiceImp implements IActiveJoinService {
    @Autowired
    private ActiveJoinDao activeJoinDao;


    @Override
    public String findActiveState(int activeId, int userId) {
        try{
            //调用dao方法返回审核实体
            ActiveJoinInInfo activeJoinInfo=activeJoinDao.findActiveState(activeId,userId);
            //获取到当前状态
            String activeState=activeJoinInfo.getActiveJoinInState();
            return activeState;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ActiveJoinInInfo findActiveJoinMessage(ActiveJoinInInfo activeJoinInInfo) {
        return activeJoinDao.findActiveJoinMessage(activeJoinInInfo);
    }

    @Override
    public boolean addActiveJoin(ActiveJoinInInfo activeJoinInInfo) {
        return activeJoinDao.addActiveJoin(activeJoinInInfo)>0;
    }

    @Override
    public List<ActiveJoinInInfo> findAllActJoin() {
        return activeJoinDao.findAllJoin();
    }

    @Override
    public boolean passReq(ActiveJoinInInfo activeJoinInInfo) {
        return activeJoinDao.passReq(activeJoinInInfo)>0;
    }

    @Override
    public List<ActiveJoinInInfo> findActiveJoinMessageByState(ActiveJoinInInfo activeJoinInInfo) {
        return activeJoinDao.findActiveJoinMessageByState(activeJoinInInfo);
    }

    @Override
    public boolean refuseReq(ActiveJoinInInfo activeJoinInInfo) {
        return activeJoinDao.refuseReq(activeJoinInInfo)>0;
    }
}