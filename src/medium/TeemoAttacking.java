package medium;

/**
 * Created by rrr on 2017/2/13.
 * 495. Teemo Attacking
 */
public class TeemoAttacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0, duplicates = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int tmp = timeSeries[i + 1] - timeSeries[i];
            if (tmp < duration)
                duplicates += duration - tmp;
        }
        result = duration * timeSeries.length - duplicates;
        return result;
    }

    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        int res = 0;
        if (timeSeries == null || timeSeries.length == 0 || duration <= 0) return res;
        for (int i = 1; i < timeSeries.length; i++) {
            res += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return res + duration;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1, 2, 4};
        System.out.println(findPoisonedDuration(timeSeries, 2));
        int[] timeSeries2 = {1, 3, 4};
        System.out.println(findPoisonedDuration(timeSeries2, 3));
        int[] timeSeries3 = {1, 5, 9, 10};
        System.out.println(findPoisonedDuration(timeSeries3, 3));
    }
}
