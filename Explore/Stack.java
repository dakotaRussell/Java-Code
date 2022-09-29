import java.util.*;

public class Stack<Element>
{
	private LinkedList<Element> theList;

	public Stack()
	{
		theList = new LinkedList<Element>();
	}

	public void push(Element e)
	{
		theList.addFirst(e);
	}

	public Element pop()
	{
		return theList.remove();
	}

}