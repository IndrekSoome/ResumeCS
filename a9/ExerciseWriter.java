package a9;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
/**
 * A class that writes details of user input to a file that has @fileName.
 * 
 */
public class ExerciseWriter {
	public static void printToScreen(ArrayList<Exercise> exercises) {
		for (Exercise exercise: exercises) {
			System.out.println(exercise);
		}
	}
	/**
	 * 
	 * @param exercises, ArrayList 
	 * @param fileName, name of file that is being written to
	 * @return true, if successful. false, if there is an error
	 * @return Exception if writing to a file is not possible
	 * 
	 */
	public static boolean printToFile(ArrayList<Exercise> exercises, String fileName) {
		try {
			// Create a new PrintWriter
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
			for (Exercise exercise: exercises) {
				pw.println(exercise);
			}
			pw.close();
			return true; //True if successful
		} catch (Exception e) {
			return false; // Throw Exception if unsuccessful
		}
	}
	/**
	 * A method to print the user input
	 * @return toSummaryString, displays user inputs as a string
	 */
	public static void tabulateSummary(ArrayList<Exercise> exercises) {
		for (Exercise exercise: exercises) {
			System.out.println(exercise.toSummaryString());
		}
	}
}
