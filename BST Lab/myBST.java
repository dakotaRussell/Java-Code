import java.awt.*;

public class myBST extends BST
{
	public Comparable parent(Comparable x)
	{     if (x == root)
		return null;
              
	      Node p = root;
	      while (p != null)
              { 
		if (x.compareTo(p.left.item) == 0 || x.compareTo(p.right.item) == 0)
		   return p.item;
		else if (x.compareTo(p.item) < 0)
	           p = p.left;
		else if (x.compareTo(p.item) > 0)
		   p = p.right;
	      }
	      return null;
		
	}

	public Comparable predecessor(Comparable x)
	{    Node p = root;
	     Node spot = null;
	     Node rightTurn = null;
             while (p != null)
	     {
		if (x.compareTo(p.item) == 0)
		{
		   spot = p;
		   p = null;}
		else if(x.compareTo(p.item) < 0)
		   p = p.left;
                else if(x.compareTo(p.item) > 0)
                {
		   rightTurn = p;
		   p = p.right;
	        }
	     }
	     if (spot == null)
		return null;
             if (spot.left != null)
	     {  p = spot.left;
		while (p.right!= null)
		{   p = p.right;}
		return p.item;
             }
	     else
		return rightTurn.item;
		
	}
	
	public Comparable successor(Comparable x)
	{    Node p = root;
	     Node spot = null;
	     Node leftTurn = null;
             while (p != null)
	     {
		if (x.compareTo(p.item) == 0)
		{   spot = p;
		   p = null; }
		else if(x.compareTo(p.item) < 0)
		{
		   leftTurn = p;
	           p = p.left;
                }
                else if(x.compareTo(p.item) > 0)
                {
		   p = p.right;
	        }
	     }
	     if (spot == null)
		return null;
             if (spot.right != null)
	     {  p = spot.right;
		while (p.left != null)
		{   p = p.left;}
		return p.item;
             }
	     else
		return leftTurn.item;

	}
	
	private int height(Node p)
	{
 	    if (p==null)
		return 0;
	    else
	       { return 1+Math.max(height(p.left), height(p.right));}
	}

	private boolean isBalanced(Node p)
	{    if (p==null)
		return true;

	     int leftHeight, rightHeight;
	     leftHeight = height(p.left);
	     rightHeight = height(p.right);
	     return Math.abs(rightHeight - leftHeight) <= 1 && isBalanced(p.left) && isBalanced(p.right);
	}

	public boolean isBalanced()
	{    
	    return isBalanced(root);
	}


}
