package zhiyuanzhe.pojo;

public class TeamTypeInfo {
    private int teamTypeId;
    private String teamTypeName;
    private String teamTYpeState;

    public TeamTypeInfo() {
    }

    public TeamTypeInfo(int teamTypeId, String teamTypeName, String teamTYpeState) {
        this.teamTypeId = teamTypeId;
        this.teamTypeName = teamTypeName;
        this.teamTYpeState = teamTYpeState;
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

    public String getTeamTYpeState() {
        return teamTYpeState;
    }

    public void setTeamTYpeState(String teamTYpeState) {
        this.teamTYpeState = teamTYpeState;
    }
}
