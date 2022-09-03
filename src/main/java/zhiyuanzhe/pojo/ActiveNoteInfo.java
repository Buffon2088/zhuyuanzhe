package zhiyuanzhe.pojo;

public class ActiveNoteInfo {
    private int activeNoteId;
    private TeamInfo teamInfo;
    private String activeNoteState;
    private AdminInfo adminInfo;
    private ActiveTypeInfo activeTypeInfo;
    private String activeNoteTime;
    private ActiveSignInfo activeSignInfo;

    public ActiveNoteInfo() {
    }

    public ActiveNoteInfo(int activeNoteId, TeamInfo teamInfo, String activeNoteState, AdminInfo adminInfo, ActiveTypeInfo activeTypeInfo, String activeNoteTime, ActiveSignInfo activeSignInfo) {
        this.activeNoteId = activeNoteId;
        this.teamInfo = teamInfo;
        this.activeNoteState = activeNoteState;
        this.adminInfo = adminInfo;
        this.activeTypeInfo = activeTypeInfo;
        this.activeNoteTime = activeNoteTime;
        this.activeSignInfo = activeSignInfo;
    }

    public int getActiveNoteId() {
        return activeNoteId;
    }

    public void setActiveNoteId(int activeNoteId) {
        this.activeNoteId = activeNoteId;
    }

    public TeamInfo getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(TeamInfo teamInfo) {
        this.teamInfo = teamInfo;
    }

    public String getActiveNoteState() {
        return activeNoteState;
    }

    public void setActiveNoteState(String activeNoteState) {
        this.activeNoteState = activeNoteState;
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

    public String getActiveNoteTime() {
        return activeNoteTime;
    }

    public void setActiveNoteTime(String activeNoteTime) {
        this.activeNoteTime = activeNoteTime;
    }

    public ActiveSignInfo getActiveSignInfo() {
        return activeSignInfo;
    }

    public void setActiveSignInfo(ActiveSignInfo activeSignInfo) {
        this.activeSignInfo = activeSignInfo;
    }
}
