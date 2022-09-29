import java.util.*;
import java.lang.*;


public class IntegerList
{
	private ArrayList<Integer> intList = new ArrayList<Integer>();

	public IntegerList()
	{}

	public IntegerList(int numObjects, int max)
	{
		Random random = new Random();
		for(int i=0; i<numObjects; i++)
		{	
			intList.add(random.nextInt(max));
		}
	}

	public void sort()
	{
		Collections.sort(intList);
	}

	public void sort(Comparator<Integer> com)
	{
		Collections.sort(intList, com);
	}

	public boolean isSorted(Comparator<Integer> com)
	{
		IntegerList temp = new IntegerList();
		for (int i=0; i<intList.size(); i++)
		{
			temp.intList.add(intList.get(i));
		}

		if (com != null)
		{
			temp.sort(com);
			for (int i=0; i<intList.size(); i++)
			{
				if (!(temp.intList.get(i).equals(intList.get(i))))
					return false;
			}

			return true;
		}

		else
		{
			for (int i=0; i<intList.size()-1; i++)
			{
				if ((intList.get(i).compareTo(intList.get(i+1))) > 0)
					return false;
			}

			return true;
		}
	}

	public String toString()
	{
		String tempString = new String();

		if (intList.size() == 0)
			return "";

		for (int i=0; i<intList.size(); i++)
		{
			int value = intList.get(i);
			tempString += value + "\n";
		}
		return tempString;
	}

	public void mySLOsort()
	{
		int i,j,theNum;
		for (i=1; i<intList.size(); i++)
		{
			theNum = intList.get(i);
			j=i;
			while (j>0 && intList.get(j-1) > theNum)
			{
				intList.set(j, intList.get(j-1));
				j--;
			}

			intList.set(j, theNum);
		}
	}

	public void mySLOsort(Comparator<Integer> com)
	{
		int i,j,theNum;
		for (i=1; i<intList.size(); i++)
		{
			theNum = intList.get(i);
			j=i;
			
			while(j>0 && com.compare(theNum, intList.get(j-1)) < 0)
			{
				intList.set(j, intList.get(j-1));
				j--;
			}
			
			intList.set(j, theNum);
		}
	}

	public int binarySearch(int key)
	{
		int mid;
		int min = 0;
		int max = intList.size()-1;
		while (min<=max)
		{
			mid = (min+max)/2;
			if (intList.get(mid) == key)
				return mid;
			else if(intList.get(mid) < key)
				min=mid+1;
			else
				max=mid-1;
		}
		return -1;
	}

/**
*	@require this.isSorted(null) == true;
*	@param key: the number to search for
*	@param min: the minimum index in the list
*	@param max: the maximum index in the list
*	@return index of the key or -1 if key is not in the list
**/
	public int recBinarySearch(int key)
	{
		return recBinarySearch(key, 0, (intList.size()-1));
	}

	private int recBinarySearch(int key, int min, int max)
	{
		int mid = (min+max)/2;
		if (intList.get(mid) == key)
			return mid;
		if (min>max)
			return -1;
		if (intList.get(mid)< key)
			return recBinarySearch(key, mid+1, max);

		return recBinarySearch(key,min, mid-1);
	}
}