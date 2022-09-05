package zhiyuanzhe.service;

import zhiyuanzhe.pojo.AdminInfo;
import zhiyuanzhe.pojo.UserInfo;

import java.util.List;

public interface IUserService {
    boolean userLogin(UserInfo userInfo);
    UserInfo findUserByLoginNameAndPwd(UserInfo userInfo);
    List<UserInfo> findAll();
    UserInfo findUser(UserInfo userInfo);
    int addUser(UserInfo userInfo);
    int updateUser(UserInfo userInfo);
    int deleteUser(UserInfo userInfo);
}
