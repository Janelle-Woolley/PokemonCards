import ecs100.*;
import java.util.*;
/**
 * Class handles GUI functions.
 * Buttons and Displaying images and Text
 *
 * @author Janelle Woolley
 * @version 1.0 15/05/23
 */

public class GUI {
  private CardHashMap cardStack; // creates a hashmap obj from CardHashMap class
  private Card card; // creates a card obj from Card class

  /**
   * Constructor for objects of class GUI.
   */
  public GUI() {
    cardStack = new CardHashMap(); // initialise the hashmap
    UI.initialise(); // initialise GUI
    
    // create buttons
    UI.addButton("Quit", UI::quit);  // quit button
    UI.addButton("Add Card", this::addCard);  // add card button
    UI.addButton("Hide Details", this::clearTextPane);  // hide details button
    UI.addButton("Show All Details", this::printAll);  // show all cards details buttons
    UI.addButton("Search", this::search);  // search button
    // create mouse listener
  }
  
  /**
   * Asks user for card name input.

   * @return String name input
   */
  public String askName() {
    boolean gettingName = true; // boolean for looping
    String name = UI.askString("Enter the card name: "); // ask for input
    
    // loops until the input is valid
    while (gettingName) {
      // checks if the input is just whitespaces
      if (name.isBlank()) {
        name = UI.askString("Enter the card name: ");
      } else if (cardStack.compareCard(name.toUpperCase())) { // checks if the input is already in the hashmap
        UI.println("Card already in collection");
        name = UI.askString("Enter a new card name: ");
      } else { // otherwise input is valid and loop ends
        gettingName = false;
      }
    }
    return name; // returns input
  }

  /**
   * Asks user for card's monetary value input.

   * @return double monValue input
   */
  public double askMonValue() {
    boolean gettingMonValue = true; // boolean for looping
    
    // max and min values for the monetary value
    final int MAX_MON_VALUE = 5275000;
    final int MIN_MON_VALUE = 0;
    
    double monValue = 0; // declare and initialise variable for santised input
    String checkMonValue = ""; // declare and initialise string for holding input
    
    // declare and initialise scanner to scan string input
    Scanner isDouble = new Scanner(checkMonValue);
    
    checkMonValue = UI.askString("Enter the card's monetary value: "); // ask for input
    
    // loops until input is valid
    while (gettingMonValue) {
      isDouble = new Scanner(checkMonValue); // creates new scanner object to ensure buffer gets cleared
      
      // checks if input contains a double
      if (isDouble.hasNextDouble()) {
        monValue = isDouble.nextDouble();
        // checks if the input is the range of expected options
        if (monValue > MIN_MON_VALUE && monValue < MAX_MON_VALUE){  
          gettingMonValue = false;
        } else { // otherwise continue looping
          checkMonValue = UI.askString("Enter the card's monetary value (0-5275000): ");
        }
      } else { // otherwise continue looping
          checkMonValue = UI.askString("Enter the card's monetary value: ");
      }
    }
    
    return monValue; // returns input
  }
  
  /**
   * Asks user for card image input.

   * @return String imageFileName input
   */
  public String askImage() {
    // ask for input
    UI.println("Choose Card Image File: ");
    String imgFileName = UIFileChooser.open();
    // returns input
    return imgFileName;
  }
  
  /**
   * Collects inputs add adds them to hashmap.
   */
  public void addCard() {
    String name = askName(); // get card name input
    double monValue = askMonValue(); // get card monetary value
    String image = askImage(); // get card image
    
    cardStack.addCard(name.toUpperCase(), monValue, image); // add inputs to hashmap
  }
  
  /**
   * Prints out all the cards details.
   */
  public void printAll() {
    cardStack.printAllDetails();
  }
  
  /**
   * Displays details and image of a card the user wants
   */
  public void search() {
    String findCard = UI.askString("Enter card name to search for: "); // ask for input
    
    // checks if input is in hashmap
    if (cardStack.compareCard(findCard.toUpperCase())) {
      // gets the current card
      card = cardStack.getCard();
      
      // clear screen for printing
      clearTextPane();
      clearGraphicsPane();
      
      card.printDetails(); // prints details
      card.displayImage(); // displays image
      card.setDisplay(true); // sets display to true 
    } else { // otherwise print error message
      UI.println("Card not Found!");
    }
  }
  
  /**
   * Clears text pane
   */
  public void clearTextPane() {
    UI.clearText();
  }
  
  /**
   * Clears graphics pane
   */
  public void clearGraphicsPane() {
    card.setDisplay(false); // set displaying card image to false
    UI.clearGraphics();
  }
}
