public class Student extends Person
{
	private double gpa;

	public Student(String name, int numLegs, double gpa)
	{
		super(name, numLegs);
		this.gpa = gpa;
	}

	public boolean equals(Object other)
	{
		return super.equals(other) && gpa==((Student)other).gpa;
	}

	public String toString()
	{
		return super.toString() + " and a Student Object with a " + gpa + " gpa";
	}
}