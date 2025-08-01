package recursion;

import java.util.ArrayList;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = 10;
        for (int i = 0; i < n; i++)
            arr.add((fibonacci(i)));
        System.out.println(arr);
    }
}
