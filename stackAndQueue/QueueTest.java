package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();

        System.out.println(q);
        System.out.println(q.size());
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        System.out.println(q);
        System.out.println(q.size());
        q.remove();
        q.remove();
        System.out.println(q);
    }
}
