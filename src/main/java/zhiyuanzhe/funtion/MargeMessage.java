package zhiyuanzhe.funtion;

import zhiyuanzhe.pojo.ActiveInfo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 合并原始数据和修改数据类
 */
public class MargeMessage {
    /**
     * 合并原始数据和已修改数据方法
     * **/
    public ActiveInfo MargeActMessage(ActiveInfo oldActive,ActiveInfo newActive) throws NoSuchFieldException, IllegalAccessException {
        //定义finalActiveInfo用于接收
        ActiveInfo finalActiveInfo=null;
        //定义存放实体的Map
        Map<String,String> oldInfoMap=new HashMap<>();
        Map<String,String> nowInfoMap=new HashMap<>();
        Map<String,String> newInfoMap=new HashMap<>();
        //存放异常的map
        Map<String,String> errInfoMap=new HashMap<>();
        //将原有实体的字段和值放到map中(.getClass().getDeclaredFields()返回反映由类对象表示的类或接口声明的所有字段的字段对象数组。这包括公共、受保护、默认（包）访问和专用字段，但不包括继承的字段。)
        for (Field filed : oldActive.getClass().getDeclaredFields()){
            //Accessable属性是继承自AccessibleObject 类. 功能是启用或禁用安全检查,指示反射的对象在使用时应该取消 Java 语言访问检查
            filed.setAccessible(true);
            String filedName=filed.getName();
            //toString()方法在Object类中定义,其返回值是String类型,返回类名和它的引用地址。
            String value= null;
            try {
                value = filed.get(oldActive).toString();
            } catch (Exception e) {
                errInfoMap.put(oldInfoMap.get("activeName"),"该活动有数据为空，请联系管理员维护~");
            }
            oldInfoMap.put(filedName,value);
        }
        //将修改实体的字段和值放到map中（主要目的是标识要返回或者操作的字段，可以用于查询和写入操作。 用于查询 指定字段 在查询操作中field方法是使用最频繁的。）
        for (Field filed : newActive.getClass().getDeclaredFields()){
            filed.setAccessible(true);
            String filedName=filed.getName();
            String value= null;
            try {
                value = filed.get(newActive).toString();
            } catch (Exception e) {
                value = "待添加";
            }
            nowInfoMap.put(filedName,value);
        }
        //循环判断两map中的值是否相通，若不相同，newInfoMap替代oldInfoMap的值
        Set oldSet=oldInfoMap.keySet();
        for (Object old : oldSet){
            //通过遍历出的key查询value(原始数据)
            String oldMessage=oldInfoMap.get(old);
            //通过遍历出的key查询value(修改后的新数据)
            String newMessage=nowInfoMap.get(old);
            //若某字段数据不相等或者为“待添加状态”则将原始数据存到新map中
            if (!oldMessage.equals(newMessage)&&!"待添加".equals(newMessage)&&!"0".equals(newMessage)){
                //将新数据存入最终的newInfoMap
                newInfoMap.put(String.valueOf(old),newMessage);
            }else {
                //将原始数据存入最终的newInfoMap
                newInfoMap.put(String.valueOf(old),oldMessage);
            }
        }
        //将最新的map重新存放到实体中
        Class<ActiveInfo> activeInfoClass = ActiveInfo.class;
        try {
            //拿到实体类对象
            ActiveInfo activeInfo=activeInfoClass.newInstance();
            //遍历map
            Set newSet=newInfoMap.keySet();
            //遍历最新map里的元素
            for (Object newKey : newSet){
                //获取key
                Field field=activeInfoClass.getDeclaredField(String.valueOf(newKey));
                //开启权限
                field.setAccessible(true);
                //获得该实体字段的类型
                String typeName = field.getGenericType().getTypeName();
                //反射到最新的实体中去
                try{
                    field.set(activeInfo,newInfoMap.get(newKey));
                }catch (Exception e){
                    if ("int".equals(typeName)){
                        field.set(activeInfo,Integer.parseInt(newInfoMap.get(newKey)));
                    }else {
                        errInfoMap.put("反射异常","反射类型无法识别，请联系管理员维护~");
                    }
                }
            }
            //将最终实体信息完善(不包含外键实体类型)
            finalActiveInfo=activeInfo;
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return finalActiveInfo;
    }
    /**
     * 修改活动合并外键实体方法
     * **/
    public ActiveInfo outActInfo(ActiveInfo newActInfo,ActiveInfo updActInfo,ActiveInfo oldActInfo){
        //获取原始活动实体外键存入新实体
        newActInfo.setTeamTypeInfo(updActInfo.getTeamTypeInfo());
        newActInfo.setAdminInfo(updActInfo.getAdminInfo());
        newActInfo.setActiveTypeInfo(updActInfo.getActiveTypeInfo());
        if (newActInfo.getTeamTypeInfo()==null){
            newActInfo.setTeamTypeInfo(oldActInfo.getTeamTypeInfo());
        }else if (newActInfo.getAdminInfo()==null){
            newActInfo.setAdminInfo(oldActInfo.getAdminInfo());
        }else if (newActInfo.getActiveTypeInfo()==null){
            newActInfo.setActiveTypeInfo(oldActInfo.getActiveTypeInfo());
        }
        //返回最终实体
        return newActInfo;
    }
}

