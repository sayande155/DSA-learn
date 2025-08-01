package array;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Brute : i loop + j loop -> searching with each combination
 */

public class TwoSum {

    // pattern 1 -> return only true or false
    public static boolean isTwoSumPresent(int arr[], int target) {
        int len = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int need = target - arr[i];
            if (map.containsKey(need)) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }

    // pattern 2 -> return the pair index
    public static int[] twoSumIndex(int arr[], int target) {
        int len = arr.length;
        int res[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int need = target - arr[i];
            if (map.containsKey(need)) {
                res[0] = map.get(need);
                res[1] = i;
                break;
            }
            map.put(arr[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        System.out.println(isTwoSumPresent(arr, target));
        int res[] = twoSumIndex(arr, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
