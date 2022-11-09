package zhiyuanzhe.service;

import org.apache.ibatis.annotations.Param;
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
    List<AdminInfo> findSuperAdmin(@Param("adminState") String adminState);
}
