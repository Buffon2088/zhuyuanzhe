package zhiyuanzhe.service;

import zhiyuanzhe.pojo.ActiveNewsInfo;

import java.util.List;

public interface IActiveNewsService {
    List<ActiveNewsInfo> findAll();
    ActiveNewsInfo findNews(ActiveNewsInfo activeNewsInfo);
    boolean addNews(ActiveNewsInfo activeNewsInfo);
    boolean deleteNews(ActiveNewsInfo activeNewsInfo);
    boolean updateNews(ActiveNewsInfo activeNewsInfo);
}
