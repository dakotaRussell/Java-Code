import java.awt.Color;
import java.awt.Point;

/*A class that models a Rectangle.*/
public class Rectangle implements Shape
{
	private double width;
	private double height;
	private Point position;
	private Color color;
	private boolean filled;

	public Rectangle(double width, double height, Point position, Color color, boolean filled)
	{
		this.width = width;
		this.height = height;
		this.position = position;
		this.color = color;
		this.filled = filled;
	}

	public double getWidth()
	{
		return width;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
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

		Rectangle r = (Rectangle)other;

		return height == r.height && width == r.width && position.equals(r.position) && color.equals(r.color) && filled == r.filled; 
	}

	public double getArea()
	{
		return width*height;
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
		xCoor = position.x + point.x;
		yCoor = position.y + point.y;
		position.move(xCoor, yCoor);
	}
}



