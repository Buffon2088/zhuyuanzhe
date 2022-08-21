package zhiyuanzhe.funtion;

import com.sun.mail.util.MailSSLSocketFactory;
import zhiyuanzhe.pojo.EmailInfo;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SendEmail {
    public boolean sendEmail(final EmailInfo emailInfo) throws GeneralSecurityException, MessagingException {
        Map<String, String> peopleEmailMap = new HashMap<>();
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com"); // 设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
        prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码

        // QQ邮箱设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //1、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //传入发件人的姓名和授权码
                return new PasswordAuthentication(emailInfo.getConsignee(), "ctvlrsuqswwfebed");
            }
        });

        //2、通过session获取transport对象
        Transport transport = session.getTransport();

        //3、通过transport对象邮箱用户名和授权码连接邮箱服务器
        String consignee = emailInfo.getConsignee();
        transport.connect("smtp.qq.com", consignee, "ctvlrsuqswwfebed");

        //4、创建邮件,传入session对象
        MimeMessage mimeMessage = complexEmail(session, emailInfo);

        //5、发送邮件
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        //6、成功
        System.out.println("消息发送成功");
        //6、关闭连接
        transport.close();
        return true;
    }

    /***
     * 封装发送邮箱方法
     */
    public static MimeMessage complexEmail(Session session, EmailInfo emailInfo) throws MessagingException {

        //消息的固定信息
        MimeMessage mimeMessage = new MimeMessage(session);

        //发件人
        mimeMessage.setFrom(new InternetAddress(emailInfo.getConsignee()));
        //收件人
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailInfo.getAddressOr()));
        //邮件标题
        mimeMessage.setSubject(emailInfo.getOtherInformation());

        //邮件内容
        //准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        //这里填的是图片路径
        if (emailInfo.getImgInformation().equals("")) {
            System.out.println("此邮件无图片");
        } else {
            DataHandler handler = new DataHandler(new FileDataSource(emailInfo.getImgInformation()));
            image.setDataHandler(handler);
            image.setContentID("test.png"); //设置图片id
        }

        //准备文本
        MimeBodyPart text = new MimeBodyPart();
        //邮件内容
        text.setContent(emailInfo.getInformation(), "text/html;charset=utf-8");

        //附件txt
        MimeBodyPart appendix = new MimeBodyPart();
        if (emailInfo.getTxtInformation().equals("")) {
            System.out.println("此邮件无附件txt");
        } else {
            appendix.setDataHandler(new DataHandler(new FileDataSource(emailInfo.getTxtInformation())));
            appendix.setFileName("test.txt");
        }

        //拼装邮件正文
        MimeMultipart mimeMultipart = new MimeMultipart();
        //检出是否有图片需要拼接
        if (!emailInfo.getImgInformation().equals("")) {
            mimeMultipart.addBodyPart(image);
        }
        mimeMultipart.addBodyPart(text);
        mimeMultipart.setSubType("related");//文本和图片内嵌成功
        //将拼装好的正文内容设置为主体
        MimeBodyPart contentText = new MimeBodyPart();
        contentText.setContent(mimeMultipart);
        //拼接附件
        MimeMultipart allFile = new MimeMultipart();
        //检出是否有图片需要拼接
        if (!emailInfo.getTxtInformation().equals("")) {
            allFile.addBodyPart(appendix);//附件都在邮件中,类型设置为mixed
        }
        allFile.addBodyPart(contentText);//正文
        allFile.setSubType("mixed"); //正文在邮件中，类型设置为mixed
        //放到Message消息中
        mimeMessage.setContent(allFile);
        mimeMessage.saveChanges();//保存修改

        return mimeMessage;
    }
}
