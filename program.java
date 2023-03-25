import java.util.*;


/**
 * Anja Samsom HW 4 Programming
 * CS 224
 * 
 * 
 Sort-and-Count(L) {
 if list L has one element
 return 0 and the list L;
 Divide the list into two halves A and B;
 (rA, A)  Sort-and-Count(A);
 (rB, B)  Sort-and-Count(B);
 (r, L)  Merge-and-Count(A, B);
 return r = rA + rB + r and the sorted list L;
}
 * 
 * 
 * 
 * 
 */
public class program
{
   

   public static void main(String[]args)
   {
      int[] L1 = {1, 13, 14, 2, 25, 26};
      int[] L2 = {6};
   
      
    int [][] arr = sort_and_count(L1);
    System.out.println("Inversion count: " + arr[0][0] + ". Sorted array: " + Arrays.toString(arr[1]));



      
   }

   public static int[][] sort_and_count(int[] L)
   {
      int[][] arr = new int[2][L.length];
      if(L.length == 1)
      {
        arr[0][0] = 0;
        arr[1] = L;
        return arr;
      }


      int[] A = Arrays.copyOfRange(L, 0, L.length/2);
      int[] B = Arrays.copyOfRange(L, L.length/2, L.length);



      

      arr[0][0] = 0;
      arr[1] = L;
      
      return arr;
   }

   
}