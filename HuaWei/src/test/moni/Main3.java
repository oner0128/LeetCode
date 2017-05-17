package test.moni;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rrr on 2017/5/17.
 * 输入n个整数，输出出现次数大于等于数组长度一半的数。
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        scanner.close();
        int[]nums=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i]=list.get(i);
        }
        int count=1,num=nums[0];
        for (int i = 1; i < nums.length; i++) {
            count=num==nums[i]?count+1:count-1;
            num=count>0?num:nums[i];
        }
        System.out.println(num);
    }
}
