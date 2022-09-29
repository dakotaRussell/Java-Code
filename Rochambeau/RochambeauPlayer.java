import java.util.Random;
import java.lang.String;

public class RochambeauPlayer
{
	private int lastThrow;
	private String name;
	private Random rand;
	private int wins;

	public RochambeauPlayer(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public int getWins()
	{
		return wins;
	}

	public void incrementWins()
	{
		wins++;
	}

	public String lastThrow()
	{
		if (lastThrow == Rochambeau.ROCK)
		{
			return "Rock";
		}

		else if (lastThrow == Rochambeau.PAPER)
		{
			return "Paper";
		}

		else if(lastThrow == Rochambeau.SCISSORS)
		{
			return "Scissors";
		}

		else
		{
			return "No Throw";
		}
		
	}

	public int makeThrow()
	{
		rand = new Random();
		lastThrow = rand.nextInt(3);
		return lastThrow;
	}

	public int makeThrow(int throwType)
	{
		lastThrow = throwType;
		return lastThrow;
	}

	public java.lang.String toString()
	{
		return name + " has " + wins + " wins.";
	}
}