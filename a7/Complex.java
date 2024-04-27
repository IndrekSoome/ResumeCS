package a7;

/**
 * 
 * @author indreksoome
 * @class Object Oriented Programming SP24-CPSC-24500-001
 * Assignment 7: Complex
 * @date: April 19, 2024
 * 
 * This class creates Complex objects and allows mathematical operations such as
 * addition, subtraction, multiplication, and division between two Complex objects.
 * All the operations are performed by the rules of he mathematical formulas provided by the assignment specifications.
 * Program also allows user to compare two Complex objects based on their absolute values 
 * Pre-conditions: complex number is form a + bi, where a is the real part, b is imaginary part
 * and i is sqr of -1
 * 
 * 
 */
public class Complex implements Comparable<Complex> {
	// Initialize the real (a) and imaginary (b) parts of the complex number
    private double a;
    private double b;

    /**
     * The default constructor
     *
     * @return Creates a Complex object for number 0
     */
    public Complex() {
        this(0, 0);
    }

    // Constructor that takes only the real part
    /**
     * This constructor takes only a (real part)
     * 
     * @param a that is the real part of a Complex object
     * @return Creates a Complex object with 0 for b
     */
    public Complex(double a) {
        this(a, 0);
    }

    
    /**
     * This constructor takes both a (real) and b (imaginary) parts of Complex object
     * 
     * @param a The real part of a Complex object
     * @param b The imaginary part of a Complex object
     * @return Creates a Complex object with 0 for b
     */
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Copy constructor for Complex
     * The created object will be a copy of the passed object
     * @param complex
     * 
     */
    public Complex(Complex complex) {
        this(complex.a, complex.b);
    }

    /**
     * Get method for a 
     *
     * @return a, real part of Complex object
     */
    public double getRealPart() {
        return a;
    }

    /**
     * Get method for b
     *
     * @return b, imaginary part of Complex object
     */
    public double getImaginaryPart() {
        return b;
    }

    /**
     * Method to add the real and imaginary parts of two Complex numbers to each other
     * @param complex 
     * @return new Complex, the new complex number that was created from the addition
     */
    public Complex add(Complex complex) {
        return new Complex(this.a + complex.a, this.b + complex.b);
    }

    /**
     * Method to subtract the real and imaginary parts of two Complex numbers from each other
     * @param complex 
     * @return new Complex, the new complex number that was created from the subtraction
     */
    public Complex subtract(Complex complex) {
        return new Complex(this.a - complex.a, this.b - complex.b);
    }

    /**
     * Method to multiply the real and imaginary parts of two Complex numbers with each other
     * @param complex 
     * @return new Complex, the new complex number that was created from the multiplication
     */
    public Complex multiply(Complex complex) {
        return new Complex(this.a * complex.a - this.b * complex.b,
            this.b * complex.a + this.a * complex.b);
    }

    /**
     * Method to divide the real and imaginary parts of the first Complex object by the second Complex object
     * @param complex 
     * @return new Complex, the new complex number that was created from the subtraction
     */
    public Complex divide(Complex complex) {
    	// To make the operation more clear define denom that is the denominator part of the division
        double denom = complex.a*complex.a + complex.b*complex.b;
        return new Complex((this.a * complex.a + this.b * complex.b) / denom,
            (this.b * complex.a - this.a * complex.b) / denom);
    }

    /**
     * Method to calculate the absolute value of a complex number by using given formula
     * @return absolute value of the complex number
     */
    public double abs() {
        return Math.sqrt((Math.pow(a, 2)) + Math.pow(b, 2));
    }

    /**
     * 
     * Method to display complex numbers as a string with proper formating
     * @return string representation of Complex
     */
    @Override
    public String toString() {
        if (b == 0) {
            return String.format("%.2f", a);
        }
        return String.format("%.1f %s %.1fi", a, (b < 0 ? "-" : "+"), Math.abs(b));
    }
    
    @Override
    /**
	 * Complexes will be compared using their absolute values
	 */
    public int compareTo(Complex obj) {
        return Double.compare(this.abs(), obj.abs());
    }
}
