package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.ActiveJoinDao;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.pojo.ActiveJoinInInfo;
import zhiyuanzhe.service.IActiveJoinService;
@Service
@Transactional
@Component
public class ActiveJoinServiceImp implements IActiveJoinService {
    @Autowired
    private ActiveJoinDao activeJoinDao;


    @Override
    public String findActiveState(int activeId, int userId) {
        try{
            //调用dao方法返回审核实体
            ActiveJoinInInfo activeJoinInfo=activeJoinDao.findActiveState(activeId,userId);
            //获取到当前状态
            String activeState=activeJoinInfo.getActiveJoinInState();
            return activeState;
        }catch (Exception e){
            return null;
        }
    }
}