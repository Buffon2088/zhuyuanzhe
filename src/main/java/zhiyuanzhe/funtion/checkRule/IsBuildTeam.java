package zhiyuanzhe.funtion.checkRule;

import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.IUserService;

import java.util.HashMap;
import java.util.Map;

/**
 * Type: 组织校验类
 * Context:创建组织校验类
 * Date:2022/10/29
 */
public class IsBuildTeam {
    public static  final int BUILD_TEAM_TIME=500;
    public Map<String,String> isBuildTeam(IUserService userService,UserInfo userInfo){
        Map<String, String> result = new HashMap<>();
        String teamName = userService.findUser(userInfo).getTeamName();
        //校验用户是否正常
        String userState=userService.findUser(userInfo).getState();
        if ("0".equals(userState)){
            result.put("2", "用戶异常，请联系管理员！");
            System.out.println("用戶异常，请联系管理员！");
            return result;
        }
        //校验用户是否已有组织
        String teamState = userService.findUser(userInfo).getTeamName();
        if (teamState.length() > 0) {
            result.put("2", "创建失败，您已有组织~");
            System.out.println("创建失败，您已有组织~");
            return result;
        }
        //校验用户时长是否满足
        int sumTime=Integer.valueOf(userService.findUser(userInfo).getUserHelpTime());
        int needTime=BUILD_TEAM_TIME-sumTime;
        if (sumTime<BUILD_TEAM_TIME){
            result.put("2", "创建失败,志愿时长不足!");
            System.out.println("创建失败,志愿时长不足!您当前志愿时长为"+userService.findUser(userInfo).getUserHelpTime()+"," +
                    "还差"+needTime+"小时");
            return result;
        }
        //创建成功
        result.put("2", "恭喜您！创建成功!");
        result.put("3", teamName);
        System.out.println("恭喜您！创建成功!");
        return result;
    }
}
