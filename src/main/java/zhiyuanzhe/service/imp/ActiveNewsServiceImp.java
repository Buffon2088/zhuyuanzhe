package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.ActiveNewsDao;
import zhiyuanzhe.pojo.ActiveNewsInfo;
import zhiyuanzhe.service.IActiveNewsService;

import java.util.List;

@Service
@Transactional
public class ActiveNewsServiceImp implements IActiveNewsService {

    @Autowired
    private ActiveNewsDao activeNewsDao;

    @Override
    public List<ActiveNewsInfo> findAll() {
        return activeNewsDao.findAll();
    }

    @Override
    public ActiveNewsInfo findNews(ActiveNewsInfo activeNewsInfo) {
        return activeNewsDao.findNews(activeNewsInfo);
    }

    @Override
    public boolean addNews(ActiveNewsInfo activeNewsInfo) {
        return activeNewsDao.addNews(activeNewsInfo)>0;
    }

    @Override
    public boolean deleteNews(ActiveNewsInfo activeNewsInfo) {
        return activeNewsDao.deleteNews(activeNewsInfo)>0;
    }

    @Override
    public boolean updateNews(ActiveNewsInfo activeNewsInfo) {
        return activeNewsDao.updateNews(activeNewsInfo)>0;
    }
}
