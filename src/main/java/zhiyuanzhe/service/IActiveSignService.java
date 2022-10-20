package zhiyuanzhe.service;

import zhiyuanzhe.pojo.ActiveNewsInfo;
import zhiyuanzhe.pojo.ActiveSignInfo;

import java.util.List;

public interface IActiveSignService {
    List<ActiveSignInfo> findAllActiveSign();
    ActiveSignInfo findActiveSign(ActiveSignInfo activeSignInfo);
    boolean addActiveSign(ActiveSignInfo activeSignInfo);
    boolean updateActiveSign(ActiveSignInfo activeSignInfo);
    boolean deleteActiveSign(ActiveSignInfo activeSignInfo);
}
