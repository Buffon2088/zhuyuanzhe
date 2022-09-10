package zhiyuanzhe.funtion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import zhiyuanzhe.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("/PublicImg")
public class SaveImg {
    /**
     * 图片文件目录
     * */
    public static String URL_PATH="/src/main/webapp/img";
    /**
     * 截取去除路径
     * */
    public static String TARGET_PATH="/target/zhiyuanzhe/WEB-INF/classes/";

    /**
     * 存储到target
     * */
    @RequestMapping("/saveImg")
    public UserInfo saveImgToTarget(UserInfo userInfo,MultipartFile file, HttpServletRequest request) {
        //target路径
        String path = request.getServletContext().getRealPath("/img");
        //截取本地路径
        File notImgPath = new File(this.getClass().getResource("/").getPath().replaceAll(TARGET_PATH,  "" ));
        //拼接img完整路径
        String localPath=notImgPath+URL_PATH;
        //通过UUID来命名
        String filenames = UUID.randomUUID().toString().replace("-", "");
        //生成最终文件名
        String filename =filenames+"-"+file.getOriginalFilename();
        //存储到Target
        File f = new File(path,filename);
        File f1=new File(localPath,filename);
        //判断路径是否存在，不存在则创建
        if(!f.exists()){
            f.mkdirs();
        }
        //上传图片
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        userInfo.setImg(filename);
        //复制图片执行方法
        try {
            copyImg(f,f1);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return userInfo;
    }
    /**
     * Io图片复制类
     * 从start（路径）复制到end（路径）
     * */
    public void copyImg(File startPath,File endPath) throws IOException {
        File[] fileArray1=startPath.listFiles();
        File[] fileArray2=startPath.listFiles();
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(startPath));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(endPath));
        byte[] bys=new byte[1024];
        int len=0;
        while ((len = bis.read(bys)) != -1){
            bos.write(bys,0,len);
        }
        bos.close();
        bis.close();
    }
    /**
     * 存储到本地
     * */
    public UserInfo saveImgToLocal(UserInfo userInfo,MultipartFile file, HttpServletRequest request) {
        //项目根路径
        String localPath="D:\\xampp\\2023毕业设计\\zhuyuanzhe\\src\\main\\webapp\\img";
        String filenames = UUID.randomUUID().toString().replace("-", "");
        String filename = file.getOriginalFilename()+filenames;
        //存储到本地项目中
        File localImg = new File(localPath,filename);
        //判断路径是否存在，不存在则创建
        if(!localImg.exists()){
            localImg.mkdirs();
        }
        //上传图片
        try {
            file.transferTo(localImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userInfo.setImg(filename);
        return userInfo;
    }
}
