import java.util.*;
import java.lang.*;

public class Explore 
{
	private static LinkedList<String> stringList;
	private static LinkedList<Integer> intList;
	public static Iterator<String> iterWords;
	public static Iterator<Integer> iterInts;
	private static Stack<String> stack = new Stack<String>();

	public static void main(String[] args)
	{
		stringList = new LinkedList<String>();
		stringList.add("Fast ");
		stringList.add("life, ");
		stringList.add("someone's ");
		stringList.add("always ");
		stringList.add("caught ");
		stringList.add("up ");
		stringList.add("in ");
		stringList.add("the ");
		stringList.add("fast ");
		stringList.add("life ");

		intList = new LinkedList<Integer>();
		intList.add(new Integer(5));
		intList.add(new Integer(3));
		intList.add(new Integer(8));
		intList.add(new Integer(6));

		iterWords = stringList.iterator();
		iterInts = intList.iterator();

		while (iterWords.hasNext())
		{
			System.out.println(iterWords.next());
		}

		for (Integer num: intList)
			System.out.println(iterInts.next());
		
		stack.push("A"); 
		stack.push("B"); 
		stack.push("C"); 
		System.out.println(stack.pop()); 
		stack.push("D"); 
		System.out.println(stack.pop()); 
		System.out.println(stack.pop()); 
		System.out.println(stack.pop());
	}


}