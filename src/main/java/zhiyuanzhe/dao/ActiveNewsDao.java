package zhiyuanzhe.dao;

import zhiyuanzhe.pojo.ActiveNewsInfo;

import java.util.List;

public interface ActiveNewsDao {

    List<ActiveNewsInfo> findAll();
    ActiveNewsInfo findNews(ActiveNewsInfo activeNewsInfo);
    int addNews(ActiveNewsInfo activeNewsInfo);
    int deleteNews(ActiveNewsInfo activeNewsInfo);
    int updateNews(ActiveNewsInfo activeNewsInfo);
}
