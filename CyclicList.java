// Program to check if a singly linked list has a cycle or not
class CyclicList {
    static class Node {
        int data;
        protected Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static Node head;

    public static void insertNodeAtEnd(int data) {
        Node newNode = new Node(data, null);
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

    public static boolean isCyclePresent() {
        Node slowPointer, fastPointer;
        slowPointer = head;
        fastPointer = head.next;
        while (true) {
            if (fastPointer == null || fastPointer.next == null) {
                return false;
            } else if (fastPointer == slowPointer || fastPointer.next == slowPointer) {
                return true;
            } else {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
        }
    }

    public static void main(String[] args) {
        head = null;
        insertNodeAtEnd(1);
        insertNodeAtEnd(2);
        insertNodeAtEnd(3);
        insertNodeAtEnd(4);
        insertNodeAtEnd(5);
        Node newNode = new Node(6, head.next.next);
        head.next.next.next.next.next = newNode;
        System.out.println(isCyclePresent());
    }
}