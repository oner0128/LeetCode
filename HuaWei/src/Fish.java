import java.util.Scanner;

/**
 * Created by rrr on 2017/4/11.
 */
public class Fish {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] newFishSizes = scanner.nextLine().split(" ");
            int newFishMax = Integer.parseInt(newFishSizes[1]);
            int newFishMin = Integer.parseInt(newFishSizes[0]);
            int fishNums = Integer.parseInt(scanner.nextLine());
            String[] Fishs = scanner.nextLine().split(" ");
            int[] fishs = new int[Fishs.length];
            for (int i = 0; i < Fishs.length; i++) {
                fishs[i] = Integer.parseInt(Fishs[i]);
            }
            System.out.println(calculate(fishs, fishNums, newFishMax, newFishMin));
        }
    }

    private static int calculate(int[] fishs, int fishNums, int newFishMax, int newFishMin) {
        int count = 0;
        boolean yes;
        for (int i = newFishMin; i <= newFishMax; i++) {
            yes = true;
            for (int fish : fishs) {
                if ((fish >= i * 2 && fish <= i * 10) || (i >= fish * 2 && i <= fish * 10)) {
                    yes = false;
                    break;
                }
            }
            if (yes) count++;
        }
        return count;
    }


}
