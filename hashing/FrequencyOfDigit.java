package hashing;

import java.util.ArrayList;
import java.util.Collections;

public class FrequencyOfDigit {

    public static void countFreq(ArrayList<Integer> arr, ArrayList<Integer> hash) {
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            int val  = arr.get(i);
            hash.set(val, hash.get(val) + 1);
        }
        return;
    }

    public static void main(String args[]) {

        // Given Array to find frequency of given digits -> 1,2,4,10,12
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(10);
        arr.add(2);
        arr.add(4);
        arr.add(2);
        arr.add(2);
        arr.add(1);
        arr.add(4);
        arr.add(10);
        arr.add(4);
        arr.add(12);
        arr.add(2);
        arr.add(12);

        int size = 12 + 1;
        ArrayList<Integer> hash = new ArrayList<>(Collections.nCopies(size, 0));
        countFreq(arr, hash);
        System.out.println(hash);

    }

}


// Implementing Hashing using array approach is limited upto 10^9 as array index cannot be more than 2^31-1
// In case of large numbers, we can use HashMap in Java which can handle large numbers and can store key-value pairs
