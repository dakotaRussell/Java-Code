/**
 *
 * @author Dakota Dehn
 * @version Lab 01
 * @version CPE102-05
 * @version Spring 2014
 */
 
 /**
 * A simple integer counter.
 */
public class Counter 
{
  
  private int count;
  private int max;
  public int previousCount;
  
  // Constructors:
  
  /**
   * Create a new Counter, with the count initialized
   * to 0.
   */
  public Counter (int max) 
  {	
	this.max = max;
    count = 0;
	
  }
  
  // Queries (Accessors):
  
  /**
   * The number of items counted.
   */
  public int currentCount () 
  {
    return count;
  }
  
  // Commands (Mutators):
  
  /**
   * Increment the count by 1.
   */
  public void incrementCount () 
  {
    count = count + 1;
	if (count == max)
	{
		count = 0;
	}
  }
  
  /**
   * Reset the count to 0.
   */
  public void reset () 
  {
	previousCount = count;
    count = 0;
  }
  
  public void unreset()
  {
	count = previousCount;
  }
}