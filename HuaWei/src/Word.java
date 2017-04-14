import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class Word {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            isSuperPrime(n);
        }
    }

    private static void isSuperPrime(int nums) {
        int n= (int) Math.sqrt(nums);
        int head=2;
        while (head<=n&&head*head<=nums){
            Double log=Math.log10(nums)/Math.log10(head);
            if (log.toString().matches(".*\\..*"));
        }
        int j;
        for (int i = 2; i <= Math.sqrt(nums); i++) {
            j = 2;
            for (j = 2; j <= nums / 2 && Math.pow(i, j) <= nums; j++)
                if (Math.pow(i, j) == nums) {System.out.println(i + " " + j);return;}
        }
        System.out.println("No");
    }
}
