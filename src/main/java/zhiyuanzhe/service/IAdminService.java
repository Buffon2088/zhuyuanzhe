package zhiyuanzhe.service;

import zhiyuanzhe.pojo.AdminInfo;

import java.util.List;

public interface IAdminService {
    boolean adminLogin(AdminInfo adminInfo);
    AdminInfo findAdminByLoginNameAndPwd(AdminInfo adminInfo);
    List<AdminInfo> findAll();
    AdminInfo findAdminById(AdminInfo adminInfo);
    boolean addAdmin(AdminInfo adminInfo);
    boolean updateAdmin(AdminInfo adminInfo);
    boolean deleteAdmin(AdminInfo adminInfo);
}
