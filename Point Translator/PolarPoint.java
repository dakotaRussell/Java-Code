/**
 *
 * @author Dakota Dehn
 * @version Project1
 * @version CPE102-05
 * @version Spring 2014
 */

public class PolarPoint implements Point
{
	private double radius;
	private double angle;

	public PolarPoint(double radius, double angle)
	{
		this.radius=radius;
		this.angle=angle;
	}

	public double xCoordinate()
	{
		return radius*Math.cos(angle);
	}

	public double yCoordinate()
	{
		return radius*Math.sin(angle);
	}

	public double radius()
	{
		return radius;
	}

	public double angle()
	{
		return angle;
	}

	public double distanceFrom(Point other)
	{
		if (angle < other.angle())
		{
			return Math.sqrt(Math.pow(radius, 2) + Math.pow(other.radius(), 2) - 2*radius*other.radius()*Math.cos(other.angle()-angle));
		}
		else
		{
			return Math.sqrt(Math.pow(radius, 2) + Math.pow(other.radius(), 2) - 2*radius*other.radius()*Math.cos(angle-other.angle()));

		}
		
	}

	public Point rotate90()
	{
		return new PolarPoint(radius, angle+Math.PI/2);
	}
}