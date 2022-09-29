import java.io.*;
import java.util.Iterator;

public class LinkedList implements Cloneable
{

   private class Node
   {
      private Object item;
      private Node next;
      private Node prev;

      private Node(Object x)
      {
         item = x;
         next = null;
         prev = null;
      }
   }

   // Self explanatory instance variables

   private Node first;
   private Node last;
   private int length;

   // Default Constructor

   public LinkedList()
   {
      first = null;
      last = null;
      length = 0;
   }

   // Insert the given object at the beginning of the list.

   public void addFirst(Object item)
   {
      Node temp = new Node(item);
      if (length == 0)
         {
             first = temp;
	     last = temp;
             length++;
         }
      else 
         {
             temp.next = first;
             first.prev = temp;
	     first = temp;
             length++;
         }
	
   }

   // Insert the given object at the end of the list.

   public void addLast(Object item)
   {
      Node temp = new Node(item);
      if (length == 0)
         {
             first = temp;
             last = temp;
             length++;
	 }
      
      else
         {
            temp.prev = last;
            last.next = temp;
            last = temp;
            length++;
         }
             
   }

   // Return the number of items in the list

   public int length()
   {
      return length;
   }

   // Determine if the list contains no items

   public boolean isEmpty()
   {
      return length == 0;
   }

   // (Virtually) remove all items from the list

   public void clear()
   {
      first = null;
      last = null;
      length = 0;
   }

   // Determine if the list contains the given item

   public boolean contains(Object item)
   {
      Node cursor = first;
      while (cursor != null)
          {
              if (cursor.item.equals(item))
                 return true;
              cursor = cursor.next;
          }
      return false;
   }

   // Remove first item on the list and return it
   
   public Object removeFirst()
   {
      if (length == 0)
         throw new Error("Nothing to remove idiot.");

      Object data = first.item;
      if (length == 1)
         {
             first = null;
             last = null;
             length--; 
         }

      else 
         {
             first = first.next;
             first.prev = null;
             length--;
         }    

     return data;
   }

   // Remove last item on the list and return it
   
   public Object removeLast()
   {
      if (length == 0)
         throw new Error("Nothing to remove idiot.");
      
      Object data = last.item;
      if (length == 1)
         {
            first = null;
            last = null;
            length--;
         }
      
      else
         {
            last = last.prev;
            last.next = null;
            length--;
         }

      return data;      
   }
   
   // Determine if two LinkedLists are equal
      
   public boolean equals(Object y)
   {
      if (y == null)
         return false;

      if (!(y instanceof LinkedList))
         return false;
     
      LinkedList list = (LinkedList)y;
      Node p = this.first;
      Node q = list.first;

      if (this.length != list.length)
         return false;

      for (int index = 0; index < this.length; index++)
         {
            if (!(p.item.equals(q.item)))
               return false;
            p = p.next;
            q = q.next;
         }
      return true;
   }

   public boolean remove(Object data)
   {
      if (!(contains(data)))
	return false;
      
      Node cursor = first;
      while (cursor != null) 
      {
      	if (cursor.item.equals(data))
	{
           if (cursor.equals(first))
	      {
                 removeFirst();
                 return true;
	      }
           if (cursor.equals(last))
	      {
                 removeLast();
                 return true;
              }
           Node temp = cursor.prev;
           temp.next = cursor.next;
           Node temp2 = cursor.next;
           temp2.prev = temp;
           length--;
           return true;
        }
        cursor = cursor.next;
      }
      
      return false;
   }
         
                 
   public Object clone()
   {
	LinkedList theClone = new LinkedList();
        Node p = this.first;
        while (p != null)
           {
               theClone.addLast(p.item);
               p = p.next;
           }
        return theClone;
   }

   public Iterator iterator()
   {
           return new LinkedIterator();
   }

   private class LinkedIterator implements Iterator
   {
           private Node cursor;

           private LinkedIterator()
           {
               cursor = first;
           }           
             
           public boolean hasNext()
           {
                return (cursor != null);
           }

           public Object next()
           {
                if (!(hasNext()))
                   throw new Error("Nothing here.");
                
                Object x = cursor.item;
                cursor = cursor.next;
                return x;
           }
          
           public void remove()
           {
                throw new UnsupportedOperationException();
           }
    }
      
         

   // **********************************************************************

   // FOR THE PURPOSES OF THIS LAB, YOU DON'T NEED TO SPEND TIME READING THE
   // REST OF THIS FILE.  HOWEVER, YOU SHOULD DO SO LATER ON YOUR OWN TIME.

   // The following specifies the maximum number of items in the list that
   // will be included in the toString method.
 
   private static int printLimit = 20;

   // This method allows the client to control the number of list items
   // that will be included in the toString method.

   public static void setPrintLimit(int limit)
   {
      if (limit >= 1)
         printLimit = limit;
   }

   // This method produces a string of the form {item1,item2,...} where item1 
   // is the first item in the list. The number of items included is the smaller 
   // of the number of items in the list and the value of printLimit. The "..."
   // is shown only if there are list items that were not included.  

   public String toString()
   {
      String answer = "{";
      int ctr = 0;
      for(Node curr=first;curr!=null;curr=curr.next)
      {
         answer = answer + curr.item;
         ++ctr;
         if (curr.next != null)
            if (ctr == printLimit)
               return answer + ",...}";
            else
               answer = answer + ",";
      }
      return answer + "}";
   }

   public static class Error extends RuntimeException
   {
      public Error(String message)
      {
         super(message);
      }
   }
}


