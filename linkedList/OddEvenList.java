package linkedList;

import java.io.*;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
} 

public class OddEvenList {
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

    public static Node oddEvenSeparate(Node head){
        if(head == null || head.next == null)
            return head;
        
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        // while(odd.next != null && even.next != null){
        //     odd.next = odd.next.next;
        //     even.next = even.next.next;
        //     if(odd.next == null) break;
        //     odd = odd.next;
        //     if(even.next == null) break;
        //     even = even.next;
        // }
        // if(odd.next != null){
        //     odd.next = odd.next.next;
        //     odd = odd.next;
        // }
        // if(even.next != null){
        //     even.next = even.next.next;
        //     even = even.next;
        // }
        // Node temp = head;
        // while(temp.next != null){
        //     temp = temp.next;
        // }
        // temp.next = evenHead;

        // More optimized

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        
        return head;
    }
    public static void display(Node head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().trim().split(" ");
        br.close();
        int arr[] = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        Node head = arr2LL(arr);
        head = oddEvenSeparate(head);
        display(head);
    }
}