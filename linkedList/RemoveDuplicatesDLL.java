package linkedList;

import java.io.*;

class Node {
    int val;
    Node prev;
    Node next;

    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class RemoveDuplicatesDLL {
    public static Node arr2DLL(int arr[]) {
        int len = arr.length;
        if (len == 0)
            return null;
        Node curr = new Node(arr[0]);
        Node head = curr;
        Node prev = null;
        for (int i = 1; i < len; i++) {
            curr.prev = prev;
            curr.next = new Node(arr[i]);
            prev = curr;
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

    public static Node removeDuplicated(Node head) {
        if (head == null || head.next == null)
            return head;

        Node i = head;
        Node j = head.next;
        while (j != null) {
            if (i.val != j.val) {
                i.next = j;
                j.prev = i;
                i = j;
            }
            j = j.next;
        }
        i.next = null;
        return head;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split("\\s+");
        int len = str.length;
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Node head = arr2DLL(arr);
        display(head);
        display(removeDuplicated(head));
    }
}
