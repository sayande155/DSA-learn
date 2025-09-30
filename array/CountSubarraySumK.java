package array;

import java.util.HashMap;
import java.util.Map;


public class CountSubarraySumK {

    public static int count(int nums[], int k){
        int n = nums.length;
        int cnt = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < n ; i++){
            prefixSum += nums[i];
            int remove = prefixSum - k;
            cnt += map.getOrDefault(remove, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        System.out.println(map);
        return cnt;
    }
    
    public static void main(String args[]){
        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(count(nums, k));
    }
}
