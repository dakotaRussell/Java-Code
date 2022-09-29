public class Person extends Animal
{
	private String name;

	public Person(String name, int legs)
	{
		super(legs);
		this.name = name;
	}

	public boolean equals(Object other)
	{
		return super.equals(other) && name.equals(((Person)other).name);
	}

	public String toString()
	{
		return super.toString() + " and a Person object whose name is " + name + "";
	}
}