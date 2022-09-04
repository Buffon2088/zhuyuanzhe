package zhiyuanzhe.service;

import zhiyuanzhe.pojo.ActiveTypeInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;

import java.util.List;

public interface IActiveTypeService {

    List<ActiveTypeInfo> findAllActiveType();
    TeamTypeInfo findActiveType(ActiveTypeInfo activeTypeInfo);
    boolean addActiveType(ActiveTypeInfo activeTypeInfo);
    boolean updateActiveType(ActiveTypeInfo activeTypeInfo);
    boolean deleteActiveType(ActiveTypeInfo activeTypeInfo);
}
