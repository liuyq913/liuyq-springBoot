package com.liuyq.springboot.autoconfig.annotation;

import com.liuyq.springboot.autoconfig.model.Test1;
import com.liuyq.springboot.autoconfig.utils.ReflectUtil;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyq on 2019/8/28.
 */
public class FieldTypeProcessor {

    public static Map<String, String> getFieldAnnoString(Object model) {
        Map<String, String> fieldAnnoMap = new LinkedHashMap<>();

        List<Field> fieldList = ReflectUtil.getFields(model.getClass());
        fieldList.stream().forEach(t -> {
            Method method = ReflectUtil.getGetter(model.getClass(), t.getName());
            try {
                try {
                    fieldAnnoMap.put(t.getName(), getMessage(t, method.invoke(model)));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return fieldAnnoMap;
    }

    public static String getMessage(Field field, Object o) throws UnsupportedEncodingException {
        FieldType fieldAnnotation = field.getAnnotation(FieldType.class);

        int lenght = fieldAnnotation.length();
        String type = fieldAnnotation.type();

        byte[] str = new byte[lenght];
        return buildByType(type, str, o.toString());
    }

    private static String buildByType(String type, byte[] str, String o) throws UnsupportedEncodingException {

        byte[] originalByte = o.getBytes("UTF-8");
        //原始数据长度
        int j = originalByte.length;

        if ("N".equals(type)) {
            //从末尾添加
            for (int i = 0; i < j; i++) {
                str[str.length - j + i] = originalByte[i];
            }
            int index = 0;
            do {
                //前面补零
                str[index] = '0';
                ++index;
            } while (str[index] == 0);
        } else if ("AN".equals(type) || "ANC".equals(type)) {
            //从头添加
            for (int i = 0; i < j; i++) {
                str[i] = originalByte[i];
            }
            do {
                str[j] = ' ';  //后面补空格
                ++j;
            } while (j < str.length);
        }


        return new String(str,"UTF-8");
    }



    public static void main(String[] ars) throws UnsupportedEncodingException {
        Map<String, String> stringStringMap = getFieldAnnoString(new Test1(12,"刘宇青"));

        System.out.println(stringStringMap.get("id")+"---------"+stringStringMap.get("id").getBytes("UTF-8").length);


        System.out.println(stringStringMap.get("name")+"---------"+stringStringMap.get("name").getBytes("UTF-8").length);
    }

}
