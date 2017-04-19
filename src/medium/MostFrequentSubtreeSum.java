package medium;

import java.util.*;

/**
 * Created by rrr on 2017/4/10.
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * Examples 1
 * Input:
 * 5
 * /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * 5
 * /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 */
public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        findsum(root, map);
        int max = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Map<Integer, Integer> heap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) max = Math.max(max, entry.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) if (entry.getValue() == max) res.add(entry.getKey());
        int[] ress = new int[res.size()];
        for (int i = 0; i < ress.length; i++) {
            ress[i] = res.get(i);
        }
        return ress;
    }

    private int findsum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int sum = 0;
        int leftSum = findsum(root.left, map);
        int rightSum = findsum(root.right, map);
        sum = leftSum + rightSum + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    int maxCount;
    Map<Integer, Integer> maps;

    public int[] findFrequentTreeSum2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        maps = new HashMap<>();
        findsum(root, maps);
        Set<Map.Entry<Integer, Integer>> entries = maps.entrySet();
        Map<Integer, Integer> heap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) if (entry.getValue() == maxCount) res.add(entry.getKey());
        int[] ress = new int[res.size()];
        for (int i = 0; i < ress.length; i++) {
            ress[i] = res.get(i);
        }
        return ress;
    }

    private int findsum2(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int sum = 0;
        int leftSum = findsum(root.left, map);
        int rightSum = findsum(root.right, map);
        sum = leftSum + rightSum + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        maxCount = Math.max(maxCount, count);
        return sum;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
