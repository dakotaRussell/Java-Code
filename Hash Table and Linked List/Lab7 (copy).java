public class HashTable
{
  LinkedList[] table;

  public HashTable(int capacity)
  {  
       table = new LinkedList[capacity];
  }

  public void add(Object element)
  {
       int index = hashCode(element)%capacity();
       if (table[index] == null)
           table[index] = new LinkedList(element);
       else
	   (table[index]).addLast(element); 
	  
  }

  public boolean contains(Object element)
  {
       int index = hashCode(element)%capacity();
       return (table[index]).contains(element);
  }

  public int numElements()
  {	
        int count=0;
       for (int i=0; i< capacity(); i++)
	{
            count += table[i].length();
        } 
	return count;
  }

  public int capacity()
  {
	return table.length;
  }

  public int maxBucketCount()
  {
	int bucketCount=0;
        for (int i=0; i<capacity(); i++)
        {
            if (table[i].length() > bucketCount)
                bucket = table[i].length();
	}
        return bucket;
  }

  public int nonZeroBucketCount()
  {
	int count=0;
        for (int i=0; i< capacity(); i++)
        {
            if (table[i] != null)
               count++;
        }
 
	return count;
  }

  public float avgNonZeroBucketCount()
  {
	float total;
        for (int i=0; i<capacity(); i++)
        {
	    total += table[i].length();
        }

	return total/nonZeroBucketCount();
  }

  public static class Error extends RuntimeException
  {
     public Error(String message)
     { 
         throw new Exception(message);
     }
  }

}
