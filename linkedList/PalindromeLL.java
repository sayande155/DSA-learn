package linkedList;

import java.io.*;
import java.util.Stack;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PalindromeLL {
    public static Node arr2LL(int arr[]) {
        int len = arr.length;
        if (len == 0)
            return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < len; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static boolean checkPalindrome(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        int len = cnt / 2;
        // 1 2 3 3 2 1
        if (cnt % 2 == 0) {
            temp = head;
            Stack<Integer> stk = new Stack<>();
            for (int i = 1; i <= len; i++) {
                stk.push(temp.val);
                temp = temp.next;
            }
            for (int i = 1; i <= len; i++) {
                if (temp.val != stk.pop()) {
                    return false;
                }
                temp = temp.next;
            }
        }
        // 1 2 3 2 1
        else{
            temp = head;
            Stack<Integer> stk = new Stack<>();
            for (int i = 1; i <= len; i++) {
                stk.push(temp.val);
                temp = temp.next;
            }
            temp = temp.next;
            for (int i = 1; i <= len; i++) {
                if (temp.val != stk.pop()) {
                    return false;
                }
                temp = temp.next;
            }
        }
        return true;
    }

    public static boolean checkPalindrome2(Node head){
        int cnt = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            cnt++;
        }
        int len = cnt / 2;
        if(cnt % 2 != 0){
            len += 1;   
        }
        temp = head;
        for(int i = 1; i <= len; i++){
            temp = temp.next;
        }
        Node curr = temp;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        temp = prev;
        while(temp != null){
            if(head.val != temp.val){
                return false;
            }
            temp = temp.next;
            head = head.next;
        }
        return true;
    }

    public static void display(Node head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static boolean checkPalindrome3(Node head){
        Node temp = head;
        Node curr = temp;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        display(head);
        display(prev);
        while(head != null){
            if(head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        br.close();
        String tempArr[] = temp.trim().split("\\s");
        int arr[] = new int[tempArr.length];
        for (int i = 0; i < tempArr.length; i++) {
            arr[i] = Integer.parseInt(tempArr[i]);
        }
        Node head = arr2LL(arr);
        System.out.println(checkPalindrome3(head));
    }
}