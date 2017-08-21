package xiaozhao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rrr on 2017/8/21.
 * 题目描述
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 * 输入描述:
 * 每个测试输入包含2个整数,n和m
 * 输出描述:
 * 按每个组合的字典序排列输出,每行输出一种组合
 * 示例1
 * 输入
 * <p>
 * 5 5
 * 输出
 * <p>
 * 1 4
 * 2 3
 * 5
 */
public class FindTargetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<List<Integer>> res = new ArrayList<>();
            findTarget(res, 1, n, m, new ArrayList<Integer>());
            for (List<Integer>list: res) {
                StringBuilder stringBuilder=new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i==list.size()-1)stringBuilder.append(list.get(i));
                    else stringBuilder.append(list.get(i)+" ");
                }
                System.out.println(stringBuilder.toString());
            }
        }
    }

    private static void findTarget(List<List<Integer>> res, int lo, int hi, int target, ArrayList<Integer> integers) {
        if (target == 0) res.add(new ArrayList<>(integers));
        else if (target < 0) return;
        else for (int i = lo; i <= hi; i++) {
                integers.add(i);
                findTarget(res, i + 1, hi, target - i, integers);
                integers.remove(integers.size() - 1);
            }
    }

}
