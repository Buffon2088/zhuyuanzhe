package zhiyuanzhe.pojo;

public class EmailInfo {
    //发件人
    private String consignee;
    //收件人
    private String addressOr;
    //发件箱
    private String Mailbox;
    //收件箱
    private String inbox;
    //文字信息
    private String information;
    //文件信息
    private String txtInformation;
    //图片信息
    private String imgInformation;
    //其他信息
    private String otherInformation;
    //发送时间
    private String sendTime;
    //发送状态
    private boolean sendState;
    //授权码
    private String key;

    public EmailInfo() {
    }

    public EmailInfo(String consignee, String addressOr, String mailbox, String inbox, String information, String txtInformation, String imgInformation, String otherInformation, String sendTime, boolean sendState, String key) {
        this.consignee = consignee;
        this.addressOr = addressOr;
        Mailbox = mailbox;
        this.inbox = inbox;
        this.information = information;
        this.txtInformation = txtInformation;
        this.imgInformation = imgInformation;
        this.otherInformation = otherInformation;
        this.sendTime = sendTime;
        this.sendState = sendState;
        this.key = key;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddressOr() {
        return addressOr;
    }

    public void setAddressOr(String addressOr) {
        this.addressOr = addressOr;
    }

    public String getMailbox() {
        return Mailbox;
    }

    public void setMailbox(String mailbox) {
        Mailbox = mailbox;
    }

    public String getInbox() {
        return inbox;
    }

    public void setInbox(String inbox) {
        this.inbox = inbox;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getTxtInformation() {
        return txtInformation;
    }

    public void setTxtInformation(String txtInformation) {
        this.txtInformation = txtInformation;
    }

    public String getImgInformation() {
        return imgInformation;
    }

    public void setImgInformation(String imgInformation) {
        this.imgInformation = imgInformation;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public boolean isSendState() {
        return sendState;
    }

    public void setSendState(boolean sendState) {
        this.sendState = sendState;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
