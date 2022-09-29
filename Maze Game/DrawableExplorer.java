/**
 * DrawableExplorer.java
 * DrawableExplorer Class that contains all the logic to model a DrawableExplorer which implements the Drawable interface.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */

public class DrawableExplorer extends Explorer implements Drawable
{
	public DrawableExplorer(Square location, Maze maze, String name)
	{
		super(location, maze, name);
	}

	public void draw()
	{
		pushMatrix();
  		translate(location().x(), location().y());
  		color skin= color(FFCD73);
  
  		//head
  		noStroke();
  		fill(skin);
  		ellipse(0,0,26,37);
  		//fill(0);
 		 translate(-9,5);
  		rotate(-PI/13);
  		ellipse(0,0,10,17);
  		rotate(PI/13);
  		translate(18,0);
  		rotate(PI/13);
  		ellipse(0,0,10,17);
  		rotate(-PI/13);
  		translate(-9,0);
  
 		 //ears
  		ellipse(-14,-5,7,10);
  		ellipse(13,-5,7,10);
  		fill(100);
  		ellipse(-15,-2,3,3);
  		ellipse(15,-2,3,3);
  
  		//eyes
  		stroke(0);
  		fill(255);
  		ellipse(-5,-8,9,5);
  		ellipse(5,-8,9,5);
  		noStroke();
  		fill(3ABBD9);
  		ellipse(-5,-8,4,5);
  		ellipse(5,-8,4,5);
  		fill(0);
  		ellipse(-5,-8,1,2);
  		ellipse(5,-8,1,2);
  		fill(skin);
  		translate(-6,-5.2);
  		rotate(PI/18);
  		ellipse(0,0,9,3);
  		rotate(-PI/18);
  		translate(12,0);
  		rotate(-PI/18);
  		ellipse(0,0,9,3);
  		rotate(PI/18);
  		translate(-6,5.2);
  		fill(0);
  		triangle(-11,-10,-8,-9,-9,-6);
  		triangle(11,-10,8,-9,9,-6);
  
  		//eyebrows
  		fill(533418);
  		arc(-5.5,-12,9,3,PI,2*PI);
  		arc(5.5,-12,9,3,PI,2*PI);

  		//nose
  		stroke(0);
  		line(0,-10,-3,-1);
  		line(-3,-1,2,-1);
  		noStroke();
  		fill(skin);
  		ellipse(-3,-1,1.5,1.5);
  
  		//mouth
  		fill(9A1613);
  		arc(0,3.5,12,12,0,PI,CHORD);
  		noStroke();
  		fill(0);
  		arc(0,3.5,10,6,0,PI,CHORD);
  		fill(255);
  		arc(0,3.5,10,4,0,PI,CHORD);
  
  		//hair
  		fill(533418);
  		triangle(-14,-7,-12,-22,-8,-22);
  		triangle(14,-7,11,-23,5,-22);
  		triangle(-13,-20,-5,-27,13,-20);
  		ellipse(-5,-25,8,5);
  
  		popMatrix();
	}
}