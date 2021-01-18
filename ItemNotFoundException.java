/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Recursion, ItemNotFoundException
 * @date 11/5/20
 */

/**
 * 
 * @version 1.0 This custom ItemNotFoundExceptio class extends the Exception
 *          class and creates one no arg class constructor that calls the no arg
 *          super constructor and also creates a String parameter class
 *          constructor that calls the String parameter super constructor
 *
 */
public class ItemNotFoundException extends Exception {

	/**
	 * no arg ItemNotFoundException constructor that calls the parent constructor in
	 * its body that prints a String statement
	 */
	public ItemNotFoundException() {
		super("The string given could not be found! ");
	}

	/**
	 * ItemNotFoundException constructor that takes in a string and calls the parent
	 * constructor to print the string when the item is not founds
	 * 
	 * @param message
	 */
	public ItemNotFoundException(String message) {
		super("Unable to find item " + message);
	}

}
