import mycs1.*;
import java.io.*;
import java.util.*;

public class Graph implements Serializable
{
   public static final int DIRECTED = 0;
   public static final int UNDIRECTED = 1;
   public static final int WEIGHTED = 2;
   public static final int UNWEIGHTED = 3;

   private int[][] adj;
   private boolean[] visited;
   private int numVertices;
   private boolean directed;
   private boolean weighted;
   private String fileName;

   public Graph(String initFile)
   {
      fileName = initFile;
      TextIO inFile;
      try
      {
         inFile = new TextIO(fileName,TextIO.INPUT);
      }
      catch (TextIO.Error e)
      {
         throw new Graph.Error("Unable to open input file " + fileName);
      }
      try
      {
         inFile = new TextIO(fileName,TextIO.INPUT);
         numVertices = inFile.readInt();
        
	 String parameter = inFile.readToken();
         if (parameter.equals("DIRECTED"))
            directed = true;
         else if (parameter.equals("UNDIRECTED"))
            directed = false;
         else
            throw new Graph.Error("Invalid format of graph file " + fileName);

         parameter = inFile.readToken();
         if (parameter.equals("WEIGHTED"))
            weighted = true;
         else if (parameter.equals("UNWEIGHTED"))
            weighted = false;
         else
            throw new Graph.Error("Invalid format of graph file " + fileName);
         
         adj = new int[numVertices][numVertices];
         for(int i=0;i<numVertices;++i)
            for(int j=0;j<numVertices;++j)
               adj[i][j] = 0;

         int from,to,weight;
         while(!inFile.endOfFile())
         {
            from = inFile.readInt();
            to = inFile.readInt();
            if (weighted)
            {
               weight = inFile.readInt();
               addEdge(from,to,weight);
            }
            else
               addEdge(from,to);
         }
         inFile.close();
      }
      catch (TextIO.Error e)
      {
         throw new Graph.Error(e.getMessage());
      }
      
   }

   public void print()
   {
      if (fileName != null)
         System.out.println("Constructed from file " + fileName);
      if (directed)
         System.out.print("DIRECTED");
      else
         System.out.print("UNDIRECTED");
      if (weighted)
         System.out.println(" WEIGHTED");
      else
         System.out.println(" UNWEIGHTED");
      System.out.println("Vertices: " + numVertices);
      System.out.println("Edges: " + edges());
      for(int v=0;v<numVertices;++v)
      {
         System.out.print(v + ": ");
         for(int u=0;u<numVertices;++u)
            if (adj[v][u] != 0)
               if (weighted)
                  System.out.print(" " + u + "<" + adj[v][u] + ">");
               else
                  System.out.print(" " + u);
         System.out.println();
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
      if (!directed)
         ctr = ctr/2;
      return ctr;
   }

   public void addEdge(int from,int to)
   {
      if (weighted)
         throw new Graph.Error("Illegal action on weighted graph");
      if (from<0 || from>=numVertices || to<0 || to>=numVertices)
         throw new Graph.Error("Invalid vertex");
      adj[from][to] = 1;
      if (!directed)
         adj[to][from] = 1;
   }

   public void addEdge(int from,int to,int weight)
   {
      if (!weighted)
         throw new Graph.Error("Illegal action on unweighted graph");
      if (from<0 || from>=numVertices || to<0 || to>=numVertices)
         throw new Graph.Error("Invalid vertex");
      if (weight <= 0)
         throw new Graph.Error("Invalid weight");
      adj[from][to] = weight;
      if (!directed)
         adj[to][from] = weight;
   }

   public static class Error extends RuntimeException
   {
      public Error(String message)
      {
         super(message);
      }
   }

   public void serialize(String fileName)
   {
      try
      {
         ObjectOutputStream outStream = 
            new ObjectOutputStream(new FileOutputStream(fileName));
         outStream.writeObject(this);
         outStream.close();
      }
      catch(Exception e)
      { throw new Graph.Error(e.toString()); }
   }

   public static Graph deserialize(String fileName)
   {
      try
      {
         ObjectInputStream inStream = 
            new ObjectInputStream(new FileInputStream(fileName));
         Graph g = (Graph) inStream.readObject();
         inStream.close();
         return g;
      }
      catch(Exception e)
      { throw new Graph.Error(e.toString()); }
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

   public int fewestEdgePath(int start, int stop)
   {
        if (!isPath(start, stop))
	    throw new Graph.Error("No path exists between the points.");

	int[] pathlength = new int[numVertices];
	int currentstep, i;
	for (int k=0; k<numVertices; k++)
        {  pathlength[k] =-1;}
	pathlength[0]=0;
	Queue q = new Queue();
	q.enqueue(start);
	while (!q.isEmpty())
	{	i = (int)q.dequeue();
		currentstep = pathlength[i];
		for (int j=0; j<numVertices; j++)
		{ if (adj[i][j] == 1 && pathlength[j] == -1)
		   {	q.enqueue(j);
			pathlength[j] = currentstep +1;
		   }	
		}
	}

	return pathlength[stop];
   }

       public int Kruskal()
      { 
	Heap heap = new Heap(numVertices, Heap.MIN);
	Edge temp;
	DisjointSets.Set x, y;
	int treeWeight = 0;
	DisjointSets myTree = new DisjointSets(numVertices);
	for (int i=0; i<numVertices; i++)
	{ for (int j=0; j<numVertices; j++)
	  {  if (adj[i][j] != 0)
		{ heap.insert(new Edge(i, j, adj[i][j]));} 
          }
	}
	while (!heap.isEmpty())
	{
	     temp = (Edge)heap.remove();
	     x = myTree.find(temp.start);
	     y = myTree.find(temp.end);
	     if (!(x.equals(y)))
	 	{
		 System.out.println("entered if statement." + treeWeight);
		 myTree.union(x,y);
		 treeWeight += temp.weight;
		}
	}
	return treeWeight;
      }

      private class Edge implements Comparable
	{  private int start, end;
	   private int weight;

	   public Edge(int x, int y, int weight)
	   { start= x;
	     end =y;
             this.weight = weight;
           }

	   public int compareTo(Object obj)
	   {
		if (((Edge)obj).weight == this.weight)
		   return 0;
		else if (((Edge)obj).weight > this.weight)
		   return -1;
                else
		   return 1;
	   }
	}
  }
