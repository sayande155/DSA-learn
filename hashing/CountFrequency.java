package hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class CountFrequency {

    public static void main(String args[]) {
        HashMap<Character, Integer> map = new HashMap<>(); // -> Unordered Map -> Fastest
        // TreeMap<Character, Integer> map = new TreeMap<>(); // -> Ordered Map ->Slowest
        // LinkedHashMap<Character, Integer> map = new LinkedHashMap<>(); // -> Ordered Map with insertion order -> Medium(Due to LL overhead)

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Character Stream : ");
        String str = sc.nextLine();

        // converting string to char array
        char[] arr = str.toCharArray();

        // number of required char frequency
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        sc.nextLine();

        // putting the required chars into map
        System.out.println("Enter list of rqeuired elements : ");
        for (int i = 0; i < n; i++) {
            map.put(sc.next().charAt(0), 0);
            sc.nextLine();
        }

        // counting frequency of each char in map
        for (char i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }

        System.out.println(map);

        sc.close();
    }

}
