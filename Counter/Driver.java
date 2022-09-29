/**
 *
 * @author Dakota Dehn
 * @version Lab 01
 * @version CPE102-05 
 * @version Spring 2014
 */

public class Driver
{ 
	public static void main(String[] args)
	{
		// Declare and test a Counter object ...
		Counter ct = new Counter(4);

		// some sample tests
		System.out.println("Initial count: " + ct.currentCount());
		ct.incrementCount();
		System.out.println("Incremented once: " + ct.currentCount());

		// more tests...
		ct.reset();
		System.out.println("Reset: " + ct.currentCount());
		ct.unreset();
		System.out.println("Unreset: " + ct.currentCount());
		ct.incrementCount();
		ct.incrementCount();
		System.out.println("Incremented twice: " + ct.currentCount());
		ct.incrementCount();
		System.out.println("Incremented thrice: " + ct.currentCount());
    }
}