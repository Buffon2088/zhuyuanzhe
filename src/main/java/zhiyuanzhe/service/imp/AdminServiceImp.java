package zhiyuanzhe.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhiyuanzhe.dao.AdminDao;
import zhiyuanzhe.pojo.AdminInfo;
import zhiyuanzhe.service.IAdminService;

import java.util.List;

@Service
@Transactional
public class AdminServiceImp implements IAdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean adminLogin(AdminInfo adminInfo) {
        return adminDao.findAdmin(adminInfo) != null;
        //return adminDao.findAdmin(adminInfo) != null?true:false;
    }

    @Override
    public AdminInfo findAdminByLoginNameAndPwd(AdminInfo adminInfo) {
        return adminDao.findAdmin(adminInfo);
    }

    @Override
    public List<AdminInfo> findAll() {
        return adminDao.findAll();
    }

    @Override
    public AdminInfo findAdminById(AdminInfo adminInfo) {
        return adminDao.findAdmin(adminInfo);
    }

    @Override
    public boolean addAdmin(AdminInfo adminInfo) {
        return adminDao.addAdmin(adminInfo)>0;
    }

    @Override
    public boolean updateAdmin(AdminInfo adminInfo) {
        return adminDao.updateAdmin(adminInfo)>0;
    }

    @Override
    public boolean deleteAdmin(AdminInfo adminInfo) {
        return adminDao.deleteAdmin(adminInfo)>0;
    }
}
