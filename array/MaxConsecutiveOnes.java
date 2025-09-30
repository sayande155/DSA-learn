package array;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static int maxConsecutiveOnesBrute(int[] nums){
        // maxCount and count variable and O(n)
        int maxCount = 0;
        int cnt = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] == 1){
                cnt += 1;
            }else{
                cnt = 0;
            }
            if(cnt > maxCount){
                maxCount = cnt;
            }
        }
        return maxCount;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("No of Maximum consecutive ones  = " + maxConsecutiveOnesBrute(nums));
    }
}
