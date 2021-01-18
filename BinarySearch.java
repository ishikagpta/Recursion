
/**
 * 
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Recursion, BinarySearch
 * @date 11/11/20
 *
 */

/**
 * 
 * @version 1.0 Class BinarySearch inherits super class SearchAlgorithm and its
 *          members and does a binary search of items in the text file
 *
 */
public class BinarySearch extends SearchAlgorithm {

	@Override
	/**
	 * This search method overrides the SearchAlgorithm search method and performs a
	 * binary search (non-recursive). The logic is to divide the array in almost
	 * halves and compare the word to be found with the middle word. Array must be
	 * sorted for binary search. It first resets the count by calling the
	 * SearchAlgorithm method resetCount, creates local variables left, right, and
	 * middle, initializes left to 0, right to the array length minus 1, and makes a
	 * while loop that works if left is less than or equal to the right. It then
	 * increments the count by calling SearchAlgorithm method incrementCount and
	 * calculates the middle. It also creates an int called value that compares the
	 * target word with the middle word. If the word compared to the middle word is
	 * equal then it returns the middle. If the word compared to the middle returns
	 * a value greater than 0, then the right from the middle is searched. Else, the
	 * left to the middle is used to search for the word. ItemNotFoundException is
	 * thrown if the word is never found.
	 */
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		resetCount();
		int left, right, middle;

		left = 0;
		right = words.length - 1;

		while (left <= right) {

			incrementCount();// to count at what number of compare, the word is found

			// find the middle index of the array
			middle = (left + right) / 2;

			// compare the word to be found with middle word in the array
			int value = wordToFind.compareTo(words[middle]);
			// if the word match the middle index, then return the index
			if (wordToFind.equals(words[middle])) {
				return middle;
			} else if (value > 0) {// if the returned value after compare is greater than 0, then shift the left to
				left = middle + 1;// middle index + 1 (use the right from the middle)
			} else {// else shift the right index to middle - 1. (use the left to the middle)
				right = middle - 1;
			}
		}
		// in the event the item is not found, throw the below exception.
		throw new ItemNotFoundException(wordToFind);
	}

	@Override
	/**
	 * below binary search method overrides the recSearch method of the
	 * SearchAlgorithm class and uses helper recursion method recSearchSub. It also
	 * resets the count by calling the resetCount method from SearchAlgorithm
	 */
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		resetCount();
		return recSearchSub(words, wordToFind, 0, words.length - 1);
	}

	/**
	 * Below recSearchSub is a new helper method for the recSearch method in this
	 * class and uses recursion for finding the word. It first checks to see if the
	 * last word is greater or equal to the first word and if the first word is less
	 * than the array length, if it is then it continues else it goes down to the
	 * else statement that throws the ItemNotFoundException. If it continues, then
	 * it calculates the middle index by adding the first and last index and divides
	 * them by 2. It then checks the base case to see if the middle index word
	 * equals the target, if it does then it returns the middle. Else if the the
	 * middle index word compared to the target word is greater than 0, it calls the
	 * method again and in the parameter makes the last equal to middle-1. Else, it
	 * calls the method again and in the parameter makes the first equal to middle+1
	 * 
	 * @param sampleArray
	 * @param target
	 * @param first
	 * @param last
	 * @return value
	 * @throws ItemNotFoundException
	 */
	private int recSearchSub(String sampleArray[], String target, int first, int last) throws ItemNotFoundException {
		if (last >= first && first < sampleArray.length) {
			incrementCount();
			int middle;

			// calculate the middle index
			middle = (first + last) / 2;

			// Base case: is the array contains the target word
			if (sampleArray[middle].equals(target)) {
				return middle;
			} else if (sampleArray[middle].compareTo(target) > 0) {// recursive case by shifting last to middle -1 if
																	// the
																	// compare to return is greater than 0
				return recSearchSub(sampleArray, target, first, middle - 1);
			} else {// recursive case by shifting first to middle + 1 if the
				// compare to return is less than 0
				return recSearchSub(sampleArray, target, middle + 1, last);
			}
		} else {
			throw new ItemNotFoundException(target);
		}
	}
}