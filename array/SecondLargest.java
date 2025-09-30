package array;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * Brute : 
 *      Sort the array -> then compare the arr[n-2] with arr[n-1] are they same or not then if same do again n-3, n-4 else return that
 * Better :
 *      First Find the max element -> then with comparing with largest find the second largest
 * Optimal :
 *      max1 = arr[0] & max2 = arr[1] -> then compare simultaneously
 * 
 */
public class SecondLargest {
    public static int findSecondLargest(ArrayList<Integer> arr) {
        int size = arr.size();
        int max1 = arr.get(0);
        int max2 = arr.get(1);

        if (max1 < max2) {
            int temp = max1;
            max1 = max2;
            max2 = temp;
        }

        for (int i = 2; i < size; i++) {
            if (arr.get(i) > max1) {
                max2 = max1;
                max1 = arr.get(i);
            } else if (arr.get(i) < max1 && arr.get(i) > max2) {
                max2 = arr.get(i);
            }
        }

        return max2;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println("Second Largest Element is = " + findSecondLargest(arr));
        sc.close();
    }
}
