public class LongestSubArrayWithOnesAfterReplacement {
    public static void main(String[] args) {
        System.out.println(LongestSubArrayWithOnesAfterReplacement.findMaxLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(LongestSubArrayWithOnesAfterReplacement.findMaxLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }

    public static int findMaxLength(int[] array, int k) {
        int maxLength = 0;
        int windowEnd = 0;
        int windowStart = 0;
        int maxOnesCount = 0;

        while(windowEnd < array.length) {
            if(array[windowEnd] == 1)  {
                maxOnesCount++;
            }
            windowEnd++;

            if(windowEnd - windowStart - maxOnesCount > k)  {
                if(array[windowStart] == 1) maxOnesCount--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }

        return maxLength;


    }
}

/*
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 */

/*
Time Complexity#
The above algorithm’s time complexity will be O(N)
O(N)
 where ‘N’ is the count of numbers in the input array.

Space Complexity#
The algorithm runs in constant space O(1)
O(1)
 */
