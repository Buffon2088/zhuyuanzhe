package zhiyuanzhe.service;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.pojo.ActiveJoinInInfo;

public interface IActiveJoinService {

    String findActiveState(int activeId,int userId);

    boolean addActiveJoin(ActiveJoinInInfo activeJoinInInfo);
}
