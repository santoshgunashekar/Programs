import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

class MthToLast {
    static class Node {
        int data;
        protected Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node head;

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

    public static void getMthToLast(int m) {
        if (head == null) {
            System.out.println("No nodes present in the list");
            return;
        }
        int length = lengthOfList();
        if (length < m) {
            System.out.println("Lesser number of codes in the list");
            return;
        }
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (position == (length - m)) {
                System.out.println("Mth to last element in the list is " + temp.data);
                return;
            }
            position++;
            temp = temp.next;
        }
        System.out.println("Lesser nodes present in the list");
    }

    public static void main(String[] args) {
        head = null;
        insertNodeAtEnd(10);
        insertNodeAtEnd(20);
        insertNodeAtEnd(30);
        insertNodeAtEnd(40);
        insertNodeAtEnd(50);
        insertNodeAtEnd(60);
        insertNodeAtEnd(70);
        insertNodeAtEnd(80);
        getMthToLast(2);
    }
}