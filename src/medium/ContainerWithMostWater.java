package medium;

import java.util.Arrays;

/**
 * Created by rrr on 2017/4/5.
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    //穷举法 O（n^2)
    //Time Limit Exceeded无法通过
    public static int maxArea(int[] height) {
        int max = 0, tmp = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                tmp = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(tmp, max);
            }
        }
        return max;
    }
    //LeetCode大神解法
//    https://discuss.leetcode.com/topic/25004/easy-concise-java-o-n-solution-with-proof-and-explanation
    public static int maxArea2(int[] height) {
        int len = height.length, low = 0, high = len -1 ;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 2, 3, 4, 1}));
        System.out.println(maxArea(new int[]{1, 2, 5, 4, 3, 2, 1}));
        System.out.println(maxArea(new int[]{1, 1, 8, 7, 5, 3, 1}));
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{1, 0}));
        System.out.println(maxArea2(new int[]{1, 2, 3, 4, 1}));
        System.out.println(maxArea2(new int[]{1, 2, 5, 4, 3, 2, 1}));
        System.out.println(maxArea2(new int[]{1, 1, 8, 7, 5, 3, 1}));
        System.out.println(maxArea2(new int[]{1, 1}));
        System.out.println(maxArea2(new int[]{1, 0}));
    }
}
