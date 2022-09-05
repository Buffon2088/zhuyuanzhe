package zhiyuanzhe.service;

import zhiyuanzhe.pojo.AdminInfo;
import zhiyuanzhe.pojo.UserInfo;

import java.util.List;

public interface IUserService {
    boolean userLogin(UserInfo userInfo);
    UserInfo findUserByLoginNameAndPwd(UserInfo userInfo);
    List<UserInfo> findAll();
    UserInfo findUser(UserInfo userInfo);
    boolean addUser(UserInfo userInfo);
    boolean updateUser(UserInfo userInfo);
    boolean deleteUser(UserInfo userInfo);
}
