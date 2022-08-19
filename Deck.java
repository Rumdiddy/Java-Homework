/**
 *  Author: Sam Jin (JHED: sjin16)
 *  Date Finished: 11/14/2019
 *
 *  Class whose instances represent deck of cards.
 */

public class Deck {
   /**
    * String array representing the cards in the deck.
    */
   private String[] deckS;  
   /**
    * Card array representing the card objects in the deck.
    */
   private Card[] deckC; 
   
   /**
    * Creates a new deck with the given name.
    */
   public Deck() {
      deckS = new String[52];
      deckC = new Card[52];
      int index = 0;
      for (int s = 1; s < 5; s++) {
         for (int r = 1; r < 14; r++) {
            Card temp = new Card(r, s);
            deckS[index] = temp.toString();
            if (temp != null) {
               deckC[index] = temp;
            }
            index++;
         }
      }
         
   }
   
   /**
    * Instance method that shuffles deck of cards.
    */
   public void shuffle() {
      for (int i = 0; i < deckS.length; i++) {
         int r = randomInt(i, 51);
         swap(i, r);
      }
   }
   
   /**
    * Instance method that sorts deck of cards.
    */
   public void sort() {
      //suit sort
      int smallesti = 0;
      for (int z = 0; z < deckS.length; z++) {
         smallesti = 0;
         for (int k = 0; k < deckS.length; k++) {
            for (int i = 0; i < deckS.length; i++) {
               for (int j = i; j < deckS.length; j++) {
                  if (deckC[j].compareTo(deckC[smallesti]) == -1) {
                     smallesti = j;
                  }
               }
               swap(i, smallesti);
            }
         }
      }
      
   }  
      
   /**
    * Helper subroutine that swaps cards.
    * @param index1 first card index
    * @param index2 second card index
    */
   private void swap(int index1, int index2) {
      String tempval = deckS[index1];
      Card tempval2 = deckC[index1];
      deckS[index1] = deckS[index2];
      deckC[index1] = deckC[index2];
      deckS[index2] = tempval;
      deckC[index2] = tempval2;
   }
   
   /**
    * Helper subroutine that generates randomInt.
    * @param low lower threshold
    * @param high upper threshold
    * @return rand the random integer
    */
   private int randomInt(int low, int high) {
      int rand = (int) (Math.random() * ((high - low) + 1)) + low;
      return rand;
   }
   
   @Override
   public String toString() {
      String output = "";
      String tempoutput;
      for (int i = 0; i < 52; i++) {
         tempoutput = deckS[i] + "\n";
         output = output + tempoutput;
      }
      return output;              
   }
   
}