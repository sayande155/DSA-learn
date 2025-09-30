package bitmp;

import java.util.Scanner;

public class SetUnsetBit {
    public static int setBit(int n, int k) {
        // 1 0 0 1 k = 2
        // 0 1 0 0
        // 1 1 0 1
        return n | (1 << k);
    }

    public static int clearBit(int n, int k) {
        // 1 0 1 1 k = 1
        // ~(0 0 1 0) => 1 1 0 1
        // 1 0 0 1
        return n & ~(1 << k);
    }

    public static int toggleBit(int n, int r, int l) {
        // 50 => 1 1 0 0 1 0
        // l = 2 r = 5 => temp = (( 1 << (r - l + 1)) - 1) << (l - 1)
        // 50 ^ temp

        int temp = (1 << (r - l + 1)) - 1;
        temp = temp << (l - 1);
        return n ^ temp;
    }

    public static int clearRightmostse

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        // System.out.println(setBit(n, k));
        // System.out.println(clearBit(n, k));
        
        // 1 1 0 1 1 0 1
        // 0 1 1 1 1 1 0
        // 1 0 1 0 0 1 1
        // int n = sc.nextInt();
        // int l = sc.nextInt();
        // int r = sc.nextInt();
        // System.out.println(toggleBit(n, r, l));
        sc.close();
    }

}
