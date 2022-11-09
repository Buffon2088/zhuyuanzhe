package zhiyuanzhe.funtion.objectInfo;

import zhiyuanzhe.pojo.AdminInfo;
import zhiyuanzhe.service.IAdminService;

import java.util.List;

/**
 * Type: 超级管理员信息
 * Context:管理员实体类
 * Date:2022/10/29
 */
public class SuperAdmin {
    /**超级管理员*/
    static final String SUPER_ADMIN="99";
    /**
     * 查询超级管理员
     * */
    public AdminInfo superAdmin(IAdminService adminService){
        //查询超级管理员信息
        List<AdminInfo> adminInfoList=adminService.findSuperAdmin(SUPER_ADMIN);
        //只取其中一位管理员
        AdminInfo adminInfo = null;
        for (int i=0;i<adminInfoList.size();i++){
            adminInfo=adminInfoList.get(i);
            //超级管理员信息校验
            boolean result=this.adminCheck(adminInfo);
            if (result=true){
                break;
            }
        }
        return adminInfo;
    }

    /**
     * 超级管理员信息校验
     * */
    public boolean adminCheck(AdminInfo adminInfo){
        //校验管理员
        if (adminInfo.getAdminState().equals(SUPER_ADMIN)){
            if (adminInfo.getEmail().length()>0){
                if (adminInfo.getKey().length()>0){
                    return true;
                }
            }
        }else {
            return false;
        }
        return false;
    }
}
