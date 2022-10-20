package zhiyuanzhe.pojo;

public class   UserInfo {
    private int userId;
    private String userName;
    private String userCardId;
    private String userTel;
    private String userEmail;
    private String userLoginName;
    private String userPwd;
    private String userHelpTime;
    private TeamJobInfo teamJobInfo;
    private int activeJoNum;
    private String teamName;
    private String key;
    private String img;
    public UserInfo() {
    }

    public UserInfo(int userId, String userName, String userCardId, String userTel, String userEmail, String userLoginName, String userPwd, String userHelpTime, TeamJobInfo teamJobInfo, int activeJoNum, String teamName, String key, String img) {
        this.userId = userId;
        this.userName = userName;
        this.userCardId = userCardId;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.userLoginName = userLoginName;
        this.userPwd = userPwd;
        this.userHelpTime = userHelpTime;
        this.teamJobInfo = teamJobInfo;
        this.activeJoNum = activeJoNum;
        this.teamName = teamName;
        this.key = key;
        this.img = img;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserHelpTime() {
        return userHelpTime;
    }

    public void setUserHelpTime(String userHelpTime) {
        this.userHelpTime = userHelpTime;
    }

    public TeamJobInfo getTeamJobInfo() {
        return teamJobInfo;
    }

    public void setTeamJobInfo(TeamJobInfo teamJobInfo) {
        this.teamJobInfo = teamJobInfo;
    }

    public int getActiveJoNum() {
        return activeJoNum;
    }

    public void setActiveJoNum(int activeJoNum) {
        this.activeJoNum = activeJoNum;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
