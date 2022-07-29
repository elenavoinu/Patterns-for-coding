import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringOfAGivenPattern {
    public static void main(String[] args) {
        String word = "abdbca";
        String pattern = "abc";

        System.out.println("The smallest substring having all characters of the pattern is: "
        + findSmallestSubStringOfGivenPattern(word, pattern));
    }

    private static String findSmallestSubStringOfGivenPattern(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        int windowEnd = 0;
        int windowStart = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int subStr = 0;

        for(Character ch : pattern.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while(windowEnd < str.length()) {
            char rightChar = str.charAt(windowEnd++);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) >= 0) {
                    matched++;
                }
            }
            while(matched == pattern.length()) {
                if(minLength > windowEnd - windowStart) {
                    minLength = windowEnd - windowStart;
                    subStr = windowStart;
                }
                char leftChar = str.charAt(windowStart++);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) == 0) {
                        matched --;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }
        return minLength > str.length() ? "" : str.substring(subStr, subStr + minLength);
    }
}
