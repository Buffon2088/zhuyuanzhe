package zhiyuanzhe.funtion.checkRule;


import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.IUserService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Type: 用户信息校验类
 * Context:用户校验
 * Date:2022/10/21
 */
public class UserLoginMessage {
    /**
     * 登录信息校验
     */
    public String userLoginCheck(IUserService userService, UserInfo userInfo) {
        //获取用户信息
        UserInfo user = userService.findUser(userInfo);
        //获取实体类的所有属性，返回Field数组
        Field[] field = userInfo.getClass().getDeclaredFields();
        //存放异常信息
        Map<String, String> errMap = new HashMap<>();
        //遍历所有属性
        for (int j = 0; j < field.length; j++) {
            //获取属性名
            String objectName = field[j].getName();
            //将属性的首字符大写，方便构造get，set方法
            objectName = objectName.substring(0, 1).toUpperCase() + objectName.substring(1);
            // 获取属性的类型
            String objectType = field[j].getGenericType().toString();
            // 如果type是类类型，则前面包含"class "，后面跟类名
            try {
                Method m = userInfo.getClass().getMethod("get" + objectName);
                // 调用getter方法获取属性值
                Object value = m.invoke(userInfo);
                if (value == null) {
                    errMap.put(objectName, "数据为空!");
                    System.out.println(objectName + "数据为空！");
                    break;
                } else {

                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (errMap.size() > 0) {
            String returnValue=errMap.toString();
            return returnValue;
        } else {
            return "Y";
        }
    }
}