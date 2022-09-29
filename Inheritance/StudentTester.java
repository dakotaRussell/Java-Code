public class StudentTester
{
	public static void main(String[]args)
	{
		Animal me= new Student("Dakota", 2, 3.9);
		Person you = new Student("Dakota", 2, 3.9);
		System.out.println(me.equals(you));
		System.out.println(me.toString());
	}
}