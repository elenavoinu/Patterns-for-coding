import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 6};
        System.out.println(Arrays.toString(targetSum(arr, 6)));
    }
    
    public static int[] targetSum(int[] arr, int target) {
        int leftPointer = 0;
        int rightPointer = arr.length-1;
        while(leftPointer < rightPointer) {
            int sum = arr[leftPointer] + arr[rightPointer];
            if(sum > target) {
                rightPointer--;
            }
            else if(sum < target) {
                leftPointer++;
            }
            else return new int[] {leftPointer, rightPointer};
        }
        
        return new int[] {-1,-1};
    }
}
