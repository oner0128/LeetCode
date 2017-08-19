package xiaozhao;

import java.util.Scanner;

/**
 * Created by rrr on 2017/8/18.
 * 题目描述
 * 有一片1000*1000的草地，小易初始站在(1,1)(最左上角的位置)。小易在每一秒会横向或者纵向移动到相邻的草地上吃草(小易不会走出边界)。大反派超超想去捕捉可爱的小易，他手里有n个陷阱。第i个陷阱被安置在横坐标为xi ，纵坐标为yi 的位置上，小易一旦走入一个陷阱，将会被超超捕捉。你为了去解救小易，需要知道小易最少多少秒可能会走入一个陷阱，从而提前解救小易。
 * 输入描述:
 * 第一行为一个整数n(n ≤ 1000)，表示超超一共拥有n个陷阱。
 * 第二行有n个整数xi，表示第i个陷阱的横坐标
 * 第三行有n个整数yi，表示第i个陷阱的纵坐标
 * 保证坐标都在草地范围内。
 * 输出描述:
 * 输出一个整数,表示小易最少可能多少秒就落入超超的陷阱
 * 示例1
 * 输入
 * <p>
 * 3
 * 4 6 8
 * 1 2 1
 * 输出
 * <p>
 * 3
 */
public class SaveXiaoYi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[][] xy = new int[2][num];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < num; j++) {
                    xy[i][j] = scanner.nextInt();
                }
            }
            System.out.println(findMinTime(num, xy));
        }
    }

    private static int findMinTime(int num, int[][] xy) {
        if (num == 0) return 0;
        int minTime = Integer.MAX_VALUE;
        for (int j = 0; j < num; j++) {
            if (xy[0][j]+xy[1][j]-2<minTime)minTime=xy[0][j]+xy[1][j]-2;
        }
        return minTime;
    }
}
