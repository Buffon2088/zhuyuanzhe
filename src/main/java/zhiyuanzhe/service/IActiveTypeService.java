package zhiyuanzhe.service;

import zhiyuanzhe.pojo.ActiveTypeInfo;
import zhiyuanzhe.pojo.TeamTypeInfo;

import java.util.List;

public interface IActiveTypeService {

    List<ActiveTypeInfo> findAllActiveType();
    ActiveTypeInfo findActiveType(ActiveTypeInfo activeTypeInfo);
    boolean addActiveType(ActiveTypeInfo activeTypeInfo);
    boolean updateActiveType(ActiveTypeInfo activeTypeInfo);
    boolean deleteActiveType(ActiveTypeInfo activeTypeInfo);
}
