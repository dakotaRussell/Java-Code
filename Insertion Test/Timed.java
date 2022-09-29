/* Dakota Dehn CPE 103 - Program 2*/

import java.awt.*;
import java.util.*;

public class Timed
{
	public static void main(String[] args)
	{
		Comparable[] input0 = new Comparable[1000];
		Comparable[] input1 = new Comparable[10000];
		Comparable[] input2 = new Comparable[100000];

		//Ascending order inputs
		for (int i=0; i<input0.length; i++)
			input0[i] = new Integer(i);

		for (int i=0; i<input1.length; i++)
			input1[i] = new Integer(i);

		for (int i=0; i<input2.length; i++)
			input2[i] = new Integer(i);

		//Testing ascending LinearSort and pass 0
		outputTest(input0, 'l', 0);
		outputTest(input1, 'l', 0);
		outputTest(input2, 'l', 0);

		//Ascending order inputs
		for (int i=0; i<input0.length; i++)
			input0[i] = new Integer(i);

		for (int i=0; i<input1.length; i++)
			input1[i] = new Integer(i);

		for (int i=0; i<input2.length; i++)
			input2[i] = new Integer(i);

		System.out.println();
		//Testing ascending BinarySort and pass 0
		outputTest(input0, 'b', 0);
		outputTest(input1, 'b', 0);
		outputTest(input2, 'b', 0);
		
		
		//Reverse order
		for (int i=input0.length; i > 0; i--)
			input0[input0.length - i] = new Integer(i);

		for (int i=input1.length; i > 0; i--)
			input1[input1.length - i] = new Integer(i);

		for (int i=input2.length; i > 0; i--)
			input2[input2.length - i] = new Integer(i);

		System.out.println();
		//Testing descending LinearSort and Pass 1
		outputTest(input0, 'l', 1);
		outputTest(input1, 'l', 1);
		outputTest(input2, 'l', 1);


		//Reverse order
		for (int i=input0.length; i > 0; i--)
			input0[input0.length - i] = new Integer(i);

		for (int i=input1.length; i > 0; i--)
			input1[input1.length - i] = new Integer(i);

		for (int i=input2.length; i > 0; i--)
			input2[input2.length - i] = new Integer(i);

		System.out.println();
		//Testing descending BinarySort and Pass 1
		outputTest(input0, 'b', 1);
		outputTest(input1, 'b', 1);
		outputTest(input2, 'b', 1);

		//Random order
		//Generating random number generator with hardcoded seed
		Random gen = new Random(4);
		for (int i=0; i< input0.length; i++)
			input0[i] = new Integer(gen.nextInt());

		for (int i=0; i< input1.length; i++)
			input1[i] = new Integer(gen.nextInt());

		for (int i=0; i<input2.length; i++)
			input2[i] = new Integer(gen.nextInt());

		System.out.println();
		//Testing random order LinearSort and pass 2
		outputTest(input0, 'l', 2);
		outputTest(input1, 'l', 2);
		outputTest(input2, 'l', 2);

		//Random order
		//Generating random number generator with hardcoded seed
		for (int i=0; i< input0.length; i++)
			input0[i] = new Integer(gen.nextInt());

		for (int i=0; i< input1.length; i++)
			input1[i] = new Integer(gen.nextInt());

		for (int i=0; i<input2.length; i++)
			input2[i] = new Integer(gen.nextInt());

		System.out.println();
		//Testing random order BinarySort and pass 2
		outputTest(input0, 'b', 2);
		outputTest(input1, 'b', 2);
		outputTest(input2, 'b', 2);

	}


		public static void outputTest(Comparable[] x, char type, int pass)
		{ 
			Double t0,t1, totaltime;
			t0 = (double)System.currentTimeMillis();
			if (type == 'l')
			{
				InsertionTest.sortLinear(x);
				t1 = (double)System.currentTimeMillis();
				totaltime = (t1-t0)/1000;
				if (pass == 0)
				{
					if (finalTest(x))
						System.out.println("For " + x.length + " objects in order, the Linear Search sort time is " + totaltime + " seconds; Sorting verified.");
					else
						System.out.println("For " + x.length + " objects in order, the Linear Search sort time is " + totaltime + " seconds; Sorting not verified.");
				}

				else if (pass == 1)
				{
					if (finalTest(x))
						System.out.println("For " + x.length + " objects in reversed order, the Linear Search sort time is " + totaltime + " seconds; Sorting verified.");
					else
						System.out.println("For " + x.length + " objects in reversed order, the Linear Search sort time is " + totaltime + " seconds; Sorting not verified.");
				}

				else if(pass == 2)
				{
					if (finalTest(x))
						System.out.println("For " + x.length + " objects in random order, the Linear Search sort time is " + totaltime + " seconds; Sorting verified.");
					else
						System.out.println("For " + x.length + " objects in random order, the Linear Search sort time is " + totaltime + " seconds; Sorting not verified.");
				}
				
			}
				
			else if (type == 'b')
			{
				InsertionTest.sortBinary(x);
				t1 = (double)System.currentTimeMillis();
				totaltime= (t1-t0)/1000;
				if (pass == 0)
				{
					if (finalTest(x))
						System.out.println("For " + x.length + " objects in order, the Binary Search sort time is " + totaltime + " seconds; Sorting verified.");
					else
						System.out.println("For " + x.length + " objects in order, the Binary Search sort time is " + totaltime + " seconds; Sorting not verified.");
				}

				else if (pass == 1)
				{
					if (finalTest(x))
						System.out.println("For " + x.length + " objects in reversed order, the Binary Search sort time is " + totaltime + " seconds; Sorting verified.");
					else
						System.out.println("For " + x.length + " objects in reversed order, the Binary Search sort time is " + totaltime + " seconds; Sorting not verified.");
				}

				else if (pass ==2)
				{
					if (finalTest(x))
						System.out.println("For " + x.length + " objects in random order, the Binary Search sort time is " + totaltime + " seconds; Sorting verified.");
					else
						System.out.println("For " + x.length + " objects in random order, the Binary Search sort time is " + totaltime + " seconds; Sorting not verified.");
				}
			}	 
		}

		public static boolean finalTest(Comparable[] x)
		{
			for (int i=0; i<x.length-1; i++)
			{
				if (x[i].compareTo(x[i+1]) > 0 )
					return false;
			}
			return true;
		}
}