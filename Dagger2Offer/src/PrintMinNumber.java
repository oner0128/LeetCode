import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by rrr on 2017/5/6.
 * 题目描述
 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder sb=new StringBuilder();
        ArrayList<String>list=new ArrayList<>();
        for (int n:numbers)list.add(String.valueOf(n));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for (String s:list)sb.append(s);
        return sb.toString();
    }
}
