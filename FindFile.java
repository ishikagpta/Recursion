
/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Recursion, FindFile
 * @date 11/11/20
 */
import java.io.File;

/**
 * 
 * @version 1.0 The class FindFile has data members and methods to find file and
 *          file directory
 *
 */

public class FindFile {

	// instance variable keeps count of matching files
	public int count = 0;
	// instance variable stores the max amount of files allowed
	public int maxFiles = 0;
	// Array with all the paths for the target file and file locations
	public String[] filewithPathCopied = new String[0];
	// Array with all the paths for the target file and file locations
	public String[] filewithPath = new String[0];

	/**
	 * This class constructor initializes the maxFiles instance variable to the
	 * formal parameter maxFiles. It also makes a local array called DefineSize that
	 * is equal to the length of maxFiles plus 4. It then sets the filewithPath
	 * array to the DefineSize array
	 * 
	 * @param maxFiles
	 */
	FindFile(int maxFiles) {
		this.maxFiles = maxFiles;
		String[] DefineSize = new String[maxFiles + 4];
		filewithPath = DefineSize;
	}

	/**
	 * Below method recursively calls itself to find the target in given directory
	 * structure and stores all the occurrence of the file in an array,
	 * filewithPath. It starts with setting local fileList array to everything in
	 * directory and then loops through the fileList array. For each file it checks
	 * to see if it matches the target and is not a directory, which if true is
	 * stored in the filewithPath array and the count is upped. If the file is a
	 * directory then the directorySearch is recursively called. In the end,
	 * filewithPathCopied is set to filewithPath.
	 * 
	 * @param target
	 * @param dirName
	 * @throws Exception
	 */
	void directorySearch(String target, String dirName) throws Exception {
		File f = new File(dirName);// this is an object of File type
		String[] fileList = f.list();// store everything under the directory in the String Array fileList

		// Loop in all the values in fileList
		for (int i = 0; i < fileList.length; i++) {
			File aFile = new File(dirName + "\\" + fileList[i]);
			// if statement ensures that the count of matching files is not equal to or more
			// than the maxfiles allowed. If it is, exception statement is thrown and the
			// filewithPathCopied array is set equal to the filewithPath array
			if (count >= maxFiles) {
				filewithPathCopied = filewithPath;
				throw new Exception(toString() + "Max number of files have been reached!");
			}
			if (!(aFile.isDirectory())) {// check and proceed if the aFine is not a directory
				if (aFile.getName().equals(target)) {// Base case if the file is found
					String path = dirName + "\\" + fileList[i];// store the directory and file (complete path) in string
																// path variable.

					filewithPath[count] = path + "\n";// store all the paths for the file in the array
					count++;
				}
			} else if (aFile.isDirectory()) {// Recursive case when aFile is a directory type, call directorySearch
												// method recursively.
				directorySearch(target, dirName + "\\" + aFile.getName());

			}
		}
		// if statement ensures that the count of matching files is not equal to or more
		// than the maxfiles allowed. If it is, exception statement is thrown and the
		// filewithPathCopied array is set equal to the filewithPath array
		if (count >= maxFiles) {
			filewithPathCopied = filewithPath;
			throw new Exception(toString() + "Max number of files have been reached!");
		}
		filewithPathCopied = filewithPath;// overwrite filewithPathCopied with filewithPath
	}

	/**
	 * Accessor method returns the count of matching files
	 * 
	 * @return count
	 */
	int getCount() {
		return count;
	}

	/**
	 * This method accesses the filewithPathCopied array that stores the list of
	 * file locations and returns it
	 * 
	 * @return filewithPathCopied
	 */
	public String[] getFiles() {
		return filewithPathCopied;
	}

	/**
	 * This toString method stores the file paths from the filewithPathCopied array
	 * in the String str and returns it if it is not null. If it is null, aka the
	 * str length is 0, No file found statement is returned
	 */
	public String toString() {
		String str = "";

		for (int i = 0; i < filewithPathCopied.length; i++) {
			if (filewithPathCopied[i] != null) {
				str += filewithPathCopied[i];
			}
		}
		// exception handling is no data in the String
		if (str.length() == 0) {
			str = "No file found";
		}
		return str;
	}
}