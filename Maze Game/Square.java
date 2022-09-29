/**
 * Square.java
 * Square Class that contains all the logic to model a Square in a Maze game.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */

import java.lang.reflect.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Square implements DelimitedTextIO
{
	public static final int SQUARE_SIZE = 50;
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2; 
	public static final int LEFT = 3;
	private boolean[] walls = new boolean[4];
	private boolean seen; 
	private boolean inView;
	private int row; 
	private int col;
	private Treasure treasure;

	public Square(int row, int col)
	{
		this.row = row;
		this.col = col;
	}

	public Square (boolean up, boolean right, boolean down, boolean left, int row, int col)
	{
		walls[UP] = up;
		walls[RIGHT] = right;
		walls[DOWN] = down; 
		walls[LEFT] = left;
		this.row = row;
		this.col = col;
		seen = false;
		inView = false;
		treasure = null;
	}

	public boolean wall(int direction)
	{
		return walls[direction];
	}

	public boolean seen()
	{
		return seen;
	}

	public boolean inView()
	{
		return inView;
	}

	public int row()
	{
		return row;
	}

	public int col()
	{
		return col;
	}

	public Treasure treasure()
	{
		return treasure;
	}

	public int x()
	{
		return (col % SQUARE_SIZE) * SQUARE_SIZE;
	}

	public int y()
	{
		return (row % SQUARE_SIZE) * SQUARE_SIZE;
	}

	public void setInView(boolean inView)
	{
		this.inView = inView;
		if (inView)
		{
			seen = true;
		}
	}

	public void setTreasure(Treasure t)
	{
		treasure = t;
	}

	public void enter()
	{
		if (treasure != null)
		{
			treasure.setFound();
		}
	}

	public String toText(char delimiter)
	{
		return getClass().getName() + delimiter + row + delimiter + col + delimiter + walls[UP] + delimiter + walls[RIGHT] + delimiter + walls[DOWN] + delimiter + walls[LEFT] + delimiter + seen + delimiter + inView;
	}

	public void toObject(Scanner input)
	{
		walls[UP] = input.nextBoolean();
		walls[RIGHT] = input.nextBoolean();
		walls[DOWN] = input.nextBoolean();
		walls[LEFT] = input.nextBoolean();
		seen = input.nextBoolean();
		inView = input.nextBoolean();
	}
}