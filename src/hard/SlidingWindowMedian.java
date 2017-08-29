package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rrr on 2017/8/29.
 * 480. Sliding Window Median
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * <p>
 * Note:
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 */
public class SlidingWindowMedian {
    // 232 ms beat 5%
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o1==o2?0:(o2>o1?1:-1));
        for (int i = 0; i < k; i++) {//初始化最大堆和最小堆
            if (maxQueue.size() < minQueue.size()) maxQueue.add(nums[i]);
            else minQueue.add(nums[i]);
            sortMaxAndMinQueue(maxQueue, minQueue);//保持最大堆中的所有数小于最小堆中的所有数
        }
        int index = 0;
        for (int i = k; i < nums.length; i++) {
            //保存窗口中位值
            medians[index++] = k % 2 == 0 ? ((double)maxQueue.peek() + (double)minQueue.peek()) / 2 : (double)minQueue.peek();
            //移除窗口最左边的元素
            int left = nums[i - k];
            if (minQueue.contains(left)) minQueue.remove(left);
            else maxQueue.remove(left);
            //增加窗口最右边的元素
            int right = nums[i];
            if (maxQueue.size() < minQueue.size()) maxQueue.add(right);
            else minQueue.add(right);
            sortMaxAndMinQueue(maxQueue, minQueue);//保持最大堆中的所有数小于最小堆中的所有数
        }
        //保存最后一个窗口中位值
        medians[index++] = k % 2 == 0 ? ((double)maxQueue.peek() + (double)minQueue.peek()) / 2 : (double)minQueue.peek();
        return medians;
    }

    private void sortMaxAndMinQueue(PriorityQueue<Integer> maxQueue, PriorityQueue<Integer> minQueue) {
        if (maxQueue.size()==0||minQueue.size()==0)return;
        while (maxQueue.peek() > minQueue.peek()) {
            int max = maxQueue.poll();
            int min = minQueue.poll();
            maxQueue.add(min);
            minQueue.add(max);
        }
    }

    //LeetCode解法 109 ms beat35%
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
            new Comparator<Integer>() {
                public int compare(Integer i1, Integer i2) {
                    return i2.compareTo(i1);
                }
            }
    );

    public double[] medianSlidingWindow2(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) return new double[0];
        double[] result = new double[n];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }

        return result;
    }

    private void add(int num) {
        if (num < getMedian()) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        }
        else {
            minHeap.remove(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        else {
            return (double)minHeap.peek();
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE}, 2)));
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(new int[]{-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 6)));
//        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
//        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o1==o2?0:(o2>o1?1:-1));
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MIN_VALUE-1);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE+1);
//        maxQueue.add(Integer.MIN_VALUE);
//        for (int i = 1; i < 10; i++) {
//            minQueue.add(i);
//            maxQueue.add(i);
//        }
//        System.out.println(minQueue.peek());
//        System.out.println(maxQueue.peek());
    }
}
