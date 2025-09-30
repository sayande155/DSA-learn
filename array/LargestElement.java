package array;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Brute : First Sort -> Then return the element at last index
 * Optimal : Linear Search of max element
 * 
 */
public class LargestElement {
    public static int findLargest(ArrayList<Integer> arr) {
        int max = arr.get(0);
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println("Largest Element is = " + findLargest(arr));

        sc.close();
    }
}