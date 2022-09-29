/*Dakota Dehn CPE 103*/
import java.util.*;
import java.lang.*;

public class RecordBST
{
	public BSTnode root;

	public RecordBST(String token)
	{
		root = new BSTnode(token);
	}

	public void addItem(String word)
	{
		if (root == null)
			root = new BSTnode(word);
		BSTnode p = root;
		while (p != null)
		{
			if (word.compareToIgnoreCase(p.item.s) <= 0 )
			{
				if (p.left == null)
				{
					p.left = new BSTnode(word);
					break;
				}
				else
					p = p.left;
			}
			else 
			{
				if (p.right == null)
				{
					p.right = new BSTnode(word);
					break;
				}
				else
					p = p.right;
			}
				
		}
	}

	public void flagItems(String word)
	{
		BSTnode p = root;
		while (p != null)
		{
			if (word.compareToIgnoreCase(p.item.s) == 0)
			{
				p.item.flagged = true;
				break;
			}
			else if (word.compareToIgnoreCase(p.item.s) < 0 )
				p = p.left;
			else 
				p = p.right;
		}
	}

	public boolean wordFound(String word)
	{
		BSTnode p = root;
		while (p != null)
		{
			if (word.compareToIgnoreCase(p.item.s) == 0) 
				return true;
			else if (word.compareToIgnoreCase(p.item.s) < 0)
				p = p.left;
			else 
				p = p.right;
		}
		return false;
	}

	public void spellCheck(String obj)
	{
		boolean found = wordFound(obj);

		//removing -s
		if (!found && obj.endsWith("s"))
		{
			String temp;
			temp = obj.substring(0, obj.length()-1);
			found = wordFound(temp);
		}

		//removing -es
		if (!found && obj.endsWith("es"))
		{
			String temp;
			temp = obj.substring(0, obj.length()-2);
			found = wordFound(temp);
		}

		//removing -ing
		if (!found && obj.endsWith("ing"))
		{
			String temp;
			temp = obj.substring(0, obj.length()-3);
			found = wordFound(temp);
		}
		

		//trying to switch concurrent letters
		if (!found)
		{
			System.out.print(obj + "       possible spellings: ");
			for (int i=0; i<obj.length()-1; i++)
			{
				char[] temp = obj.toCharArray();
				char swap = temp[i+1];
				temp[i+1] = temp[i];
				temp[i] = swap;
				String newString = new String(temp);
				found = wordFound(newString);
				if (found)
					{ 
					  System.out.printf(newString);
					}
				
			}
			System.out.printf("\n");
		}
	}

	public void printFlaggedItems(BSTnode p)
	{
		if (p != null)
		{
			printFlaggedItems(p.left);
			if (p.item.flagged == true) 
				System.out.println(p.item.s);
			printFlaggedItems(p.right);
		}
			
		
	}

	private class BSTnode
	{
		public BSTnode left, right; 
		public ItemRecord item;

		public BSTnode(String token)
		{
			item = new ItemRecord(token);
			left = null; 
			right = null;
		}
	}

}