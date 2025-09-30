package array;

import java.util.HashMap;
import java.util.Map;

/*
 * Brute : iterate over array and count each -> O(n)
 * Better : Hashing
 * Optimal :  Moore's Voting Algorithm
 * Dry run ----->
 * 2 2 1 3 2 2 1
 * ele = 2 nums[i] = 2 cnt = 1
 * ele = 2 nums[i] = 2 cnt = 2
 * ele = 2 nums[i] = 1 cnt = 1
 * ele = 2 nums[i] = 3 cnt = 0
 * ele = 2 nums[i] = 2 cnt = 1
 * ele = 2 nums[i] = 2 cnt = 2
 * ele = 2 nums[i] = 1 cnt = 1
 * 
 */
public class MajorityElement {

    public static int findMajorityBetter(int nums[]) {
        int len = nums.length;
        int majority = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i]) == false) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if (map.get(nums[i]) > len / 2) {
                majority = nums[i];
                break;
            }
        }
        return majority;
    }

    public static int findMajorityOptimal(int nums[]) {
        int len = nums.length;
        int cnt = 0;
        int element = -1;
        for (int i = 0; i < len; i++) {
            if (cnt == 0) {
                element = nums[i];
                cnt++;
            } else if (element == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for (int i = 0; i < len; i++) {
            if (element == nums[i]) {
                cnt++;
            }
        }
        if(cnt > len / 2){
            return element;
        }
        return -1;
    }

    public static void main(String args[]) {
        int nums[] = { 5 };
        System.out.println(findMajorityOptimal(nums));
    }
}
