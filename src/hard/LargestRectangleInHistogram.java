package hard;

import java.util.Stack;

/**
 * Created by rrr on 2017/5/16.
 * 84. Largest Rectangle in Histogram
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.
 */
public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        if(heights==null)return 0;
        Stack<Integer> stack=new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i<heights.length){
            if (stack.isEmpty()||heights[i]>=heights[stack.peek()])stack.push(i++);
            else {
                int leftIndex=stack.pop();
                int area=heights[leftIndex]*(stack.isEmpty()?i:(i-stack.peek()-1));
                maxArea=Math.max(area,maxArea);
            }
        }
        while (!stack.isEmpty()){
            int leftIndex=stack.pop();
            int area=heights[leftIndex]*(stack.isEmpty()?i:(i-stack.peek()-1));
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
    //leetCode
    public static int largestRectangleArea2(int[] heights) {
        if(heights==null)return 0;
        Stack<Integer> stack=new Stack<>();
        int maxArea = 0;
        for(int i=0;i<=heights.length;i++){
            int h=i==heights.length?0:heights[i];
            if (stack.isEmpty()||h>=heights[stack.peek()])stack.push(i);
            else {
                int leftIndex=stack.pop();
                int area=heights[leftIndex]*(stack.isEmpty()?i:(i-stack.peek()-1));
                maxArea=Math.max(area,maxArea);
                i--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }
}
