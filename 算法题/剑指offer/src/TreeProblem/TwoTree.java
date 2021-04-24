package TreeProblem;

import java.util.*;

public class TwoTree {
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
//        Arrays.asList()

        new ArrayList<>();
        new LinkedList<>();
        new HashMap<>();
    }

    public void preNoRecursionOrder(TwoNode root) {
        if (root != null) {
            Stack<TwoNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TwoNode tempNode = stack.pop();
                list.add(tempNode.val);
                if (tempNode.right != null) stack.push(tempNode.right);
                if (tempNode.left != null) stack.push(tempNode.left);
            }
        }
    }

    public void midNoRecursionOrder(TwoNode root) {
        if (root != null) {
            Stack<TwoNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
    }

    public void postNoRecursionOrder(TwoNode root) {
        if (root != null) {
            Stack<TwoNode> s1 = new Stack<>();
            Stack<TwoNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()) {
                root = s1.pop();
                s2.push(root);
                if (root.left != null) s1.push(root.left);
                if (root.right != null) s1.push(root.right);
            }
            while (!s2.isEmpty()) {
                list.add(s2.pop().val);
            }
        }
    }

    public void pre(TwoNode root) {
        if (root != null) {
            Stack<TwoNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }

    public void mid(TwoNode root) {
        if (root != null) {
            Stack<TwoNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
    }

    public void post(TwoNode root) {
        if (root != null) {
            Stack<TwoNode> s1 = new Stack<>();
            Stack<TwoNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()) {
                root = s1.pop();
                if (root.left != null) {
                    s1.push(root.left);
                }
                if (root.right != null) {
                    s1.push(root.right);
                }
            }
            while (!s2.isEmpty()) {
                list.add(s2.pop().val);
            }
        }
    }
}

class TwoNode {
    int val;
    TwoNode left;
    TwoNode right;

    TwoNode() {
    }

    TwoNode(int val) {
        this.val = val;
    }

    TwoNode(int val, TwoNode left, TwoNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}