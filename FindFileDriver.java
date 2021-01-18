
/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Recursion, FindFileDriver
 * @date 11/11/20
 */
import java.io.File;

/**
 * 
 * @version 1.0 This FindFileDriver class tests the FindFile class assigning the
 *          targetFile, pathToSearch, and max number of files to find. It then
 *          prints the matching file paths if it is below the max number of
 *          files. If it is not below the max number of files, it goes down to
 *          the catch statement and prints the previous file paths along with
 *          exception statements. If the original directory path itself does not
 *          exist, an else statement is printed that states that the input file
 *          path is invalid.
 *
 */
public class FindFileDriver {

	/**
	 * This main method tests the FindFile class by creating local variables for the
	 * target file, the path to search, and the max number of files that can be
	 * found. It first makes a File class object equal to the directory. It then
	 * checks to see if the directory path is valid. If it is, it goes into the try
	 * statement where the FindFile object is set equal to the max number of files
	 * that can be found and then the FindFile directorySearch method is called
	 * using the target file and path to search as parameters. It then prints the
	 * full paths by calling the toString method of FindFile. The statement goes
	 * into the catch statement if the number of matching files is equal to or
	 * exceeds the max number of files to find. This is where the Exception is
	 * printed. If, originally, the directory path was not valid, then it would have
	 * skipped down to the else statement were Input path is invalid would be
	 * printed.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String targetFile = "a.txt";// Target file to be searched
		String pathToSearch = "C:\\Ishika\\Ishika";// Directory to begin with the search
		int MAX_NUMBER_OF_FILES_TO_FIND = 4;// constant max value allowed for finding the occurrence of the target file

		File tmpDir = new File(pathToSearch); // creates a File object called tmpDir that is set equal to a copy File of
												// the directory to begin with the search
		boolean exists = tmpDir.exists();// check if the input directory path is valid.

		if (exists) {// Check if the directory structure exists then proceed
			FindFile finder = null; // creates a FindFile object and sets it to null
			try {
				finder = new FindFile(MAX_NUMBER_OF_FILES_TO_FIND); // sets the FindFile object to a new FindFile with
																	// parameter of the max number of files to find
				finder.directorySearch(targetFile, pathToSearch);// Call the method directorySearch of class FindFile
																	// passing the file name and initial directory path

				// Print the output as full paths where the file was found.
				System.out.println(finder.toString());

			} catch (Exception e) {
				e.printStackTrace(); // prints previous exceptions, namely in the directorySearch method in the
										// FindFile class if file was found up until the max file count
			}

		} else {// Raise exception if the directory doesn't exist.
			System.out.println("Input Path is invalid");
		}
	}
}
