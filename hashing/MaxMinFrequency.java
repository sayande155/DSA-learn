package hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxMinFrequency {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 6, 8, 7, 9, 3, 4, 5, 9, 6, 1, 4, 7, 5, 2, 3, 6, 9, 5, 4, 2, 3, 6, 6, 4, 7, 8, 5, 2 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }

        System.out.println(map);
        List<Integer> li = new ArrayList<>(map.values());
        Collections.sort(li);
        int minFreq = li.get(0);
        int maxFreq = li.get(li.size() - 1);

        // Find corresponding keys
        int minKey = -1, maxKey = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == minFreq) {
                minKey = entry.getKey();
            }
            if (entry.getValue() == maxFreq) {
                maxKey = entry.getKey();
            }
        }

        System.out.println("Min Frequency Value: " + minFreq + ", Key: " + minKey);
        System.out.println("Max Frequency Value: " + maxFreq + ", Key: " + maxKey);
        
    }

}
