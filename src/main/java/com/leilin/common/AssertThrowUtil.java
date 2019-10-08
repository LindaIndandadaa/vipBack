package com.leilin.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *所需要的验证
 */
public class AssertThrowUtil {
    //判断是否为空，如果为空，抛出自定义异常，否则返回去掉前后空格的结果
    public static String AssertNotBlank(String message, String target) {
        if(target==null || (target=target.trim()).length()==0)
            throw new ThisSystemException(message);
        return target;
    }

    public static String $(String message, String target) {
        return AssertNotBlank(message, target);
    }

    public static void assertNotNull(String message, Object o) {
        if(o == null)
            throw new ThisSystemException(message);
    }

    /**
     * 相等，不相等抛出异常
     * @param message
     * @param o1
     * @param o2
     */
    public static void assertEquals(String message, Object o1, Object o2){
        if(o1==null ? !(o1==o2) : !o1.equals(o2)) {
            throw new ThisSystemException(message);
        }
    }

    /**
     * 不相等，相等抛出异常
     * @param message
     * @param o1
     * @param o2
     */
    public static void assertNotEquals(String message, Object o1, Object o2){
        if(o1==null ? o1==o2 : o1.equals(o2)) {
            throw new ThisSystemException(message);
        }
    }

    /**
     * 判断true or false
     * @param message
     * @param b
     */
    public static void assertTrue(String message, boolean b) {
        if(!b)
            throw new ThisSystemException(message);
    }
    public static void assertFalse(String message, boolean b) {
        if(b)
            throw new ThisSystemException(message);
    }

    /**
     * 验证是否符合正则表达式
     * @param message
     * @param reg
     * @param target
     */
    public static void assertPatternMatch(String message, String reg, String target){

        Pattern pattern = Pattern.compile(reg);//11位数字
        Matcher ma = pattern.matcher(target);
        if(!ma.matches()) {
            throw new ThisSystemException(message);
        }
    }


    public static int parstInt(String target, int defaultValue) {
        try {
            return Integer.parseInt(target.trim());
        }catch (Exception e) {
            return defaultValue;
        }
    }


}
