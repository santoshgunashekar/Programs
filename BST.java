class BST {
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

    public static Node insertNode(int data, Node node) {
        if (node == null) {
            Node newNode = new Node(data, null, null);
            node = newNode;
            return node;
        }
        if (data <= node.data) {
            node.left = insertNode(data, node.left);
        } else {
            node.right = insertNode(data, node.right);
        }
        return node;
    }

    public static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    public static void search(int data, Node node, int steps) {
        if (node == null) {
            System.out.println("Element does not exist in the list");
            return;
        }
        if (data == node.data) {
            System.out.println("Element exists in the list. Found in " + steps + " steps.");
            return;
        } else if (data <= node.data) {
            search(data, node.left, steps + 1);
        } else {
            search(data, node.right, steps + 1);
        }
    }

    public static void main(String[] args) {
        root = insertNode(5, root);
        root = insertNode(11, root);
        root = insertNode(3, root);
        root = insertNode(8, root);
        root = insertNode(7, root);
        root = insertNode(4, root);
        inOrderTraversal(root);
        search(7, root, 1);
    }
}