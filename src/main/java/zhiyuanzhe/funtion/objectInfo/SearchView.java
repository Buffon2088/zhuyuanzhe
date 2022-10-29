package zhiyuanzhe.funtion.objectInfo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhiyuanzhe.pojo.TeamInfo;
import zhiyuanzhe.service.ITeamService;

import java.util.List;

/**
 * Type: 方法类
 * Context:ajax搜索框方法类
 * Date:2022/10/25
 */
@Service
@RequestMapping("/SearchView")
public class SearchView {
    @Autowired
    private ITeamService teamService;
    @ResponseBody
    @RequestMapping(value = "button",produces = "text/html;charset=UTF-8")
    public String button(String date) {
        List<TeamInfo> teamInfoList = teamService.buttonFindTeamList(date);
        return JSONObject.toJSONString(teamInfoList);
    }
}
