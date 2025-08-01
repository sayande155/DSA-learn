package recursion;

public class ReverseArray {
    public static int[] revArr(int[] arr, int i, int j){
        if(i >= j ) return arr;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return revArr(arr, i+1, j-1);
    }

    public static void main(String args[]) {
        int arr[] = { 10, 20, 30, 40, 50, 60 };
        int i = 0;
        int j = arr.length - 1;
        // revArr(arr, i, j);
        for (int a : revArr(arr, i, j)) {
            System.out.print(a + " ");
        }
    }

}
