//Rochambeau 

public class Rochambeau
{
	public static final int PAPER = 1;
	public static final int ROCK = 0;
	public static final int SCISSORS = 2; 

	public static int getWinner(int throw1, int throw2)
	{
		if (throw1 == throw2)
		{
			return 0;
		}

		else if(throw2 > throw1 || (throw2 == ROCK && throw1 == SCISSORS))
		{
			return -1;
		}

		else 
		{
			return 1;
		}
	}
}