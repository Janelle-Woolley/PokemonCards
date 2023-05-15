import ecs100.*;
/**
 * Support class for GUI and CardHashMap.
 * Creates Cards
 *
 * @author Janelle Woolley
 * @version 1.0 15/05/23
 */

public class Card {
  // variables for card details
  private String cardName;
  private double cardMonetaryValue;
  private String cardImage;
  private static final String DEFAULTIMAGE = "default.jpg";
  private boolean cardDisplayed;

  /**
   * Constructor for objects of class Card.
   */
  public Card(String name, double CardValue, String image) {
    // intailise the variables for card details
    this.cardName = name;
    this.cardMonetaryValue = CardValue;
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
  
  /**
   * Prints out card's details.
   */
  public void printDetails() {
    UI.println("---------------------");
    UI.println("Name: " + this.cardName);
    UI.println("Monetary Value: $" + this.cardMonetaryValue);
    UI.println("---------------------");
  }
  
  /**
   * Displays card image in graphics pane
   */
  public void displayImage() {
    // declare and initialise constant variables
    final int LOCX = 100;
    final int LOCY = 100;
    final double WIDTH = 200;
    final double HEIGHT = 250;
    
    UI.drawImage(this.cardImage, LOCX, LOCY, WIDTH, HEIGHT); // print image
  }
  
  /**
   * Setter for boolean cardDisplayed
   */
  public void setDisplay(boolean displayState) {
    this.cardDisplayed = displayState;
  }
}
