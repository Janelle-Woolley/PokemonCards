import ecs100.*;
/**
 * Class handles GUI functions.
 * Buttons and Displaying images and Text
 *
 * @author Janelle Woolley
 * @version 1.0 09/05/23
 */

public class GUI {
  private CardHashMap cardStack; // creates a hashmap obj from CardHashMap class
  private Card card; // creates a card obj from Card class

  /**
   * Constructor for objects of class GUI.
   */
  public GUI()
  {
    cardStack = new CardHashMap(); // initialise the hashmap
    UI.initialise(); // initialise GUI
    
    // create buttons
      // search button
      // quit button
      // add card button
      // hide details button
      // show all cards details buttons
    // create mouse listener
  }
  
  // method to get name input
  // method to get price input
  // method to get image input
  // method to add inputs to hashmap
  // method to clear text pane
  // method to clear graphics pane
  // method to diplay card image & details
}
