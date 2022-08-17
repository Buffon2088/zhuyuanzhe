package zhiyuanzhe.pojo;

public class AdminInfo {
    private int adminId;
    private String adminCarID;
    private String adminTel;
    private String adminLoginName;
    private String adminPwd;
    private String adminState;

    public AdminInfo() {
    }

    public AdminInfo(int adminId, String adminCarID, String adminTel, String adminLoginName, String adminPwd, String adminState) {
        this.adminId = adminId;
        this.adminCarID = adminCarID;
        this.adminTel = adminTel;
        this.adminLoginName = adminLoginName;
        this.adminPwd = adminPwd;
        this.adminState = adminState;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminCarID() {
        return adminCarID;
    }

    public void setAdminCarID(String adminCarID) {
        this.adminCarID = adminCarID;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

    public String getAdminLoginName() {
        return adminLoginName;
    }

    public void setAdminLoginName(String adminLoginName) {
        this.adminLoginName = adminLoginName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminState() {
        return adminState;
    }

    public void setAdminState(String adminState) {
        this.adminState = adminState;
    }
}
