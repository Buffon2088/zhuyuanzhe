package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.AdminDao;
import zhiyuanzhe.dao.UserDao;
import zhiyuanzhe.pojo.AdminInfo;
import zhiyuanzhe.pojo.UserInfo;
import zhiyuanzhe.service.IAdminService;
import zhiyuanzhe.service.IUserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean userLogin(UserInfo userInfo) {
        return userDao.findUser(userInfo) != null;
    }

    @Override
    public UserInfo findUserByLoginNameAndPwd(UserInfo userInfo) {
        return userDao.findUser(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserInfo findUser(UserInfo userInfo) {
        return userDao.findUser(userInfo);
    }

    @Override
    public int addUser(UserInfo userInfo) {
        return userDao.addUser(userInfo);
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        return userDao.updateUser(userInfo);
    }

    @Override
    public int deleteUser(UserInfo userInfo) {
        return userDao.deleteUser(userInfo);
    }
}
