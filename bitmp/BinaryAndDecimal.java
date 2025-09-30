package bitmp;

import java.util.Scanner;

public class BinaryAndDecimal {
    public static int bin2Dec(String bin){
        int dec = 0;
        int len = bin.length();
        for(int i = 0; i < len; i++){
            if(bin.charAt(i) == '1')
                dec += Math.pow(2, (len - i - 1));
        }
        return dec;
    }
    public static String dec2Bin(int dec) {
        StringBuilder res = new StringBuilder();
        while (dec > 1) {
            res = res.append(dec % 2);
            dec /= 2;
        }
        res = res.append(dec);
        res.reverse();
        return res.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter decimal : ");
        // int dec = sc.nextInt();
        // System.out.println("Equivalent binary : " + dec2Bin(dec));

        // String bin = sc.nextLine();
        // System.out.println(bin2Dec(bin));

        System.out.println(Integer.toBinaryString(13));
        sc.close();
    }
}
