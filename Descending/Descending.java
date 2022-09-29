import java.util.*;

public class Descending implements Comparator<Integer>
{
	public int compare(Integer x, Integer y)
	{
		if (x < y)
			return 1;

		else if(x > y)
			return -1;

		else
			return 0;
	}
}