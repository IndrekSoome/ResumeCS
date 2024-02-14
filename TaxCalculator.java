
package m;
import java.util.Scanner;

/**
 * The following program will ask user for their employee name and the amount of income, and will return
 * the full name, income, and calculated income tax (based on Java Land rules provided in the assignment 2 description).
 * Only type double positive values for user's income are allowed
 * In case of negative input for income, error message is printed.
 * 
 * @author Indrek Soome
 * @class Object Oriented Programming SP24-CPSC-24500-001
 * Assignment 2: Tax Calculator
 * @date: February 13, 2024
 */
public class TaxCalculator {
	
    /**
     * Here we will calculate income tax by the given rules.
     * "An employee has J$4000 of income is tax free.
	 * The next J$1500 is taxed at 10%.
	 * The next J$28000 after that is taxed at 20%.
	 * Any further amount is taxed at 40%."
     *
     * @param income, the income of the user/employee
     * @return The calculated income tax
     */
    private static double calculateIncomeTax(double income) {
        double tax = 0;

        // Tax is zero when income<=4000
        if (income <= 4000) {
            return 0;
        }

        // tax of 10% tax on the next 1500
        if (income > 4000 && income <= 5500) {
            return (income - 4000) * 0.10;
        }

        // tax of 20% on the next 28000
        if (income > 5500 && income <= 33500) {
            return (1500 * 0.10) + ((income - 5500) * 0.20);
        }

        // tax of 40% on any other exceeding amount of income
        if (income > 33500) {
            return (1500 * 0.10) + (28000 * 0.20) + ((income - 33500) * 0.40);
        }
        // Returning the calculated amount of tax
        return tax;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user to enter their full name
        System.out.print("Enter your full name: ");
        String fullName = sc.nextLine();

        // Ask user to enter their income in
        System.out.print("Enter your income in J$: ");
        double income = sc.nextDouble();

        // Make sure that input for income is positive and display error message otherwise
        if (income < 0) {
            System.out.println("Invalid input, income should be zero or more");
        } else {
            // Calculate income tax
            double incomeTax = calculateIncomeTax(income);

            // Printing results (name, income, income tax)
            System.out.printf("\nName: %s\n",fullName);
            System.out.printf("Income: J$%,.0f%n", income); 
            System.out.printf("Income Tax: J$%,.0f%n", incomeTax); 
        }

    }
}
