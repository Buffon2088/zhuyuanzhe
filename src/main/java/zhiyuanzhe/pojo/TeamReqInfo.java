package zhiyuanzhe.pojo;

public class TeamReqInfo {
    private int teamJoinId;
    private String teamReqTime;
    private String teamReqState;
    private UserInfo userInfo;
    private TeamInfo teamInfo;
    private String state;

    public TeamReqInfo() {
    }

    public TeamReqInfo(int teamJoinId, String teamReqTime, String teamReqState, UserInfo userInfo, TeamInfo teamInfo, String state) {
        this.teamJoinId = teamJoinId;
        this.teamReqTime = teamReqTime;
        this.teamReqState = teamReqState;
        this.userInfo = userInfo;
        this.teamInfo = teamInfo;
        this.state = state;
    }

    public int getTeamJoinId() {
        return teamJoinId;
    }

    public void setTeamJoinId(int teamJoinId) {
        this.teamJoinId = teamJoinId;
    }

    public String getTeamReqTime() {
        return teamReqTime;
    }

    public void setTeamReqTime(String teamReqTime) {
        this.teamReqTime = teamReqTime;
    }

    public String getTeamReqState() {
        return teamReqState;
    }

    public void setTeamReqState(String teamReqState) {
        this.teamReqState = teamReqState;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public TeamInfo getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(TeamInfo teamInfo) {
        this.teamInfo = teamInfo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
