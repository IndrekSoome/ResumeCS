package a9;

import java.util.Date;
/**
 * Represents a rock climbing exercise
 * Extends the Exercise class to include specific properties related to rock climbing,
 * such as wall height and repetitions.
 */
public class RockClimbing extends Exercise {
    private double wallHeight; 
    private int repetitions; 
    private double distance;

    /**
     * Constructs a new RockClimbing exercise instance with details.
     * 
     * @param name, the name of the exercise
     * @param date, the date the exercise was done
     * @param duration, the duration of the exercise in minutes
     * @param wallHeight the height of the wall climbed, in feet
     * @param repetitions the number of times climbed
     * @param comment, a comment about the exercise session
     */
    public RockClimbing(String name, Date date, double duration, double wallHeight, int repetitions, String comment) {
        super(name, date, duration, comment);
        this.wallHeight = wallHeight;
        this.repetitions = repetitions;
    }
    /**
     * Gets the height of the climbing wall.
     * 
     * @return the wall height in feet
     */
    public double getWallHeight() {
        return wallHeight;
    }
    /**
     * Sets the height of the climbing wall.
     * 
     * @param wallHeight the height of the wall in feet
     */
    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }
    /**
     * Gets the number of repetitions of the climb.
     * 
     * @return the number of times the climb was completed
     */
    public int getRepetitions() {
        return repetitions;
    }
    /**
     * Sets the number of repetitions of the climb.
     * 
     * @param repetitions the number of times climbed
     */

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
    /**
     * Returns the type of exercise.
     * 
     * @return the string "RockClimbing"
     */
    @Override
    public String getType() {
        return "RockClimbing";
    }
    /**
     * Calculates and returns the calories burned during rock climbing exercise
     * The calculation considers the wall height, repetitions, and duration.
     * 
     * @return the number of calories burned
     */
    @Override
    public double getCaloriesBurned() {
        // Method that calculates calories burned for rock climbing
        return wallHeight * repetitions / getDuration() * 100; 
    }
    /**
     * Provides a custom string representation of the rock climbing exercise 
     * 
     * @return a formatted string detailing the wall height and repetitions
     */
    @Override
    public String toStringCustomInfo() {
        return String.format("Wall Height: %.2f feet, Repetitions: %d", wallHeight, repetitions);
    }
}
