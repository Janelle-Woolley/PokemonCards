import java.util.HashMap;
/**
 * Holds Cards in a HashMap.
 *
 * @author Janelle Woolley
 * @version 1.0 15/05/23
 */

public class CardHashMap {
  private HashMap<Integer, Card> cardHashMap; // declear hashmap
  private int currentId; // declears int for card Id for hashmap
  private Card currCard; // creates a card obj from Card class
  
  /**
   * Constructor for objects of class CardHashMap.
   */
  public CardHashMap() {
    cardHashMap = new HashMap<Integer, Card>(); //initalise the hashmap
    currentId = 0; // intalise the currentId
    
    // add default cards
    addCard("PIKACHU", 32.69, "pikachu.jpg");
    addCard("EEVEE", 184, null);
  }
  
  /**
   * Adds a card to the hashmap.
   */
  public void addCard(String name, double monValue, String image) {
    currentId++; // update current id
    cardHashMap.put(currentId, new Card(name, monValue, image)); // add card to hashmap
  }
  
  /**
   * Loops through hashmap. 
   * Compares an input to card name values in hashmap

   * @return boolean if parameter matches a name
   */
  public boolean compareCard(String name) {
    // loop through hashmap
    for (int cardId : cardHashMap.keySet()) {
      // checks if parameter matches the card's name
      if (cardHashMap.get(cardId).getCardName().equals(name)) {
        currCard = cardHashMap.get(cardId); // sets card in hashmap to the current card
        return true; 
      }
    }
    
    return false; // if parameter doesn't match any card names
  }
  
  /**
   * Loops through hashmap printing out card details.
   */
  public void printAllDetails() {
    // loops through hashmap
    for (int cardId : cardHashMap.keySet()) {
      currCard = cardHashMap.get(cardId);
      currCard.printDetails();
    }
  }
  
  /**
   * Getter for the current card.

   * @return currCard
   */
  public Card getCard() {
    return this.currCard;
  }
}
