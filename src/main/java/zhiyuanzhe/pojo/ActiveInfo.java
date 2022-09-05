package zhiyuanzhe.pojo;

import org.springframework.format.annotation.DateTimeFormat;

public class ActiveInfo {
    private int activeId;
    private String activeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String activeStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String activeEndTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private int activeTime;
    private String activeAddress;
    private int activeHighNum;
    private int activeLowNum;
    private int activeNum;
    private String activeContext;
    private String activeState;
    private int activeJoinNum;
    private String img;
    private AdminInfo adminInfo;
    private ActiveTypeInfo activeTypeInfo;
    private TeamTypeInfo teamTypeInfo;

    public ActiveInfo() {
    }

    public ActiveInfo(int activeId, String activeName, String activeStartTime, String activeEndTime, int activeTime, String activeAddress, int activeHighNum, int activeLowNum, int activeNum, String activeContext, String activeState, int activeJoinNum, String img, AdminInfo adminInfo, ActiveTypeInfo activeTypeInfo, TeamTypeInfo teamTypeInfo) {
        this.activeId = activeId;
        this.activeName = activeName;
        this.activeStartTime = activeStartTime;
        this.activeEndTime = activeEndTime;
        this.activeTime = activeTime;
        this.activeAddress = activeAddress;
        this.activeHighNum = activeHighNum;
        this.activeLowNum = activeLowNum;
        this.activeNum = activeNum;
        this.activeContext = activeContext;
        this.activeState = activeState;
        this.activeJoinNum = activeJoinNum;
        this.img = img;
        this.adminInfo = adminInfo;
        this.activeTypeInfo = activeTypeInfo;
        this.teamTypeInfo = teamTypeInfo;
    }

    public int getActiveId() {
        return activeId;
    }

    public void setActiveId(int activeId) {
        this.activeId = activeId;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public String getActiveStartTime() {
        return activeStartTime;
    }

    public void setActiveStartTime(String activeStartTime) {
        this.activeStartTime = activeStartTime;
    }

    public String getActiveEndTime() {
        return activeEndTime;
    }

    public void setActiveEndTime(String activeEndTime) {
        this.activeEndTime = activeEndTime;
    }

    public int getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(int activeTime) {
        this.activeTime = activeTime;
    }

    public String getActiveAddress() {
        return activeAddress;
    }

    public void setActiveAddress(String activeAddress) {
        this.activeAddress = activeAddress;
    }

    public int getActiveHighNum() {
        return activeHighNum;
    }

    public void setActiveHighNum(int activeHighNum) {
        this.activeHighNum = activeHighNum;
    }

    public int getActiveLowNum() {
        return activeLowNum;
    }

    public void setActiveLowNum(int activeLowNum) {
        this.activeLowNum = activeLowNum;
    }

    public int getActiveNum() {
        return activeNum;
    }

    public void setActiveNum(int activeNum) {
        this.activeNum = activeNum;
    }

    public String getActiveContext() {
        return activeContext;
    }

    public void setActiveContext(String activeContext) {
        this.activeContext = activeContext;
    }

    public String getActiveState() {
        return activeState;
    }

    public void setActiveState(String activeState) {
        this.activeState = activeState;
    }

    public int getActiveJoinNum() {
        return activeJoinNum;
    }

    public void setActiveJoinNum(int activeJoinNum) {
        this.activeJoinNum = activeJoinNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

    public ActiveTypeInfo getActiveTypeInfo() {
        return activeTypeInfo;
    }

    public void setActiveTypeInfo(ActiveTypeInfo activeTypeInfo) {
        this.activeTypeInfo = activeTypeInfo;
    }

    public TeamTypeInfo getTeamTypeInfo() {
        return teamTypeInfo;
    }

    public void setTeamTypeInfo(TeamTypeInfo teamTypeInfo) {
        this.teamTypeInfo = teamTypeInfo;
    }
}
