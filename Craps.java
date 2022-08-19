import java.util.Scanner;

/**
 *  Author: Sam Jin (JHED: sjin16)
 *  Date Finished: 10/16/2019
 *
 *  This class was written to create a Craps game implementation.
 */
public class Craps {
   /**
    * Minimum required bet.
    */
   private static final int MIN_BET = 5;
   /**
    * Number of sides of the die.
    */
   private static final int MAX_ROLL = 6;
   
   /**
    * Execution starts here.
    * @param args command-line arguments
    */
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      int wallet1 = getWallet(keyboard);
      int bet = makeBet(keyboard, wallet1);
      boolean cond1 = playRound();
      if (cond1) { 
         wallet1 = wallet1 + bet;
      } else {
         wallet1 = wallet1 - bet;
      }
      
      if (wallet1 > 0) {
         boolean cond2 = doAgain(keyboard);
         while (cond2) {
            bet = makeBet(keyboard, wallet1);
            cond1 = playRound();
            if (cond1) { 
               wallet1 = wallet1 + bet;
            } else {
               wallet1 = wallet1 - bet;
            }
            cond2 = doAgain(keyboard);
         }
      }
      goodbye(wallet1);
   }
   
   /**
    * Prompts user for the amount of money they have left to play.
    * Re-prompts and rejects values that are not at least MIN_BET.
    * @param scnr existing Scanner object from which to read user input
    * @return amount of money entered by user
    */
   public static int getWallet(Scanner scnr) {
      System.out.print("How much money do you have to play with? ");
      int wallet = scnr.nextInt();
      
      while (wallet < MIN_BET) {
         System.out.print("Invalid quantity. Enter value above 5$: ");
         wallet = scnr.nextInt();
      }
      return wallet;
   }
   
   /**
    * Prompts user to make a bet.
    * @param scnr existing Scanner object to read user input
    * @param wallet amount in the user's wallet
    * @return user's bet
    */
   public static int makeBet(Scanner scnr, int wallet) {
      System.out.println("You have " + wallet + "$ in your wallet");
      System.out.print("The minimum bet size is 5$. Place your bet: ");
      int bet = scnr.nextInt();
      
      if (bet < MIN_BET) {
         System.out.println("Your bet is below the minimum of 5$, try again.");
         bet = makeBet(scnr, wallet);
      } else if (bet > wallet) {
         System.out.print("Your bet is more than what is in your wallet");
         System.out.print(", try again.");
         bet = makeBet(scnr, wallet);
      }
      return bet;
   }
      
   
   /**
    * Prompts user if they want to play again.
    * @param scnr existing Scanner object from which to read user input
    * @return true if user wants to play again, false if otherwise
    */
   public static boolean doAgain(Scanner scnr) {
      System.out.println("Enter 1 to play again, 0 to quit:");
      int ui = scnr.nextInt();
      if (ui == 1) {
         return true;
      }
      return false;         
   }
   
   /**
    * Plays a round of craps with the user.
    * @return true if user won round, false otherwise
    */
   public static boolean playRound() {
      int roll1 = rollDice();
      System.out.println("You rolled a " + roll1);
      
      if (roll1 == 2 || roll1 == 3 || roll1 == 12) {
         System.out.println("You lose :-(");
         return false;
      } else if (roll1 == 7 || roll1 == 11) {
         System.out.println("You win :-)");
         return true;
      }
      return rollForPoint(roll1);    
   }
   
   /**
    * Prints goodbye message to user based on whether they went broke.
    * Broke if have less than MIN_BET, otherwise tells how much in wallet.
    * @param wallet amount of money in wallet
    */
   public static void goodbye(int wallet) {
      if (wallet == 0) {
         System.out.println("Sorry, you're broke...");
      } else {
         System.out.print("You have " + wallet);
         System.out.println(" left in your wallet. Goodbye!");
      }
   }
   
   /**
    * Repeatedly rolls dice until either the point value or 7 is rolled.
    * @param point the current point value
    * @return true if user rolled point value before rolling 7, false if roll 7.
    */
   public static boolean rollForPoint(int point) {
      int rollp = rollDice();
      System.out.println("You rolled a " + rollp);
      if (rollp == 7) {
         System.out.println("You lose :-(");
         return false;
      } else if (rollp == point) {
         System.out.println("You win :-)");
         return true;
      }          
      return rollForPoint(point); 
   }
   
   /**
    * Rolls a single die to obtain a value between 1 and 
    * MAX_ROLL, inclusive.
    * @return face value rolled
    */
   public static int rollDie() {
      // DO NOT MAKE CHANGES to rollDie() AND USE IT AS-IS
      int rand = (int) (Math.random() * 100);
      return (rand % MAX_ROLL + 1);
   }
   
   /**
    * Rolls a pair of dice.
    * @return sum of face values rolled
    */
   public static int rollDice() {
      int d1 = rollDie();
      int d2 = rollDie();
      int sum = d1 + d2;
      return sum;
   }
}

