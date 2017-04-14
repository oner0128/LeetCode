import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rrr on 2017/4/11.
 */
public class Nums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] numsStr = scanner.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            Arrays.sort(nums);
            calculate(nums);
        }
    }

    private static void calculate(int[] nums) {
        int one = nums[0] - 1, two = nums[nums.length-1] + 1;
        int count = 0;
        int missNum = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 2) {
                count++;
                missNum = nums[i - 1] + 1;
            } else if (nums[i] - nums[i - 1] > 2) {
                System.out.println("mistake");
                return;
            }
        }
        if (count == 0) {
            if (one == 0) System.out.println(two);
            else System.out.println(one + " " + two);
        } else if (count == 1 && missNum != -1) System.out.println(missNum);
        else System.out.println("mistake");
    }
}
