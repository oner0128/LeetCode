package HashTable;

import java.util.*;

/**
 * Created by rrr on 2017/4/10.
 * 554. Brick Wall
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * <p>
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 * <p>
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * <p>
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 * <p>
 * Example:
 * Input:
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * Output: 2
 * Note:
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 * Subscribe to see which companies asked this question.
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum, count, maxEdge = 0, wallWeight = 0;
        for (int num : wall.get(0)) wallWeight += num;
        for (List<Integer> list : wall) {
            sum = 0;
            for (int num : list) {
                sum += num;
                if (wallWeight == sum) break;
                count = map.getOrDefault(sum, 0) + 1;
                map.put(sum, count);
                maxEdge = Math.max(maxEdge, count);
            }
        }
        return wall.size() - maxEdge;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 2, 2, 1));
        lists.add(Arrays.asList(3, 1, 2));
        lists.add(Arrays.asList(1, 3, 2));
        lists.add(Arrays.asList(2, 4));
        lists.add(Arrays.asList(3, 1, 2));
        lists.add(Arrays.asList(1, 3, 1, 1));
        System.out.println(new BrickWall().leastBricks(lists));
    }
}
