import java.util.Scanner;

/**
 * Write a description of class RochambeauGame here.
 * 
 * @author Julie Workman 
 * @version 1.0
 * @version 1/08/09
 */
public class RochambeauGame
{
    public static void main(String[] argv)
    {
        int p2Throw, winner;
        
        // Declare and construct a Scanner object to read from the command-line
        Scanner scanner = new Scanner(System.in);

        // Prompt for a name
        System.out.print("What is your name? ");
       
        // Read the name using the Scanner
        String name = scanner.nextLine();

        // Construct a computer and human RochambeauPlayer
        RochambeauPlayer p1 = new RochambeauPlayer("Computer");
        RochambeauPlayer p2 = new RochambeauPlayer(name);
        
        // Prompt for a win total
        System.out.print("How many wins shall we play until? ");
       
        // Read the name using the Scanner
        int winTotal = scanner.nextInt();
       
	  // Main game loop.
        while (p1.getWins()< winTotal && p2.getWins() < winTotal) {
            System.out.println();
            System.out.println(p1);
            System.out.println(p2);
            
            System.out.print("Make throw (0 - Rock, 1 - Paper, 2 - Scissors):");
            p2Throw = scanner.nextInt();
            
            winner = Rochambeau.getWinner(p1.makeThrow(), p2.makeThrow(p2Throw));
            
            System.out.println(p1.getName() + " throws " + p1.lastThrow());
            System.out.println(p2.getName() + " throws " + p2.lastThrow());
            
            if (winner == 1) {
                System.out.println(p1.getName() + " wins the round.");
                p1.incrementWins();
            }
            else if (winner == -1) {
                System.out.println(p2.getName() + " wins the round.");
                p2.incrementWins();
            }
            else 
                System.out.println("This round is a tie.");
        }
        
        // Match is over.  Print winner.
        if (p1.getWins() == winTotal)
            System.out.println(p1.getName() + " wins the match.");
        else
            System.out.println(p2.getName() + " wins the match.");
    }
}