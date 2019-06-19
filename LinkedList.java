class LinkedListADT {
    static class Node {
        int data;
        protected Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node head;

    public static void getValueAtPosition(int k) {
        if (head == null) {
            System.out.println("No nodes present in the list");
            return;
        }
        int position = 1;
        Node temp = head;
        while (temp != null) {
            if (position == k) {
                System.out.println("Value at position " + k + " is " + temp.data);
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Lesser number of nodes present in the list");
    }

    public static void insertNodeAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void insertNodeAtMiddle(int data, int k) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        int position = 1;
        Node temp = head;
        Node prev = head;
        while (position < k - 1 && temp != null) {
            prev = temp;
            temp = temp.next;
            position++;
        }
        if (position != k - 1) {
            prev.next = newNode;
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void insertNodeAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void removeValue(int value) {
        if (head == null) {
            System.out.println("Removing a node is not possible");
            return;
        }
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data == value) {
                removekthNode(position);
                temp = temp.next;
                continue;
            }
            position++;
            temp = temp.next;
        }
    }

    public static void traverse() {
        if (head == null) {
            System.out.println("No nodes in the list");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int lengthOfList() {
        int length = 0;
        if (head == null) {
            return 0;
        }
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void search(int data) {
        if (head == null) {
            System.out.println("No nodes present");
            return;
        }
        int position = 1;
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Data present at index " + position);
            }
            position++;
            temp = temp.next;
        }
    }

    public static void removeNodeAtEnd() {
        removekthNode(lengthOfList());
    }

    public static void removeFirstNode() {
        removekthNode(1);
    }

    public static void removekthNode(int k) {
        if (head == null) {
            System.out.println("Removing a node is not possible");
            return;
        }
        if (k == 1) {
            Node first = head;
            head = head.next;
            first = null;
            return;
        }
        Node temp = head;
        Node prev = head;
        int count = 1;
        while (count < k && temp != null) {
            prev = temp;
            temp = temp.next;
            count++;
        }
        if (count != k) {
            System.out.println("Lesser nodes present in the list");
            return;
        }
        if (temp.next == null) {
            Node node = temp;
            prev.next = null;
            node = null;
            return;
        } else {
            Node node = prev.next;
            prev.next = temp.next;
            node = null;
            return;
        }

    }

    public static void reverseList() {
        if (head == null) {
            System.out.println("No nodes in the list");
        }
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        head = null;
        insertNodeAtEnd(10);
        traverse();
        insertNodeAtEnd(20);
        traverse();
        insertNodeAtEnd(30);
        traverse();
        insertNodeAtEnd(40);
        traverse();
        insertNodeAtEnd(20);
        traverse();
        insertNodeAtEnd(30);
        traverse();
        insertNodeAtStart(0);
        traverse();
        insertNodeAtMiddle(100, 4);
        traverse();
        System.out.println("Length of the linked list is " + lengthOfList());
        search(20);
        removeFirstNode();
        traverse();
        removeNodeAtEnd();
        traverse();
        reverseList();
        traverse();
        getValueAtPosition(5);
    }
}