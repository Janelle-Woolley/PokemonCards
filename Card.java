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
  
  private final int LOCX = 100;
  private final int LOCY = 100;
  private final double WIDTH = 200;
  private final double HEIGHT = 250;
  
  
  /**
   * Constructor for objects of class Card.
   */
  public Card(String name, double CardValue, String image) {
    // intailise the variables for card details
    this.cardName = name;
    this.cardMonetaryValue = CardValue;
    
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
   * Displays card image in graphics pane.
   */
  public void displayImage() {
    UI.drawImage(this.cardImage, LOCX, LOCY, WIDTH, HEIGHT); // print image
  }
  
  /**
   * Checks if x y cords are in range of the card image.

   * @return boolean if cords in range
   */
  public boolean onImage(double x, double y) {
    // checks if the x, y are in range
    if ((x >= LOCX) && (x <= LOCX + WIDTH) && (y >= LOCY) && (y <= LOCY + HEIGHT)) {
      return true;
    } else {
      return false;
    }
  }
}
