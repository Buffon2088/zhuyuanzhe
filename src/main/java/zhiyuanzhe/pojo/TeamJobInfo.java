package zhiyuanzhe.pojo;

public class TeamJobInfo {
    private int teamJobId;
    private String teamJobName;
    private String teamJobState;

    public TeamJobInfo() {
    }

    public TeamJobInfo(int teamJobId, String teamJobName, String teamJobState) {
        this.teamJobId = teamJobId;
        this.teamJobName = teamJobName;
        this.teamJobState = teamJobState;
    }

    public int getTeamJobId() {
        return teamJobId;
    }

    public void setTeamJobId(int teamJobId) {
        this.teamJobId = teamJobId;
    }

    public String getTeamJobName() {
        return teamJobName;
    }

    public void setTeamJobName(String teamJobName) {
        this.teamJobName = teamJobName;
    }

    public String getTeamJobState() {
        return teamJobState;
    }

    public void setTeamJobState(String teamJobState) {
        this.teamJobState = teamJobState;
    }
}
