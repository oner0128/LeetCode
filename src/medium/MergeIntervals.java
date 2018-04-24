package medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rrr on 2018/4/24.
 * 56. Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */


class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> comparator= (o1, o2) -> o1.start>o2.start?1:o1.start==o2.start?0:-1;
        Collections.sort(intervals,comparator);
        for (int i=0,j=i+1;i<intervals.size()-1;) {
            if (intervals.get(i).end>=intervals.get(j).start){
                intervals.get(i).end=intervals.get(j).end>intervals.get(i).end?intervals.get(j).end:intervals.get(i).end;
                intervals.remove(j);
            }else {
                i=j++;
            }
        }
        return intervals;
    }
}
