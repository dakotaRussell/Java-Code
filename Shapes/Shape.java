/**
 *
 * @author Dakota Dehn
 * @version Project2-1
 * @version CPE102-05
 * @version Spring 2014
 */

public interface Shape
{
	/** 
	* @return the area of the object. 
	**/
	double getArea(); 

	/**
	* @return the java.awt.Color of the object. 
	**/
	java.awt.Color getColor(); 

	/**
	* Sets the java.awt.Color of the object. 
	* @param java.awt.Color color to make the object.
	**/
	void setColor(java.awt.Color color); 

	/**
	* @return true if the object is filled with color, otherwise false. 
	**/
	boolean getFilled(); 

	/**
	* Sets the filled state of the object.
	* @param boolean filled of whether or not the object is colored.
	**/
	void setFilled(boolean filled); 

	/**
	* Moves the shape by the x and y amounts specified in the Point
	*	@param java.awt.Point point to move the object by.
	**/
	void move(java.awt.Point point); 
}