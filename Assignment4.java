import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author indreksoome
 * @class Object Oriented Programming SP24-CPSC-24500-001
 * Assignment 4: 
 * @date: March 8, 2024
 */

public class Assignment4 {
	/**
	 *
	 * @param filename
	 * @return number of lines in a text file
	 * @throws IOException if an input/output error occurs while reading the file
	 */
    
    public static int getNoLines(String filename) throws Exception {
        try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
            // Let's count and return the number of lines in the file
            return (int) fileStream.count();
        }
    }
    /**
	 * 
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */
    public static int[][] create2DArray(String filename) throws Exception {
        // Gets number of lines in the file to set the number of rows
        int rows = getNoLines(filename);
        int[][] array = new int[rows][];

        // Open given file using Scanner
        try (Scanner scanner = new Scanner(new File(filename))) {
            int row = 0;
            while (scanner.hasNextLine()) {
                // Reads the line and then it splits it into parts
                String[] parts = scanner.nextLine().trim().split("\\s+");
                array[row] = new int[parts.length]; // Create the row 
                // Parse each part as an integer
                for (int i = 0; i < parts.length; i++) {
                    array[row][i] = Integer.parseInt(parts[i]);
                }
                row++;
            }
        } 
        return array; // returns jagged 2D array
    }
    /**
     * This method finds the index of the longest row in the created 2D (two-dimensional) array
     *
     * @param array the two-dimensional array
     * @return the index of the longest row in file
     */
    public static int findLongestRow(int[][] array) {
    	// Variable storing the longest row in the array
        int longestRow = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i].length > array[longestRow].length) {
                longestRow = i;
            }
        }
        // Return the longest row
        return longestRow;
    }

    /**
     * This method finds the max value in a given row (index) of the created 2D (two-dimensional) array
     *
     * @param array is the two-dimensional array
     * @param row is the index of the row
     * @return the maximum value in the row
     */
    public static int findMaxInRow(int[][] array, int row) {
    	// Variable storing the max value
        int max = array[row][0];
        for (int i = 1; i < array[row].length; i++) {
            if (array[row][i] > max) {
                max = array[row][i];
            }
        }
        // Return the max value 
        return max;
    }

    /**
     * Finds the maximum value in a 2D (two-dimensional) array.
     *
     * @param array the created two-dimensional array
     * @return the maximum value in the whole array
     */
    public static int findMax(int[][] array) {
        int maximum = array[0][0];
        for (int[] row : array) {
            for (int value : row) {
                if (value > maximum) {
                    maximum = value;
                }
            }
        }
        // Return max value in whole array
        return maximum;
    }
    /**
     * 
     * Main prints out amount of lines in file, index and length of longest row, Biggest value on first row, and the max value in file
     * @param args command line arguments
     * @throws Exception
     */
    public static void main(String[] args) {
    	String filename = null;
        if (args.length < 1) {
            System.out.println("Usage: Assignment4 inputFilename"); // If no command line commands are given return... and exit
            System.exit(0);
        }
        // 0 because path to file is inserted in command line by user
        filename = args[0];
        int[][] arr = null;
        try {
        	// Output number of lines in given file
            System.out.println("Number of lines in the file = "+getNoLines(filename));
            arr = create2DArray(filename);
            // Print index and length of the longest row in the array
            int longestRow = findLongestRow(arr);
            System.out.println("Longest row index: " + (longestRow+1) + ", with length: " + arr[longestRow].length);
            
            // Output max number in first row
            System.out.println("Max value in first row = " + findMaxInRow(arr, 0));
            //Print the biggest value in the whole file
            System.out.println("Max value in file = " + findMax(arr));
            // Return exception if there is problem with the array or any of the methods
        } catch (Exception e) {
        	System.out.print(e);
        }
    }
} 
