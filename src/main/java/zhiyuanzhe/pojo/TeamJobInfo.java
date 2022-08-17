package zhiyuanzhe.pojo;

public class TeamJobInfo {
    private int TeamJobId;
    private String TeamJobName;
    private String TeamJobState;

    public TeamJobInfo() {
    }

    public TeamJobInfo(int teamJobId, String teamJobName, String teamJobState) {
        TeamJobId = teamJobId;
        TeamJobName = teamJobName;
        TeamJobState = teamJobState;
    }

    public int getTeamJobId() {
        return TeamJobId;
    }

    public void setTeamJobId(int teamJobId) {
        TeamJobId = teamJobId;
    }

    public String getTeamJobName() {
        return TeamJobName;
    }

    public void setTeamJobName(String teamJobName) {
        TeamJobName = teamJobName;
    }

    public String getTeamJobState() {
        return TeamJobState;
    }

    public void setTeamJobState(String teamJobState) {
        TeamJobState = teamJobState;
    }
}
