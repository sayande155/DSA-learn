package stackAndQueue;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Queue {
    private Node head = null;
    private Node tail = null;

    public void enQueue(int ele) {
        Node newNode = new Node(ele);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public int deQueue() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return -1;
        }

        if (head == tail) {
            int temp = head.val;
            head = tail = null;
            return temp;
        }

        int temp = head.val;
        head = head.next;
        return temp;
    }

    public int peek() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return head.val;
    }

    public void display() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class QueueLL {
    public static void main(String args[]) {
        Queue q = new Queue();
        System.out.println(q.deQueue());
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(6);
        q.enQueue(7);
        q.enQueue(8);
        q.display();
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        q.display();

    }
}
