package array;

/*
 * Problem : Best Time to Buy and Sell Stock so that profit can me maximum
 * Condition :  Buy before sell and only one transaction
 * Algo : 
 * mini = arr[0] -> set first element as min value
 * maxProfit - 0 -> set max profit as 0 as of we need not do any transaction if profit is -1
 * for i : 0 -> n-1
 *  calculate profit : mini - arr[i]
 *  set maxProfit
 *  set mini
 * return maxProfit
 * dry run : 
 * 7 6 4 3 1
 * initial mini = 7 maxProfit = 0
 *  i = 0 profit = 0 maxProfit = 0 mini = 7
 *  i = 1 profit = -1 maxprofit = 0 mini = 6
 *  i = 2 profit = -2 maxprofit = 0 mini = 4
 *  i = 3 profit = -1 maxprofit = 0 mini = 3
 *  i = 4 profit = 2 maxprofit = 2 mini = 1
 * return o
 * 
 */
public class Stocks {

    public static int bestTimeToBuyStock(int nums[]){
        int len = nums.length;
        int mini = nums[0];
        int maxProfit = 0;
        for(int i = 0 ; i < len; i++){
            int profit = nums[i] - mini;
            maxProfit = Math.max(maxProfit, profit);
            mini = Math.min(mini, nums[i]);
        }
        return maxProfit;
    }
    public static void main(String args[]){
        int nums[] = {7,6,4,3,1};
        System.out.println("Max profit = " + bestTimeToBuyStock(nums));
    }
    
}
