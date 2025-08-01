package hashing;

public class CharHashing {
    public static void countFreqChar(String str, int hash[]){
        int len = str.length();
        for(int i = 0; i < len; i++){
            hash[str.charAt(i) - 'a'] += 1;
        }
        return;
    }
    public static void main(String args[]){
        String str = "baidyabati" ;
        
        // Precomputation for Hashing
        int[] hash = new int[26];
        countFreqChar(str, hash);
        for(int i : hash)
            System.out.print(i + " ");
    }
}
