package zhiyuanzhe.dao;

import zhiyuanzhe.pojo.ActiveSignInfo;
import zhiyuanzhe.pojo.AdminInfo;

import java.util.List;


public interface ActiveSignDao {
    List<ActiveSignInfo> findAllActiveSign();
    ActiveSignInfo findActiveSign(ActiveSignInfo activeSignInfo);
    int addActiveSign(ActiveSignInfo activeSignInfo);
    int updateActiveSign(ActiveSignInfo activeSignInfo);
    int deleteActiveSign(ActiveSignInfo activeSignInfo);

}
