package NiuKe.HuaWei;


import java.util.*;

/**
 * Created by rrr on 2017/4/12.
 */
public  class ErrorLog {
    public static void main(String[] args) {
        String str = "This is my1original string!";

        //str＝str.substring(int beginIndex);截取掉str从首字母起长度为beginIndex的字符串，将剩余字符串赋值给str；
        System.out.println(str.substring(6));
        //截取str中从beginIndex开始至endIndex结束时的字符串，并将其赋值给str;
        System.out.println(str.substring(0, 2));

        String sr = "This is my third string!";
        String sx = "is";
        int index = sr.indexOf(sx);
        System.out.println(index);
        int index2 = sr.indexOf(sx, 3);
        System.out.println(index2);
        String str3 = "a2dfcfar1bzvb";
        System.out.println(str3.indexOf(97, 10));
        Integer.parseInt("132");
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.bitCount(Integer.MAX_VALUE + 1));
        System.out.println(Integer.bitCount(Integer.MIN_VALUE + 1));
        System.out.println(Integer.MIN_VALUE + 1);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MIN_NORMAL);
        System.out.println(Integer.bitCount(-1024 >> 1));
        System.out.println(-1024 >>> 1);
    }
    boolean ps(int a) {
        System.out.println(Double.MIN_NORMAL);
        return true;
    }
}
