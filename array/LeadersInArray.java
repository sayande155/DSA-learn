package array;

import java.util.ArrayList;

/*
 * 
 * 10 22 12 3 0 6
 * maxi = 6
 */
public class LeadersInArray {

    // public static int[] findLeadersInArray(int arr[]){
    //     int n = arr.length;
    //     int maxi = Integer.MIN_VALUE;
    //     int res[] = new int[n];
    //     int pos = 0;
    //     for(int i = n - 1; i >= 0; i--){
    //         if(arr[i] > maxi){
    //             maxi = arr[i];
    //             res[pos++] = maxi;
    //         }
    //     }
    //     return Arrays.copyOf(res, pos);
    // }
    public static ArrayList<Integer> findLeadersInArray(int arr[]){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] > maxi){
                maxi = arr[i];
                res.add(0, maxi);
            }
        }
        return res;
    }

    public static void main(String args[]){
        int arr[] = {10, 22, 12, 3, 0, 6};
        // int res[] = findLeadersInArray(arr);
        // for(int i : res){
        //     System.out.print(i + " ");
        // }
        System.out.println(findLeadersInArray(arr));
    }
    
}
