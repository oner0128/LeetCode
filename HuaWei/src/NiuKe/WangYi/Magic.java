package NiuKe.WangYi;


import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class Magic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int one = nums[0];
            for (int j = 0; j < len-1; j++) {
                nums[j]= (nums[j]+nums[j + 1] )% 100;
            }nums[len-1]= (nums[len-1]+one )% 100;
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            sb.append(nums[i]+" ");
        }sb.append(nums[len - 1]);
        System.out.println(sb.toString());
    }
}
