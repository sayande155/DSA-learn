package array;

import java.util.Scanner;

public class LinearSearch {

    // return zero based index
    public static int linearSearch(int[] arr, int key) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  <n; i++){
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        sc.close();
        int index = linearSearch(arr, key);
        System.out.println((index != -1) ? index : "not found");
    }
}
