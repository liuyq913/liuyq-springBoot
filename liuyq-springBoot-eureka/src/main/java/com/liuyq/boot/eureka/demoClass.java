package com.liuyq.boot.eureka;

/**
 * Created by liuyq on 2019/5/8.
 */
public class demoClass {
    public static void main(String[] gars){
        try {
            StackTraceElement[] stackTrace = (new RuntimeException()).getStackTrace();
            StackTraceElement[] var2 = stackTrace;
            int var3 = stackTrace.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                StackTraceElement stackTraceElement = var2[var4];
                if("main".equals(stackTraceElement.getMethodName())) {
                    System.out.println(Class.forName(stackTraceElement.getClassName()));
            }
            }
        } catch (ClassNotFoundException var6) {
            ;
        }


    }
}
