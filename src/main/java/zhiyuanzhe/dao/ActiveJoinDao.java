package zhiyuanzhe.dao;

import org.apache.ibatis.annotations.Param;
import zhiyuanzhe.pojo.ActiveJoinInInfo;

import java.util.List;

public interface ActiveJoinDao {
    ActiveJoinInInfo findActiveState(@Param("activeId") int activeId,@Param("userId") int userId);
    ActiveJoinInInfo findTest(@Param("userid") int id);
    List<ActiveJoinInInfo> findAllJoin();
}
