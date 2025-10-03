package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InPostPre {

    public static int getPriority(char i) {
        switch (i) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String inToPost(String input) {
        Stack<Character> st = new Stack<>();
        String res = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' || input.charAt(i) >= 'a' && input.charAt(i) <= 'z'
                    || input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                res += input.charAt(i);
            } else if (input.charAt(i) == ')') {
                while (st.empty() == false && st.peek() != '(') {
                    res = res + st.pop();
                }
                st.pop(); // to remove the opening bracket
            } else if (input.charAt(i) == '(') {
                st.push(input.charAt(i));
            } else {
                // ^ => right associativity => <
                // others => <=
                while (!st.isEmpty() &&
                        ((getPriority(input.charAt(i)) < getPriority(st.peek()))
                                ||
                                (getPriority(input.charAt(i)) == getPriority(st.peek()) && input.charAt(i) != '^'))) {
                    res += st.pop();
                }
                st.push(input.charAt(i));
            }

            System.out.println(st + " " + res);
        }
        while (st.isEmpty() == false) {
            res = res + st.pop();
        }
        return res;
    }

    public static String revStr(String input) {
        char str[] = input.toCharArray();
        int i = 0;
        int j = str.length - 1;
        while (i <= j) {
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
        return new String(str);
    }

    public static String inToPre(String input) {

        StringBuilder sb = new StringBuilder(revStr(input));
        System.out.println(sb);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }
        System.out.println(sb);

        Stack<Character> st = new Stack<>();
        String res = "";
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z' || sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z'
                    || sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                res += sb.charAt(i);
            } else if (sb.charAt(i) == '(') {
                st.push(sb.charAt(i));
            } else if (sb.charAt(i) == ')') {
                while (st.empty() == false && st.peek() != '(') {
                    res += st.pop();
                }
                st.pop();
            } else {
                // ^ => right associativity => <=
                // others => strictly <
                while (!st.isEmpty() && ((sb.charAt(i) != '^' && getPriority(sb.charAt(i)) < getPriority(st.peek()))
                        || (sb.charAt(i) == '^' && getPriority(sb.charAt(i)) <= getPriority(st.peek())))) {
                    res += st.pop();
                }
                st.push(sb.charAt(i));
            }
            System.out.println(st + " " + res);
        }
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return revStr(res);
    }

    public static String postToIn(String input) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' || input.charAt(i) >= 'a' && input.charAt(i) <= 'z'
                    || input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                st.push(input.charAt(i) + "");
            } else {
                String op2 = st.pop();
                String op1 = st.pop();
                st.push('(' + op1 + input.charAt(i) + op2 + ')');
            }
            System.out.println((st));
        }
        return st.pop();
    }

    public static String preToIn(String input) {
        Stack<String> st = new Stack<>();
        input = revStr(input);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' || input.charAt(i) >= 'a' && input.charAt(i) <= 'z'
                    || input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                st.push(input.charAt(i) + "");
            } else {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push('(' + op1 + input.charAt(i) + op2 + ')');
            }
            System.out.println((st));
        }
        return st.pop();
    }

    public static String preToPost(String input) {
        Stack<String> st = new Stack<>();
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' || input.charAt(i) >= 'a' && input.charAt(i) <= 'z'
                    || input.charAt(i) >= '0' && input.charAt(i) <= 9) {
                st.push(input.charAt(i) + "");
            } else {
                st.push(st.pop() + st.pop() + input.charAt(i));
            }
            System.out.println(st);
        }
        return st.pop();
    }

    public static String postToPre(String input){
        Stack<String> st = new Stack<>();
        for(int i = 0 ; i < input.length(); i++){
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' || input.charAt(i) >= 'a' && input.charAt(i) <= 'z'
                    || input.charAt(i) >= '0' && input.charAt(i) <= 9) {
                st.push(input.charAt(i) + "");
            } else {
                String op2 = st.pop();
                String op1 = st.pop();
                st.push(input.charAt(i) + op1 + op2);
            }
            System.out.println(st);
        }
        return st.pop();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        // System.out.println(inToPost(input));
        // System.out.println(inToPre(input));
        // System.out.println(postToIn(input));
        // System.out.println(preToIn(input));
        // System.out.println(preToPost(input));
        System.out.println(postToPre(input));

    }
}
