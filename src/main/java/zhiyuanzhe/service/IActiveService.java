package zhiyuanzhe.service;

import org.apache.ibatis.annotations.Param;
import zhiyuanzhe.pojo.ActiveInfo;

import java.util.List;

public interface IActiveService {

    List<ActiveInfo> activeList();

    List<ActiveInfo> activeList(int activeTypeId);
    //通过ID查看
    ActiveInfo findActiveById(ActiveInfo activeInfo);

    ActiveInfo findActive(ActiveInfo activeInfo);

    boolean addActive(ActiveInfo activeInfo);

    boolean updateActive(ActiveInfo activeInfo);

    boolean delActive(ActiveInfo activeInfo);
    //批量处理
    boolean delActiveList(int begin,int end);
    //批量添加
    int addActiveList(List<ActiveInfo> activeInfoList);

    int countNum();

    List<ActiveInfo> findHotAct();

    int sumActTime();

    List<ActiveInfo> findActByActiveType(@Param("activeType") String activeType);
}
