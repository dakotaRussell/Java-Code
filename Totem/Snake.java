public class Snake implements TotemPole
{
	TotemPole rest;

	public Snake(TotemPole rest)
	{
		this.rest=rest;
	}

	public int power()
	{
		return 3 + rest.power();
	}

	public int height()
	{
		return 1 + rest.height();
	}

	public boolean chiefPole(int bearCount)
	{
		if (bearCount < 3) 
			return rest.chiefPole(0);

		else
			return true;
	}
}