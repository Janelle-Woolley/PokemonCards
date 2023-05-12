
/**
 * Support class for GUI and CardHashMap.
 * Creates Cards
 *
 * @author Janelle Woolley
 * @version 1.0 09/05/23
 */

public class Card {
  // variables for card details
  private String cardName;
  private double cardMonataryValue;
  private String cardImage;
  private static final String DEFAULTIMAGE = "default.jpg";
  private boolean cardDisplayed;

  /**
   * Constructor for objects of class Card.
   */
  public Card(String name, double CardValue, String image) {
    // intailise the variables for card details
    this.cardName = name;
    this.cardMonataryValue = CardValue;
    this.cardDisplayed = false;
    
    // if the user selects cancel instead of and image
    if (image == null) {
        this.cardImage = DEFAULTIMAGE;
    } else {
        this.cardImage = image;
    }
  }
  
  /**
   * Consructor overloading for objects of class Card.
   */
  public Card(String name, double cardValue) {
    this(name, cardValue, null);
  }
  
  /**
   * Getter for card name

   * @return cardName
   */
  public String getCardName() {
    return this.cardName;
  }
  
  // create method to display card details in text pane
  // create method to display card image in GUI
}
