package linkedList;

import java.io.*;

public class DeleteMiddleNode {
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

    public static Node findMiddle(Node head) {
        // 1 2 3 4 5
        // 1 2 3 4 5 6

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static int getLL(Node head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }

    public static Node deleteMiddleNode(Node head) {
        if (head == null || head.next == null)
            return head;
        int len = getLL(head);
        len = len / 2 - 1;
        Node temp = head;
        while (len > 0) {
            temp = temp.next;
            len--;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static Node deleteMiddleNodeOptimized(Node head) {
        if(head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
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
        // System.out.println(findMiddle(head).val);
        display(deleteMiddleNodeOptimized(head));
    }
}
