mport java.util.Map;

public class PermutationsInAString {
    public static void main(String[] args) {
        System.out.println(hasPermutationsOfPattern("oidbcaf", "abc"));

    }
    public static boolean hasPermutationsOfPattern(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : pattern.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int windowStart = 0;
        int windowEnd = 0;
        int matchedPattern = 0;

        while(windowEnd < str.length()){
            char rightChar = str.charAt(windowEnd++);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0) matchedPattern++;
            }
            
            if(matchedPattern == map.size()) return true;

            if(windowEnd >= pattern.length()) {
                char leftChar = str.charAt(windowStart++);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) == 0) {
                        matchedPattern--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
}

//    Create a HashMap to calculate the frequencies of all characters in the pattern.
//    Iterate through the string, adding one character at a time in the sliding window.
//    If the character being added matches a character in the HashMap, decrement its frequency in the map.
//    If the character frequency becomes zero, we got a complete match.
//    If at any time, the number of characters matched is equal to the number of distinct characters in the pattern
//        (i.e., total characters in the HashMap), we have gotten our required permutation.
//    If the window size is greater than the length of the pattern, shrink the window to make it equal to the pattern’s size.
//    At the same time, if the character going out was part of the pattern, put it back in 
