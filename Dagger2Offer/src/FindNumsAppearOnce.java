import java.util.*;

/**
 * Created by rrr on 2017/5/5.
 * 题目描述
 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer>set=new HashSet<>();
        for (int num:array){
            if (set.contains(num))set.remove(num);
            else set.add(num);
        }
        Iterator<Integer> iterator=set.iterator();
        num1[0]=iterator.next();num2[0]=iterator.next();
    }
}
