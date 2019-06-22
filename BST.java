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

    public static boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeight(node.left);
        if (node.left != null) {
            leftHeight++;
        }
        int rightHeight = getHeight(node.right);
        if (node.right != null) {
            rightHeight++;
        }
        int difference = leftHeight - rightHeight;
        if (difference >= -1 && difference <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public static Node rotateRight(Node node) {
        Node temp = node;
        node = node.left;
        if (temp.right == null && node.right == null) {
            node.right = temp;
        } else if (temp.right != null && node.right == null) {
            node.right = temp.right;
            insertNode(temp.data, node.right);
        } else if (temp.right == null && node.right != null) {
            insertNode(temp.data, node.right);
            node = findMax(node.right);
        } else {
            insertNode(temp.data, node.right);
            InsertNodes(node.right, temp.right);
        }
        temp.left = null;
        return node;
    }

    public static void InsertNodes(Node node, Node root) {
        if (node == null) {
            return;
        }
        insertNode(node.data, root);
        InsertNodes(node.left, root);
        InsertNodes(node.right, root);
    }

    public static void main(String[] args) {
        root = insertNode(5, root);
        root = insertNode(4, root);
        root = insertNode(3, root);
        root = insertNode(2, root);
        root = insertNode(1, root);
        root = insertNode(7, root);
        root = insertNode(6, root);
        root = insertNode(8, root);

        root = rotateRight(root.right);
        traversePreOrder(root);
        // inOrderTraversal(root);
    }
}