import java.util.*;
import java.util.Queue;
import java.util.*;



/**
 * Anja Samsom HW 4 Programming
 * CS 224
 */
public class program
{
   

   public static void main(String[]args)
   {
      ArrayList<Integer> L1 = new ArrayList<Integer>(); 
      L1.add(1);
      L1.add(13);
      L1.add(14);
      L1.add(2);
      L1.add(25);
      L1.add(26);


      ArrayList<Integer> L2 = new ArrayList<Integer>(); 
      L2.add(45);
      L2.add(23);
      L2.add(12);
      L2.add(34);
      L2.add(10);

      ArrayList<Integer> L3 = new ArrayList<Integer>(); 
      L3.add(45);
      L3.add(23);
      L3.add(12);

    sector arr = sort_and_count(L3);
    
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

      int inv = 0;
      while(A.size() !=0 || B.size() !=0)
      {
         if(A.size() == 0)
         {
            for(int unit : B)
            {
               R.add(unit);
            }
            B.clear();
            sector secR = new sector(R, inv);

            System.out.println("padme");

            return secR;
         }

         else if(B.size() == 0)
         {
            for(int unit : A)
            {
               
               R.add(unit);
               System.out.println("amidala");

            }
            A.clear();
            sector secR = new sector(R, inv);
            System.out.println("R: " + R);


            return secR;
         }

         else
         {
            if(A.get(0) < B.get(0))
            {
               R.add(A.remove(0));

            }
            else if(A.get(0) > B.get(0))
            {
               System.out.println(B.size());

               System.out.println("hello");
               System.out.println("R: " + R);
               System.out.println(A.get(0) + ", " + B.get(0));
               R.add(B.remove(0));
               System.out.println("R: " + R);
               System.out.println(B.size());

               System.out.println("bye\n");


               // we are skipping through the rest of A
               inv =  inv + A.size();

            }
         }

      }

      sector secR = new sector(R, inv);
      return secR;
   }
}