package zhiyuanzhe.dao;

import org.apache.ibatis.annotations.Param;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.pojo.ActiveJoinInInfo;

import java.util.List;

public interface ActiveJoinDao {
    ActiveJoinInInfo findActiveState(@Param("activeId") int activeId,@Param("userId") int userId);

    List<ActiveJoinInInfo> findAllJoin();

    int addActiveJoin(ActiveJoinInInfo activeJoinInInfo);

    ActiveJoinInInfo findActiveJoinMessage(ActiveJoinInInfo activeJoinInInfo);

    int passReq(ActiveJoinInInfo activeJoinInInfo);

    int refuseReq(ActiveJoinInInfo activeJoinInInfo);

    List<ActiveJoinInInfo> findActiveJoinMessageByState(ActiveJoinInInfo activeJoinInInfo);

    int findActNumByUser(@Param("userId")int userId);

}
