package array;

import java.util.ArrayList;
import java.util.Scanner;

public class IsSorted {
    public static boolean isSorted(ArrayList<Integer> arr) {
        int size = arr.size();
        for (int i = 0; i < size - 1; i++) {
            if (arr.get(i + 1) < arr.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i <n; i++){
            arr.add(sc.nextInt());
        }
        sc.close();

        System.out.println("Array is sorted ? -> " + isSorted(arr));
    }
}
