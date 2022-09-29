import java.awt.Color;
import java.awt.Point;

/*A class that models a Triangle.*/
public class Triangle implements Shape
{
	private Point a;
	private Point b;
	private Point c;
	private Color color;
	private boolean filled;

	public Triangle(Point a, Point b, Point c, Color color, boolean filled)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
		this.filled = filled;
	}

	public Point getVertexA()
	{
		return a;
	}

	public Point getVertexB()
	{
		return b;
	}

	public Point getVertexC()
	{
		return c;
	}

	public void setVertexA(Point a)
	{
		this.a = a;
	}

	public void setVertexB(Point b)
	{
		this.b = b;
	}

	public void setVertexC(Point c)
	{
		this.c = c;
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

		Triangle t = (Triangle)other;

		return a.equals(t.a) && b.equals(t.b) && c.equals(t.c) && color.equals(t.color) && filled == t.filled; 
	}


	public double getArea()
	{
		double A, B, C;
		A = Math.sqrt(Math.pow(b.x-a.x, 2)+ Math.pow(b.y-a.y, 2));
		B = Math.sqrt(Math.pow(c.x-b.x, 2)+ Math.pow(c.y-b.y, 2));
		C = Math.sqrt(Math.pow(a.x-c.x, 2)+ Math.pow(a.y-c.y, 2));
		return Math.sqrt(((A+B+C)/2)*(((A+B+C)/2)-A)*(((A+B+C)/2)-B)*(((A+B+C)/2)-C));
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
		int axCoor, ayCoor, bxCoor, byCoor, cxCoor, cyCoor;
		axCoor = a.x + point.x;
		ayCoor = a.y + point.y;
		bxCoor = b.x + point.x;
		byCoor = b.y + point.y;
		cxCoor = c.x + point.x;
		cyCoor = c.y + point.y;
		
		a.move(axCoor, ayCoor);
		b.move(bxCoor, byCoor);
		c.move(cxCoor, cyCoor);
	}
}