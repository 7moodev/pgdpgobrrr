import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;




public class myClass{



    public static void main(String[]args){

       // Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 };
            //int[] result = filterDuplicates(array);
        // System.out.println(Arrays.deepToString(countDuplicates(new int[]{1,2,2,2,3,4,5,5,5,5,3,2,2,5,6,32423,23,423,423,234,4,2})));
    
           // System.out.println("Elements that appear only once: " + Arrays.toString(result));


       // System.out.println(containsDuplicate(new int[] {1,2,3,4,5,6,5,5,5,5}));

       //System.out.println(customModulo(10, 3));
       



       //--------------------------------------//
        // tranverse an array backward:
        
       // for (int counter = myArray.length - 1; counter >= 0; counter--) {
            // some code
            //System.out.println(myArray[counter]);
       // }
//System.out.println(Arrays.toString(shuffle(new int[] {1,2,3,4,5,5,5})));
        //     int[] originalArray = {1, 43, 24, 42, 42, 3, 3, 3, 4, 5, 6, 6, 6, 4};
        // int[] shuffledArray = shuffle(Arrays.copyOf(originalArray, originalArray.length));
        // System.out.println(Arrays.toString(shuffledArray));
        int[][] lol = new int [][]{
            {1,2,3,4},
{1,2,3,4}
        };
        System.out.println((lol));
       }




    //    public static int[] shuffle(int[] array) {
    //     Random rand = new Random();
    //     for (int i = 0; i < array.length; i++) {
    //         int randomIndexToSwap = rand.nextInt(array.length);
    //         int temp = array[randomIndexToSwap];
    //         array[randomIndexToSwap] = array[i];
    //         array[i] = temp;
    //     }
    //     return array;}

    //    public static int[] GetUnique(int[] myArray2){
    //     int counter = 0;
    //     for(int i = 0; i<myArray2.length; i++){
    //         int j;
    //         for (j=0; j<myArray2.length; j++){
    //             if(myArray2[i] == myArray2[j]){
    //                 break;
    //             }
    //         }
    //         if (i==j) counter++;
    //     }

    //     int backArr[] = new int[counter];
    //     counter= 0;
    //        for(int i = 0; i<myArray2.length; i++){
    //         int j=0;
    //         for (j=0; j<myArray2.length; j++){
    //             if(myArray2[i] == myArray2[j]){
    //                 break;
    //             }
    //         }
    //         if(i==j){ 
    //             backArr[counter] = myArray2[i];
    //             counter++;}
    //     }
    //         return backArr;
    //    }






    //     public static int[] ReversArr(int[] myArray){
    //     //reverse an Array:
    //     //int[] myArray = new int[]{0,1,2,3,4,5,6};
    //     int i = 0;
    //     int j = myArray.length - 1;

    //     while (i < j) {
    //         // Swap elements at positions i and j
    //         int temp = myArray[i];
    //         myArray[i] = myArray[j];
    //         myArray[j] = temp;

    //         // Move indices toward the center
    //         i++;
    //         j--;
    //     }
    //     return myArray;
    //     }


    //     public static int[] BubbleSort(int[] myArray1){
    //     //String BubbleSort = "BUBBLE SORT";
    //     //int myArray1[] = new int []{1,4,6,2,32,2,1,11};

    //     boolean sorted = true;
    //     while(sorted){
    //         sorted = false;
    //         for (int i = 0; i < myArray1.length-1; i++){
    //             if(myArray1[i] > myArray1[i+1]){
    //                 int temp = myArray1[i];
    //                myArray1[i] = myArray1[i+1];
    //                myArray1[i+1] = temp;
    //                sorted = true;
    //             }
    //         }
    //     }
    //     return myArray1;
    //     }

    // public static boolean containsDuplicate(int[] nums) {
    //     // Base case...
    //     if(nums==null || nums.length==0)
    //         return false;
    //     // Create a hashset...
    //     HashSet<Integer> hset = new HashSet<Integer>();
    //     // Traverse all the elements through the loop...
    //     for(int idx: nums){
    //         // If it contains duplicate...
    //         if(!hset.add(idx)){
    //             return true;
    //         }
    //     }
    //     // Otherwise return false...
    //     return false;
    // }


   
      
    
    //     public static int[] filterDuplicates(int[] array) {
    //         int count;
    //         int uniqueCount = 0;
    
