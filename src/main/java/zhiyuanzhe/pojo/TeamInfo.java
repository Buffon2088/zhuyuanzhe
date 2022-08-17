package zhiyuanzhe.pojo;

public class TeamInfo {
    private int teamId;
    private String teamName;
    private String teamStartData;
    private int teamPeopleNum;
    private int teamHelpTime;
    private TeamTypeInfo teamTypeInfo;
    private UserInfo userInfo;
    private String teamState;

    public TeamInfo() {
    }

    public TeamInfo(int teamId, String teamName, String teamStartData, int teamPeopleNum, int teamHelpTime, TeamTypeInfo teamTypeInfo, UserInfo userInfo, String teamState) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamStartData = teamStartData;
        this.teamPeopleNum = teamPeopleNum;
        this.teamHelpTime = teamHelpTime;
        this.teamTypeInfo = teamTypeInfo;
        this.userInfo = userInfo;
        this.teamState = teamState;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamStartData() {
        return teamStartData;
    }

    public void setTeamStartData(String teamStartData) {
        this.teamStartData = teamStartData;
    }

    public int getTeamPeopleNum() {
        return teamPeopleNum;
    }

    public void setTeamPeopleNum(int teamPeopleNum) {
        this.teamPeopleNum = teamPeopleNum;
    }

    public int getTeamHelpTime() {
        return teamHelpTime;
    }

    public void setTeamHelpTime(int teamHelpTime) {
        this.teamHelpTime = teamHelpTime;
    }

    public TeamTypeInfo getTeamTypeInfo() {
        return teamTypeInfo;
    }

    public void setTeamTypeInfo(TeamTypeInfo teamTypeInfo) {
        this.teamTypeInfo = teamTypeInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getTeamState() {
        return teamState;
    }

    public void setTeamState(String teamState) {
        this.teamState = teamState;
    }
}
