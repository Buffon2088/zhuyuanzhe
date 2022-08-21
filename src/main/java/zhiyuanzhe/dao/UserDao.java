package zhiyuanzhe.dao;

import zhiyuanzhe.pojo.UserInfo;

import java.util.List;

public interface UserDao {

    List<UserInfo> findAll();
    UserInfo findAllUser(UserInfo userInfo);
    int addUser(UserInfo userInfo);
    int updateUser(UserInfo userInfo);
    int deleteUser(UserInfo userInfo);
}
