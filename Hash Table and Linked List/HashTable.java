import java.awt.*;

public class HashTable
{
  LinkedList[] table;
  int capacity;

  public HashTable(int capacity)
  {  
       table = new LinkedList[capacity];
       this.capacity = capacity;
  }

  public void add(Object element)
  {
       int index = Math.abs(((String)element).hashCode())%capacity;
       if (table[index] == null)
	{
           table[index] = new LinkedList();
	   table[index].addFirst(element);
        }
       else
	   (table[index]).addLast(element); 
	  
  }

  public boolean contains(Object element)
  {
       int index = Math.abs(((String)element).hashCode()) %capacity;
       return (table[index]).contains(element);
  }

  public int numElements()
  {	
        int count=0;
       for (int i=0; i< capacity; i++)
	{
	   if (table[i] != null)
            count += table[i].length();
        } 
	return count;
  }

  public int capacity()
  {
	return capacity;
  }

  public int maxBucketCount()
  {
	int bucket=0;
        for (int i=0; i<capacity; i++)
        {
            if (table[i] != null && table[i].length() > bucket)
                bucket = table[i].length();
	}
        return bucket;
  }

  public int nonZeroBucketCount()
  {
	int count=0;
        for (int i=0; i< capacity; i++)
        {
            if (table[i] != null)
               count++;
        }
 
	return count;
  }

  public float avgNonZeroBucketCount()
  {
	float total=0;
        for (int i=0; i<capacity; i++)
        {
	    if (table[i] != null)
	    	total += table[i].length();
        }

	return total/nonZeroBucketCount();
  }

  public static class Error extends RuntimeException
  {
     public Error(String message) throws Exception
     { 
         throw new Exception(message);
     }
  }

}
