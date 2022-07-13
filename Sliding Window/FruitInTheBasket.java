import java.util.HashMap;
import java.util.Map;

public class FruitInTheBasket {
    public static void main(String[] args) {
        char [] array = new char[] {'A', 'B', 'C', 'A', 'C'};
        System.out.println("Fruits in the basket " + findLength(array));
    }
    public static int findLength(char[] array){
        int maxLength = 0;
        int leftPointer = 0;
        int rightPointer = 0;

       Map<Character, Integer> basket = new HashMap<>();

       while(rightPointer < array.length) {
           basket.put(array[rightPointer], basket.getOrDefault(array[rightPointer], 0) + 1);
           rightPointer++;

           while(basket.size() > 2) {
               basket.put(array[leftPointer], basket.get(array[leftPointer]) - 1);
               if(basket.get(array[leftPointer])==0) {
                   basket.remove(array[leftPointer]);
               }
               leftPointer++;
           }
           maxLength = Math.max(maxLength, rightPointer - leftPointer);
       }

       return maxLength;
    }
}
