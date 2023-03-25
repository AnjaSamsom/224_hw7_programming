import java.util.*;
import java.util.Queue;
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
      int[] L2 = {7,8,9,6};
   
      
    sector arr = sort_and_count(L2);
    System.out.println("Inversion count: " + arr[0][0] + ". Sorted array: " + Arrays.toString(arr[1]));



      
   }

   public static sector sort_and_count(int[] L)
   {
      if(L.length == 1)
      {
        arr[0][0] = 0;
        arr[1] = L;
        return arr;
      }

      int [][] A = new int [2][L.length/2];
      A[1] = Arrays.copyOfRange(L, 0, L.length/2);
      int [][] B = new int [2][L.length/2];
      B[1] = Arrays.copyOfRange(L, L.length/2, L.length);


      A = sort_and_count(A[1]);
      B = sort_and_count(B[1]);

      //System.out.println("A");
      //System.out.println(Arrays.toString(A[1]));

  //    System.out.println("B");
//      System.out.println(Arrays.toString(B[1]));

      int arrR [][] = merge_and_count(A[1],B[1]);

      int ra = A[0][0];
      int rb = A[0][0];
      int r = arrR[0][0];

      arr[0][0] = ra+rb+r;
      arr[1] = arrR[1];
      
      return arr;
   }

   public static int[][] merge_and_count(int[] A, int[] B)
   {
      // make a queue for A and B

      LinkedList<Integer> qA = new LinkedList<Integer>();
      for(int num : A)
      {
         qA.add(num);
      }

      LinkedList<Integer> qB = new LinkedList<Integer>();
      for(int num : B)
      {
         qB.add(num);
      }      

      int inv = 0;
      int [][] arr  = new int[2][A.length + B.length];

      LinkedList<Integer> R = new LinkedList<Integer>();

      for(int i = 0; i<qA.size() && i<qB.size(); i++)
      {
        // System.out.println("compare");

         System.out.println(qA.get(i));
         System.out.println(qB.get(i));
         System.out.println();

         if(qA.get(i) < qB.get(i))
         {
            System.out.println("added " + qA.get(i));
            R.add(qA.remove(i));


         }
         else if( qA.get(i) > qB.get(i))
         {
            System.out.println("added " + qB.get(i));
            R.add(qB.remove(i));
            inv ++;
         }
      }

      arr[0][0] = inv;



      for(int unit : R)
      {

      }



      System.out.println(Arrays(R));




      return arr;



   }

   
}