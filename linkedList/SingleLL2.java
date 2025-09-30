package linkedList;

import java.io.*;
import java.util.*;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}
public class SingleLL2 {

    public static Node arr2SLL(int arr[]){
        int len = arr.length;
        if(arr.length == 0){
            System.out.println("Array is empty!!");
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1; i < len; i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void displayLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node reverseSLL(Node head){
        Node curr = head;
        Node prev = null;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev; 
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node reverseLLRecursive(Node head){
        if(head == null){
            return head;
        }

        if(head.next == null){
            return head;
        }
        Node newHead = reverseLLRecursive(head.next);        
        Node temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return newHead;
    }

    // 1 2 3 4 5 -> 5 4 3 2 1
    // 2 3 4 5 -> 5 4 3 2
    // 3 4 5 -> 5 4 3
    // 4 5 -> 5 4
    // 5 -> 5

    public static void main(String args[]) throws IOException {
        // int arr[] = {5,9,7,8,6,3,6};
        int arr[] = {1,2,3,4,5};
        Node head = arr2SLL(arr);
        displayLL(head);
        // head = reverseSLL(head);
        head = reverseLLRecursive(head);
        displayLL(head);
        List<Integer> li = new ArrayList<>();
        li.add(5);
        li.contains(5);
    }
}
