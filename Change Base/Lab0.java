import mycs1.*;
import java.lang.*; 

public class Lab0
{
    public static int val;
    public static int base;
    public static char answer;

   public static void main(String[] args)
   {
       System.out.println("Type 'y' to continue");
       answer = Keyboard.readChar();
       
       while (answer == 'y')
	   {
	       System.out.println("Input value?");
	       val = Keyboard.readInt();
	       System.out.println("Base?");
	       base = Keyboard.readInt();
	       if (base < 2 || base > 16)
		   throw new RuntimeException("Base out of acceptable range");

	       if (val < 0)
		   System.out.println(val + " is -" + changeBase(Math.abs(val), base) + " in base " + base);
	       else
		   System.out.println(val + " is " + changeBase(val, base) + " in base " + base);
       
	       System.out.println("Type 'y' to continue");
	       answer = Keyboard.readChar();
	   }
				  


			      
	       
       
   }

   private static final char[] digits = {'0','1','2','3','4','5','6','7','8',
                                         '9','A','B','C','D','E','F'};

   // value must be >= 0 and base must be in 2..16

   private static String changeBase(long value,int base)
   {
      if (value < base)
         return "" + digits[(int)value];
      else
         return changeBase(value/base,base) + digits[(int)(value%base)];
   }
}
