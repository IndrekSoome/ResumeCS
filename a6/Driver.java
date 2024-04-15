package a6;

import java.util.Scanner;
/** 
 * 
 * @author indreksoome
 * @class Object Oriented Programming SP24-CPSC-24500-001
 * Assignment 6: Nodes
 * @date: April 5, 2024
 * 
 * 
 * Driver class, implements class Nodes
 * Menu-driven interface to manage a collection of {@code INode} objects.
 * Allows user to interact with the system
 * @Node and @ThreeDNode objects.
 * 
 * <p>Each menu choice triggers a corresponding operation from the {@code Nodes} class, making it user-friendly
 * and interactive. The user is able to add (fill) nodes, clear the list of nodes, view counts of node types (nodes, threednodes), sort the collection
 * based on node values (addition), and display the filled list of nodes.
 * 
 * <p>The operations are managed through a console-based menu system, that implements user choices.
 *
 * 
 * @precondition Usage:
 *     1. Fill the collection with choosen amount of nodes.
 *     2. Clear the list of nodes.
 *     3. Count and display the number of type Node objects.
 *     4. Count and display the number of type hreeDNode objects.
 *     5. Sort the nodes.
 *     6. Display all nodes.
 *     7. Exit the program.
 */
public class Driver {
	// Creating a new instance of Nodes and initialicing scanner object
    private static Nodes nodes = new Nodes(); 
    private static Scanner sc = new Scanner(System.in);

    /**
     * Displays all implemented operations in class nodes
     * Each of these choices need to call the corresponding operation from class Nodes
     * @param args
     */
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = getChoice();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Size to fill:");
                        int size = sc.nextInt();
                        nodes.fill(size);
                        break;
                    case 2:
                        nodes.clear();
                        System.out.println("Successful");
                        break;
                    case 3:
                        System.out.println("# of Nodes: " + nodes.countNodes());
                        break;
                    case 4:
                        System.out.println("# of ThreeDNodes: " + nodes.countThreeDNodes());
                        break;
                    case 5:
                        nodes.sort();
                        System.out.println("Successful");
                        break;
                    case 6:
                    	System.out.println("Nodes:");
                        System.out.println(nodes);
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid. Try again.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Continue program if user didn't choose exit.
            if (!exit) {
                System.out.println("Press any key to continue...");
                sc.nextLine(); 
                sc.nextLine(); 
            }
        }
        // Close program
        sc.close();
        System.out.println("Program turned off.");
    }
    /**
     * Displays menu items for user
     * 
     */
    private static void showMenu() {
        System.out.println("1. Fill");
        System.out.println("2. Clear");
        System.out.println("3. Count Nodes");
        System.out.println("4. Count ThreeDNodes");
        System.out.println("5. Sort");
        System.out.println("6. Display");
        System.out.println("7. Exit");
    }
    /**
     * 
     * @return the corresponding object from Nodes class
     */
    private static int getChoice() {
        return sc.nextInt();
    }
}
