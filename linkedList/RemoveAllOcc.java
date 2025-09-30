package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveAllOcc {
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
    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node removeAllOcc(Node head, int val){
        if(head == null) return null;
        Node curr = head;
        Node prev = null;
        while(curr != null){
            if(curr.val == val && prev != null){
                prev.next = curr.next;
                curr = curr.next;
            }else if(curr.val == val && prev == null){
                curr = curr.next;
                head = head.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().trim().split("\\s+");
        int n = temp.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        int val = Integer.parseInt(br.readLine().trim());
        br.close();
        Node head = arr2LL(arr);
        head = removeAllOcc(head, val);
        display(head);
    }
}
