package array;

import java.util.Scanner;

/*
 * 
 * Brute -> Linear Searh
 * Better -> Hashing
 * Optimal -> XOR (as all numbers appear twice except one)
 */
public class NumberAppearenceOnce {
    public static int findTheNumberAppearenceOnceOptimal(int nums[]){
        int xor = 0;
        int len = nums.length;
        for(int i = 0;  i < len; i++){
            xor ^= nums[i];
        }
        return xor;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("No of Maximum consecutive ones  = " + findTheNumberAppearenceOnceOptimal(nums));
    }
}
