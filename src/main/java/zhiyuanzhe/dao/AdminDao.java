package zhiyuanzhe.dao;

import org.apache.ibatis.annotations.Param;
import zhiyuanzhe.pojo.AdminInfo;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface AdminDao {
    List<AdminInfo> findAll();
    AdminInfo findAdmin(AdminInfo adminInfo);
    int addAdmin(AdminInfo adminInfo);
    int updateAdmin(AdminInfo adminInfo);
    int deleteAdmin(AdminInfo adminInfo);
    List<AdminInfo> findSuperAdmin(@Param("adminState") String adminState);
}
