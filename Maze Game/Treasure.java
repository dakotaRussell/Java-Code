/**
 * Treasure.java
 * Treasure Class that contains all the logic to model a Treasure occupant in a maze which extends the RandomOccupant class.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */

import java.lang.reflect.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Treasure extends RandomOccupant
{
	private boolean found;

	public Treasure(Maze maze)
	{
		super(maze);
		found = false;
		location().setTreasure(this);
	}

	public Treasure(Maze maze, long seed)
	{
		super(maze,seed);
		found = false;
		location().setTreasure(this);
	}

	public Treasure(Maze maze, Square location)
	{
		super(maze, location);
		found = false;
		location().setTreasure(this);
	}

	public boolean found()
	{
		return found;
	}

	public void setFound()
	{
		found = true;
	}

	public void move()
	{}

	public void moveTo(Square newLoc)
	{
		if (this.location() != null)
			this.location().setTreasure(null);

		super.moveTo(newLoc);
		newLoc.setTreasure(this);
	}

	public String toText(char delimiter)
	{
		return super.toText(delimiter) + delimiter + found;
	}

	public void toObject(Scanner input)
	{
		super.toObject(input);
		found = input.nextBoolean();
	}
}