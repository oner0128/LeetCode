package hard;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rrr on 2017/8/29.
 * 295. Find Median from Data Stream
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * Credits:
 * Special thanks to @Louis1992 for adding this problem and creating all test cases.
 */
public class FindMedianFromDataStream {
    //Status: Time Limit Exceeded
    //使用最大最小堆  超时  - - !LeetCode系统问题或网络问题，能通过
    class MedianFinder_wrong {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder_wrong() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(((o1, o2) -> o1 == o2 ? 0 : (o1 < o2 ? 1 : -1)));
        }

        public void addNum(int num) {
            if (num < findMedian()) maxHeap.add(num);
            else minHeap.add(num);
            if (maxHeap.size() > minHeap.size())
                minHeap.add(maxHeap.poll());
            if (minHeap.size() - maxHeap.size() > 1)
                maxHeap.add(minHeap.poll());
        }

        public double findMedian() {
            if (minHeap.isEmpty() && maxHeap.isEmpty()) return 0.0;
            if (minHeap.size() == maxHeap.size()) return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2.0;
            else return (double) minHeap.peek();
        }
    }

    //leetCode解法 trick：PriorityQueue默认为最小堆，也可以用它作为最大堆，即加入的是-num，间接构建最大堆
    class MedianFinder {

        private Queue<Long> small = new PriorityQueue(),
                large = new PriorityQueue();

        public MedianFinder() {
        }

        public void addNum(int num) {
            large.add((long) num);
            small.add(-large.poll());
            if (large.size() < small.size())
                large.add(-small.poll());
        }

        public double findMedian() {
            return large.size() > small.size()
                    ? large.peek()
                    : (large.peek() - small.peek()) / 2.0;
        }
    }
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
