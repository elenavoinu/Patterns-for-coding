import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        // TODO: Write your code here
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (i > 0 && arr[i] == arr[i + 1]) continue;
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) right--;
                else {
                    triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                }
            }
        }
        return triplets;
    }
}
/*
U:
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
Example 1:
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

M:
2 pointers

P:
1. Sort the array
2. Iterate over the array and skip the duplicates:
if(i > 0 && arr[i] == arr[i - 1]) continue;
5. Initialize right pointer = arr.length -1;
6. Iterate over the array while left < right
7. check if arr[i] + arr[left] + arr[right] == 0 and add to the list if condition true
8. increment left and right--
9. check if arr[i] + arr[left] + arr[right] > 0 and decrement right pointer
10. check if arr[i] + arr[left] + arr[right] < 0 and increment left pointer
11. return the triplets

E:
Sorting takes O(nlogn)
Searching for pairs takes O(n).
As we are searching for every number in the input array, this means that overall searchTriplets() will take O(N * logN + N^2)
which is asymptotically equivalent to O(N^2)

Space: O(n)

*/
