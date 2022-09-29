/**
 * DrawableMonster.java
 * Drawable Monster Class that contains all the logic to model a DrawableMonster which implements the Drawable interface.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */

public class DrawableMonster extends Monster implements Drawable
{
	public DrawableMonster(Maze maze)
	{
		super(maze);
	}

	public DrawableMonster(Maze maze, long seed)
	{
		super(maze, seed);
	}

	public DrawableMonster(Maze maze, Square location)
	{
		super(maze, location);
	}
	public void draw()
	{
		pushMatrix();
		translate(location().x(), location().y());
  		color skin= color(FFCD73);
  
  		//head
  		noStroke();
  		fill(skin);
  		ellipse(0,1,30,38);
  		fill(150);
  		ellipse(0,1,29,34);
  		fill(skin);
 		ellipse(0,-2,30,36);
  
  		//ears
  		translate(-16,0);
  		ellipse(0,0,6,10);
  		translate(32,0);
  		ellipse(0,0,6,10);
  
  		//eyes
  		translate(-16,0);
  		fill(255);
  		ellipse(-6,-4,8,5);
  		ellipse(6,-4,8,5);
  		fill(3AA6D0);
  		ellipse(-6,-4,4,5);
  		ellipse(6,-4,4,5);
  		fill(0);
  		ellipse(-6,-4,1,2);
  		ellipse(6,-4,1,2);
  
  		//glasses
  		noFill();
  		stroke(0);
  		rect(-12,-7,10,5);
  		rect(1,-7,10,5);
  		line(-12,-5,-15,-6);
  		line(12,-5,15,-6);
  
  		//nose
  		line(0,-5,-3,2);
  		line(-3,2,2,2);
  
  		//lips
  		noStroke();
  		fill(FF9581);
  		rect(-5,9,10,2.5);
  		triangle(-5,9,-2,8,0,9);
  		triangle(5,9,2,8,0,9);
  
  		//hair
  		fill(8353A3);
  		triangle(-17,-4,-15,-15,-6,-20);
  		triangle(17,-4,15,-15,6,-20);
  		ellipse(0,-19,18,2);
  		ellipse(0,-18,10,4);
  		popMatrix();
	}
}