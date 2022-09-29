/**
 * Monster.java
 * Monster Class that contains all the logic to model a Monster that extends the Random Occupant class.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */

import java.lang.reflect.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Monster extends RandomOccupant
{
	public Monster(Maze maze)
	{
		super(maze);
	}

	public Monster(Maze maze, long seed)
	{
		super(maze, seed);
	}

	public Monster(Maze maze, Square location)
	{
		super(maze, location);
	}
}