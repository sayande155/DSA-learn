package recursion;

import java.util.Scanner;

public class Factorial {
    public static int fact(int n) {
        if (n == 0 || n == 1)   // Base Condition
            return 1;
        return n * fact(n - 1); // Recursive call
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        int fact = fact(n);
        System.out.println("Factorial of " + n + " : " + fact);
        sc.close();
    }
}
