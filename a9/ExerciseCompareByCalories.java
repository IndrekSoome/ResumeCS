package a9;

import java.util.Comparator;
/**
 * This class implements a method to compare exercises by their calories burned using comparator.
 */
public class ExerciseCompareByCalories implements Comparator<Exercise> {
    @Override
    public int compare(Exercise exercise1, Exercise exercise2) {
        double calories1 = exercise1.getCaloriesBurned();
        double calories2 = exercise2.getCaloriesBurned();

        // Compare 
        if (calories1 < calories2) {
            return -1;
        } else if (calories1 > calories2) {
            return 1;
        } else {
            return 0;
        }
    }
}
