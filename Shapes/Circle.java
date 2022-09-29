import java.awt.Color;
import java.awt.Point;

/*A class that models a Circle.*/
public class Circle implements Shape
{
	//instance variables
	private double radius;
	private Point position;
	private Color color;
	private boolean filled;

	//constructor
	public Circle(double radius, Point position, Color color, boolean filled)
	{
		this.radius = radius;
		this.position = position;
		this.color = color;
		this.filled = filled;
	}

	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	public Point getPosition()
	{
		return position;
	}

	public boolean equals(Object other)
	{
		if (other == null)
		{
			return false;
		}

		if(!this.getClass().equals(other.getClass()))
		{
			return false;
		}

		Circle c = (Circle)other;

		return radius == c.radius && position.equals(c.position) && color.equals(c.color) && filled == c.filled; 
	}

	public double getArea()
	{
		return radius*radius*(double)Math.PI;
	} 

	public Color getColor()
	{
		return color;
	} 

	public void setColor(Color color)
	{
		this.color = color;
	} 

	public boolean getFilled()
	{
		if (filled)
		{
			return true;
		}

		else
		{
			return false;
		}
	} 

	public void setFilled(boolean filled)
	{
		this.filled = filled;
	} 

	public void move(Point point)
	{
		int xCoor, yCoor;
		xCoor = (int)position.getX() + point.x;
		yCoor = (int)position.getY() + point.y;
		position.move(xCoor, yCoor);
	}
}