package com.leilin.common;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 系统的工具类
 */
public class ThisSystemUtil {
        private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        /**
         * MD5加密
         *
         * @param origin      字符
         * @param charsetname 编码
         * @return
         */
        private static String charsetname = "utf8";
        public static String md5(String origin) {
            String resultString = null;
            try {
                resultString = new String(origin);
                MessageDigest md = MessageDigest.getInstance("MD5");
                if (null == charsetname || "".equals(charsetname)) {
                    resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
                } else {
                    resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
                }
            } catch (Exception e) {
            }
            return resultString;
        }

        public static String byteArrayToHexString(byte b[]) {
            StringBuffer resultSb = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                resultSb.append(byteToHexString(b[i]));
            }
            return resultSb.toString();
        }

        public static String byteToHexString(byte b) {
            int n = b;
            if (n < 0) {
                n += 256;
            }
            int d1 = n / 16;
            int d2 = n % 16;
            return hexDigIts[d1] + hexDigIts[d2];
        }

        public static String uuid(){
            char[] cs = new char[32];
            String uuid = UUID.randomUUID().toString();
            char c=0;
            int j=0;
            for(int i=0; i<uuid.length();i++) {
                if((c=uuid.charAt(i))!='-')
                    cs[j++]=c;
            }
            return new String(cs);
        }
        public static void main(String[] args) {
            for(int i=0; i<10;i++)
                System.out.println(uuid());
        }
}
