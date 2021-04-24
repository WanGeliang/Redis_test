package ZuoShen.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化与反序列化二叉树，
 */
public class SerialTree {
    public static void main(String[] args) {
        TreeNode n12 = new TreeNode(12);
        TreeNode n3 = new TreeNode(3);
        n12.left = n3;
        SerialTree method = new SerialTree();
//        String s=method.SerialTree(n12);
//        System.out.println(s);
//        TreeNode treeNode = method.ReSerialToTree(s);
//        System.out.println(treeNode);

        String ss = method.CXSerialTreeNode(n12);
        System.out.println(ss);
        System.out.println(method.ReCXTreeNode(ss));
    }

    /**
     * 1.序列化二叉树
     * 方法一：使用前序进行序列化
     *
     * @param root
     * @return
     */
    public String SerialTree(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += SerialTree(root.left);
        res += SerialTree(root.right);
        return res;

    }

    /**
     * 使用前序遍历进行反序列化二叉树
     *
     * @param s
     * @return
     */
    public TreeNode ReSerialToTree(String s) {
        String[] str = s.split("!");
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        return converToNode(list);
    }

    /**
     * 撞进一个队列里面
     *
     * @param list
     * @return
     */
    public TreeNode converToNode(LinkedList<String> list) {
        String s = list.pollFirst();
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = converToNode(list);
        root.right = converToNode(list);
        return root;
    }

    /**
     * 使用层序遍历进行序列化二叉树
     *
     * @param root
     * @return
     */
    public String CXSerialTreeNode(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String s = root.val + "!";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head.left != null) {
                s += head.left.val + "!";
                queue.add(head.left);
            } else {
                s += "#!";
            }
            if (head.right != null) {
                s += head.right.val + "!";
                queue.add(head.right);
            } else {
                s += "#!";
            }
        }
        return s;
    }

    /**
     * 使用层序遍历反序列化二叉树
     *
     * @param s
     * @return
     */
    public TreeNode ReCXTreeNode(String s) {
        String[] values = s.split("!");
        int index = 0;
        TreeNode head = newTreeNode(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()){
            node=queue.poll();
            node.left=newTreeNode(values[index++]);
            node.right=newTreeNode(values[index++]);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }
        return head;
    }

    public TreeNode newTreeNode(String s) {
        if (s.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(s));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}