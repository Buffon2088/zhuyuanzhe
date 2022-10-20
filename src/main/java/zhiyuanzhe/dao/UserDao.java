package zhiyuanzhe.dao;

import org.apache.ibatis.annotations.Param;
import zhiyuanzhe.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<UserInfo> findAll();
    UserInfo findUser(UserInfo userInfo);
    int addUser(UserInfo userInfo);
    int updateUser(UserInfo userInfo);
    int deleteUser(UserInfo userInfo);
    List<UserInfo> teamJob();
    String findEmailByName(@Param("newAddressOr") String newAddressOr);
}
