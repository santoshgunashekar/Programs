import java.util.Queue;
import java.util.Stack;

class BinaryTree {
    static class Node {
        int data;
        protected Node left;
        protected Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node root;

    public static void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.left);
        System.out.println(node.data);
        traverseInOrder(node.right);
    }

    public static void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public static void traversePostOrder(Node node) {
        if (node == null) {
            return;
        }
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.println(node.data);
    }

    public static void traversePreOrderNoRecursion() {
        if (root == null) {
            return;
        }
        Stack<Node> list = new Stack<Node>();
        Node temp;
        for (temp = root;;) {
            System.out.println(temp.data);
            if (temp.right != null) {
                list.push(temp.right);
            }
            if (temp.left != null) {
                temp = temp.left;
                continue;
            }
            if (list.empty()) {
                break;
            }
            temp = list.pop();
        }
    }

    public static void traverseInOrderNoRecursion() {
        if (root == null) {
            return;
        }
        Stack<Node> list = new Stack<Node>();
        Node temp;
        for (temp = root;;) {
            if (temp.right != null) {
                list.push(temp.right);
            }
            list.push(temp);
            if (temp.left != null) {
                temp = temp.left;
                continue;
            }
            if ((temp.left == null && temp.right == null) || (temp.left == null)) {
                list.pop();
            }
            System.out.println(temp.data);
            System.out.println(list.pop().data);
            if (list.empty()) {
                break;
            }
            temp = list.pop();
        }
    }

    public static void traversePostOrderNoRecursion() {
        if (root == null) {
            return;
        }
        Stack<Node> list = new Stack<Node>();
        Stack<Node> out = new Stack<Node>();
        Node temp = root;
        list.add(root);
        while (!list.empty()) {
            temp = list.pop();
            out.push(temp);
            if (temp.left != null) {
                list.add(temp.left);
            }
            if (temp.right != null) {
                list.add(temp.right);
            }
        }
        while (!out.empty()) {
            System.out.println(out.pop().data);
        }
    }

    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftMax = 0, rightMax = 0;
        if (node.left != null) {
            leftMax = 1 + getHeight(node.left);
        }
        if (node.right != null) {
            rightMax = 1 + getHeight(node.right);
        }
        return Math.max(leftMax, rightMax);
    }

    public static int getLevel(Node node, Node parent, int level) {
        if (parent == null) {
            return 0;
        }
        if (node == parent) {
            return level;
        }
        int temp = getLevel(node, parent.left, level + 1);
        if (temp != 0) {
            level = temp;
            return level;
        }
        level = getLevel(node, parent.right, level + 1);
        return level;

    }

    public static int getDepth(Node node) {
        return getLevel(node, root, 0);
    }

    public static void main(String[] args) {
        root = null;
        Node newNode = new Node(1, null, null);
        root = newNode;
        newNode = new Node(2, null, null);
        root.left = newNode;
        newNode = new Node(3, null, null);
        root.right = newNode;
        newNode = new Node(4, null, null);
        root.right.left = newNode;
        newNode = new Node(5, null, null);
        root.right.right = newNode;
        newNode = new Node(6, null, null);
        root.right.left.left = newNode;
        newNode = new Node(7, null, null);
        root.right.left.right = newNode;
        newNode = new Node(8, null, null);
        root.right.right.right = newNode;
        traversePreOrder(root);
        System.out.println("Height of the tree is " + getHeight(root));
        System.out.println("Level of root node is " + getLevel(root.right.right.right, root, 0));
        System.out.println("Depth of last node is " + getDepth(root.right.right.right));
        traversePostOrderNoRecursion();
    }
}