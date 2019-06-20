import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

class ListFlattener {
    static class Node {
        int data;
        protected Node next, prev, child;

        Node(int data, Node prev, Node child, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    static Node head;
    static Node tail;

    public static void traverse() {
        if (head == null) {
            System.out.println("No nodes present in the list");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void traverseChild() {
        if (head == null) {
            System.out.println();
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            Node head_temp = head;
            head = temp.child;
            traverse();
            traverseChild();
            head = head_temp;
            temp = temp.next;
        }
        System.out.println();
    }

    static Node prev;
    static Queue<Node> childList;

    public static Node listFlatten() {
        if (head == null) {
            return null;
        }
        int count = 0;
        Node head_result = childList.peek();
        while (childList.size() != 0) {
            // System.out.println("Size is " + childList.size());
            Node node = childList.remove();
            // System.out.println(node.data + " is popped");
            if (count != 0) {
                prev.next = node;
            }
            count++;
            // System.out.println(node.data);
            while (node != null) {
                if (node.child != null) {
                    childList.add(node.child);
                }
                prev = node;
                // System.out.print(node.data + "->");
                node = node.next;
                /*
                 * if (node != null) { System.out.println(node.data); }
                 */
            }
        }
        // System.out.println("null");
        return head_result;
    }

    public static void main(String[] args) throws NoSuchElementException {
        head = null;

        // Inserting the nodes given in the list
        Node newNode, newNode1, mainNode, newNode2, newNode3;
        {
            mainNode = new Node(5, null, null, null);
            head = mainNode;
            {
                newNode1 = new Node(6, null, null, null);
                mainNode.child = newNode1;
                newNode = new Node(25, newNode1, null, null);
                newNode1.next = newNode;
                {
                    newNode2 = new Node(8, null, null, null);
                    newNode.child = newNode2;
                }
                newNode1 = new Node(6, newNode, null, null);
                newNode.next = newNode1;
                {
                    newNode2 = new Node(9, null, null, null);
                    newNode1.child = newNode2;
                    {

                        newNode1 = new Node(7, null, null, null);
                        newNode2.child = newNode1;
                    }
                }
            }

            newNode = new Node(33, mainNode, null, null);
            mainNode.next = newNode;
            mainNode = newNode;

            newNode1 = new Node(17, newNode, null, null);
            newNode.next = newNode1;
            mainNode = newNode;

            newNode = new Node(2, newNode1, null, null);
            newNode1.next = newNode;
            mainNode = newNode;
            {
                newNode = new Node(2, null, null, null);
                mainNode.child = newNode;
                {
                    newNode1 = new Node(12, null, null, null);
                    newNode.child = newNode1;
                    {
                        newNode2 = new Node(21, null, null, null);
                        newNode1.child = newNode2;
                        newNode3 = new Node(3, newNode2, null, null);
                        newNode2.next = newNode3;
                    }
                    newNode2 = new Node(5, newNode1, null, null);
                    newNode1.next = newNode2;
                }

                newNode1 = new Node(7, newNode, null, null);
                newNode.next = newNode1;
            }

            newNode1 = new Node(1, mainNode, null, null);
            mainNode.next = newNode1;
            mainNode = newNode1;
        }

        prev = null;
        childList = new LinkedList<Node>();
        childList.add(head);
        head = listFlatten();
        traverse();

    }

}