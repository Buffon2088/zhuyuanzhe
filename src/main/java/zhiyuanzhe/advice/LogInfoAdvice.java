package zhiyuanzhe.advice;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogInfoAdvice {
    // 获取当前系统日期
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    //    定义统一切点表达式
    @Pointcut("@annotation(zhiyuanzhe.annotaion.LogInfoAnnotaion)")//新注解切点表达式
    public void ponintCut(){}

    //    前置通知
    @Before("ponintCut()")
    public void BeforeReturning(JoinPoint joinPoint) throws UnknownHostException {
        InetAddress inetAddress = Inet4Address.getLocalHost();
        String message="目标对象"+ StringUtils.substringBefore(joinPoint.getTarget().toString(),"@")+
                "/IP地址"+inetAddress.getHostAddress()+"/时间"+simpleDateFormat.format(date)+"/开始执行"
                +joinPoint.getSignature().getName()+"切点方法";
        System.out.println(message);
    }

    //    后置通知
    @AfterReturning("ponintCut()")
    public void AfterReturning(JoinPoint joinPoint) throws UnknownHostException {
        InetAddress inetAddress = Inet4Address.getLocalHost();
        String message="目标对象"+StringUtils.substringBefore(joinPoint.getTarget().toString(),"@")+
                "/IP地址"+inetAddress.getHostAddress()+"/时间"+simpleDateFormat.format(date)+"/开始执行"
                +joinPoint.getSignature().getName()+"切点方法";
        System.out.println(message);
    }
}
