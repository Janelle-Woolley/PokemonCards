import ecs100.*;
import java.util.*;
/**
 * Class handles GUI functions.
 * Buttons and Displaying images and Text
 *
 * @author Janelle Woolley
 * @version 1.0 10/05/23
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
      // add card button
      // hide details button
      // show all cards details buttons
      // search button
    // create mouse listener
  }
  
  /**
   * Asks user for card name input.
   */
  public String askName() {
    boolean gettingName = true; // boolean for looping
    String name = UI.askString("Enter the card name: "); // ask for input
    
    // loops until the input is valid
    while (gettingName) {
      // checks if the input is just whitespaces
      if (name.isBlank()) {
        name = UI.askString("Enter the card name: ");
      } else { // otherwise input is valid and loop ends
        gettingName = false;
      }
    }
    return name; // returns input
    
    // TO ADD:
    // checks if the input is already in the hashmap
  }

  /**
   * Asks user for card's monetary value input.
   */
  public float askMonValue() {
    boolean gettingMonValue = true; // boolean for looping
    
    // max and min values for the monetary value
    final float MAX_MON_VALUE = 5275000;
    final float MIN_MON_VALUE = 0;
    
    float monValue = 0; // declare and initialise variable for santised input
    String checkMonValue = ""; // declare and initialise string for holding input
    
    // declare and initialise scanner to scan string input
    Scanner isFloat = new Scanner(checkMonValue);
    
    checkMonValue = UI.askString("Enter the card's monetary value: "); // ask for input
    
    // loops until input is valid
    while (gettingMonValue) {
      isFloat = new Scanner(checkMonValue); // creates new scanner object to ensure buffer gets cleared
      
      // checks if input contains a float
      if (isFloat.hasNextFloat()) {
        monValue = isFloat.nextFloat();
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
   */
  public String askImage() {
    // ask for input
    String imgFileName = UIFileChooser.open("Choose Card Image File: ");
    // returns input
    return imgFileName;
  }
  // method to add inputs to hashmap
  // method to clear text pane
  // method to clear graphics pane
  // method to diplay card image & details
}
