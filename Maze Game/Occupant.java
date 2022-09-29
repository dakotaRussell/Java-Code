/**
 * Occupant.java
 * Occupant Class that contains all the logic to model an Occupant within a Maze game.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */
import java.lang.reflect.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public abstract class Occupant implements DelimitedTextIO
{
	private Square location;

	public Occupant()
	{}

	public Occupant(Square start)
	{
		location = start;
	}

	public Square location()
	{
		return location;
	}

	public void moveTo(Square newLoc)
	{
		location = newLoc;
	}

	public String toText(char delimiter)
	{
		return getClass().getName() + delimiter + location.row() + delimiter + location.col();
	}

	public abstract void toObject(Scanner input);
}