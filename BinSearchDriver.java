
/**
 * Linear and Binary Search Homework 5 Driver
 * CSS 143
 * 
 * Note that nothing in this class needs to be changed except for your FILE_AND_PATH variable
 * 
 * Implement the Binary Search using both the iterative and recursive techniques covered
 * in class
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinSearchDriver {

	public final static String FILE_AND_PATH = "c:\\Ishika\\longwords.txt";
	/*
	 * TODO: Be sure to change the FILE_AND_PATH to point to your local copy of
	 * longwords.txt or a FileNotFoundException will result
	 */

	// Note how we deal with Java's Catch-or-Declare rule here by declaring the
	// exceptions we might throw
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(FILE_AND_PATH));
		int wordCount = 0;
		ArrayList<String> theWords = new ArrayList<String>();

		// read in words, count them
		while (input.hasNext()) {
			theWords.add(input.next());
			wordCount++;
		}

		// make a standard array from an ArrayList
		String[] wordsToSearch = new String[theWords.size()];
		theWords.toArray(wordsToSearch);

		// start with the linear searches
//		tryLinearSearch(wordsToSearch, "DISCIPLINES");
		tryLinearSearch(wordsToSearch, "ABACTERIAL");
		tryLinearSearch(wordsToSearch, "TRANSURANIUM");
		tryLinearSearch(wordsToSearch, "HEURISTICALLY");
		tryLinearSearch(wordsToSearch, "FOO");

		// and compare these results to the binary searches
//		tryBinarySearch(wordsToSearch, "DISCIPLINES");
		tryBinarySearch(wordsToSearch, "ABACTERIAL");
		tryBinarySearch(wordsToSearch, "AGGRESSIVENESS");
		tryBinarySearch(wordsToSearch, "HEURISTICALLY");
		tryBinarySearch(wordsToSearch, "FOO");

	}

	/**
	 * Method tryBinarySearch precondition: wordsToSearch is a nonempty array of
	 * Strings, and target is a non-null string to search for in our collection of
	 * strings postcondition: Uses a BinarySearch object (which implements this
	 * style of search) to try to find the target string
	 */
	private static void tryBinarySearch(String[] wordsToSearch, String target) {
		// Todo: Build a LinearSearch class that inherits from SearchAlgorithm, and put
		// it in the same directory as this class to successfully compile
		SearchAlgorithm bs = new BinarySearch();

		try {
			System.out.println("Iterative Search");
			System.out.print(target + " found at index: " + bs.search(wordsToSearch, target));
			System.out.println(" taking " + bs.getCount() + " comparisons.");

			System.out.println("Binary Search");
			System.out.print(target + " found at index: " + bs.recSearch(wordsToSearch, target));
			System.out.println(" taking " + bs.getCount() + " comparisons.");
		} catch (ItemNotFoundException e) {
			System.out.println(target + ":" + e.getMessage());
		}
	}

	/**
	 * Method tryLinearSearch precondition: wordsToSearch is a nonempty array of
	 * Strings, and target is a non-null string to search for in our collection of
	 * strings postcondition: Uses a LinearSearch object to try to find the target
	 * string
	 */
	private static void tryLinearSearch(String[] wordsToSearch, String target) {
		// Todo: Build a LinearSearch class that inherits from SearchAlgorithm, and put
		// it in the same directory as this class to successfully compile
		SearchAlgorithm bs = new LinearSearch();

		try {
			System.out.print(target + " found at index: " + bs.search(wordsToSearch, target));
			System.out.println(" taking " + bs.getCount() + " comparisons.");

		} catch (ItemNotFoundException e) {
			System.out.println(target + ":" + e.getMessage());
		}
	}

}
