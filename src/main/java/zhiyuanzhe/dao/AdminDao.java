package zhiyuanzhe.dao;

import zhiyuanzhe.pojo.AdminInfo;

import java.util.List;

public interface AdminDao {
    List<AdminInfo> findAll();
    AdminInfo findAdmin(AdminInfo adminInfo);
    int addAdmin(AdminInfo adminInfo);
    int updateAdmin(AdminInfo adminInfo);
    int deleteAdmin(AdminInfo adminInfo);

}
