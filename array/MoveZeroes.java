package array;

import java.util.Scanner;

/*
 * 
 * 1 2 3 0 0 0 2 0 5
 * 
 * brute : store non zero elements in new array and them copying from there
 * optimal : 2 pointer approach ( find first zero pos to j then swapping loop)
 * 
 * 
 */
public class MoveZeroes {

    public static void moveZeroesToEnd(int[] nums) {
        int len = nums.length;

        // finding the position of first zero
        int j = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // if no zeroes are present
        if (j == -1)
            return;

        // moving zeroes to the end
        for (int i = j + 1; i < len; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.print("\nOriginal Array : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        moveZeroesToEnd(arr);
        System.out.print("\nModified Array : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
