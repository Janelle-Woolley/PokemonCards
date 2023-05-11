import java.util.HashMap;
/**
 * Holds Cards in a HashMap.
 *
 * @author Janelle Woolley
 * @version 1.0 09/05/23
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
  }
  
  /**
   * Adds a card to the hashmap
   */
  public void addCard(String name, Float monValue, String image) {
    currentId++;// update current id
    cardHashMap.put(currentId, new Card(name, monValue, image)); // add card to hashmap
  }
  
  // create method to check if a name matches one in the hashmap
  // create method to loop through hashmap to print card details
}
