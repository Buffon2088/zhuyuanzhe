package zhiyuanzhe.dao;
import org.apache.ibatis.annotations.Param;
import zhiyuanzhe.pojo.ActiveInfo;

import java.util.List;

public interface ActiveDao {
    List<ActiveInfo> activeList();

    ActiveInfo findActive(ActiveInfo activeInfo);

    List<ActiveInfo> findActiveList(int activeTypeId);

    int addActive(ActiveInfo activeInfo);

    int updateActive(ActiveInfo activeInfo);

    int delActive(ActiveInfo activeInfo);
    //批量删除
    int delActiveList(int begin,int end);
    //批量添加
    int addActiveList(List<ActiveInfo> activeInfoList);

    int countNum();

    List<ActiveInfo> findHotAct();

    int sumActTime();

    List<ActiveInfo> findActByActiveType(@Param("activeType") String activeType);

}
