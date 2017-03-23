import java.util.Scanner;

/**
 * Created by rrr on 2017/3/23.
 * 题目描述
 Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 */
public class PictureSorted {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(picturesSorted(scanner.nextLine()));
        }
    }
    public static String picturesSorted(String s){
        StringBuilder stringBuilder=new StringBuilder();
        int[]count=new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i]!=0)
            stringBuilder.append(new String(new char[count[i]]).replace('\0',(char) i));
        }
        return stringBuilder.toString();
    }
}
