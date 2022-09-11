package zhiyuanzhe.pojo;

public class ActiveJoinInInfo {
    private int activeJoinInId;
    private ActiveTypeInfo activeTypeInfo;
    private TeamInfo teamInfo;
    private UserInfo userInfo;
    private AdminInfo adminInfo;
    private ActiveInfo activeInfo;
    private String activeJoinInState;
    private int activeJoinInNum;
    private String activeJoinInAskTime;
    private String activeJoinInPassTime;

    public ActiveJoinInInfo() {
    }

    public ActiveJoinInInfo(int activeJoinInId, ActiveTypeInfo activeTypeInfo, TeamInfo teamInfo, UserInfo userInfo, AdminInfo adminInfo, ActiveInfo activeInfo, String activeJoinInState, int activeJoinInNum, String activeJoinInAskTime, String activeJoinInPassTime) {
        this.activeJoinInId = activeJoinInId;
        this.activeTypeInfo = activeTypeInfo;
        this.teamInfo = teamInfo;
        this.userInfo = userInfo;
        this.adminInfo = adminInfo;
        this.activeInfo = activeInfo;
        this.activeJoinInState = activeJoinInState;
        this.activeJoinInNum = activeJoinInNum;
        this.activeJoinInAskTime = activeJoinInAskTime;
        this.activeJoinInPassTime = activeJoinInPassTime;
    }

    public int getActiveJoinInId() {
        return activeJoinInId;
    }

    public void setActiveJoinInId(int activeJoinInId) {
        this.activeJoinInId = activeJoinInId;
    }

    public ActiveTypeInfo getActiveTypeInfo() {
        return activeTypeInfo;
    }

    public void setActiveTypeInfo(ActiveTypeInfo activeTypeInfo) {
        this.activeTypeInfo = activeTypeInfo;
    }

    public TeamInfo getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(TeamInfo teamInfo) {
        this.teamInfo = teamInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

    public ActiveInfo getActiveInfo() {
        return activeInfo;
    }

    public void setActiveInfo(ActiveInfo activeInfo) {
        this.activeInfo = activeInfo;
    }

    public String getActiveJoinInState() {
        return activeJoinInState;
    }

    public void setActiveJoinInState(String activeJoinInState) {
        this.activeJoinInState = activeJoinInState;
    }

    public int getActiveJoinInNum() {
        return activeJoinInNum;
    }

    public void setActiveJoinInNum(int activeJoinInNum) {
        this.activeJoinInNum = activeJoinInNum;
    }

    public String getActiveJoinInAskTime() {
        return activeJoinInAskTime;
    }

    public void setActiveJoinInAskTime(String activeJoinInAskTime) {
        this.activeJoinInAskTime = activeJoinInAskTime;
    }

    public String getActiveJoinInPassTime() {
        return activeJoinInPassTime;
    }

    public void setActiveJoinInPassTime(String activeJoinInPassTime) {
        this.activeJoinInPassTime = activeJoinInPassTime;
    }
}
