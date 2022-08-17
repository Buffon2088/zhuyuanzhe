package zhiyuanzhe.pojo;


public class ActiveNewsInfo {
    private int activeNewsId;
    private String activeNewsImg;
    private String activeNewsName;
    private String activeNewsContext;
    private String activeNewsTime;
    private int activeNewsNum;
    private AdminInfo adminInfo;
    private String activeNewsState;

    public ActiveNewsInfo() {
    }

    public ActiveNewsInfo(int activeNewsId, String activeNewsImg, String activeNewsName, String activeNewsContext, String activeNewsTime, int activeNewsNum, AdminInfo adminInfo, String activeNewsState) {
        this.activeNewsId = activeNewsId;
        this.activeNewsImg = activeNewsImg;
        this.activeNewsName = activeNewsName;
        this.activeNewsContext = activeNewsContext;
        this.activeNewsTime = activeNewsTime;
        this.activeNewsNum = activeNewsNum;
        this.adminInfo = adminInfo;
        this.activeNewsState = activeNewsState;
    }

    public int getActiveNewsId() {
        return activeNewsId;
    }

    public void setActiveNewsId(int activeNewsId) {
        this.activeNewsId = activeNewsId;
    }

    public String getActiveNewsImg() {
        return activeNewsImg;
    }

    public void setActiveNewsImg(String activeNewsImg) {
        this.activeNewsImg = activeNewsImg;
    }

    public String getActiveNewsName() {
        return activeNewsName;
    }

    public void setActiveNewsName(String activeNewsName) {
        this.activeNewsName = activeNewsName;
    }

    public String getActiveNewsContext() {
        return activeNewsContext;
    }

    public void setActiveNewsContext(String activeNewsContext) {
        this.activeNewsContext = activeNewsContext;
    }

    public String getActiveNewsTime() {
        return activeNewsTime;
    }

    public void setActiveNewsTime(String activeNewsTime) {
        this.activeNewsTime = activeNewsTime;
    }

    public int getActiveNewsNum() {
        return activeNewsNum;
    }

    public void setActiveNewsNum(int activeNewsNum) {
        this.activeNewsNum = activeNewsNum;
    }

    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

    public String getActiveNewsState() {
        return activeNewsState;
    }

    public void setActiveNewsState(String activeNewsState) {
        this.activeNewsState = activeNewsState;
    }
}
