package array;

import java.util.ArrayList;
import java.util.Scanner;

public class LeftRotate {
    public static void leftRotateByDBrute(ArrayList<Integer> arr, int d) {
        int size = arr.size();
        d = d % size;
        int[] temp = new int[d];

        // Copying of initial d elements in temp
        for (int i = 0; i < d; i++) {
            temp[i] = arr.get(i);
        }

        // Placing rest of elements to their correct positions
        for (int i = d; i < size; i++) {
            arr.set(i - d, arr.get(i));
        }

        // Copying from temp
        for (int i = 0; i < d; i++) {
            arr.set(i + (size - d), temp[i]);
        }

    }

    public static void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }
    }

    public static void leftRotateByDOptimal(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
        reverse(nums, 0, len - 1);
    }

    public static void rightRotateByDOptimal(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        k = len - k;
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
        reverse(nums, 0, len - 1);
    }

    public static void leftRotateByOne(ArrayList<Integer> arr) {
        int size = arr.size();
        int temp = arr.get(0);
        for (int i = 0; i < size - 1; i++) {
            arr.set(i, arr.get(i + 1));
        }
        arr.set(size - 1, temp);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // ArrayList<Integer> arr = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     arr.add(sc.nextInt());
        // }
        // int d = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        sc.close();
        // System.out.println("Original Array : " + arr);
        // leftRotateByOne(arr);
        // leftRotateByDBrute(arr, d);
        // reverse(arr, 0, n - 1);
        rightRotateByDOptimal(arr, d);
        System.out.println("After d left rotation : " + arr);
        for(int i : arr)
            System.out.print(i + " ");
    }
}
