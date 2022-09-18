package zhiyuanzhe.service;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.pojo.ActiveJoinInInfo;

import java.util.List;

public interface IActiveJoinService {

    String findActiveState(int activeId,int userId);

    ActiveJoinInInfo findActiveJoinMessage(ActiveJoinInInfo activeJoinInInfo);

    boolean addActiveJoin(ActiveJoinInInfo activeJoinInInfo);

    List<ActiveJoinInInfo> findAllActJoin();

    boolean passReq(ActiveJoinInInfo activeJoinInInfo);

    List<ActiveJoinInInfo> findActiveJoinMessageByState(ActiveJoinInInfo activeJoinInInfo);

    boolean refuseReq(ActiveJoinInInfo activeJoinInInfo);

}
