package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int asteroids[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }else{
                while(!st.isEmpty() && st.peek() > 0 && Math.abs((double)asteroids[i]) > st.peek()){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() > 0 && Math.abs((double)asteroids[i]) == st.peek()){
                    st.pop();
                }else if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroids[i]);
                }
            }
        }
        System.out.println("final =" + st);
        int len = st.size();
        int res[] = new int[len];
        int i = 0;
        while(!st.isEmpty()){
            res[i++] = st.pop();
        }
        return res;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strArr[] = br.readLine().trim().split("\\s+");
        int arr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        arr = asteroidCollision(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
