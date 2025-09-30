package array;

import java.util.HashSet;

/*
 * 
 * Brute : Linear Serch for each element
 * Better : Sort & then search
 */
public class LongestConsecutiveSequence {

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = 0;
        int j = high;
        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] >= pivot && j > low) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int findLongestConsecutiveSequence(int arr[]) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        int lastMin = Integer.MIN_VALUE;
        int maxLen = 0;
        int len = 0;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] - lastMin == 1) {
                len += 1;
            } else if (arr[i] == lastMin) { // handling equal element case
                continue;
            } else {
                len = 1;
            }
            lastMin = arr[i];
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }

    public static int findLongestConsecutiveSequenceOptimal(int arr[]) {
        int n = arr.length;
        int maxLen = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for(int i : set){
            if(!set.contains(i - 1)){
                int cnt = 1;
                int x = i;
                while(set.contains(x + 1)){
                    cnt++;
                    x++;
                }
                maxLen = Math.max(maxLen, cnt);
            }
        }
        return maxLen;
    }

    public static void main(String args[]) {
        int arr[] = { 53, 57, 77, 15, 78, 58, 17, 63, 90, 73, 68, 82, 40, 68, 22, 52, 81, 92, 80, 37, 62, 17, 76, 67,
                55, 56, 20, 22, 37, 71, 65, 7, 30, 93, 1, 1, 90, 46, 36, 74, 0, 37, 76, 69, 39, 97, 39, 30, 14, 89, 74,
                71, 27, 79, 51, 45, 51, 54, 90, 35, 68, 38, 7, 82, 55, 65, 14, 40, 20, 64, 89, 95, 8, 43, 14, 88, 5, 24,
                72, 9, 56, 17, 60, 91, 16, 94, 47, 15, 33 };
        System.out.println("\n" + findLongestConsecutiveSequenceOptimal(arr));
    }

}
