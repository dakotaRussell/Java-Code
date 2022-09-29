/**
 * DrawableSquare.java
 * Drawable Square Class that contains all the logic to model a DrawableSquare which implements the Drawable interface.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */

public class DrawableSquare extends Square implements Drawable
{
	public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col)
	{
		super(up, right, down, left, row, col);
	}

	public void draw()
	{
		pushMatrix();
		translate(x(),y());
		if (inView())
		{
  			fill(255);
  			rect(0,0,50,50);
  			fill(#28417A);
  			for (int i=0; i<50; i+=5)
  			{
    			  for(int j=0; j<50; j+=10)
    			  {
      				rect(i,j,2,6);
    			  }
  			}

			if (wall(Square.UP))
			{
				stroke(230);
  				fill(#61100C);
 				rect(0,0,16.6,5);
  				rect(16.7,0,16.6,5);
  				rect(50-16.7,0,16.5,5);
			}

			if (wall(Square.LEFT))
			{
				stroke(230);
  				fill(#61100C);
 				rect(0,0,5,16.6);
  				rect(0,16.7,5,16.6);
  				rect(0,50-16.7,5,16.5);
			}

			if (wall(Square.DOWN))
			{
				stroke(230);
  				fill(#61100C);
 				rect(0,45,16.6,5);
  				rect(16.7,45,16.6,5);
  				rect(50-16.7,45,16.5,5);
			}

			if (wall(Square.RIGHT))
			{
				stroke(230);
  				fill(#61100C);
 				rect(45,0,5,16.6);
  				rect(45,16.7,5,16.6);
  				rect(45,50-16.7,5,16.5);
			}
		}
		
		else if (seen() && !inView())
		{
			fill(160);
  			rect(0,0,50,50);
  			fill(#08132D);
  			for (int i=0; i<50; i+=5)
  			{
    			for(int j=0; j<50; j+=10)
    			{
      				rect(i,j,2,6);
    			}
  			}

			if (wall(Square.UP))
			{
				stroke(200);
  				fill(#330500);
 				rect(0,0,16.6,5);
  				rect(16.7,0,16.6,5);
  				rect(50-16.7,0,16.5,5);
			}

			if (wall(Square.LEFT))
			{
				stroke(200);
  				fill(#330500);
 				rect(0,0,5,16.6);
  				rect(0,16.7,5,16.6);
  				rect(0,50-16.7,5,16.5);
			}

			if (wall(Square.DOWN))
			{
				stroke(200);
  				fill(#330500);
 				rect(0,45,16.6,5);
  				rect(16.7,45,16.6,5);
  				rect(50-16.7,45,16.5,5);
			}

			if (wall(Square.RIGHT))
			{
				stroke(200);
  				fill(#330500);
 				rect(45,0,5,16.6);
  				rect(45,16.7,5,16.6);
  				rect(45,50-16.7,5,16.5);
			}
		}
                popMatrix();
	}
}
