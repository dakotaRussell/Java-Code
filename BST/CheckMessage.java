/*Dakota Dehn CPE 103*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class CheckMessage
{
	
	public static void main (String[ ] args) throws Exception
	{
		//RecordBST dict, alarmWords;

		//creating the Dictionary
		Scanner scanText = new Scanner(new File(args[1]));
		RecordBST dict = new RecordBST(scanText.nextLine());
		while (scanText.hasNext())
			dict.addItem(scanText.nextLine());

		//creating the alarmWords tree
		scanText = new Scanner(new File(args[2]));
		RecordBST alarmWords = new RecordBST(scanText.nextLine());
		while (scanText.hasNext())
				alarmWords.addItem(scanText.nextLine());

		//if they are more than one alarm word file
		for (int i=3; i<args.length; i++)
		{
			scanText = new Scanner(new File(args[i]));
			while (scanText.hasNext())
				alarmWords.addItem(scanText.next());
		}

		System.out.println("\nAnalyzing the file " + args[0] + " ...\n" );
		System.out.println("Checking against the file " + args[1] + " ...");
		System.out.println("these words were not found: ");

		//spell checking the entire message
		scanText = new Scanner(new File(args[0]));
		while (scanText.hasNext())
			dict.spellCheck(scanText.next());

		//alarm word checking the entire message
		System.out.println("\nChecking against the alarms files...");
		System.out.println("these words were found: ");
		scanText = new Scanner(new File(args[0]));
		while (scanText.hasNext())
			alarmWords.flagItems(scanText.next());

		alarmWords.printFlaggedItems(alarmWords.root);
	}
	
}