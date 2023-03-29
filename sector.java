import java.util.*;
public class sector 
{
    public int inversions;
    public ArrayList<Integer> nums = new ArrayList<Integer>(); // Create an ArrayList object

    /*
     * sector contains an inversion count
     * and an arraylist
     */
    public sector(ArrayList<Integer> nums, int inversions)
    {
        this.inversions = inversions;
        this.nums = nums;
    }

}
