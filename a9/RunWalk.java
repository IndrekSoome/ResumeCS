package a9;

import java.util.Date;
/**
 * Represents a running or walking exercise
 * This class extends @Exercise and includes additional properties specific to running or walking,
 * istance covered, to calculate calories burned and provide detailed exercise information.
 */
public class RunWalk extends Exercise {
    private double distance; // Specific to RunWalk
    /**
     * Constructs a new RunWalk exercise instance
     *
     * @param name, the name of the exercise
     * @param date, the date the exercise was performed
     * @param duration, the duration of the exercise in minutes
     * @param distance, the distance covered in miles
     * @param comment, a comment about the exercise 
     */
    public RunWalk(String name, Date date, double duration, double distance, String comment) {
        super(name, date, duration, comment);
        this.distance = distance;
    }
    /**
     * Gets the distance covered in the exercise 
     * 
     * @return the distance in miles
     */
    public double getDistance() {
        return distance;
    }
    /**
     * Sets the distance covered in the exercise 
     * 
     * @param distance the distance in miles to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
    /**
     * Returns the type of exercise
     * 
     * @return the string "RunWalk"
     */
    @Override
    public String getType() {
        return "RunWalk";
    }
    /**
     * Calculates and returns the calories burned during the run or walk.
     * Based on the distance covered and the duration
     * 
     * @return the number of calories burned
     */
    @Override
    public double getCaloriesBurned() {
        return distance / getDuration() * 9000;
    }
    /**
     * Provides a custom string representation of the running or walking exercise
     * 
     * @return a formatted string detailing the distance covered
     */
    @Override
    public String toStringCustomInfo() {
        return String.format("Distance: %.2f miles", distance);
    }
}

