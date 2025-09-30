package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 1 2 3 1 1 1 2 3
 * 
 * 1 -> 0
 * 3 -> 1
 * 6 -> 2
 * 7 -> 3
 * 8 -> 4
 * 9 -> 5 (need = 6 which is already present) -> check
 * 11 -> 6
 * 12 -> 7 (need = 9 which is already present) -> check
 * 
 * Brute : Calculating sum of all subarrays
 * 
 */
public class LongestSubarraySumK {

    // this is optimal approach if + - 0  all exist in array & this is better approach if only + and 0 exist in array
    public static int longestSubarraySumK1(int[] arr, int k) {
        int len = arr.length;
        // To store the sum of elements from index 0 to i
        Map<Integer, Integer> preSubSum = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            // calculating sum 
            sum += arr[i];
            // checking if sum == k
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            // checking if sum - k exists in map
            int temp = sum - k;
            // if true : setting maxLen
            if (preSubSum.containsKey(temp)) {
                maxLen = Math.max(maxLen, i - preSubSum.get(temp));
            }
            // if sum does not exist in map : add sum to map
            if (preSubSum.containsKey(sum) == false) {
                preSubSum.put(sum, i);
            }
        }
        return maxLen;
        
        // System.out.println(preSubSum.keySet());
        // System.out.println(preSubSum.values());
    }

    // optimal for array containing only + & 0
    public static int longestSubarraySumK2(int[] arr, int k) {
        int len = arr.length;
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < len){
            sum += arr[right];
            if(sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            while(sum > k && left <= right){
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return maxLen;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        System.out.println("Longest Subarray length having sum " + k + " is  = " + longestSubarraySumK2(arr, k));
    }

}
