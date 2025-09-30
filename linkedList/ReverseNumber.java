package linkedList;

public class ReverseNumber {
    public static int revNum(int num){
        int rev = 0;
        int cnt = 0;
        while(num > 0){
            int digit = num % 10;
            if(rev == 0 && cnt > 0 && digit != 0){
                rev = (int) Math.pow(10, cnt) + digit;
                num = num / 10;
                cnt = 0;
                continue;
            }
            if(digit == 0) cnt++;
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev;
    }
    public static void main(String args[]){
        int num = 130;
        System.out.println(revNum(num));
    }
}
