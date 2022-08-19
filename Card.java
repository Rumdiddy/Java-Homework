/**
 *  Author: Sam Jin (JHED: sjin16)
 *  Date Finished: 11/14/2019
 *
 *  Class whose instances represent single playing card from
 *  deck of cards.
 */

public class Card {
   /**
    * Attribute for rank.
    */
   private int rank;
   /**
    * Attribute for suit.
    */
   private int suit;
   /**
    * String array representing suits.
    */
   private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
   /**
    * String array representing face cards.
    */
   private String[] face = new String[14];
   
   
   /**
    * Creates a new Cards with the given name.
    * @param r rank
    * @param s suit
    */
   public Card(int r, int s) {
      rank = r;
      suit = s;
   }
   
   /**
    * Gets the integer rank value.
    * @return rank string version of int rank
    */
   public String getRank() {
      face[1] = "Ace";
      face[11] = "Jack";
      face[12] = "Queen";
      face[13] = "King";
      if (rank >= 2 && rank <= 10) {
         return Integer.toString(rank);
      } else {
         return face[rank];
      }         
   }
   
   /**
    * Gets the integer suit value.
    * @return suit String version of suit
    */
   public String getSuit() {
      return suits[suit - 1];
   }
   
   /**
    * Compares this Card with the specified otherCard for order.
    * @param otherCard the other Card object to be compared.
    * @return a negative integer, zero, or a positive integer as
    * this object is less than, equal to, or greater than the otherCard.
    */
   public int compareTo(Card otherCard) {
      if (suit < otherCard.suit) {
         return -1;
      } else if (suit > otherCard.suit) {
         return 1;
      } else if (rank < otherCard.rank) {
         return -1;
      } else if (rank > otherCard.rank) {
         return 1;
      } else {
         return 0;
      }
   }

   
   @Override
   public String toString() {
      String rankS = getRank();
      String suitS = getSuit();
      String card = rankS + " of " + suitS;
      return card;         
   }
   
   @Override
   public boolean equals(Object other) {
      if (other == this) {
         return true;
      }
      if (!(other instanceof Card)) {
         return false;
      }
      Card o = (Card) other;
      
      return Integer.compare(rank, o.rank) == 0 &&
         Integer.compare(suit, o.suit) == 0;
   }
}