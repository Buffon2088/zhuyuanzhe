package zhiyuanzhe.funtion.system;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class FileUtil {
    public static final String[] SUFFIX_ARRAY=new String[]{".jpg",".png,.jpeg,.JFIF"};
    public static final String FILE_URL="D:\\upload";
    public static boolean checkSuffix(String url){
        String suffixName=url.substring(url.lastIndexOf("."));
        boolean flag=false;
        for (String name:SUFFIX_ARRAY) {
            if (name.equals(suffixName)){
                flag=true;
                break;
            }
        }
        return flag;
    }
    public static String replaceFileName(String url){
        String suffixName=url.substring(url.lastIndexOf("."));
        StringBuffer buffer=new StringBuffer();
        String uuid= UUID.randomUUID().toString().replace("-","");
        buffer.append(uuid);
        buffer.append(suffixName);
        return  buffer.toString();
    }
    public static String assmembleUrl(HttpServletRequest request,String fileName){
        StringBuffer buffer=new StringBuffer();
        String servleturl=request.getServerName();
        String port=String.valueOf(request.getServerPort());
        buffer.append("http://");
        buffer.append(servleturl);
        buffer.append(":");
        buffer.append(port);
        buffer.append("/");
        buffer.append("upload/");
        buffer.append(fileName);
        return  buffer.toString();
    }

}
