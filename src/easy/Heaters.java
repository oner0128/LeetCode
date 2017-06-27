package easy;

import java.util.Arrays;

/**
 * Created by rrr on 2017/6/19.
 * 475. Heaters
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * <p>
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * <p>
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * <p>
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */
public class Heaters {
    //思路：对于每个houses的位置在heaters中进行二分查找
    //若没有找到，则求出left or right heaters距离最小的一个，注意处理边界
    //输出第二步中最大的一个距离
    //没能通过测试就是因为没处理好边界的求值
    public static int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0) return 0;
        int ansRadius=0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int lo = 0, hi = heaters.length-1;
            int mid = lo + (hi - lo) / 2;
            while (lo < hi) {
                mid = lo + (hi - lo) / 2;
                if (heaters[mid] == house) break;
                if (heaters[mid] > house) hi = mid;
                else lo = mid + 1;
            }
            if (heaters[mid] != house) {
                int minRadius = 0;
                if (mid<heaters.length-1)//边界没处理好，使用+1-1来求左右的heaters，当heaters长度为1无法使用，缺乏通用性
                    minRadius = Math.abs(heaters[mid] - house)<Math.abs(heaters[mid+1] - house)?Math.abs(heaters[mid] - house):Math.abs(heaters[mid+1] - house);
                else minRadius = Math.abs(heaters[mid] - house)<Math.abs(heaters[mid-1] - house)?Math.abs(heaters[mid] - house):Math.abs(heaters[mid-1] - house);
                ansRadius=Math.max(ansRadius,minRadius);
            }
        }
        return ansRadius;
    }
    //LeetCode解法
    public static int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }
    //参照LeetCode代码重新编写边界部分代码
    public static int findRadius3(int[] houses, int[] heaters) {
        if (houses.length == 0) return 0;
        int ansRadius=0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int lo = 0, hi = heaters.length-1;
            int mid = lo + (hi - lo) / 2;
            while (lo < hi) {
                mid = lo + (hi - lo) / 2;
                if (heaters[mid] == house) break;
                if (heaters[mid] > house) hi = mid;
                else lo = mid + 1;
            }
            if (heaters[mid] != house) {
                int distance1=lo>0?Math.abs(house-heaters[lo-1]):Integer.MAX_VALUE;
                int distance2=lo<heaters.length?Math.abs(house-heaters[lo]):Integer.MAX_VALUE;
                ansRadius=Math.max(ansRadius,Math.min(distance1,distance2));
            }
        }
        return ansRadius;
    }
    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1,2,3,4},new int[]{1,4}));
        System.out.println(findRadius(new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 5, 5, 5, 6}));
        System.out.println(findRadius(new int[]{1,2,3,4,5},new int[]{1,5}));
        System.out.println(findRadius(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 5, 5, 5, 6}));
        System.out.println(findRadius2(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
        System.out.println(findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
        System.out.println(findRadius3(new int[]{1,2,3,4},new int[]{1,4}));
        System.out.println(findRadius3(new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 5, 5, 5, 6}));
        System.out.println(findRadius3(new int[]{1,2,3,4,5},new int[]{1,5}));
        System.out.println(findRadius3(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 5, 5, 5, 6}));
        System.out.println(findRadius3(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
        System.out.println(findRadius3(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
        System.out.println(Arrays.binarySearch(new int[]{1,2,5}, 3));
        int[]heaters={1,2,5};int house=3;
        int lo = 0, hi = heaters.length-1;
        int mid = lo + (hi - lo) / 2;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (heaters[mid] == house) break;
            if (heaters[mid] > house) hi = mid;
            else lo = mid + 1;
        }
        System.out.println(lo);
    }
}
