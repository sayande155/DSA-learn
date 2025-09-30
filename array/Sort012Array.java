package array;

/*
 * Brute : count nos of 0 1 2 then put that in array
 * Optimal : 
 * DUTCH NATIONAL FLAG ->
 * 0 to low-1 : 0
 * low to mid - 1 : 1
 * mid to high-1 : 0/1/2 --------> unsorted part and rest are sorted
 * high to n-1 : 2
 */
public class Sort012Array{
    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sort(int nums[]){
        int len = nums.length;
        int low = 0;
        int mid = 0;
        int high = len -1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {0,1,2,0,0,1,0,2,0,1,2,1,0,0,0,0};
        sort(arr);
        for(int i : arr){
            System.out.print(i);
        }
    }
}