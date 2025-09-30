package bitmp;

import java.util.Scanner;

public class SwapTwoNumbers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println(a + " " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + " " + b);

        // a = 1 b = 2 01 10
        // a^b = 11 a = 11
        // b = a^b 11 10
        // b = 01
        // a = a ^ b 11 01
        // a = 10
    }
}
