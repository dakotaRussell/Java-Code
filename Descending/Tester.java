import java.util.*;

public class Tester
{
   public static void main(String[] args)
   {
      IntegerList nums = new IntegerList(10, 100);
      
      System.out.println("The unsorted nums:\n" + nums);
      
      System.out.println("The list is sorted naturally? " + nums.isSorted(null));
      System.out.println("The list is sorted descending? " + nums.isSorted(new Descending()));
      System.out.println("The list is sorted oddEvenAscending? " + nums.isSorted(new OddEvenAscending()));
      System.out.println("The list is sorted oddEvenDescending? " + nums.isSorted(new OddEvenDescending()));
      
      nums.sort();
      System.out.println("\nSorted Naturally:\n" + nums);
      
      System.out.println("The list is sorted naturally? " + nums.isSorted(null));
      System.out.println("The list is sorted descending? " + nums.isSorted(new Descending()));
      System.out.println("The list is sorted oddEvenAscending? " + nums.isSorted(new OddEvenAscending()));
      System.out.println("The list is sorted oddEvenDescending? " + nums.isSorted(new OddEvenDescending()));

      nums.sort(new Descending());
      System.out.println("\nSorted Descending:\n" + nums);

      System.out.println("The list is sorted naturally? " + nums.isSorted(null));
      System.out.println("The list is sorted descending? " + nums.isSorted(new Descending()));
      System.out.println("The list is sorted oddEvenAscending? " + nums.isSorted(new OddEvenAscending()));
      System.out.println("The list is sorted oddEvenDescending? " + nums.isSorted(new OddEvenDescending()));

      nums.sort(new OddEvenAscending());
      System.out.println("\nSorted OddEvenAscending:\n" + nums);
      
      System.out.println("The list is sorted naturally? " + nums.isSorted(null));
      System.out.println("The list is sorted descending? " + nums.isSorted(new Descending()));
      System.out.println("The list is sorted oddEvenAscending? " + nums.isSorted(new OddEvenAscending()));
      System.out.println("The list is sorted oddEvenDescending? " + nums.isSorted(new OddEvenDescending()));

      nums.sort(new OddEvenDescending());
      System.out.println("\nSorted OddEvenDescending:\n" + nums);
      
      System.out.println("The list is sorted naturally? " + nums.isSorted(null));
      System.out.println("The list is sorted descending? " + nums.isSorted(new Descending()));
      System.out.println("The list is sorted oddEvenAscending? " + nums.isSorted(new OddEvenAscending()));
      System.out.println("The list is sorted oddEvenDescending? " + nums.isSorted(new OddEvenDescending()));
      
      /* Testing mySLOsort */

      nums.mySLOsort();
      System.out.println("\nSorted naturally according to mySLOsort:\n" + nums);
      
      System.out.println("The list is sorted naturally? " + nums.isSorted(null));
      System.out.println("The list is sorted descending? " + nums.isSorted(new Descending()));
      System.out.println("The list is sorted oddEvenAscending? " + nums.isSorted(new OddEvenAscending()));
      System.out.println("The list is sorted oddEvenDescending? " + nums.isSorted(new OddEvenDescending()));

      nums.mySLOsort(new OddEvenAscending());
      System.out.println("\nSorted OddEvenAscending according to mySLOsort:\n" + nums);
      
      System.out.println("The list is sorted naturally? " + nums.isSorted(null));
      System.out.println("The list is sorted descending? " + nums.isSorted(new Descending()));
      System.out.println("The list is sorted oddEvenAscending? " + nums.isSorted(new OddEvenAscending()));
      System.out.println("The list is sorted oddEvenDescending? " + nums.isSorted(new OddEvenDescending()));

      /* Testing binarySearch */
     Scanner in = new Scanner(System.in);
      int key;

      nums.sort();
      System.out.println("\nSorted Naturally:\n" + nums);

      System.out.print("Iterative Binary Search");
      System.out.print("Enter a search key (-1 to quit): ");
      key = in.nextInt();
      while (key != -1)
      {
         System.out.println("The index of " + key + " is: " + nums.binarySearch(key));
         System.out.print("Enter a search key (-1 to quit): ");
         key = in.nextInt();
      }

      System.out.print("Recursive Binary Search");
      System.out.print("Enter a search key (-1 to quit): ");
      key = in.nextInt();
      while (key != -1)
      {
         System.out.println("The index of " + key + " is: " + nums.recBinarySearch(key));
         System.out.print("Enter a search key (-1 to quit): ");
         key = in.nextInt();
      }
    
   }
}