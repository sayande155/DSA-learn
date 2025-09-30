package linkedList;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class SingleLL {

    // converting array to SLL
    public static Node arrToLL(int arr[]) {
        int len = arr.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new Node(arr[0]);
        }

        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < len; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    // traversal in a SLL
    public static void displayLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // find an element in SLL
    public static boolean searchKey(Node head, int key) {
        while (head != null) {
            if (head.data == key)
                return true;
            head = head.next;
        }
        return false;
    }

    // find length of SLL
    public static int lengthLL(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    // insert at beginning
    public static Node insertBeg(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        return head;
    }

    // insert at end
    public static Node insertEnd(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null)
            return new Node(val);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // insert at position(k)
    public static Node insertPos(Node head, int val, int k){
        Node newNode = new Node(val);
        
        int cnt = 0;

        if(k == 1){
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node temp = head;
        while(temp.next != null){
            cnt++;
            if(cnt == k - 1){
                break;
            }
            temp = temp.next;
        }
        
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }


    // delete from beginning
    public static Node deleteBeg(Node head){
        if(head == null){
            System.out.println("Underflow");
            return null;
        }
        head = head.next;
        return head;
    }

    // delete from end
    public static Node deleteEnd(Node head){
        // for empty list
        if(head == null){
            System.out.println("Underflow");
            return null;
        }
        // for single element
        if(head.next == null){
            return null;
        }
        // rest all cases
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }


    // delete from any pos
    public static Node deletePos(Node head, int k){
        if(head == null){
            System.out.println("Underflow");
            return null;
        }

        if(head.next == null){
            return null;
        }

        if(k == 1){
            head = head.next;
            return head;
        }

        Node temp = head;
        int cnt = 0;

        while(temp.next.next != null){
            cnt++;
            if(cnt == k-1){
                break;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
    
    public static void main(String args[]) {
        int arr[] = { 5, 10, 3, 6, 9, 7, 8 };

        Node head = arrToLL(arr);
        displayLL(head);

        head = deletePos(head,9);
        displayLL(head);

        // head = deleteBeg(head);
        // displayLL(head);

        // head = insertPos(head, 17, 8);
        // displayLL(head);

        // head = insertBeg(head, 6);
        // displayLL(head);

        // head = insertEnd(head, 17);
        // displayLL(head);

        // System.out.println(searchKey(head, 7));

        // System.out.println(lengthLL(head));
    }
}