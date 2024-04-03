package a5;

/**
 * 
 * This class represents a node in xy-coordinate system.
 *
 * @author indreksoome
 * @class Object Oriented Programming SP24-CPSC-24500-001
 * Assignment 5: Node
 * @date: March 23, 2024
 */
 
public class Node {
	// Set final values for constants to make changing the code easier
    private static final int MIN_VAL = -100;
    private static final int MAX_VAL = 100;
    private int x;
    private int y;

    /**
     * Default constructor that initializes x and y to (0, 0)
     * @return x=0, y=0
     */
    public Node() throws Exception{
        this(0,0); // helps reduce code duplication
    }
    /**
     * Constructor that accepts two integers for x and y.
     * 
     * @param x, the x-coordinate of the node
     * @param y, the y-coordinate of the node
     * @throws Exception if x or y is out of the valid range, throw exception
     */
    public Node(int x, int y) throws Exception {
        this.x = x;
        this.y = y;
        setX(x);
        setY(y);
    }
    /**
     * Copy constructor
     * 
     * @param node, the node to be copied
     */
    public Node(Node node) throws Exception{
        this(node.x, node.y);
    }
    /**
     * 
     * @return current value for x (-100<=X<=100)
     */
    public int getX() {
		return this.x;
	}
    /**
     * 
     * @return current value for y (-100<=y<=100)
     */
	public int getY() {
		return this.y;
	}
	
	/**
	 * @return the value is set if valid [-100,100], otherwise, the method does nothing
	 */
    public void setX(int x) throws Exception {
		if (isValidX(x))
			this.x = x;
		else
			throw new Exception(x + " is invalid x value, should be in the range ["+MIN_VAL+", "+MAX_VAL+"]");
	}
    /**
	 * @return the value is set if valid [-100,100], otherwise, the method does nothing
	 */
	public void setY(int y) throws Exception {
		if (isValidY(y))
			this.y = y;
		else
			throw new Exception(y + " is invalid y value, should be in the range ["+MIN_VAL+", "+MAX_VAL+"]");
	}
	/**
	 * Validate x coordinate
	 * 
	 * @param x x-coordinate 
	 * 
	 */
	private boolean isValidX(int x) {
		return x >=MIN_VAL  &&  x<=MAX_VAL ;		
	}
	/**
	 * Validate y coordinate
	 * 
	 * @param y y-coordinate 
	 * 
	 */
	private boolean isValidY(int y) {
		return y>=MIN_VAL && y <= MAX_VAL;
	}
    
    /**
     * This method checks the equality of nodes
     * method override
     * 
     * @param obj the object to compare with
     * @return True if the compared nodes are equal, in other case return false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
        	return true;
        if (!(obj instanceof Node)) 
        	return false;
        Node node = (Node) obj;
        return x == node.x && y == node.y;
    }
    /**
     * 
     * Method returns a string representation of Node
     * 
     * @return A string representation of the Node in form of Node {x=?, y=?}
     */
    @Override
    public String toString() {
    	super.toString();
    	return "Node {x = " + x + ", y = " + y + "}";
    }
    
    /**
     * Adds the given node to the caller node by adding x and y coordinates
     * 
     * @param node the node that we are trying to add
     * @throws Exception if the result is out of the valid range, exception is raised 
     */
    
    public void add(Node node) throws Exception{
        int newX = this.x + node.getX();
        int newY = this.y + node.getY();
        setX(newX); // Validated using setters
        setY(newY);
    }

}
