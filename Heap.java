import java.util.LinkedList;
import java.util.Queue;

class Heap {
    static class Node {
        int data;
        protected Node left, right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node root;
    static boolean max;
    static int count = 0;
    static Node lastNode, currentParent;
    static Queue<Node> parentQueue;
    static int childRemoved;

    public static Node insertNode(int data, Node node) {
        count++;
        Node newNode = new Node(data, null, null);
        lastNode = newNode;
        if (node == null) {
            if (node != root) {
                parentQueue.add(newNode);
            }
            return newNode;
        }
        if (node.left == null) {
            node.left = insertNode(data, node.left);
            if (max) {
                node = maxHeapify(node);
            } else {
                node = minHeapify(node);
            }
            return node;
        } else if (node.right == null) {
            node.right = insertNode(data, node.right);
            if (max) {
                node = maxHeapify(node);
            } else {
                node = minHeapify(node);
            }
            return node;
        }
        if (count % 2 == 0) {
            currentParent = parentQueue.remove();
            childRemoved++;
        }
        if (childRemoved % 2 == 1) {
            node.left = insertNode(data, currentParent);
        } else {
            node.right = insertNode(data, currentParent);
        }
        if (max) {
            node = maxHeapify(node);
        } else {
            node = minHeapify(node);
        }
        return node;
    }

    // For a min-heap
    // For a max-heap, change the lesser than symbol(<) to greater than symbol(>)
    public static Node maxHeapify(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null && node.left.data > node.data) {
            int temp = node.data;
            node.data = node.left.data;
            node.left.data = temp;
        }
        if (node.right != null && node.right.data > node.data) {
            int temp = node.data;
            node.data = node.right.data;
            node.right.data = temp;
        }
        node.left = maxHeapify(node.left);
        node.right = maxHeapify(node.right);
        return node;
    }

    public static Node minHeapify(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null && node.left.data < node.data) {
            int temp = node.data;
            node.data = node.left.data;
            node.left.data = temp;
        }
        if (node.right != null && node.right.data < node.data) {
            int temp = node.data;
            node.data = node.right.data;
            node.right.data = temp;
        }
        node.left = minHeapify(node.left);
        node.right = minHeapify(node.right);
        return node;
    }

    public static void traverse(Node node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        System.out.print(node.data + " ");
        traverse(node.right);
    }

    public static void traversePre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        traversePre(node.left);
        traversePre(node.right);
    }

    public static int getMin() {

        int temp = root.data;
        root.data = lastNode.data;
        if (currentParent.right != null) {
            currentParent.right = null;
        } else {
            currentParent.left = null;
        }
        root = minHeapify(root);
        return temp;
    }

    public static int getMax() {
        int temp = root.data;
        root.data = lastNode.data;
        if (currentParent.right != null) {
            currentParent.right = null;
        } else {
            currentParent.left = null;
        }
        root = maxHeapify(root);
        return temp;
    }

    public static void main(String[] args) {
        root = null;
        lastNode = null;
        childRemoved = 0;
        // set max to true to get max-Heap
        // set max to false to get min-Heap
        max = true;

        parentQueue = new LinkedList<Node>();
        root = insertNode(1, root);
        root = insertNode(3, root);
        root = insertNode(6, root);
        root = insertNode(5, root);
        root = insertNode(9, root);
        root = insertNode(8, root);
        root = insertNode(-2, root);
    }
}