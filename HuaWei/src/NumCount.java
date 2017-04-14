import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class NumCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            cal(n);
        }
    }

    private static void cal(int n) {
        int[] nums=new int[10];
        for (int i = 1; i <= n; i++) {
            int num=i;
            while (num>0){
                int mod=num%10;
                nums[mod]++;
                num/=10;
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < nums.length-1; i++) {
            stringBuilder.append(nums[i]+" ");
        }stringBuilder.append(nums[nums.length-1]);
        System.out.println(stringBuilder.toString());
    }

}
