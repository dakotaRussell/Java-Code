import java.util.*;

public class OddEvenDescending implements Comparator<Integer>
{
	public int compare(Integer x, Integer y)
	{
		if((x % 2 == 1) && (y % 2 == 0))
			return -1;

		else if((x % 2 == 0) && (y % 2 == 1))
			return 1;

		else
		{
			if (x>y)
				return -1;

			if (x<y)
				return 1;

			else
				return 0;
		}

	}	
}