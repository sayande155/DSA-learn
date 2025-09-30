package linkedList;

import java.io.*;

class Node {
    int val;
    Node prev;
    Node next;

    Node(int val) {
        this.prev = null;
        this.val = val;
        this.next = null;
    }
}

public class RemoveAllOccDLL {
    public static Node arr2DLL(int arr[]) {
        int len = arr.length;
        if (len == 0)
            return null;
        Node curr = new Node(arr[0]);
        Node head = curr;
        Node prev = null;
        for (int i = 1; i < len; i++) {
            curr.next = new Node(arr[i]);
            curr.prev = prev;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static Node removeAllOcc(Node head, int target) {
        if (head == null)
            return null;
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            System.out.println(curr.val);
            if (curr.val == target && prev == null) {
                curr = curr.next;
                if(curr != null){
                    curr.prev = prev;
                }
                head = curr;
            } else if (curr.val == target && prev != null) {
                prev.next = curr.next;
                curr = curr.next;
                if (curr != null) {
                    curr.prev = prev;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split("\\s+");
        int arr[] = new int[str.length];
        for (int i = 0; i < str.length; i++)
            arr[i] = Integer.parseInt(str[i]);
        int target = Integer.parseInt(br.readLine().trim());
        br.close();
        Node head = arr2DLL(arr);
        head = removeAllOcc(head, target);
        display(head);
    }
}
