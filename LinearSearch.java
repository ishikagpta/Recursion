
/**
 * 
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Recursion, LinearSearch 
 * @date 11/11/20
 *
 */

/**
 * 
 * @version 1.0 Class LinearSearch inherits super class SearchAlgorithm and its
 *          members and does a Linear Search for items in text file
 *
 */
public class LinearSearch extends SearchAlgorithm {

	@Override
	/**
	 * This search method overrides the search method in the SearchAlgorithm class
	 * and performs a linear search (non-recursive). It first resets the count by
	 * calling the resetCount method from the SearchAlgorithm class. It then checks
	 * to see if the array length is 0, in which case it throws the
	 * ItemNotFoundException. The logic is to loop the array full of words and
	 * compare the word to be found with every value in the array and return the
	 * index i at which the target word equals to the word in the array. With each
	 * run through the loop, the incrementCount method from the super class is
	 * called as well to keep track and count of the number of words that the loop
	 * has gone through.
	 */
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		resetCount();
		// if the array has no elements, throw exception.
		if (words.length == 0) {
			throw new ItemNotFoundException(wordToFind);
		}
		// Loop in the array and search the word at every element
		for (int i = 0; i < words.length; i++) {
			// call method incrementCount()
			incrementCount();
			if (words[i].equals(wordToFind)) {// if the word is found then return the index.
				return i;
			}
		}
		// throws exception if word is never found
		throw new ItemNotFoundException(wordToFind);
	}

	@Override
	/**
	 * The below recSearch method overrides the SearchAlgorithm recSearch method by
	 * doing a linear search using recursion. It calls the helper method
	 * recSearchSub in its body. It also resets the count by calling the resetCount
	 * method from SearchAlgorithm
	 */
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		resetCount();
		return recSearchSub(words, 0, words.length - 1, wordToFind);
	}

	/**
	 * The below recSearchSub method is the helper method that linearly searches for
	 * the word using recursion. It first checks to see if the last index is greater
	 * than or equal to first and if the first index is less than the array length.
	 * It then checks the base case to see if the array has the target word at the
	 * last index and returns last if so and calls the incrementCount method from
	 * SearchAlgorithm to keep track of count. It then checks the other base case to
	 * see if the array has the target word at the first index and returns first if
	 * so and calls the incrementCount method from SearchAlgorithm to keep track of
	 * count. It then calls the incrementCount method from SearchAlgorithm to keep
	 * track of count and calls the method again and upps the parameter first by 1
	 * and decreases the parameter last by 1. If the first if check criteria was not
	 * met, it goes into the bottom else statement where it throws the
	 * ItemNotFoundException.
	 * 
	 * @param sampleArray
	 * @param first
	 * @param last
	 * @param value
	 * @return
	 * @throws ItemNotFoundException
	 */
	private int recSearchSub(String sampleArray[], int first, int last, String value) throws ItemNotFoundException {
		if (last >= first && first < sampleArray.length) {
			incrementCount();
			if (sampleArray[last].equals(value)) { // Base case: is the array contains the target word at last
				incrementCount(); // index
				return last;
			} else if (sampleArray[first].equals(value)) { // Base case: is the array contains the target word at first
				incrementCount(); // index
				return first;
			} else { // recursive case by shifting last to last - 1 and first to first + 1
				incrementCount();
				return recSearchSub(sampleArray, first + 1, last - 1, value);
			}
		} else {
			throw new ItemNotFoundException(value);
		}

	}
}
