package stackAndQueue;

import java.util.Stack;

class Queue1 {
    private Stack<Integer> q1 = new Stack<>();
    private Stack<Integer> q2 = new Stack<>();

    public void enQueue(int val) {
        while (q1.size() > 0) {
            q2.push(q1.pop());
        }
        q1.push(val);
        while (q2.size() > 0) {
            q1.push(q2.pop());
        }
    }

    public int deQueue() {
        if (q1.empty()) {
            return -1;
        }
        return q1.pop();
    }

    public int peek() {
        if (q1.empty()) {
            return -1;
        }
        return q1.peek();
    }

    public void display() {
        System.out.println(q1);
    }
}

class Queue2 {
    private Stack<Integer> q1 = new Stack<>();
    private Stack<Integer> q2 = new Stack<>();

    // 6
    // 5 4 3 2 1
    public void enQueue(int val){
        q1.push(val);
    }

    public int peek(){
        if(q1.size() == 0 && q2.size() == 0){
            return -1;
        }

        while(q2.size() > 0){
            return q2.peek();
        }

        while(q1.size() > 0){
            q2.push(q1.pop());
        }
        return q2.peek();
    }

    public int deQueue(){
        if(q1.size() == 0 && q2.size() == 0){
            return -1;
        }
        
        while(q2.size() > 0){
            return q2.pop();
        }

        while(q1.size() > 0){
            q2.push(q1.pop());
        }
        return q2.pop();
    }

    public void display(){
        if(q1.size() == 0 && q2.size() == 0){
            System.out.println("Queue is Empty");
        }
        System.out.println(q2 + " " + q1);
    }
}

public class QueueUsingStack {
    public static void main(String args[]) {
        Queue1 q1 = new Queue1();
        q1.display();

        q1.enQueue(5);
        q1.enQueue(9);
        q1.enQueue(7);
        q1.enQueue(8);
        q1.enQueue(2);
        
        q1.display();
        System.out.println(q1.peek());
        q1.deQueue();
        q1.enQueue(6);
        q1.display();
        q1.deQueue();
        q1.display();

        System.out.println();
        Queue2 q2 = new Queue2();
        q2.display();

        q2.enQueue(5);
        q2.enQueue(9);
        q2.enQueue(7);
        q2.enQueue(8);
        q2.enQueue(2);
        
        q2.display();
        System.out.println(q2.peek());
        q2.deQueue();
        q2.enQueue(6);
        q2.display();
        q2.deQueue();
        q2.display();

    }
}
