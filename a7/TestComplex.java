package a7;

import java.util.Scanner;
/**
 * 
 * @author indreksoome
 * @class Object Oriented Programming SP24-CPSC-24500-001
 * @code TestComplex
 * @date: April 19, 2024
 * 
 * This class works as a tester for @code Complex. It asks user for two different complex numbers 
 * and scans the inputs as @double. Next it calls required operations from @Complex 
 * and displays the results.
 * 
 * Pre-condition: entered complex numbers are form double space double
 * 
 * @precondition Usage:
 *     1. Ask for the first complex number
 *     2. Ask for the second complex number
 *     3. Display complex number operations using given formulas in the following order:
 *     		i. Addition 
 *     	    ii. Subtraction 
 *     	    iii. Multiplication
 *          iiii. Divisio
 *     
 */
public class TestComplex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Promt the user with instructions for first complex number
        System.out.print("Enter the first complex number: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        Complex c1 = new Complex(a, b);

        // Promt the user with instructions for second complex number
        System.out.print("Enter the second complex number: ");
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        Complex c2 = new Complex(c, d);

        // Print sum of complexes using method add
        Complex sum = c1.add(c2);
        System.out.println("(" + c1 + ") + (" + c2 + ") = " + sum);

        // Print difference of complexes using method substract
        Complex diff = c1.subtract(c2);
        System.out.println("(" + c1 + ") - (" + c2 + ") = " + diff);

        // Print product of complexes using method multiply
        Complex prod = c1.multiply(c2);
        System.out.println("(" + c1 + ") * (" + c2 + ") = " + prod);

        // Print quotient of complexes using method divide
        Complex quot = c1.divide(c2);
        System.out.println("(" + c1 + ") / (" + c2 + ") = " + quot);

        //Print the absolute value of the first complex using method abs
        double absVal = c1.abs();
        System.out.println("|(" + c1 + " )| = " + absVal);

        scanner.close();
    }
}
