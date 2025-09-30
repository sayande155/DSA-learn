package stackAndQueue;

class Stack {
    private int top = -1;
    private int size = 10;
    private int st[] = new int[size];

    public void push(int ele) {
        if (top >= size-1) {
            System.out.println("Overflow");
            return;
        }
        top++;
        st[top] = ele;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Underflow");
            return -1;
        }
        int temp = st[top];
        top--;
        return temp;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return st[top];
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(st[i] + " ");
        }
        System.out.println();
    }
}

public class StackArray {
    public static void main(String args[]) {
        Stack st = new Stack();
        st.display();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(70);
        st.push(80);
        st.push(90);
        st.push(100);
        st.push(110);
        st.display();
        System.out.println(st.size());        
        System.out.println(st.peek());     
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();   
        st.pop();  
        st.display(); 
    }
}
