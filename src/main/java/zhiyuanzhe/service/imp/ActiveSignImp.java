package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.ActiveSignDao;
import zhiyuanzhe.dao.AdminDao;
import zhiyuanzhe.pojo.ActiveSignInfo;
import zhiyuanzhe.pojo.AdminInfo;
import zhiyuanzhe.service.IActiveSignService;
import zhiyuanzhe.service.IAdminService;

import java.util.List;

@Service
@Transactional
public class ActiveSignImp implements IActiveSignService {
    @Autowired
    private ActiveSignDao activeSignDao;
    @Override
    public List<ActiveSignInfo> findAllActiveSign() {
        return activeSignDao.findAllActiveSign();
    }

    @Override
    public ActiveSignInfo findActiveSign(ActiveSignInfo activeSignInfo) {
        return activeSignDao.findActiveSign(activeSignInfo);
    }

    @Override
    public boolean addActiveSign(ActiveSignInfo activeSignInfo) {
        return activeSignDao.addActiveSign(activeSignInfo)>0;
    }

    @Override
    public boolean updateActiveSign(ActiveSignInfo activeSignInfo) {
        return activeSignDao.updateActiveSign(activeSignInfo)>0;
    }

    @Override
    public boolean deleteActiveSign(ActiveSignInfo activeSignInfo) {
        return activeSignDao.deleteActiveSign(activeSignInfo)>0;
    }
}
