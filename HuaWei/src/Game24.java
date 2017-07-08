import java.util.Scanner;

/**
 * Created by rrr on 2017/7/6.
 * 题目描述
 * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
 * 输入：
 * 4个1-10的数字。[数字允许重复，测试用例保证无异常数字]
 * 输出：
 * true or false
 * <p>
 * 输入描述:
 * 输入4个int整数
 * <p>
 * <p>
 * 输出描述:
 * 返回能否得到24点，能输出true，不能输出false
 * 示例1
 * 输入
 * <p>
 * 7 2 1 10
 * 输出
 * <p>
 * true
 */
public class Game24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = new int[4];
            boolean[]used=new boolean[4];
            for (int i = 0; i < 4; i++)
                nums[i] = scanner.nextInt();
            System.out.println(dfs(nums, used,  nums[0]));
        }
    }

    private static boolean dfs(int[] nums, boolean[] used, int sum) {
        for (int i = 1; i < 4; i++) {//第一个数的符号默认为+，若第一个数的符号可变为+-*/，前面没有乘数和被除数
            if (used[i]==false){
                used[i]=true;
                if (dfs(nums,used,sum+nums[i])||
                        dfs(nums,used,sum-nums[i])||
                        dfs(nums,used,sum*nums[i])||
                        dfs(nums,used,sum/nums[i]))
                    return true;
                used[i]=false;
            }
        }
        return sum==24;
    }

}
