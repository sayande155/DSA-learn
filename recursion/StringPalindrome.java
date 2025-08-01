package recursion;

public class StringPalindrome {

    public static boolean checkPalindrome(String str, int i, int j) {
        if (i == j) // base condition
            return true;

        if (str.charAt(i) == str.charAt(j)) // recursive call 
            return checkPalindrome(str, i + 1, j - 1);
        else   // false condition 
            return false;
    }

    public static void main(String args[]) {
        String str = "Markrdam";
        str = str.toLowerCase();
        System.out.println(checkPalindrome(str, 0, str.length() - 1));
    }
}
