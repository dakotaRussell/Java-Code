public class Eagle implements TotemPole
{

	public Eagle()
	{}

	public int power()
	{
		return 2;
	}

	public int height()
	{
		return 1;
	}

	public boolean chiefPole(int bearCount)
	{
		return (bearCount >= 3); 
	}
}