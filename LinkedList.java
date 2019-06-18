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

    public static void insertNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
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

    public static void search() {

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

    public static void main(String[] args) {
        head = null;
        insertNode(10);
        insertNode(20);
        insertNode(30);
        insertNode(40);
        insertNode(20);
        insertNode(30);

        Node temp = head;

        // removekthNode(1);
        // removeValue(20);
        System.out.println("Length of the linked list is " + lengthOfList());
        temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}