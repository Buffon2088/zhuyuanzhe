package zhiyuanzhe.pojo;

public class ActiveJoinInInfo {
    private int activeJoinInId;
    private String activeJoinInState;
    private int activeJoinInNum;
    private String activeJoinInAskTime;
    private String activeJoinInPassTime;

    public ActiveJoinInInfo() {
    }

    public ActiveJoinInInfo(int activeJoinInId, String activeJoinInState, int activeJoinInNum, String activeJoinInAskTime, String activeJoinInPassTime) {
        this.activeJoinInId = activeJoinInId;
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
