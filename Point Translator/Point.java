/**
 *
 * @author Dakota Dehn
 * @version Project1
 * @version CPE102-05
 * @version Spring 2014
 */


public interface Point
{
	double xCoordinate();
	double yCoordinate();
	double radius();
	double angle();
	double distanceFrom(Point other);
	Point rotate90();
}