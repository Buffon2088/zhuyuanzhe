package zhiyuanzhe.funtion.system;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.logging.Logger;

@Component
    public class StringUtil {
        private static Logger logger = Logger.getLogger(String.valueOf(StringUtil.class));
        public String getRandomValue(int length) {
            StringBuffer str = new StringBuffer();
            String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            try {
                for (int i = 0; i < length; i++) {
                    char c = base.charAt(new Random().nextInt(base.length()));
                    str.append(c);
                }
            } catch (Exception e){
               e.printStackTrace();
            }
            return str.toString();
        }
    }
