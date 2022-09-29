
public class PointTester
{
   private static boolean testXCoordinate(Point pt, double expected)
   {
      boolean pass = false;
      try {
      pass = doubleEquals(pt.xCoordinate(), expected);
      System.out.println(": xCoordinate = " + pt.xCoordinate() + " (== " +
         expected + ") -- " + passOrFail(pass));
      }
      catch (Throwable t) {
	  t.printStackTrace();
      }
      return pass;
   }

   private static boolean testYCoordinate(Point pt, double expected)
   {
      boolean pass = false;
      try {
      pass = doubleEquals(pt.yCoordinate(), expected);
      System.out.println(": yCoordinate = " + pt.yCoordinate() + " (== " +
	expected + ") -- " + passOrFail(pass));
      }
      catch (Throwable t) {
	  t.printStackTrace();
      }
      return pass;
   }

   private static boolean testRadius(Point pt, double expected)
   {
      boolean pass = false;
      try {
      pass = doubleEquals(pt.radius(), expected);
      System.out.println(": radius = " + pt.radius() + " (== " +
         expected + ") -- " + passOrFail(pass));
      }
      catch (Throwable t) {
	  t.printStackTrace();
      }
      return pass;
   }

   private static boolean testAngle(Point pt, double expected)
   {
      boolean pass = false;
      try {
      pass = angleEquals(pt.angle(), expected);
      System.out.println(": angle = " + Math.toDegrees(pt.angle()) +
         " (== " + Math.toDegrees(expected) + ") -- " + passOrFail(pass));
      }
      catch (Throwable t) {
	  t.printStackTrace();
      }
      return pass;
   }

   private static boolean testDistanceFrom(Point pt, Point other, double expected)
   {
      boolean pass = false;
      try {
      pass = doubleEquals(pt.distanceFrom(other), expected);
      System.out.println(": distanceFrom = " + pt.distanceFrom(other) +
         " (== " + expected + ") -- " + passOrFail(pass));
      }
      catch (Throwable t) {
	  t.printStackTrace();
      }
      return pass;
   }

   private static boolean cTestRotate90(Point pt, Point expected)
   {
      boolean pass = false;
      try {
      double x = pt.xCoordinate();
      double y = pt.yCoordinate();
      Point newpt = pt.rotate90();

      boolean rotWorked = pointEquals(newpt, expected);
      boolean unchanged = doubleEquals(pt.xCoordinate(), x) &&
	doubleEquals(pt.yCoordinate(), y);
      pass = rotWorked && unchanged;
      System.out.println(": rotate90 = " + cPointToString(newpt)
	+ " (== " + cPointToString(expected) + ") -- " +
         passOrFail(pass));
      }
      catch (Throwable t) {
	  t.printStackTrace();
      }
      return pass;
   }

   private static boolean pTestRotate90(Point pt, Point expected)
   {
      boolean pass = false;
      try {
      double x = pt.xCoordinate();
      double y = pt.yCoordinate();
      Point newpt = pt.rotate90();

      boolean rotWorked = pointEquals(newpt, expected);
      boolean unchanged = doubleEquals(pt.xCoordinate(), x) &&
         doubleEquals(pt.yCoordinate(), y);
      pass = rotWorked && unchanged;
      System.out.println(": rotate90 = " + pPointToString(newpt)
         + " (== " + pPointToString(expected) + ") -- " +
         passOrFail(pass));
      }
      catch (Throwable t) {
	  t.printStackTrace();
      }
      return pass;
   }

