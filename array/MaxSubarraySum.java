package array;

import java.util.Scanner;
/*
 * Brute : find sum of all possible sub array O(n^3)
 * Better : find sum of all possible sub array O(n^2)
 * Optimal : Kadane's Algo 
 * -> set maxSum = Integer.MIN_VALUE, sum = 0
 * -> for i : 0 -> n-1
 * ->   add the element to sum
 * ->   check if sum is greater than maxSum -> if yes update maxSum
 * ->   check if sum is neg or not -> if yes set sum = 0
 * -> return maxSum
 */
public class MaxSubarraySum {

    public static int maxSubarraySum(int nums[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    // if index also needed 
    public static int[] maxSubarraySumIndex(int nums[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int len = nums.length;
        int res[] = new int[3];
        for (int i = 0; i < len; i++) {
            if(sum == 0)
                res[1] = i;
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
                res[2] = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        res[0] = maxSum;
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(maxSubarraySum(nums));
        int res[] = maxSubarraySumIndex(nums);
        for(int i : res)
            System.out.print(i + " ");
    }
}
