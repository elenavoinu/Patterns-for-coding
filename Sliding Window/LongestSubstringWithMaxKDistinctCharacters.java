package LongestSubStringWithKDistinctCharacters;

import java.util.HashMap;

public class LongestSubstringWithMaxKDistinctCharacters {
    public static void main(String[] args) {
        String word = "araaci";
        System.out.println(longestSubArrayWithKDistinctChars(word, 2));

    }
    public static int longestSubArrayWithKDistinctChars(String str, int k) {
        if(str == null || str.length() == 0) return 0;

        int leftPointer = 0;
        int rightPointer = 0;
        int maxLength = 0;
        char[] array = str.toCharArray();

        HashMap<Character, Integer> hm = new HashMap<>();
        while(rightPointer < array.length) {
            //populate the hashmap
            hm.put(array[rightPointer], hm.getOrDefault(array[rightPointer], 0) + 1);
            rightPointer++;

            while(hm.size() > k) { //means we have more than k distinct characters
                hm.put(array[leftPointer], hm.get(array[leftPointer]) - 1);
                if(hm.get(array[leftPointer]) == 0) hm.remove(array[leftPointer]);
                leftPointer++;
            }
            maxLength = Math.max(maxLength, rightPointer - leftPointer);

        }
        return maxLength;
//        int maxLen = Integer.MIN_VALUE;
//        HashMap<Character, Integer> freq  = new HashMap<>();
//        char [] chars = word.toCharArray();
//        int windowStart = 0;
//        for(int windowEnd = 0; windowEnd < chars.length; windowEnd++) {
//
//            freq.putIfAbsent(chars[windowEnd], freq.getOrDefault(chars[windowEnd],0) + 1);
//
//            while(freq.size() > k) {
//                freq.put(chars[windowStart], freq.get(chars[windowEnd]) - 1);
//                if(freq.get(chars[windowStart]) == 0 ) {
//                    freq.remove(chars[windowStart]);
//                }
//                windowStart++;
//            }
//            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
//        }
//
//        return  maxLen;
    }
}
//U:
/*Input  String="araaci", K=2
Output: 4
Explanation: a and r are distinct. C would be a 3rd distinct character
since the problem  k = 2, the longest subarray with 2 distinct chars is 4

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
*/
//M:
//sliding window

//P:
/*
1) Create a hash table to store the characters and their frequency
2) Create a maxLen variable to keep track of the longest length of subarray
3) Create a variable window start and windowLen
4) Iterate over the input array and store the characters in the map (int windowEnd = 0; ...)
5) check if the number of distinct characters in the map == k if true then:
6) update the maxLen using Math.max(maxLen, windowLen)
7) increment windowStart
8) increment window End

9) return the maxLen
 */

/* Plan:
input check: is string is null or length is 0
Declare a pointer that will iterate over the String (endWindow)
Declare pointer that will move the window forward (startWindow)
Declare a count variable that would keep trac of the window size
Declare a distinct number variable that would keep track of the distinct characters in the string
Declare maxLength variable

while distinct character variable is greater than k,
we calculate the max: max = Math.max(max, count);
we increment startWindow
we increment the endWindow
we decrement the distinct characters number
Else
we inctement the endWindow

*/