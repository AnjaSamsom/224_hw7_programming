import java.util.*;
import java.util.Queue;
import java.util.*;



/**
 * Anja Samsom HW 4 Programming
 * CS 224
 * 
 * 
 Sort-and-Count(L) {


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
      ArrayList<Integer> L2 = new ArrayList<Integer>(); 
      L2.add(5);
      L2.add(3);


   
      
    sector arr = sort_and_count(L2);
    System.out.println("Inversion count: " + arr.inversions + ". Sorted array: " + arr.nums);



      
   }

   public static sector sort_and_count(ArrayList<Integer> L)
   {
      sector arr = new sector(L, 0);

      //  if list L has one element
      // return 0 and the list L;
      if(L.size() == 1)
      {
        return arr;
      } 

      //  Divide the list into two halves A and B;
      ArrayList<Integer> A = new ArrayList<Integer>(L.subList(0, L.size()/2));
      ArrayList<Integer> B = new ArrayList<Integer>(L.subList(L.size()/2, L.size()));


      // (rA, A) Sort-and-Count(A);
      sector secA  = sort_and_count(A);
      
      // (rB, B) Sort-and-Count(B);
      sector secB  = sort_and_count(B);

      // (r, L) Merge-and-Count(A, B);\
      sector secR  = merge_and_count(A, B);

      //  return r = rA + rB + r and the sorted list L;
      secR.inversions = secA.inversions + secB.inversions + secR.inversions;
      return secR;
   }

   public static sector merge_and_count(ArrayList<Integer> A, ArrayList<Integer> B)
   {
      // final list
      ArrayList<Integer> R = new ArrayList<Integer>();

      System.out.println(A.get(0));
      System.out.println(B.get(0));
      System.out.println();




      int i = 0;
      int inv = 0;
      while(A.size() !=0 || B.size() !=0)
      {
         if(A.size() == 0)
         {
            for(int unit : B)
            {
               R.add(unit);
            }
            System.out.println("1");
            sector secR = new sector(R, inv);
            return secR;
         }
         else if(B.size() == 0)
         {
            for(int unit : A)
            {
               
               R.add(unit);
            }
            System.out.println("2");
            System.out.println(R);

            sector secR = new sector(R, inv);
            return secR;
         }

         else
         {
            if(A.get(i) < B.get(i))
            {
               //System.out.println("added " + A.get(i));
               R.add(A.remove(i));
               System.out.println("3");

            }
            else if(A.get(i) > B.get(i))
            {
               //System.out.println("added " + B.get(i));
               R.add(B.remove(i));
               System.out.println("4");
               System.out.println(R);
               inv ++;
            }
            i++;
         }


      }

      sector secR = new sector(R, inv);
      return secR;
   }
}