import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rrr on 2017/3/11.
 */
public class FindEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(findEvenNumber(scanner.nextInt()));
        }
    }

    public static int findEvenNumber(int n) {
        if (n<3)return -1;
        int[][] nums = new int[n][2*n-1];
        nums[0][0]=1;
        nums[1][0]=nums[1][1]=nums[1][2]=1;
        for (int i = 2; i <n; i++) {
            for (int j = 0; j <= 2*i; j++) {
                if (j==0||j==2*i)nums[i][j]=1;
                else if (j==1)nums[i][j]=nums[i-1][j-1]+nums[i-1][j];
                else if (j==2*i-1)nums[i][j]=nums[i-1][j-2]+nums[i-1][j-1];
                else nums[i][j]=nums[i-1][j-2]+nums[i-1][j-1]+nums[i-1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        for (int i = 0; i < 2*n-1; i++) {
           if ((nums[n-1][i]&1)!=1)return i+1;
        }
        return -1;
    }
}
