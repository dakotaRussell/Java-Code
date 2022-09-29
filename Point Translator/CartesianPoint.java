/**
 *
 * @author Dakota Dehn
 * @version Project1
 * @version CPE102-05
 * @version Spring 2014
 */

public class CartesianPoint implements Point
{
	//instance variables
	private double xCoordinate;
	private double yCoordinate;

	public CartesianPoint(double xCoordinate, double yCoordinate)
	{
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	} 

	public double xCoordinate()
	{
		return xCoordinate;
	}

	public double yCoordinate()
	{
		return yCoordinate;
	}

	public double radius()
	{
		return Math.sqrt(Math.pow(xCoordinate, 2)+ Math.pow(yCoordinate, 2));
	}

	public double angle()
	{
		return Math.atan2(yCoordinate,xCoordinate);
		
	}

	public double distanceFrom(Point other)
	{
		return Math.sqrt(Math.pow((other.xCoordinate() - xCoordinate), 2) + Math.pow((other.yCoordinate() - yCoordinate), 2));
	}

	public Point rotate90()
	{
		return new CartesianPoint(-yCoordinate, xCoordinate);
	}

}