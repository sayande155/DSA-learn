package stackAndQueue;

import java.util.Stack;

public class StackTest {

    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        
        System.out.println(st);
        System.out.println(st.size());
        System.out.println(st.capacity());
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        System.out.println(st);
        System.out.println(st.size());
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st);
        System.out.println(st.size());
        System.out.println(st.capacity());
    }
    
}
