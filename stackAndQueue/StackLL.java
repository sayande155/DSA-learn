package stackAndQueue;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
}

class Stack{
    Node top = null;

    public void push(int val){
        Node newNode = new Node(val);
        if(top == null){
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    public int pop(){
        if(top == null){
            System.out.println("Stack Underflow");
            return -1;
        }
        int temp = top.val;
        top = top.next;
        return temp;
    }

    public int peek(){
        if(top == null){
            System.out.println("Stack Underflow");
            return -1;
        }
        return top.val;
    }

    public void display(){
        if(top == null){
            System.out.println("Stack is Empty");
            return;
        }
        Node temp = top;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class StackLL {
    public static void main(String args[]){
        Stack st = new Stack();
        st.display();
        
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        st.display();
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        st.display();
    }
}
