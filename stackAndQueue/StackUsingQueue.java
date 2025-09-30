package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

class Stack {
    private Queue<Integer> q = new LinkedList<>();

    public void push(int val) {
        int temp = q.size();
        q.add(val);
        while (temp > 0) {
            q.add(q.peek());
            q.remove();
            temp--;
        }
    }

    public void display() {
        System.out.println(q);
    }

    public int peek() {
        if (q.size() <= 0) {
            return -1;
        }
        return q.peek();
    }

    public int pop() {
        if (q.size() <= 0) {
            return -1;
        }
        int temp = q.peek();
        q.remove();
        return temp;
    }
}

public class StackUsingQueue {
    public static void main(String args[]) {
        Stack st = new Stack();
        st.display();
        st.push(5);
        st.push(7);
        st.push(5);
        st.push(4);
        st.push(9);
        st.display();
        st.peek();
        st.pop();
        st.display();
        st.pop();
        st.peek();
        st.pop();
        st.display();
    }
}
