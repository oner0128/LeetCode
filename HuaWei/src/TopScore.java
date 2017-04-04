import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rrr on 2017/3/26.
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 * 输入描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 */
public class TopScore {static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
        String[] first = scanner.nextLine().split(" ");
        int N = Integer.parseInt(first[0]), M = Integer.parseInt(first[1]);
        String[] scoreStr = scanner.nextLine().split(" ");
        int[] score = new int[scoreStr.length];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(scoreStr[i]);
        }
        while (M > 0) {
            topScore(scanner.nextLine(),score);
            M--;
        }
        for (int i:list) System.out.println(i);
    }
    scanner.close();}

    public static void topScore(String qOrc, int[] score) {
        String[] str=qOrc.split(" ");
        int A = Integer.parseInt(str[1]), B = Integer.parseInt(str[2]);
        if (str[0].equals("Q")){
            list.add(findMax(A,B,score));
        }else {
            score[A-1]=B;
        }
    }

    private static int findMax(int i, int i1, int[] score) {
        if (i>i1){
            i=i+i1;
            i1=i-i1;
            i=i-i1;
        }
        int max=0;
        for (int j = i-1; j <i1 ; j++) {
            if (max<score[j])max=score[j];
        }
        return max;
    }
}
