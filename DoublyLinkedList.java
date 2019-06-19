import java.util.Scanner;

class DoublyLinkedList {
    static class Node {
        int data;
        protected Node prev;
        protected Node next;

        Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    static Node head;
    static Node current;
    static int current_position;

    public static void insertNodeAtEnd(int data) {
        if (head == null) {
            Node newNode = new Node(data, null, null);
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(data, null, null);
        temp.next = newNode;
        newNode.prev = temp;
    }

    public static void traverse() {
        if (head == null) {
            System.out.println("No nodes present in the list");
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

    /**
     * public static void moveLeft() { if (current_position == 0) {
     * System.out.println("Already at the start"); return; } current = current.prev;
     * current_position--; System.out.println("Currently at node " +
     * current_position + " and data is " + current.data); }
     * 
     * public static void moveRight() { if (current_position == lengthOfList()) {
     * System.out.println("Already at the end"); return; } current_position++;
     * System.out.println("Currently at node " + current_position + " and data is "
     * + current.data); current = current.next; }
     */

    public static void insertAtPosition(int k, int data) {
        if (head == null) {
            insertNodeAtEnd(data);
            return;
        }
        int position = 0;
        Node temp = head;
        while (position < k - 1 && temp != null) {
            temp = temp.next;
            position++;
        }
        if (position != k - 1) {
            System.out.println("Lesser number of nodes in the list");
            return;
        }
        Node newNode = new Node(data, null, null);
        newNode.prev = temp.prev;
        newNode.next = temp;

        temp.prev.next = newNode;
        temp.prev = newNode;
    }

    public static void removeAtPosition(int k) {
        if (head == null) {
            System.out.println("No nodes present in the list");
            return;
        }
        Node temp = head;
        int position = 0;
        while (position < k - 1 && temp != null) {
            temp = temp.next;
            position++;
        }
        if (position != k - 1) {
            System.out.println("Lesser number of nodes in the list");
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public static void main(String[] args) {
        insertNodeAtEnd(10);
        insertNodeAtEnd(20);
        insertNodeAtEnd(30);
        insertNodeAtEnd(40);
        // traverse();
        Scanner scanner = new Scanner(System.in);
        current = head;
        current_position = 0;
        /*
         * while (true) { System.out.println("l- left and r-right"); String input =
         * scanner.next(); if (input.equalsIgnoreCase("l")) { moveLeft(); } else if
         * (input.equalsIgnoreCase("r")) { moveRight(); } else { break; } }
         */
        insertAtPosition(3, 10);
        traverse();
        removeAtPosition(3);
        traverse();
    }
}