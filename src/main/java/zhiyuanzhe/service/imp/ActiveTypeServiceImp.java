package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.ActiveTypeDao;
import zhiyuanzhe.pojo.ActiveTypeInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;
import zhiyuanzhe.service.IActiveTypeService;

import java.util.List;

@Service
@Transactional
public class ActiveTypeServiceImp implements IActiveTypeService {
    @Autowired
    private ActiveTypeDao activeTypeDao;

    @Override
    public List<ActiveTypeInfo> findAllActiveType() {
        return activeTypeDao.findAllActiveType();
    }

    @Override
    public TeamTypeInfo findActiveType(ActiveTypeInfo activeTypeInfo) {
        return activeTypeDao.findActiveType(activeTypeInfo);
    }

    @Override
    public boolean addActiveType(ActiveTypeInfo activeTypeInfo) {
        return activeTypeDao.addActiveType(activeTypeInfo)>0;
    }

    @Override
    public boolean updateActiveType(ActiveTypeInfo activeTypeInfo) {
        return activeTypeDao.updateActiveType(activeTypeInfo)>0;
    }

    @Override
    public boolean deleteActiveType(ActiveTypeInfo activeTypeInfo) {
        return activeTypeDao.deleteActiveType(activeTypeInfo)>0;
    }
}
