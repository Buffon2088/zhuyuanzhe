package zhiyuanzhe.dao;

import zhiyuanzhe.pojo.ActiveTypeInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;

import java.util.List;

public interface ActiveTypeDao {

    List<ActiveTypeInfo> findAllActiveType();
    TeamTypeInfo findActiveType(ActiveTypeInfo activeTypeInfo);
    int addActiveType(ActiveTypeInfo activeTypeInfo);
    int updateActiveType(ActiveTypeInfo activeTypeInfo);
    int deleteActiveType(ActiveTypeInfo activeTypeInfo);
}
