import java.awt.*;

public class CircleTest
{
	public static void main(String[] args)
	{
		try
		{
			CirclePlease c1 = new CirclePlease(-2);
			System.out.println(c1);
		}
		catch (CircleException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}


