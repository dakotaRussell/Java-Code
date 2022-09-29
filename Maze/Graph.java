//Dakota Dehn CPE 103
import java.awt.*;
import java.io.*;
import java.util.*;

public class Graph implements Serializable
{
   private int[][] adj;
   private boolean[] visited;
   private int numVertices;
   public int[] parent;

   public Graph(int[][] array, int row, int col)
   {
      numVertices = row*col;
      parent = new int[numVertices];
      for (int k=0; k<numVertices; k++)
        { parent[k] = -1; }
      adj = new int[numVertices][numVertices];
      for (int i=0; i<row-1; i++){ 
         for (int j=0; j<col; j++){
            if (array[i][j] == -1){}
            else{
            if (j>0 && j<col-1) 
            {
               if (array[i][j-1] != -1)
                  addEdge(i*col+j, i*col+j-1); 

               if (array[i][j+1] != -1)
                  addEdge(i*col+j, i*col+j+1);

               if (array[i+1][j] != -1)
                  addEdge(i*col+j, (i+1)*col+j);
            }

            else if (j==0)
            {
               if (array[i][j+1] != -1)
                  addEdge(i*col+j, i*col+j+1);

               if (array[i+1][j] != -1)
                  addEdge(i*col+j, (i+1)*col+j);
            }

            else
            {
               if (array[i][j-1] != -1)
                  addEdge(i*col+j, i*col+j-1);

               if (array[i+1][j] != -1)
                  addEdge(i*col+j, (i+1)*col+j);
            }
         }
         }
      }
   }

   public int vertices()
   {
      return numVertices;
   }

   public int edges()
   {
      int ctr = 0;
      for(int i=0;i<numVertices;++i)
         for(int j=0;j<numVertices;++j)
            if(adj[i][j] != 0)
               ++ctr;
         ctr = ctr/2;
      return ctr;
   }

   public void addEdge(int from,int to)
   {
      adj[from][to] = 1;
      adj[to][from] = 1;
   }

   public void initilizeVisited()
   {
      visited = new boolean[numVertices];
      for(int i = 0; i < numVertices; i++)
      {
         visited[i] = false;
      }
   }

   public void visit(int p)
   {
      visited[p] = true;
      for(int i = 0; i < numVertices; i++)
      {
         if(adj[p][i] == 1 && visited[i] == false)
           visit(i);
      }
   } 

   public boolean isPath(int start, int stop)
   {
      initilizeVisited();
      visit(start);
      if(visited[stop] == false)
         return false;
      else
         return true;
   }

   public int fewestEdgePath(int start, int stop, int[][] array)
   {
	int[] pathlength = new int[numVertices];
	int currentstep, i, startMark, end;
   startMark = 0;
   end = 0;
	for (int k=0; k<numVertices; k++)
        {  pathlength[k] =-1;}
	pathlength[start]= 0;
   //parent[start] = 0;
	int[] q = new int[numVertices];
	q[startMark] = start;
   end++;
	while (startMark != end)
	{  i = q[startMark];
      startMark++;
		currentstep = pathlength[i];
		for (int j=0; j<numVertices; j++)
		{ if (adj[i][j] == 1 && pathlength[j] == -1)
		   {	q[end] = j;
            parent[j] = i;
            end++;
			   pathlength[j] = currentstep+1;
		   }	
		}
	}
      return pathlength[stop];
   }

  public void tracePath(int[][] maze, int start, int stop, int col)
  {
      int index = stop;
      int x, y;
      while (parent[index] != start)
      {
         x = parent[index] % col;
         y = parent[index] / col;
         //keep x and y there
         maze[y][x] = 3;
         index = parent[index];
      }
  }

  public void findRandomBlock(int[][] maze, int col)
  {
      int blockLoc, x, y;
      Random gen = new Random();
      blockLoc = gen.nextInt(numVertices);
      x = blockLoc % col;
      y = blockLoc / col;
      while (maze[y][x] != 3)
      {
         blockLoc = gen.nextInt(numVertices);
         x = blockLoc % col;
         y = blockLoc / col;
      }
      
      maze[y][x] = -1;
  }

   public void resetWhitePath(int[][] maze, int row, int col)
   {
      for (int i=0; i<row; i++)
      {
         for (int j=0; j<col; j++)
         {
            if (maze[i][j] == 3)
            {
               maze[i][j] = 0;
            }
         }
      }
   }
      
}

