package stackAndQueue;

import java.util.Stack;
import java.io.*;

public class ValidParenthesis {
    public static boolean checkValidParenthesis(String input) {
        Stack<Character> st = new Stack<>();
        char ip[] = input.toCharArray();
        for (int i = 0; i < ip.length; i++) {
            // when array is empty
            if (st.isEmpty()) {
                st.push(ip[i]);
                continue;
            }
            // when opening bracket
            if (ip[i] == '(' || ip[i] == '{' || ip[i] == '[') {
                st.push(ip[i]);
            }
            // for round
            else if (ip[i] == ')' && st.peek() == '(') {
                st.pop();
            }
            // for round
            else if (ip[i] == '}' && st.peek() == '{') {
                st.pop();
            }
            // for round
            else if (ip[i] == ']' && st.peek() == '[') {
                st.pop();
            } else {
                return false;
            }
        }
        System.out.println(st);
        if (st.size() != 0) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        System.out.println(checkValidParenthesis(input));

    }
}