    //         // Count the number of unique elements
    //         for (int i = 0; i < array.length; i++) {
    //             count = 0;
    //             for (int j = 0; j < array.length; j++) {
    //                 if (array[i] == array[j]) {
    //                     count++;
    //                 }
    //             }
    //             if (count == 1) {
    //                 uniqueCount++;
    //             }
    //         }
    
    //         // Create an array to store the unique elements
    //         int[] result = new int[uniqueCount];
    //         int index = 0;
    
    //         // Populate the result array with unique elements
    //         for (int i = 0; i < array.length; i++) {
    //             count = 0;
    //             for (int j = 0; j < array.length; j++) {
    //                 if (array[i] == array[j]) {
    //                     count++;
    //                 }
    //             }
    //             if (count == 1) {
    //                 result[index++] = array[i];
    //             }
    //         }
    
    //         return result;
    //     }


    //     public static void bubbleSortDescending(int[] array) {
    //         int n = array.length;
    //         boolean swapped;
    
    //         for (int i = 0; i < n - 1; i++) {
    //             swapped = false;
    
    //             for (int j = 0; j < n - 1 - i; j++) {
    //                 // Compare adjacent elements and swap if necessary for descending order
    //                 if (array[j] < array[j + 1]) {
    //                     int temp = array[j];
    //                     array[j] = array[j + 1];
    //                     array[j + 1] = temp;
    //                     swapped = true;
    //                 }
    //             }
    
    //             // If no two elements were swapped in the inner loop, the array is already sorted
    //             if (!swapped) {
    //                 break;
    //             }
    //         }
    //     }
    


    
        
    //         public static int[][] countDuplicates(int[] array) {
    //             Map<Integer, Integer> occurrences = new HashMap<>();
        
    //             // Count occurrences of each element in the array
    //             for (int num : array) {
    //                 occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    //             }
        
    //             // Create a 2D array to store the counts and elements
    //             int[][] result = new int[occurrences.size()][2];
    //             int index = 0;
        
    //             // Populate the result array with counts and elements
    //             for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
    //                 result[index][0] = entry.getKey();  // Element
    //                 result[index][1] = entry.getValue(); // Count
    //                 index++;
    //             }
        
    //             return result;
    //         }

    //         public static int customModulo(int dividend, int divisor) {
    //             if (divisor == 0) {
    //                 throw new IllegalArgumentException("Cannot divide by zero");
    //             }
        
    //             int quotient = dividend / divisor;
    //             int product = quotient * divisor;
    //             int remainder = dividend - product;
        
    //             // Adjust the remainder if needed
    //             if (dividend < 0 && remainder != 0) {
    //                 remainder += divisor;
    //             }
        
    //             return remainder;
    //         }
        


    // // Addition without +
    // public static int add(int a, int b) {
    //     while (b != 0) {
    //         int carry = a & b;
    //         a = a ^ b;
    //         b = carry << 1;
    //     }
    //     return a;
    // }

    // // Subtraction without -
    // public static int subtract(int a, int b) {
    //     return add(a, add(~b, 1));
    // }

    // // Multiplication without *
    // public static int multiply(int a, int b) {
    //     int result = 0;
    //     while (b != 0) {
    //         if ((b & 1) == 1) {
    //             result = add(result, a);
    //         }
    //         a <<= 1;
    //         b >>>= 1;
    //     }
    //     return result;
    // }

    // // Division without /
    // public static int divide(int a, int b) {
    //     if (b == 0) {
    //         throw new ArithmeticException("Cannot divide by zero");
    //     }

    //     int quotient = 0;
    //     int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;

    //     a = Math.abs(a);
    //     b = Math.abs(b);

    //     while (a >= b) {
    //         a = subtract(a, b);
    //         quotient = add(quotient, 1);
    //     }

    //     return multiply(quotient, sign);
    // }

    // // Modulus without %
    // public static int modulus(int a, int b) {
    //     if (b == 0) {
    //         throw new ArithmeticException("Cannot calculate modulus with zero divisor");
    //     }

    //     int result = subtract(a, multiply(divide(a, b), b));

    //     // Adjust for negative result
    //     return (result < 0) ? add(result, b) : result;
    // }
    

}