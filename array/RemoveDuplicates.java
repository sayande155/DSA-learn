package array;

import java.util.Scanner;

/*
 * Remove duplicate elements from a SORTED array and return the no of unique elements
 * input : [1,1,2,2,2,3]
 * processing : [1,2,3,_,_,_] and return 3
 * 
 * Brute : Take a Set and put elements in that as it stores only unique elements then copy to nums
 * Optimal : two pointer technique
 * 
 */
public class RemoveDuplicates {
    public static int removeDuplicatesFromSortedArray(int nums[]) {
        int len = nums.length;
        int k = 0;
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] != nums[i]) {
                k++;
                nums[++i] = nums[j];
            }
        }
        for(int e : nums){
            System.out.print(e + " ");
        }
        return k+1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("No of final elements : " + removeDuplicatesFromSortedArray(nums));
    }
}
