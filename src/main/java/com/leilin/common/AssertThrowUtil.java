package com.leilin.common;

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
}
