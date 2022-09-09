package zhiyuanzhe.pojo;

public class TeamTypeInfo {
    private int teamTypeId;
    private String teamTypeName;
    private String teamTypeState;

    public TeamTypeInfo() {
    }

    public TeamTypeInfo(int teamTypeId, String teamTypeName, String teamTypeState) {
        this.teamTypeId = teamTypeId;
        this.teamTypeName = teamTypeName;
        this.teamTypeState = teamTypeState;
    }

    public int getTeamTypeId() {
        return teamTypeId;
    }

    public void setTeamTypeId(int teamTypeId) {
        this.teamTypeId = teamTypeId;
    }

    public String getTeamTypeName() {
        return teamTypeName;
    }

    public void setTeamTypeName(String teamTypeName) {
        this.teamTypeName = teamTypeName;
    }

    public String getTeamTypeState() {
        return teamTypeState;
    }

    public void setTeamTypeState(String teamTypeState) {
        this.teamTypeState = teamTypeState;
    }
}
