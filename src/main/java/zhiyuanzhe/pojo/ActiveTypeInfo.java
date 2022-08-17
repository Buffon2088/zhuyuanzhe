package zhiyuanzhe.pojo;

public class ActiveTypeInfo {
    private int activeTypeId;
    private String activeTypeName;
    private String activeTypeState;

    public ActiveTypeInfo() {
    }

    public ActiveTypeInfo(int activeTypeId, String activeTypeName, String activeTypeState) {
        this.activeTypeId = activeTypeId;
        this.activeTypeName = activeTypeName;
        this.activeTypeState = activeTypeState;
    }

    public int getActiveTypeId() {
        return activeTypeId;
    }

    public void setActiveTypeId(int activeTypeId) {
        this.activeTypeId = activeTypeId;
    }

    public String getActiveTypeName() {
        return activeTypeName;
    }

    public void setActiveTypeName(String activeTypeName) {
        this.activeTypeName = activeTypeName;
    }

    public String getActiveTypeState() {
        return activeTypeState;
    }

    public void setActiveTypeState(String activeTypeState) {
        this.activeTypeState = activeTypeState;
    }
}
