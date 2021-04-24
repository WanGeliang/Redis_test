package TreeProblem;

import java.util.HashMap;
import java.util.Map;

public class ReBuilderTree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return helperBuilder(preOrder, 0, preOrder.length, inOrder, 0, inOrder.length, map);
    }

    public TreeNode helperBuilder(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart == preEnd || inStart == inEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = map.get(root.val);
        int len = inRoot - inStart;
        root.left = helperBuilder(preOrder, preStart + 1, preStart + len, inOrder, inStart, inRoot - 1, map);
        root.right = helperBuilder(preOrder, preStart + len + 1, preEnd, inOrder, inRoot + 1, inEnd, map);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}