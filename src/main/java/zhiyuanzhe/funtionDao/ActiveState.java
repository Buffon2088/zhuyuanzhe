package zhiyuanzhe.funtionDao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zhiyuanzhe.dao.ActiveJoinDao;
import zhiyuanzhe.pojo.ActiveInfo;
import zhiyuanzhe.pojo.ActiveJoinInInfo;
import zhiyuanzhe.service.IActiveJoinService;



@Controller
@RequestMapping("/user")
public class ActiveState {
    @Autowired
    private IActiveJoinService activeJoinService;
    @Autowired
    private ActiveJoinDao activeJoinDao;
    public String activeState(ActiveInfo activeInfo,int userId){

        activeJoinDao.findAllJoin();
        //查询审核表中状态值

        return "22";
    }
}
