import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Anja Samsom HW 4 Programming
 * CS 224
 */
public class program
{  
   public static void main(String[]args)
   {
      // getting user input for the name of the file
      System.out.print("Name of the file with the extension: ");
      Scanner sc = new Scanner(System.in);
      String name = sc.next();
      sc.close();


      // gets arraylist from the input file
      ArrayList<ArrayList<Integer>> my_list = from_file(name);

      for(ArrayList<Integer> num_list : my_list)
      {
         // I made an object to hold the arraylist and the number of inversions
         sector arr = sort_and_count(num_list);
         System.out.println("Inversion count: " + arr.inversions + ". Sorted array: " + arr.nums);

      }

   }
   /**
    * takes in the string name of the file
    * and returns an arraylist of arraylists
    * that will each have the method called on them later
    * to sort
    */
   public static ArrayList<ArrayList<Integer>> from_file(String input)
   {
      ArrayList<ArrayList<Integer>> final_list = new ArrayList<ArrayList<Integer>>();
      String line = "";
      try
      {
         File file  = new File (input);
         Scanner sc = new Scanner(file);
         while (sc.hasNext())
         {
            ArrayList<Integer> my_list = new ArrayList<Integer>();
            line = sc.nextLine();
            // split by every space
            String parts[] = line.split(" ");
            for(String number : parts)
            {
               my_list.add(Integer.parseInt(number));
            }
            final_list.add(my_list);
         }
         sc.close();
      }

      catch (FileNotFoundException e) {
         System.out.println("PROBLEM!! Run again and make sure you have the correct file name!");
       }

       return final_list;
   }

   /*
    * takes in the arraylist L
    * and returns a sector object (contains inversion count and arraylist)
    * splits the list up and recurses
    */
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

      // (r, L) Merge-and-Count(A, B);

      sector secR  = merge_and_count(secA.nums, secB.nums);
      //System.out.println(secR.nums+"\n \n");

      //  return r = rA + rB + r and the sorted list L;
      secR.inversions = secA.inversions + secB.inversions + secR.inversions;
 
      return secR;
   }

   /*
    * takes in both arraylists and returns one sorted
    * list in a sector that also contains the inversion count
    */
   public static sector merge_and_count(ArrayList<Integer> A, ArrayList<Integer> B)
   {
      // final list
      ArrayList<Integer> R = new ArrayList<Integer>();

      int inv = 0;
      while(A.size() !=0 || B.size() !=0)
      {
         // dump the rest of B
         if(A.size() == 0)
         {
            for(int unit : B)
            {
               R.add(unit);
            }
            B.clear();
            sector secR = new sector(R, inv);
            return secR;
         }

         // dump the rest of B
         else if(B.size() == 0)
         {
            for(int unit : A)
            {               
               R.add(unit);
            }
            A.clear();
            sector secR = new sector(R, inv);

            return secR;
         }

         // but if they both have something in them, make sure they go in the right order
         else
         {
            if(A.get(0) < B.get(0))
            {
               R.add(A.remove(0));

            }
            else if(A.get(0) > B.get(0))
            {
               R.add(B.remove(0));

               // we are skipping through the rest of A
               inv =  inv + A.size();

            }
         }
      }
      sector secR = new sector(R, inv);
      return secR;
   }
}