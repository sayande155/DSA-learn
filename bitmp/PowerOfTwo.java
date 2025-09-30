package bitmp;

import java.util.Scanner;

public class PowerOfTwo {
    // 1 = 1
    // 2 = 10
    // 4 = 100
    // 8 = 1000
    // 6 = 110
    // 10 = 1010

    // 7 = 0111 ; 8 = 1000
    // 0111
    // 1000
    // 0000

    public static boolean powerOfTwo(int n) {
        return (n > 0 && (n & n - 1) == 0);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(powerOfTwo(n));
    }
}
