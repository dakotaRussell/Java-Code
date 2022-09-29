import java.util.ArrayList;
import java.awt.Color;

/*A class that models a Work Space.*/
public class WorkSpace
{
   private ArrayList<Shape> shapeList;
   
   public WorkSpace()
   {
      shapeList = new ArrayList<Shape>();
   }
   
   public void add(Shape shape)
   {
      shapeList.add(shape);
   }
   
   public Shape remove(int index)
   {  
      Shape shape= shapeList.get(index);
      shapeList.remove(index);
      return shape;
   }
   
   public Shape get(int index)
   {
      return shapeList.get(index);
   }
   
   public int size()
   {
      return shapeList.size();
   }
   
   public ArrayList<Circle> getCircles()
   {  
      ArrayList<Circle> temp = new ArrayList<Circle>();
      for (int i=0; i<shapeList.size(); i++)
      {
         if (shapeList.get(i) instanceof Circle)
         {
            Circle c = (Circle)shapeList.get(i);
            temp.add(c);
         }
      }

      return temp;
   }  
   
   public ArrayList<Triangle> getTriangles()
   {  
      ArrayList<Triangle> temp = new ArrayList<Triangle>();
      for (int i=0; i<shapeList.size(); i++)
      {
         if (shapeList.get(i) instanceof Triangle)
         {
            Triangle t = (Triangle)shapeList.get(i);
            temp.add(t);
         }
      }

      return temp;
   }  

   public ArrayList<Rectangle> getRectangles()
   {  
      ArrayList<Rectangle> temp = new ArrayList<Rectangle>();
      for (int i=0; i<shapeList.size(); i++)
      {
         if (shapeList.get(i) instanceof Rectangle)
         {
            Rectangle r = (Rectangle)shapeList.get(i);
            temp.add(r);
         }
      }

      return temp;
   }  

   public ArrayList<ConvexPolygon> getConvexPolygons()
  {  
      ArrayList<ConvexPolygon> temp = new ArrayList<ConvexPolygon>();
      for (int i=0; i<shapeList.size(); i++)
      {
         if (shapeList.get(i) instanceof ConvexPolygon)
         {
            ConvexPolygon cp = (ConvexPolygon)shapeList.get(i);
            temp.add(cp);
         }
      }

      return temp;
   }  
   
   public ArrayList<Shape> getShapesByColor(Color color)
   {
      ArrayList<Shape> temp = new ArrayList<Shape>();
      for (int i=0; i<shapeList.size(); i++)
      {
         if (shapeList.get(i).getColor().equals(color))
         {
            Shape clr = shapeList.get(i);
            temp.add(clr);
         }
      }

      return temp;
   }

   public double getAreaOfAllShapes()
   {
      double sumArea = 0;
      for (int i=0; i<shapeList.size(); i++)
      {
        sumArea += shapeList.get(i).getArea();
      }
      return sumArea;
   }  
}