   private static boolean testCartesianPoints()
   {
      boolean pass = true;

      Point pt, pt1, pt2;

      System.out.println("[ ] Cartesian Accessors");
      // (1.0, 1.0)
      pt = new CartesianPoint(1.0, 1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testXCoordinate(pt, 1.0);

      pt = new CartesianPoint(1.0, 1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testYCoordinate(pt, 1.0);

      // (-1.0, 1.0)
      pt = new CartesianPoint(-1.0, 1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testXCoordinate(pt, -1.0);

      pt = new CartesianPoint(-1.0, 1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testYCoordinate(pt, 1.0);

      // (-1.0, -1.0)
      pt = new CartesianPoint(-1.0, -1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testXCoordinate(pt, -1.0);

      pt = new CartesianPoint(-1.0, -1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testYCoordinate(pt, -1.0);

      // (-2.7, 3.212)
      pt = new CartesianPoint(-2.7, 3.212);
      System.out.print("\t" + cPointToString(pt));
      pass &= testXCoordinate(pt, -2.7);

      pt = new CartesianPoint(-2.7, 3.212);
      System.out.print("\t" + cPointToString(pt));
      pass &= testYCoordinate(pt, 3.212);

      // (19.281, 0.0)
      pt = new CartesianPoint(19.281, 0.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testXCoordinate(pt, 19.281);

      pt = new CartesianPoint(19.281, 0.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testYCoordinate(pt, 0.0);

      // (0.0, 0.0)
      pt = new CartesianPoint(0.0, 0.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testXCoordinate(pt, 0.0);

      pt = new CartesianPoint(0.0, 0.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testYCoordinate(pt, 0.0);

      System.out.println("[ ] Cartesian Distance");
      // (0.0, 0.0) --> (1.0, 0.0)
      pt1 = new CartesianPoint(0.0, 0.0);
      pt2 = new CartesianPoint(1.0, 0.0);
      System.out.print("\t" + cPointToString(pt1) + " --> " + cPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 1.0);

      // (9.0, -3.0) --> (9.0, -3.0)
      pt1 = new CartesianPoint(9.0, -3.0);
      pt2 = new CartesianPoint(9.0, -3.0);
      System.out.print("\t" + cPointToString(pt1) + " --> " + cPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 0.0);

      // (9.0, -3.0) --> (-2.0, -6.212)
      pt1 = new CartesianPoint(9.0, -3.0);
      pt2 = new CartesianPoint(-2.0, -6.212);
      System.out.print("\t" + cPointToString(pt1) + " --> " + cPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 11.459361);

      System.out.println("[ ] Cartesian Rotate");
      // (0.0, 0.0) rotate90
      pt1 = new CartesianPoint(0.0, 0.0);
      pt2 = new CartesianPoint(0.0, 0.0);
      System.out.print("\t" + cPointToString(pt1));
      pass &= cTestRotate90(pt1, pt2);

      // (1.0, 0.0) rotate90
      pt1 = new CartesianPoint(1.0, 0.0);
      pt2 = new CartesianPoint(0.0, 1.0);
      System.out.print("\t" + cPointToString(pt1));
      pass &= cTestRotate90(pt1, pt2);

      // (0.0, -1.0) rotate90
      pt1 = new CartesianPoint(0.0, -1.0);
      pt2 = new CartesianPoint(1.0, 0.0);
      System.out.print("\t" + cPointToString(pt1));
      pass &= cTestRotate90(pt1, pt2);

      // (-19.73, -0.00124) rotate90
      pt1 = new CartesianPoint(-19.73, -0.00124);
      pt2 = new CartesianPoint(0.00124, -19.73);
      System.out.print("\t" + cPointToString(pt1));
      pass &= cTestRotate90(pt1, pt2);

      return pass;
   }

   private static boolean testPolarPoints()
   {
      boolean pass = true;

      Point pt, pt1, pt2;

      System.out.println("[ ] Polar Accessors");
      // 2.0:90
      pt = new PolarPoint(2.0, Math.toRadians(90.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testRadius(pt, 2.0);

      pt = new PolarPoint(2.0, Math.toRadians(90.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testAngle(pt, Math.toRadians(90.0));

      // 1.0:45
      pt = new PolarPoint(1.0, Math.toRadians(45.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testRadius(pt, 1.0);

      pt = new PolarPoint(1.0, Math.toRadians(45.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testAngle(pt, Math.toRadians(45.0));

      // 1.0:-45
      pt = new PolarPoint(1.0, Math.toRadians(-45.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testRadius(pt, 1.0);

      pt = new PolarPoint(1.0, Math.toRadians(-45.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testAngle(pt, Math.toRadians(-45.0));

      // -2.7: 30
      pt = new PolarPoint(-2.7, Math.toRadians(30));
      System.out.print("\t" + pPointToString(pt));
      pass &= testRadius(pt, -2.7);

      pt = new PolarPoint(-2.7, Math.toRadians(30));
      System.out.print("\t" + pPointToString(pt));
      pass &= testAngle(pt, Math.toRadians(30));

      System.out.println("[ ] Polar Distance");
      // 0.0:0.0 --> 1.0:0.0
      pt1 = new PolarPoint(0.0, 0.0);
      pt2 = new PolarPoint(1.0, 0.0);
      System.out.print("\t" + pPointToString(pt1) + " --> " + pPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 1.0);

      // 9.0:45 --> 3.0:225
      pt1 = new PolarPoint(9.0, Math.toRadians(45));
      pt2 = new PolarPoint(3.0, Math.toRadians(225));
      System.out.print("\t" + pPointToString(pt1) + " --> " + pPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 12.0);

      // 7.0:45 --> 2.7:120
      pt1 = new PolarPoint(7.0, Math.toRadians(45));
      pt2 = new PolarPoint(2.7, Math.toRadians(120));
      System.out.print("\t" + pPointToString(pt1) + " --> " + pPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 6.81957770651);

      System.out.println("[ ] Polar Rotate");
      // 0.0:0.0 rotate90
      pt1 = new PolarPoint(0.0, 0.0);
      pt2 = new PolarPoint(0.0, Math.toRadians(90.0));
      System.out.print("\t" + pPointToString(pt1));
      pass &= pTestRotate90(pt1, pt2);

      // 1.0:45 rotate90
      pt1 = new PolarPoint(1.0, Math.toRadians(45.0));
      pt2 = new PolarPoint(1.0, Math.toRadians(135.0));
      System.out.print("\t" + pPointToString(pt1));
      pass &= pTestRotate90(pt1, pt2);

      // 3.9:-45 rotate90
      pt1 = new PolarPoint(3.9, Math.toRadians(-45));
      pt2 = new PolarPoint(3.9, Math.toRadians(45));
      System.out.print("\t" + pPointToString(pt1));
      pass &= pTestRotate90(pt1, pt2);

      return pass;
   }

   private static boolean testMixedPoints()
   {
      boolean pass = true;

      Point pt, pt1, pt2;

      System.out.println("[ ] Mixed Accessors (Polar)");
      // 2.0:90
      pt = new PolarPoint(2.0, Math.toRadians(90.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testXCoordinate(pt, 0.0);

      pt = new PolarPoint(2.0, Math.toRadians(90.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testYCoordinate(pt, 2.0);

      // 1.0:45
      pt = new PolarPoint(1.0, Math.toRadians(45.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testXCoordinate(pt, 0.707106781187);

      pt = new PolarPoint(1.0, Math.toRadians(45.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testYCoordinate(pt, 0.707106781187);

      // 1.0:-45
      pt = new PolarPoint(1.0, Math.toRadians(-45.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testXCoordinate(pt, 0.707106781187);

      pt = new PolarPoint(1.0, Math.toRadians(-45.0));
      System.out.print("\t" + pPointToString(pt));
      pass &= testYCoordinate(pt, -0.707106781187);

      System.out.println("[ ] Mixed Accessors (Cartesian)");
      // (1.0, 1.0)
      pt = new CartesianPoint(1.0, 1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testRadius(pt, 1.41421356237);

      pt = new CartesianPoint(1.0, 1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testAngle(pt, Math.toRadians(45.0));

      // (-1.0, 1.0)
      pt = new CartesianPoint(-1.0, 1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testRadius(pt, 1.41421356237);

      pt = new CartesianPoint(-1.0, 1.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testAngle(pt, Math.toRadians(135));

      // (-2.7, -4.0)
      pt = new CartesianPoint(-2.7, -4.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testRadius(pt, 4.82597140481);

      pt = new CartesianPoint(-2.7, -4.0);
      System.out.print("\t" + cPointToString(pt));
      pass &= testAngle(pt, 4.11863931367);

      System.out.println("[ ] Mixed Distance");
      // 7.0:45 --> (1.0, 2.0)
      pt1 = new PolarPoint(7.0, Math.toRadians(45));
      pt2 = new CartesianPoint(1.0, 2.0);
      System.out.print("\t" + pPointToString(pt1) + " --> " + cPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 4.92965670105);

      // (1.0, 2.0) --> 7.0:45
      pt1 = new CartesianPoint(1.0, 2.0);
      pt2 = new PolarPoint(7.0, Math.toRadians(45));
      System.out.print("\t" + cPointToString(pt1) + " --> " + pPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 4.92965670105);

      // 7.0:133 --> (1.0, -2.0)
      pt1 = new PolarPoint(7.0, Math.toRadians(133));
      pt2 = new CartesianPoint(1.0, -2.0);
      System.out.print("\t" + pPointToString(pt1) + " --> " + cPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 9.16656318836);

      // (1.0, -2.0) --> 7.0:133
      pt1 = new CartesianPoint(1.0, -2.0);
      pt2 = new PolarPoint(7.0, Math.toRadians(133));
      System.out.print("\t" + cPointToString(pt1) + " --> " + pPointToString(pt2));
      pass &= testDistanceFrom(pt1, pt2, 9.16656318836);

      return pass;
   }

   public static void main(String [] args)
   {
      boolean pass;
      try {
          pass = testCartesianPoints();
      }
      catch (Throwable t) {
	  t.printStackTrace();
          pass = false;
      }
      System.out.println("Cartesian Point Tests: " + passOrFail(pass) + "\n");
      try {
          pass = testPolarPoints();
      }
      catch (Throwable t) {
	  t.printStackTrace();
          pass = false;
      }
      System.out.println("Polar Point Tests: " + passOrFail(pass) + "\n");
      try {
          pass = testMixedPoints();
      }
      catch (Throwable t) {
	  t.printStackTrace();
          pass = false;
      }
      System.out.println("Mixed Point Tests: " + passOrFail(pass) + "\n");
   }

   // return true when |a - b| < epsilon
   private static boolean doubleEquals(double a, double b)
   {
      double epsilon = 1e-5;
      return (Double.isNaN(a) && Double.isNaN(b)) ||
         (Math.abs(a - b) < epsilon); 
   }

   private static String passOrFail(boolean pass)
   {
      return (pass ? "Pass" : "Fail");
   }

   private static String cPointToString(Point pt)
   {
      return "(" + pt.xCoordinate() + "," + pt.yCoordinate() + ")";
   }

   private static String pPointToString(Point pt)
   {
      return "(" + pt.radius() + " -- " + Math.toDegrees(pt.angle()) + ")";
   }

   private static boolean pointEquals(Point pt, Point expected)
   {
      return doubleEquals(pt.xCoordinate(), expected.xCoordinate()) &&
         doubleEquals(pt.yCoordinate(), expected.yCoordinate());
   }

   // return true when (|a - b| +/- 2PI) < epsilon
   private static boolean angleEquals(double a, double b)
   {
      double epsilon = 1e-5;
      double twoPI = Math.PI * 2.0;
      return (Double.isNaN(a) && Double.isNaN(b)) ||
         (Math.abs(a - b) < epsilon) || 
         (Math.abs(a - b + twoPI) < epsilon) || 
         (Math.abs(a - b - twoPI) < epsilon); 
   }
}