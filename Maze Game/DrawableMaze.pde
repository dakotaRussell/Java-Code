/**
 * DrawableMaze.java
 * DrawableMaze Class that contains all the logic to model a DrawableMaze with Treasures, Monsters, and an Explorer that implements Drawable interface.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */

public class DrawableMaze extends Maze implements Drawable
{
	public DrawableMaze(DrawableSquare[][] maze, int rows, int cols)
	{
		super(maze, rows, cols);
	}
	public void draw() 
	{
		fill(70);
		rect(0,0,500,500);

		for(int i=0; i<rows(); i++)
		{
			for(int j=0; j<cols(); j++)
			{
				((DrawableSquare)getSquare(i,j)).draw();
			}
		}
                
                for(int i=0; i<getNumRandOccupants(); i++)
                {
                  ((Drawable)(this.getRandomOccupant(i))).draw();
                }
                
                ((Drawable)getExplorer()).draw();
                
                
                  
	}
}
