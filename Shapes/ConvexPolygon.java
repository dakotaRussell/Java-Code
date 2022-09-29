import java.awt.Color;
import java.awt.Point;

/*A class that models a Convex Polygon.*/
public class ConvexPolygon implements Shape
{
	private Point[] vertices;
	private Color color;
	private boolean filled;

	public ConvexPolygon(Point[] vertices, Color color, boolean filled)
	{
		this.vertices = vertices;
		this.color = color;
		this.filled = filled;
	}

	public Point getVertex(int index)
	{
		return vertices[index];
   }

	public void setVertex(int index, Point point)
	{
		vertices[index] = point;
	}

	public double getArea()
	{
		double area=0;
		for (int i=0; i<(vertices.length)-1; i++)
		{
			area += ((vertices[i].x)*(vertices[i+1].y))-((vertices[i+1].x)*(vertices[i].y));
		}

		area += (vertices[vertices.length-1].x)*(vertices[0].y)-(vertices[0].x)*(vertices[vertices.length-1].y);

		return .5*area;
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

		ConvexPolygon o = (ConvexPolygon)other;
		boolean truthValue = true;
      
		for (int i=0; i<vertices.length; i++)
		{
			truthValue = vertices[i].x == o.vertices[i].x && vertices[i].y == o.vertices[i].y;
			if (truthValue == false)
			{
				return false;
			}
		}
      
      return truthValue && color.equals(o.color) && filled == o.filled;
	}

	public void setFilled(boolean filled)
	{
		this.filled = filled;
	} 

	public void move(Point point)
	{
		for (int i=0; i<vertices.length; i++)
		{
			int xCoor, yCoor;
			xCoor = vertices[i].x + point.x;
			yCoor = vertices[i].y + point.y;
			vertices[i].move(xCoor, yCoor);
		}
	}
}