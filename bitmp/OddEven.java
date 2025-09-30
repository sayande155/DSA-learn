package bitmp;

import java.io.*;

public class OddEven {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if((n & 1) == 1){
            System.out.println("Odd");
        }else{
            System.out.println("Even");
        }
    }
}
