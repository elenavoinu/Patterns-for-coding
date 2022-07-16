import java.util.HashMap;

public class LongestSubStringWithDistinctCharacters {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("aabccbb")); // 3
        System.out.println("Length of the longest substring: " + findLength("abbbb")); // 2
        System.out.println("Length of the longest substring: " + findLength("abccde")); // 3
    }
    public static int findLength(String str) {
        int maxLength = 0;
        //start window
        int left = 0;
        //end window
        int right = 0;
        //HashMap to store the frequencies of the characters found in the string
        HashMap<Character, Integer> hm = new HashMap<>();

        //iterate over our string
        while(right < str.length()) {
            if(!hm.containsKey(str.charAt(right))) {
                hm.put(str.charAt(right), 1);
                right++;
            }
            else {
                hm.remove(str.charAt(left));
                left++;
            }
            maxLength = Math.max( maxLength, right - left);
        }

        return maxLength;
    }
}
//O(N) runtime
//O(K) Space complexity where k is the number of distinct characters