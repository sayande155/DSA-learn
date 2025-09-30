package bitmp;

import java.util.Scanner;

public class SetOrNot {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        n = n >> (k);
        if((n & 1) == 1)    System.out.println(true);
        else System.out.println("false");

    }
}
