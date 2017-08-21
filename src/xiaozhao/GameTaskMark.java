package xiaozhao;

import java.util.Scanner;

/**
 * Created by rrr on 2017/8/21.
 * 题目描述
 * 游戏里面有很多各式各样的任务，其中有一种任务玩家只能做一次，这类任务一共有1024个，任务ID范围[1,1024]。请用32个unsigned int类型来记录着1024个任务是否已经完成。初始状态都是未完成。 输入两个参数，都是任务ID，需要设置第一个ID的任务为已经完成；并检查第二个ID的任务是否已经完成。 输出一个参数，如果第二个ID的任务已经完成输出1，如果未完成输出0。如果第一或第二个ID不在[1,1024]范围，则输出-1。
 * 输入描述:
 * 输入包括一行,两个整数表示人物ID.
 * 输出描述:
 * 输出是否完成
 * 示例1
 * 输入
 * <p>
 * 1024 1024
 * 输出
 * <p>
 * 1
 */
public class GameTaskMark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int first = scanner.nextInt()-1;
            int second = scanner.nextInt()-1;
            if (first < 0 || first > 1023 || second < 0 || second > 1023) {
                System.out.println(-1);
                return;
            }
            int[] tasks = new int[32];
            int index = first / 32;
            int pos = first-index * 32;
            int tmp=1;
            while (pos<31){
                pos++;
                tmp<<=1;
            }
            tasks[index]=tasks[index]|tmp;

            index = second/32;
            pos = second - index*32;
            tmp = tasks[index];
            tmp = tmp>>(31-pos);
            if((tmp&1)==1) System.out.println(1);
            else System.out.println(0);
        }
    }
}
