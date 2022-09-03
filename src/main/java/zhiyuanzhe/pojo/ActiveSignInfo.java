package zhiyuanzhe.pojo;

public class ActiveSignInfo {
    private int activeSignId;
    private String activeSignState;
    private String activeSignStartTime;
    private String activeSignEndTime;
    private String activeSignTime;
    private String state;
    private ActiveTypeInfo activeTypeInfo;
    private TeamInfo teamInfo;
    private UserInfo userInfo;

    public ActiveSignInfo() {
    }

    public ActiveSignInfo(int activeSignId, String activeSignState, String activeSignStartTime, String activeSignEndTime, String activeSignTime, String state, ActiveTypeInfo activeTypeInfo, TeamInfo teamInfo, UserInfo userInfo) {
        this.activeSignId = activeSignId;
        this.activeSignState = activeSignState;
        this.activeSignStartTime = activeSignStartTime;
        this.activeSignEndTime = activeSignEndTime;
        this.activeSignTime = activeSignTime;
        this.state = state;
        this.activeTypeInfo = activeTypeInfo;
        this.teamInfo = teamInfo;
        this.userInfo = userInfo;
    }

    public int getActiveSignId() {
        return activeSignId;
    }

    public void setActiveSignId(int activeSignId) {
        this.activeSignId = activeSignId;
    }

    public String getActiveSignState() {
        return activeSignState;
    }

    public void setActiveSignState(String activeSignState) {
        this.activeSignState = activeSignState;
    }

    public String getActiveSignStartTime() {
        return activeSignStartTime;
    }

    public void setActiveSignStartTime(String activeSignStartTime) {
        this.activeSignStartTime = activeSignStartTime;
    }

    public String getActiveSignEndTime() {
        return activeSignEndTime;
    }

    public void setActiveSignEndTime(String activeSignEndTime) {
        this.activeSignEndTime = activeSignEndTime;
    }

    public String getActiveSignTime() {
        return activeSignTime;
    }

    public void setActiveSignTime(String activeSignTime) {
        this.activeSignTime = activeSignTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
