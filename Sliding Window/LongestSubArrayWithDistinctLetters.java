import java.util.HashSet;
import java.util.Set;

public class LongestSubArrayWithDistinctLetters {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("aabccbb")); // 3
        System.out.println("Length of the longest substring: " + findLength("abbbb")); // 2
        System.out.println("Length of the longest substring: " + findLength("abccde")); // 3
    }

    public static int findLength(String str) {
        //sliding window technique
        //validate string is not null or empty
        //declare start and end of the window
        //declare the max distinct characters variables
        //in a loop, declare a set and add end window characters
        //check if set contains left and add them otherwise remove
        //increment left
        //calculate max length using Math.max method
       // return maxLength
        if(str == null || str.equals("")){
            return 0;
        }
        int left = 0, right = 0, maxLength = 0;
        Set<Character> distinctChars = new HashSet<>();
        while( right < str.length()) {

          if(!distinctChars.contains(str.charAt(right)))  {
              distinctChars.add(str.charAt(right));
              maxLength = Math.max(maxLength, distinctChars.size());
              right++;
          }
          else {
              distinctChars.remove(str.charAt(left));
              left++;
          }
        }
        return maxLength;
    }
}
