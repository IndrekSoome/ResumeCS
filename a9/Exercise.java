package a9;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author indreksoome
 * @class Object Oriented Programming SP24-CPSC-24500-001
 * Assignment 9: Exercise Tracker
 * @date: May 8, 2024
 * 
 * @Exercise implements Comparable is a program mostly implemented by Dr. Wedyan. I implemented the compareTo() method and comments for methods and constructors.
 * Abstract class that is representing an exercise.
 * Implements Comparable interface to enable sorting by the calories burned (calculated in separate class).
 * Represents a general exercise session.
 * Provides a framework for managing information common to all types of exercises,
 * such as name, date, duration, and comments. 
 * Is sorted by the calories burned
 *
 * <p>Exercise types that extend this class provide implementations for calculating calories burned,
 * determining the exercise type, and generating specific string representations for exercise details.</p>
 */
 
public abstract class Exercise implements Comparable<Exercise> {
	private String name;
	private Date date;
	private double duration;
	private String comment;
	private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	public String getName() {
		return name;
	}
	/**
     * Gets the name of the exercise.
     * @return The name of the exercise.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Sets the name of the exercise
     * @param name The name to set
     */
	public Date getDate() {
		return date;
	}
	/**
     * Gets the date of the exercise
     * @return The date of the exercise
     */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * sets date to current date
	 */
	public void setDate() {
		this.date = new Date(); // current date
	}
	/**
     * Sets the date of the exercise from a string
     * @param date The date string in "MM/dd/yyyy" format
     */
	public void setDate(String date) {
		try {
			this.date = df.parse(date);
		} catch (Exception ex) {
			this.date = new Date(); // now
		}
	}
	/**
     * Gets the duration of the exercise
     * @return The duration of the exercise
     */
	public double getDuration() {
		return duration;
	}
	/**
     * Sets the duration of the exercise
     * @param duration, duration to set
     */
	public void setDuration(double duration) {
		if (duration < 0) {
			this.duration = 0;
		} else {
			this.duration = duration;
		}
	}
	/**
     * Gets the comment of the exercise
     * @return The comment of the exercise
     */
	public String getComment() {
		return comment;
	}
	/**
     * Sets the comment of exercise
     * @param comment The comment that is set
     */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
     * A constructor for Exercise (default)
     * It sets default values for name, date, duration, and comment.
     */
	public Exercise() {
		name = "Exercise";
		setDate();
		setDuration(0);
		setComment("Unknown exercise");
	}
	/**
     * Constructor for exercise (uses parameters)
     * @param name, name of the exercise
     * @param date, date of the exercise
     * @param duration, duration of the exercise
     * @param comment, comment of the exercise
     */
	public Exercise(String name, Date date, double duration, String comment) {
		setName(name);
		setDate(date);
		setDuration(duration);
		setComment(comment);
	}
	/**
     * A constructor for Exercise that uses the initialized parameters
     * @param name, name of the exercise
     * @param date, date of the exercise as a string as "MM/dd/yyyy"
     * @param duration, duration of the exercise
     * @param comment, comment of the exercise
     */
	public Exercise(String name, String date, double duration, String comment) {
		setName(name);
		setDate(date);
		setDuration(duration);
		setComment(comment);
	}
	private String getDateAsString() {
		return df.format(date);
	}
	/**
	 * generates tab-delimited String containing exercise-specific data 
	 * @return tab-delimited String of exercise-specific info
	 */
	public abstract String toStringCustomInfo();
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%.2f\t%s\t%.2f\t%s", name,getType(),getDateAsString(),getDuration(),toStringCustomInfo(),getCaloriesBurned(),comment);
	}
	/**
     * Abstract method to get the type for exercise
     * @return type of exercise
     */
	public abstract String getType();
	
	/**
     * This is an abstract method that calculates calories burned for the exercise
     * @return The calories burned for exercise.
     */
	public abstract double getCaloriesBurned();
	
	@Override
	public int compareTo(Exercise other) {
		double myCalories = getCaloriesBurned();
		double otherCalories = other.getCaloriesBurned();
		if (myCalories > otherCalories) {
			return 1;
		} else if (myCalories < otherCalories) {
			return -1;
		} else {
			return 0;
		}
		
		
	}
	/**
     * Generates a summary string for the exercise.
     * @return A formatted summary string containing exercise type, name, date, and calories burned.
     */
	public String toSummaryString() {
		return String.format("%-20s%-25s%-15s%10.2f",name,getType(),getDateAsString(),getDuration(),getCaloriesBurned());
	}
}