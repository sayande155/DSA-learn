package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseSLL {
    public static Node arr2LL(int arr[]) {
        int len = arr.length;
        if (len == 0)
            return null;
        Node curr = new Node(arr[0]);
        Node head = curr;
        for (int i = 1; i < len; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
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

    public static Node reverseSLL(Node head){
        if(head == null || head.next == null) return head;

        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split("\\s+");
        int len = str.length;
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Node head = arr2LL(arr);
        display(head);
        display(reverseSLL(head));
    }
}
