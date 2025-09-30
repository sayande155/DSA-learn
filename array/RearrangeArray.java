package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Rearrange given array into positive-negative order 
 * 
 * Type 1 : Equal number of positive and negative (LeetCode)
 * Brute : take 2 array pos and neg put elements into that then again put that in result array in order
 * Optimal : pos & neg to pointer --> as we know positive will be at even index and negative will be at odd index
 * 
 * Type 2 : Not equal number (GFG)
 * 
 * 
 */
public class RearrangeArray {
    public static int[] rearrangeArray1(int nums[]) {
        int n = nums.length;
        int res[] = new int[n];
        int pos = 0;
        int neg = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res[pos] = nums[i];
                pos += 2;
            } else {
                res[neg] = nums[i];
                neg += 2;
            }
        }
        return res;
    }

    public static int[] rearrangeArray2(int arr[]) {
        int n = arr.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int res[] = new int[n];
        int i = 0;
        for (i = 0; i < n; i++) {
            if (arr[i] >= 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        System.out.println(pos);
        System.out.println(neg);
        if (pos.size() > neg.size()) {
            for (i = 0; i < neg.size(); i++) {
                res[2 * i] = pos.get(i);
                res[2 * i + 1] = neg.get(i);
            }
            int ptr = 2 * neg.size();
            for (i = neg.size(); i < pos.size(); i++) {
                res[ptr++] = pos.get(i);
            }
        } else {
            for (i = 0; i < pos.size(); i++) {
                res[2 * i] = pos.get(i);
                res[2 * i + 1] = neg.get(i);
            }
            int ptr = 2 * i;
            for (i = pos.size(); i < neg.size(); i++) {
                res[ptr++] = neg.get(i);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        // int res[] = rearrangeArray1(arr);
        int res[] = rearrangeArray2(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

}
