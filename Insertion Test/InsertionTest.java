/* Dakota Dehn CPE 103- Program 2*/

public class InsertionTest
{
	public static void sortLinear(Comparable[] x)
	{
		int index;
		Comparable temp;
		for (int i = 1; i < x.length; i++)
		{	
			//calling linearSearch to produce correct index
			temp = x[i];
			index = InsertionTest.linearSearch(x, i, temp);
			//assigning the current number to said index
			for (int j = index; j < i; j++)
			{
				x[j+1] = x[j];
			}
			x[index] = temp;
		}
	}

	public static void sortBinary(Comparable[] x)
	{
		int index;
		Comparable temp;
		for (int i = 1; i < x.length; i++)
		{
			//calling binarySearch to produce correct index
			temp = x[i];
			index = InsertionTest.binarySearch(x, i-1, temp);
			//assigning the current number to said index
			for (int j = index; j < i; j++)
			{
				x[j+1] = x[j];
			}
			x[index] = temp;
		}
	}

	public static Integer linearSearch(Comparable[] x, int end, Comparable num)
	{
		for (int i = 0; i < end; i++)
		{
			if (x[i].compareTo(num) > 0)
			{
				return i;
			}
		}
		return end;
	}

	public static Integer binarySearch(Comparable[] x, int end, Comparable num)
	{
		int min, max, middle;
		min = 0;
		max = end;
		middle = (min + max)/2;
		while (min <= max)
		{
			if(x[middle].compareTo(num) == 0)	
				return middle;

			else if (x[middle].compareTo(num) > 0)
				max = middle-1;
				
			else
				min = middle+1;
				

			middle = (min + max)/2;
		}

		return min;
	}
}