package array;

import java.util.Scanner;

/*
 * 
 * 0 1 3 (missing 2)
 * n = 3
 * # elements = 4
 */
public class MissingNumber {

    public static int findMissingNumberBrute(int[] nums) {
        // simple linear search of 1 to n
        int n = nums.length;
        for (int i = 0; i < n + 1; i++) {
            int flag = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }

    public static long findMissingNumberOptimal1(int[] nums){
        // sum method -> not suggested as sum can be overflowed if int
        int n = nums.length;
        long sum = n * (n + 1) / 2;
        long temp = 0;
        for(int i = 0; i < n; i++){
            temp += nums[i];
        }
        return sum - temp;

    }

    public static long findMissingNumberOptimal2(int[] nums){
        // xor method
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i = 0 ; i < n ; i++){
            xor1 ^= i;
            xor2 ^= nums[i];
        }
        xor1 ^= n;
        return xor1 ^ xor2;
    }

    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        // System.out.println("Missing element = " + findMissingNumberBrute(nums));
        // System.out.println("Missing element = " + findMissingNumberOptimal1(nums));
        System.out.println("Missing element = " + findMissingNumberOptimal2(nums));
    }
}
