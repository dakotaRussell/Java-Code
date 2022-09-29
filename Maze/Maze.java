//Dakota Dehn CPE 103

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.Iterator;
import javax.swing.*;
import java.util.Scanner;
import java.io.File;

public class Maze extends Applet {
   
   // array that holds the maze info
   private int[][] maze;

   //number of rows and colsumns in the maze
   private int rows, cols;

   private int startX, startY, endX, endY, x, y; 

   //number of clicks the user makes on the game to produce start and end blocks
   private int clickCount = 0;

   //number of times the "GO" button is pushed
   private int buttonCount = 0;

   //the "GO" button that will be repeatedly clicked
   private JButton takeAction;

   //graph keeping track of possible paths
   private Graph myGraph;

   // initial size of maze - if bigger may go off window
   private final int MAXROWS = 20;
   private final int MAXCOLS = 30;
   
   // size of each block in pixels
   private final int blkSize = 20;
   
   //inner class that displays the maze
   private MazeCanvas mazeField;

   // everything is put on this panel   
   private JPanel mazePanel;

   // label, textfield, string, and load button for the file
   private JLabel fileLabel;
   private JTextField fileText;
   String fileName;
   private JButton fileButton;
   
   //this listener object responds to button events
   private ButtonActionListener buttonListener;
   private MouseEventListener mouseListener;

   // this method sets up the canvas and starts it off
   public void init() {
      System.out.println("Maze started"); // goes to console 
      
      mouseListener = new MouseEventListener();
      buttonListener = new ButtonActionListener();
               
      // the mazePanel is the panel that contains the maze interfaces, including
      // the buttons and output display
      mazePanel = new JPanel();
      // Y_AXIS layout places components from top to bottom, in order of adding
      mazePanel.setLayout(new BoxLayout(mazePanel, BoxLayout.Y_AXIS));
      
      // components for loading the filename
      fileLabel = new JLabel("File name:");
      mazePanel.add(fileLabel);
      fileText = new JTextField("", 20);
      mazePanel.add(fileText);
      fileButton = new JButton("Load File");
      mazePanel.add(fileButton);
      fileButton.addActionListener(buttonListener);

      // this is where the maze is drawn
      // if you add more to this layout after the mazeField, 
      //   it may be below the bottom of the window, depending on window size
      mazeField = new MazeCanvas();
      mazePanel.add(mazeField);
      mazeField.addMouseListener(mouseListener);

      takeAction = new JButton("GO");
      // the listener is triggeble when the button is clicked
      mazePanel.add(takeAction);
      takeAction.addActionListener(buttonListener);
      
      // now add the maze panel to the applet
      add(mazePanel);
   }
   
   // this object is triggered whenever a button is clicked
   private class ButtonActionListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          
         // find out which button was clicked 
         Object source = event.getSource();
         
         if (source == fileButton)
         {
            fileName = fileText.getText();
            makeMaze(fileName);
            myGraph = new Graph(maze,rows,cols);
         }

         if (source == takeAction)
         {
            if (!gameOver())
            {
               buttonCount++;
               if (buttonCount % 2 == 1)
               {
                  myGraph.fewestEdgePath(startY*cols+startX, endY*cols+endX, maze);
                  myGraph.tracePath(maze, startY*cols+startX, endY*cols+endX, cols);
                  mazeField.paint(mazeField.getGraphics());
               }
                  
               else 
               {
                  myGraph.findRandomBlock(maze, cols); 
                  moveFirstStep(myGraph.parent, startY*cols+startX);
                  for (int i=0; i<rows; i++)
                  {
                     for (int j=0; j<cols; j++)
                     {
                        if (maze[i][j] == 1)
                        {
                           startX = j;
                           startY = i;
                        }
                     }
                  }
                  mazeField.paint(mazeField.getGraphics());
                  myGraph.resetWhitePath(maze, rows, cols);
                  myGraph = new Graph(maze, rows, cols);
               }
            }

            else
            {
               fileName = fileText.getText();
               makeMaze(fileName);
               myGraph = new Graph(maze,rows,cols);
               buttonCount = 0;
               clickCount = 0;
            }  
         }
      } 
   }

   private class MouseEventListener implements MouseListener
   {
      public void mouseClicked(MouseEvent e)
      {
         // location on the mazeCanvas where mouse was clicked
         // upper-left is (0,0)
         x = e.getX() / blkSize;
         y = e.getY() / blkSize;
         
         if (clickCount == 0)
         {  
            startX = x;
            startY = y; 
            //painting the block green
            maze[startY][startX] = 1;
            clickCount++;
            mazeField.paint(mazeField.getGraphics());
         }
         else if (clickCount == 1)
         {
            endX = x;
            endY = y;
            //painting the block red
            maze[endY][endX] = 2;
            clickCount++;
            mazeField.paint(mazeField.getGraphics());
         }
      
         
      }
      
      
      public void mousePressed(MouseEvent e) { }
      public void mouseReleased(MouseEvent e) { }
      public void mouseEntered(MouseEvent e) { }
      public void mouseExited(MouseEvent e) { } 
   }

   public boolean makeMaze(String fileName)
   {
      try
      {
         Scanner scanner = new Scanner(new File(fileName));
         rows = scanner.nextInt();
         cols = scanner.nextInt();
         maze = new int[rows][cols];
         //fill out maze matrix
         for(int i=0; i<rows; i++)
         {
            for(int j=0; j<cols; j++)
            {
               maze[i][j] = scanner.nextInt();
            }
         }
   
         // now draw it
         mazeField.paint(mazeField.getGraphics());
         return true;
      }
      catch(Exception e)
      {
         return false;
      }
   }

   public boolean gameOver()
   {
      if (!(myGraph.isPath(startY*cols+startX, endY*cols+endX)))
      {
         return true;
      }

      if (myGraph.fewestEdgePath(startY*cols+startX, endY*cols+endX, maze) <= 8)
         return true;

      return false;
   }

   public void moveFirstStep(int[] parent, int start)
   {
      int x, y;
      for (int m=0; m<parent.length; m++)
      {
         if (parent[m] == start)
         {
            x = m % cols;
            y = m / cols;
            if (maze[y][x] == 3)
            {
               maze[y][x] = 1;
               maze[start/cols][start%cols] = 0;
            }
               
         }
      }
   }
           
   class MazeCanvas extends Canvas {
      // this class paints the output window 
       
     // the constructor sets it up
      MazeCanvas() {
         rows = MAXROWS;
         cols = MAXCOLS;
         maze = new int[MAXROWS][MAXCOLS];
         setSize(cols*blkSize, rows*blkSize);
         setBackground(Color.white);
      }
       
      public void paint(Graphics g)
      {
         g.setColor(Color.white);
         g.fillRect(0, 0, cols*blkSize, rows*blkSize);
         
         for (int i=0; i<rows; i++)
         { 
            for (int j=0; j<cols; j++)
            {
               if (maze[i][j] == -1)
               {
                  // location is a wall
                  g.setColor(Color.black);
               }
               else if (maze[i][j] == 1)
               {
                  g.setColor(Color.green);
               }
               else if (maze[i][j] == 2)
               {
                  g.setColor(Color.red);
               }
               else if (maze[i][j] == 3)
               {
                  g.setColor(Color.yellow);
               }
               else
               {
                  // location is clear
                  g.setColor(Color.white);
               }
               // draw the location
               g.fillRect(j*blkSize, i*blkSize, blkSize, blkSize);
            }
         }
      }
   }
}
