package zhiyuanzhe.service;

import zhiyuanzhe.pojo.ActiveInfo;

import java.util.List;

public interface IActiveService {

    List<ActiveInfo> activeList();

    List<ActiveInfo> activeList(int activeTypeId);

    ActiveInfo findActive(ActiveInfo activeInfo);

    boolean addActive(ActiveInfo activeInfo);

    boolean updateActive(ActiveInfo activeInfo);

    boolean delActive(ActiveInfo activeInfo);
    //批量处理
    boolean delActiveList(int begin,int end);
    //批量添加
    int addActiveList(List<ActiveInfo> activeInfoList);

    int countNum();
}
