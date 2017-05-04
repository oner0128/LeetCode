/**
 * Created by rrr on 2017/5/4.
 * 题目描述
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    static boolean verift = true;

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        helper(sequence, 0, sequence.length - 1);
        return verift;
    }

    private static void helper(int[] sequence, int start, int end) {
        if (start >= end) return;
        int index = start;
        int root = sequence[end];
        int i = start;
        while (i < end) {
            if (sequence[i] > root) break;
            i++;
        }
        index = i ;
        //left
        i = start;
        while (i < index) {
            if (sequence[i++] > root) {
                verift = false;
                return;
            }
        }
        //right
        i = index;
        while (i < end) {
            if (sequence[i++] < root) {
                verift = false;
                return;
            }
        }
        helper(sequence, start, index - 1);
        helper(sequence, index, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{4,6,7,5}));
        System.out.println(VerifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));
        System.out.println(VerifySquenceOfBST(new int[]{7, 4, 6, 5}));
    }
}
