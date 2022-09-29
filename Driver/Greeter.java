//Greeter

public class Greeter
{
	private String name;
	
	//instance variables
	public Greeter(String name)
	{
		this.name = name;
	}
	
	public String greet()
	{
		return "Hello " + name;
	}
}