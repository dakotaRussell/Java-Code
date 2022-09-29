/**
 * DrawableTreasure.java
 * Drawable Treasure Class that contains all the logic to model a DrawableTreasure which implements the Drawable interface.
 * 
 * @author Dakota Dehn  Section 5
 * @version May 2, 2014
 */

public class DrawableTreasure extends Treasure implements Drawable
{
	public DrawableTreasure(Maze maze)
	{
		super(maze);
	}

	public DrawableTreasure(Maze maze, long seed)
	{
		super(maze, seed);
	}

	public DrawableTreasure(Maze maze, Square location)
	{
		super(maze, location);
	}

	public void draw() 
	{
		pushMatrix();
  		translate(location().x(), location().y());
  
  		fill(EEC393);
  		ellipse(0,-15,14,14);
  
  		fill(230);
  		arc(0,23,46,57,PI,2*PI,CHORD);
  		noStroke();
  		rect(-5,-12,10,14);
  		ellipse(0,-12,16,4);
  
  		fill(3ADE57);
  		rect(-14,2,28,19);
  		fill(0);
  		textSize(8.2);
  		text("Patron",-13,15);
  
  		popMatrix();
	}
}