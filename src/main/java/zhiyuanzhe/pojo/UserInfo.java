package zhiyuanzhe.pojo;

public class UserInfo {
    private int UserId;
    private String UserName;
    private String UserCardId;
    private String UserTel;
    private String UserEmail;
    private String UserLoginName;
    private String UserPwd;
    private String UserHelpTime;
    private TeamJobInfo teamJobInfo;
    private int ActiveJoinNum;
    private String UserState;

    public UserInfo() {
    }

    public UserInfo(int userId, String userName, String userCardId, String userTel, String userEmail, String userLoginName, String userPwd, String userHelpTime, TeamJobInfo teamJobInfo, int activeJoinNum, String userState) {
        UserId = userId;
        UserName = userName;
        UserCardId = userCardId;
        UserTel = userTel;
        UserEmail = userEmail;
        UserLoginName = userLoginName;
        UserPwd = userPwd;
        UserHelpTime = userHelpTime;
        this.teamJobInfo = teamJobInfo;
        ActiveJoinNum = activeJoinNum;
        UserState = userState;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserCardId() {
        return UserCardId;
    }

    public void setUserCardId(String userCardId) {
        UserCardId = userCardId;
    }

    public String getUserTel() {
        return UserTel;
    }

    public void setUserTel(String userTel) {
        UserTel = userTel;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserLoginName() {
        return UserLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        UserLoginName = userLoginName;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }

    public String getUserHelpTime() {
        return UserHelpTime;
    }

    public void setUserHelpTime(String userHelpTime) {
        UserHelpTime = userHelpTime;
    }

    public TeamJobInfo getTeamJobInfo() {
        return teamJobInfo;
    }

    public void setTeamJobInfo(TeamJobInfo teamJobInfo) {
        this.teamJobInfo = teamJobInfo;
    }

    public int getActiveJoinNum() {
        return ActiveJoinNum;
    }

    public void setActiveJoinNum(int activeJoinNum) {
        ActiveJoinNum = activeJoinNum;
    }

    public String getUserState() {
        return UserState;
    }

    public void setUserState(String userState) {
        UserState = userState;
    }
}
