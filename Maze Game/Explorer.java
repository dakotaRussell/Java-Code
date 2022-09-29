import java.lang.reflect.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/** 
 * Explorer.java
 * Explorer Class that contains all the logic to model a Explorer in a Maze, extending the Occupant class.
 * 
 * @author Dakota Dehn  Section 5
 * @version May 2, 2014
 */

public class Explorer extends Occupant
{
	private String name;
	private Maze maze;

	public Explorer(Maze maze)
	{
		this.maze = maze;
	}

	public Explorer(Square location, Maze maze, String name)
	{
		super(location);
		this.maze = maze;
		this.name = name;
		maze.lookAround(location);
	}

	public String name()
	{
		return name;
	}

	public void move(int key)
	{
		//query for location
		int row;
		int col;
		row = location().row();
		col = location().col();
		int dir = 0;
		//check to see if there is a wall in the direction
		if (key == KeyEvent.VK_KP_UP || key == KeyEvent.VK_UP)
		{
			row-=1;
			dir = Square.UP;
		}

		else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT)
		{
			col+=1;
			dir = Square.RIGHT;
		}

		else if (key == KeyEvent.VK_KP_DOWN || key == KeyEvent.VK_DOWN)
		{
			row+=1;
			dir = Square.DOWN;
		}

		else if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT)
		{
			col-=1;
			dir= Square.LEFT;
		}


		if (!super.location().wall(dir))
		{
			moveTo(maze.getSquare(row,col));
		}

		
		// adjust row/col if there is no wall 
		// move Explorer
	}

	public void moveTo(Square s)
	{
		super.moveTo(s);
		s.enter();
		maze.lookAround(s);
	}


	public String toText(char delimiter)
	{
		return super.toText(delimiter) + delimiter + name;
	}

	public void toObject(Scanner input)
	{
		int row, col;
		row = input.nextInt();
		col = input.nextInt();
		moveTo(maze.getSquare(row,col));
		name = input.next();
	}
}