import java.awt.*;

public class ZeroRadiusException extends CircleException
{
	public ZeroRadiusException()
	{
		super("zero radius");
	}
}