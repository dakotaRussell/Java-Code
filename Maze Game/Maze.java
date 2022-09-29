import java.lang.reflect.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/** 
 * Maze.java
 * Maze Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Dakota Dehn Section 5
 * @version May 2, 2014
 */

public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] maze;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */

   public Maze()
   {
      randOccupants = new ArrayList<RandomOccupant>();
   }

   public Maze(Square[][] maze, int rows, int cols)
   {
      //initialize the maze, rows, and cols instance variables
         this.maze = new Square[rows][cols];
   		this.maze = maze;
   		this.rows = rows;
   		this.cols = cols;
		
      // create the empty ArrayList of RandomOccupants
   		randOccupants = new ArrayList<RandomOccupant>();	
   }

   public void writeMazeToFile(String fileName) throws IOException
   {
      PrintStream out = new PrintStream(new File(fileName));

         out.println(rows + "," + cols);

         for (int i=0; i<rows; i++)
         {
            for (int j=0; j<cols; j++)
            {
               out.println(maze[i][j].toText(','));
            }
         }

         out.println(explorer.toText(','));

         for (int k=0; k<getNumRandOccupants(); k++)
         {
            out.println(getRandomOccupant(k).toText(','));
         }
   }
	

   public void readMazeFromFile(String fileName) throws IOException, MazeReadException, FileNotFoundException
   {
      Scanner scanner = new Scanner(new File(fileName));
      Scanner linescan;
      String line;
      int lineNum = 1;

      line = scanner.nextLine();
      linescan = new Scanner(line);
      linescan.useDelimiter(",");

      try
      {
         rows = linescan.nextInt();
         cols = linescan.nextInt();
         maze = new Square[rows][cols]; 
      }
      
      catch (Exception e)
      {
         throw new MazeReadException("Rows and columns not specified.", line, lineNum);
      }

      while (scanner.hasNext())
      {
         
         lineNum++;
         line = scanner.nextLine();
         linescan = new Scanner(line);
         linescan.useDelimiter(",");
         String type;

         try {
            type = linescan.next();
         }
         catch (Exception e)
         {
            throw new MazeReadException("Line format or other error.", line, lineNum);
         }

         if (type.equals("Square"))
         { 
            int tempRow = linescan.nextInt();
            int tempCol = linescan.nextInt();

            if (getSquare(tempRow, tempCol) != null)
            {
               throw new MazeReadException("Duplicate square.", line,lineNum);
            }

            else
            {
               Square temp = new Square(tempRow, tempCol);
               temp.toObject(linescan);
               maze[tempRow][tempCol] = temp;
            }
         }

         else if(type.equals("Monster"))
         {
            try
            {
               Monster monster = new Monster(this);
               monster.toObject(linescan);
               addRandomOccupant(monster);
            }
            catch (Exception e)
            {
               throw new MazeReadException("Line format or other error.", line, lineNum);
            }
         }

         else if(type.equals("Explorer"))
         {
            try
            {
               Explorer explorer = new Explorer(this);
               explorer.toObject(linescan);
               this.explorer = explorer;
            }
            catch (Exception e)
            {
               throw new MazeReadException("Line format or other error.", line, lineNum);
            }
         }

         else if(type.equals("Treasure"))
         {
            try
            {
               Treasure treasure = new Treasure(this);
               treasure.toObject(linescan);
               addRandomOccupant(treasure);
            }
            catch (Exception e)
            {
               throw new MazeReadException("Line format or other error.", line, lineNum);
            }
         }

         else
         {
            throw new MazeReadException("Unknown type.", line, lineNum);
         }

      /*catch(Exception e)
      {
         throw new MazeReadException("Line format or other error.", line, lineNum);
      }*/
            
      }
   }

   // QUERIES
   public Square getSquare(int row, int col) 
	{ 
		return maze[row][col]; 
	}
   
   public int rows() 
   {
		return rows;
   }

   public int cols() 
   {
   	return cols;
   }

   public String explorerName() 
	{
   	return explorer.name();
   }

   public Explorer getExplorer()
	{
		return explorer;
	}
    
   //Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   //          Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) 
	{
		return randOccupants.get(index);
	}

   public int getNumRandOccupants() 
	{
		return randOccupants.size();
   }
	
   // COMMANDS
   // implement the following method
   public void addRandomOccupant(RandomOccupant ro) 
   {
   	randOccupants.add(ro);
   }
   
   public void setExplorer(Explorer e) 
	{
   		explorer = e;
   }
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
      // CHANGE - instruct each object in the RandomOccupant to move
      for (int i=0; i<getNumRandOccupants(); i++)
      {
         this.getRandomOccupant(i).move();
      }
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *   it is in the same location as the Explorer, return
    *   MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
		int status = ACTIVE;
        
      // implement
		if (foundAllTreasures())
		{
   		status = EXPLORER_WIN;
   	}

   	else
   	{
			for (int i=0; i<getNumRandOccupants(); i++)
			{
   			if (this.getRandomOccupant(i).location() == explorer.location() && this.getRandomOccupant(i) instanceof Monster)
   			{
   				status = MONSTER_WIN;
   			}
			}   		
      }

   	return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      // search through all the occupants to see if the Treasures have been found.  Return false if
      //        - there is a Treasure that hasn't been found.
      for (int i=0; i<getNumRandOccupants(); i++)
      {
      	if (this.getRandomOccupant(i) instanceof Treasure)
      	{
            if(!(((Treasure)(this.getRandomOccupant(i))).found()))
            {
               foundAll = false;
            }
      		
      	}
      }
              
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
        
      //Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
      //        - Check the diagonal squares.  If there isn't a wall in the way, set their inview to true.

      if (!s.wall(Square.UP))
      {
         getSquare(row-1,col).setInView(true);
         if (!getSquare(row-1,col).wall(Square.LEFT))
         {
            getSquare(row-1,col-1).setInView(true);
         }

         if(!getSquare(row-1,col).wall(Square.RIGHT))
         {
            getSquare(row-1,col+1).setInView(true);
         }  
      }

      if(!s.wall(Square.RIGHT))
      {
         getSquare(row,col+1).setInView(true);
         if (!getSquare(row,col+1).wall(Square.UP))
         {
            getSquare(row-1,col+1).setInView(true);
         }
         if (!getSquare(row,col+1).wall(Square.DOWN))
         {
            getSquare(row+1,col+1).setInView(true);
         }
      }

      if(!s.wall(Square.DOWN))
      {
         getSquare(row+1,col).setInView(true);
         if (!getSquare(row+1,col).wall(Square.LEFT))
         {
            getSquare(row+1,col-1).setInView(true);
         }
         if (!getSquare(row+1,col).wall(Square.RIGHT))
         {
            getSquare(row+1,col+1).setInView(true);
         }
      }

      if(!s.wall(Square.LEFT))
      {
         getSquare(row,col-1).setInView(true);
         if (!getSquare(row,col-1).wall(Square.UP))
         {
            getSquare(row-1,col-1).setInView(true);
         }
         if (!getSquare(row,col-1).wall(Square.DOWN))
         {
            getSquare(row+1,col-1).setInView(true);
         }
      }
   }
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) 
      {
         for (int j = 0; j<cols; j++) 
         {
            maze[i][j].setInView(false);
         }
      }
   }
}