import java.lang.reflect.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

/**
 * RandomOccupant.java
 * RandomOccupant Class that contains all the logic to model a Random Occupant that extends the Occupant class.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */

public abstract class RandomOccupant extends Occupant
{
	private Random random;
	private Maze maze;

	public RandomOccupant(Maze maze)
	{
		super();
		this.maze = maze;
		random = new Random();
		int row, col;
		row = random.nextInt(maze.rows());
		col = random.nextInt(maze.cols());
		moveTo(maze.getSquare(row,col));
	}

	public RandomOccupant (Maze maze, long seed)
	{
		super();
		random = new Random(seed);
		this.maze = maze;
		int row, col;
		row = random.nextInt(maze.rows());
		col = random.nextInt(maze.cols());
		moveTo(maze.getSquare(row,col));
	}

	public RandomOccupant(Maze maze, Square location)
	{
		super(location);
		this.maze = maze;
		random = new Random();
	}

	public void move()
	{
		int row, col, direction;
		boolean done = false;
		row = super.location().row();
		col = super.location().col();
		while (!done)
		{
			direction = random.nextInt(4);

			if (!super.location().wall(direction))
			{
				done = true;
				if (direction == Square.UP)
				{
					row--;
				}
				else if (direction == Square.RIGHT)
				{
					col++;
				}
				else if (direction == Square.DOWN)
				{
					row++;
				}
				else if (direction == Square.LEFT)
				{
					col--;
				}
			}
		}
		moveTo(maze.getSquare(row,col));
	}


	public void toObject(Scanner input)
	{
		int row, col;
		row = input.nextInt();
		col = input.nextInt();
		moveTo(maze.getSquare(row,col));
	}
}