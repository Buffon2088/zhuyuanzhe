package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.ActiveDao;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.service.IActiveService;

import java.util.List;
@Service
@Transactional
public class ActiveServiceImp implements IActiveService {
    @Autowired
    private ActiveDao activeDao;
    @Override
    public List<ActiveInfo> activeList() {
        return activeDao.activeList();
    }

    @Override
    public List<ActiveInfo> activeList(int activeTypeId) {
        return activeDao.findActiveList(activeTypeId);
    }


    @Override
    public ActiveInfo findActive(ActiveInfo activeInfo) {
        return activeDao.findActive(activeInfo);
    }

    @Override
    public boolean addActive(ActiveInfo activeInfo) {
        return activeDao.addActive(activeInfo)>0;
    }

    @Override
    public boolean updateActive(ActiveInfo activeInfo) {
        return activeDao.updateActive(activeInfo)>0;
    }

    @Override
    public boolean delActive(ActiveInfo activeInfo) {
        return activeDao.delActive(activeInfo)>0;
    }

    @Override
    public boolean delActiveList(int begin, int end) {
        return activeDao.delActiveList(begin,end)>0;
    }
    //返回int 带编添加了几行
    @Override
    public int addActiveList(List<ActiveInfo> activeInfoList) {
        return activeDao.addActiveList(activeInfoList);
    }

    @Override
    public int countNum() {
        return activeDao.countNum();
    }


}
