package array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * Find union of two sorted arrays
 * brute : using set -> copy array 1 elements then copy array 2 elements then copy elements of set in result array and return
 * optimal : inplace -> 2 pointer approach arr1[i] arr2[j] union[k] 
 */
public class FindUnionIntersection {
    public static int[] findUnionBrute(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < len1; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < len2; i++) {
            set.add(arr2[i]);
        }
        // System.out.println(set);
        int[] union = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            union[i++] = it.next();
        }
        return union;
    }

    public static int[] findUnionOptimal(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] temp = new int[len1 + len2];
        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                if (k == 0 || temp[k - 1] != arr1[i]) {
                    temp[k++] = arr1[i];
                }
                i++;
            } else {
                if (k == 0 || temp[k - 1] != arr2[j]) {
                    temp[k++] = arr2[j];
                }
                j++;
            }
        }
        while (i < len1) {
            if (k == 0 || temp[k - 1] != arr1[i]) {
                temp[k++] = arr1[i];
            }
            i++;
        }

        while (j < len2) {
            if (k == 0 || temp[k - 1] != arr2[j]) {
                temp[k++] = arr2[j];
            }
            j++;
        }
        return Arrays.copyOf(temp, k);
    }

    public static int[] findIntesectionBrute(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] intersection = new int[len2];
        int k = 0;
        int[] visited = new int[len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (arr1[i] == arr2[j] && visited[j] == 0) {
                    intersection[k++] = arr1[i];
                    visited[j] = 1;
                }
            }
        }
        return Arrays.copyOf(intersection, k);
    }

    public static void main(String args[]) {
        int[] arr1 = { 1, 1, 2, 2, 3, 5, 6, 8 };
        int[] arr2 = { 1, 2, 2, 3, 4, 5, 6, 7, 8 };

        // int[] union = findUnionBrute(arr1, arr2);
        // int[] union = findUnionOptimal(arr1, arr2);
        int[] intersection = findIntesectionBrute(arr1, arr2);
        for (int i : intersection) {
            System.out.print(i + " ");
        }
    }
}
