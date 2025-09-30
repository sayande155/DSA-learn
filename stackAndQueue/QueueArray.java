package stackAndQueue;

class Queue {
    private int head = -1;
    private int tail = -1;
    private int size = 5;
    private int q[] = new int[10];

    private boolean isFull() {
        if ((tail + 1) % size == head)
            return true;
        return false;
    }

    public void enQueue(int ele) {
        if (head == -1) {
            head++;
            tail++;
            q[head] = ele;
            return;
        }
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        tail = (tail + 1) % size;
        q[tail] = ele;
    }

    public int peek() {
        if (head == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return q[head];
    }

    public int deQueue() {
        if (head == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }
        if (head == tail) {
            int temp = q[head];
            head = tail = -1;
            return temp;
        }
        int temp = q[head];
        head = (head + 1) % size;
        return temp;
    }

    public void display() {
        if (head == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        if (head <= tail) {
            for (int i = head; i <= tail; i++) {
                System.out.print(q[i] + " ");
            }
            System.out.println();
            return;
        }
        int i = head;
        while (i < size) {
            System.out.print(q[i++] + " ");
        }
        i = tail;
        while (i < head) {
            System.out.print(q[i++] + " ");
        }
        System.out.println();
    }
}

public class QueueArray {
    public static void main(String args[]) {
        Queue q = new Queue();
        System.out.println(q.deQueue());
        q.display();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        q.display();
        q.deQueue();
        q.display();
        q.enQueue(6);
        q.display();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.display();
        q.enQueue(7);
        q.enQueue(8);
        q.enQueue(9);
        q.enQueue(10);
        q.display();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.display();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        q.display();
    }
}
