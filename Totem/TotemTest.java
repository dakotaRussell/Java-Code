/**
 * The test class TotemTest.
 *
 * @author  Julie Workman
 * @version 5/28/13
 */
public class TotemTest
{
    TotemPole p1, p2, p3;

    public static void main(String[] args)
    {
       new TotemTest().run();
    }

    public TotemTest()
    {
        p1 = new Bear(
                new Bear(
                   new Snake(
                      new Snake(
                         new Snake(
                            new Bear(
                               new Eagle()))))));
        p2 = new Snake(
                new Bear(
                   new Bear(
                      new Bear(
                         new Snake(
                               new Eagle())))));
        p3 = new Eagle();                          
    }

   public void run()
   {
      boolean pass = true;

      pass &= testHeight();
      pass &= testPower();
      pass &= testChiefPole();

      if (pass)
         System.out.println("Congrats, you pass.  The Gashunongan people rejoice!");
      else
         System.out.println("Not done yet.  I hope the Gashunongan people aren't head hunters!");
   }
  

    public boolean testHeight()
    {
       boolean pass = true;

       pass &= test(p1.height(), 7, 1);
       pass &= test(p2.height(), 6, 2);
       pass &= test(p3.height(), 1, 3);

       return pass;
    }

    public boolean testPower()
    {
       boolean pass = true;

       pass &= test(p1.power(), 26, 4);
       pass &= test(p2.power(), 23, 5);
       pass &= test(p3.power(), 2,  6);

       return pass;
    }

    public boolean testChiefPole()
    {
        boolean pass = true;

        pass &= test(p1.chiefPole(0), false, 7);
        pass &= test(p2.chiefPole(0), true,  8);
        pass &= test(p3.chiefPole(0), false, 9);

        return pass;
    }

    private static boolean test(int test, int expect, int testNum)
    {
       if (test != expect)
       {
          System.out.println("   FAILED test #" + testNum);
          return false;
       }

       return true;
    }

    private static boolean test(boolean test, boolean expect, int testNum)
    {
       if (test != expect)
       {
          System.out.println("   FAILED test #" + testNum);
          return false;
       }

       return true;
    }
}
