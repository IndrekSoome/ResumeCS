package a9;

import java.util.Date;
/**
 * Represents a weightlifting exercise 
 * This class extends @Exercise and includes additional properties specific to weightlifting,
 * such as the weight lifted, to calculate calories burned and provide detailed exercise information.
 */
public class WeightLifting extends Exercise {
    private double weight; // Specific to WeightLifting

    /**
     * Constructs a new WeightLifting exercise instance
     *
     * @param name, the name of the exercise
     * @param date, the date the exercise was performed, in "MM/dd/yyyy" format
     * @param duration, the duration of the exercise in minutes
     * @param comment, a comment about the exercise session
     */
    public WeightLifting(String name, String date, double duration, String comment) {
        super(name, date, duration, comment);
        this.weight = weight;
    }
    /**
     * Gets the weight used in the weightlifting
     * 
     * @return the weight in pounds
     */
    public double getWeight() {
        return weight;
    }
    /**
     * Sets the weight used in the weightlifting
     * 
     * @param weight the weight in pounds
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    /**
     * Returns the type of exercise
     * 
     * @return the string "Weightlifting"
     */
    @Override
    public String getType() {
        return "Weightlifting";
    }
    
    /**
     * Calculates and returns the calories burned during the weightlifting session.
     * Based on the weight used and the duration of the session.
     * 
     * @return the number of calories burned
     */
    @Override
    public double getCaloriesBurned() {
        // Calculate calories burned for weightlifting
        return weight / getDuration() * 50; 
    }
    /**
     * Provides a custom string representation of the weightlifting exercise 
     * 
     * @return a formatted string detailing the weight used
     */
    @Override
    public String toStringCustomInfo() {
        return String.format("Weight: %.2f pounds", weight);
    }
}
