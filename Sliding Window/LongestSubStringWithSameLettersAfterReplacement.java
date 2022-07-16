import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithSameLettersAfterReplacement {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("aabccbb", 2)); // 5
        System.out.println("Length of the longest substring: " + findLength("abbcb", 1)); // 4
        System.out.println("Length of the longest substring: " + findLength("abccde", 1)); // 3
    }
    public static int findLength(String str, int k) {
        int maxLength = 0;
        int right = 0;
        int left = 0;
        int maxRepeatLetterCount = 0;
        //count frequencies of each letter
        Map<Character, Integer> sameChars = new HashMap<>();
        while(right < str.length()) {
            sameChars.put(str.charAt(right),sameChars.getOrDefault(str.charAt(right),0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, sameChars.get(str.charAt(right)));
            right++;

            if(right - left - maxRepeatLetterCount > k) {
                sameChars.put(str.charAt(left), sameChars.get(str.charAt(left))-1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left);

        }
        return maxLength;

    }
}
