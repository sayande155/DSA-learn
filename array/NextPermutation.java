package array;


//! Not Done
public class NextPermutation {
    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] reverse(int nums[], int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
        return nums;
    }

    public static int[] findNextPermutation(int nums[]) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return reverse(nums, 0, n);
        }

        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, index, i);
            }
        }

        return reverse(nums, index, index);
    }

    public static void main(String ars[]) {
        int arr[] = { 1, 2, 3 };
        int[] result = findNextPermutation(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
