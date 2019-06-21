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

    public static Node findMax(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return node.right;
        } else if (node.left != null) {
            return node.left;
        } else {
            return node;
        }
    }

    public static Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return node.left;
        } else if (node.right != null) {
            return node.right;
        } else {
            return node;
        }
    }

    public static Node deleteNode(int data, Node node) {
        if (node == null) {
            return null;
        }
        if (data == node.data) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left != null && node.right == null) {
                Node temp = findMax(node.left);
                int temp_data = temp.data;
                node.left = deleteNode(temp_data, node.left);
                node.data = temp_data;
                return node;
            } else {
                Node temp = findMin(node.right);
                int temp_data = temp.data;
                node.right = deleteNode(temp_data, node.right);
                node.data = temp_data;
                return node;
            }
        }
        if (data < node.data) {
            node.left = deleteNode(data, node.left);
        } else if (data > node.data) {
            node.right = deleteNode(data, node.right);
        }
        return node;
    }

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

    public static Node LCA(int data1, int data2, Node node) {
        if (node == null) {
            return null;
        }
        if (Math.max(data2, data1) <= node.data) {
            node = LCA(data1, data2, node.left);
        } else if (Math.min(data2, data1) > node.data) {
            node = LCA(data1, data2, node.right);
        } else {
            return node;
        }
        return node;
    }

    public static void main(String[] args) {
        root = insertNode(5, root);
        root = insertNode(11, root);
        root = insertNode(3, root);
        root = insertNode(8, root);
        root = insertNode(7, root);
        root = insertNode(4, root);
        root = insertNode(2, root);
        root = insertNode(1, root);
        root = insertNode(9, root);
        root = insertNode(10, root);
        root = insertNode(7, root);
        root = insertNode(16, root);
        root = insertNode(12, root);
        root = insertNode(18, root);
        root = insertNode(19, root);
        System.out.println(LCA(7, 19, root).data);
        // inOrderTraversal(root);
        // search(7, root, 1);
        // System.out.println(findMin(root.left.right));
        // root = deleteNode(3, root);
        // root = deleteNode(8, root);
        // root = deleteNode(5, root);
        // inOrderTraversal(root);
    }
}