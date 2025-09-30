package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddOne {
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
    public static Node addOne(Node head) {
        int num = 0;
        Node temp = head;
        while (temp != null) {
            num = num * 10 + temp.val;
            temp = temp.next;
        }
        num += 1;
        String str = new String(String.valueOf(num));
        temp = new Node((int) str.charAt(0) - 48);
        head = temp;
        for(int i = 1; i < str.length(); i++){
            temp.next = new Node((int) str.charAt(i)  - 48);
            temp = temp.next;
        }
        return head;
    }
    public static Node addOne2(Node head) {
        int num = 0;
        Node temp = head;
        while (temp != null) {
            num = num * 10 + temp.val;
            temp = temp.next;
        }
        num += 1;
        System.out.println(num);
        Node prev = null;
        while(num != 0){
            temp = new Node(num % 10);
            temp.next = prev;
            prev = temp;
            temp = temp.next;
            num = num / 10;
        }
        return prev;
    }
    public static Node addOne3(Node head) {
        int sum = 0;
        // int carry = 0;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        sum = temp.val + 1;
        if(sum < 10){
            temp.val = sum;
            return head;
        }
        return head;
    }

    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().trim().split("\\s+");
        int n = temp.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        br.close();
        Node head = arr2LL(arr);
        head = addOne3(head);
        display(head);
    }
}
