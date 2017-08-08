package medium;

import base.TreeLinkNode;
import easy.IsomorphicStrings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rrr on 2017/8/8.
 * 116. Populating Next Right Pointers in Each Node
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode {
    //bfs
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeLinkNode node = queue.poll();
                if (size > 0 && queue.peek() != null) node.next = queue.peek();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }

    //dfs
    public void connect2(TreeLinkNode root) {
        List<List<TreeLinkNode>> listList = new ArrayList<>();
        dfs(root, listList, 0);
        for (List<TreeLinkNode> list : listList)
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
    }

    private void dfs(TreeLinkNode root, List<List<TreeLinkNode>> listList, int level) {
        if (root == null) return;
        if (level >= listList.size()) listList.add(new ArrayList<>());

        listList.get(level).add(root);
        dfs(root.left, listList, level + 1);
        dfs(root.right, listList, level + 1);
    }
}
