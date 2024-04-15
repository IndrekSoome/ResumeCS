package a6;

public class ThreeDNode extends Node {
	private int z;

    
	/**
	 * 
	 * Default constructor that constructs a ThreeDNode with default x, y, z = 0
     * @throws Exception
     */
    public ThreeDNode() throws Exception {
    	// Calls Node's) default constructor (
        super(); 
        this.z=0;
    }

    // Constructor with x and y, z is assumed to be 0
    /**
     * Method that constructs a ThreeDNode with x, y, and z values 0
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @throws Exception
     */
    public ThreeDNode(int x, int y) throws Exception {
    	super(x, y); // Calls Node's constructor
        this.z = 0;
    }

    /**
     * Method that constructs a ThreeDNode with specified x, y, and z values.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param z The z-coordinate.
     * @throws Exception If an error occurs during construction.
     */
    public ThreeDNode(int x, int y, int z) throws Exception {
        super(x, y); // Calls Node's constructor
        setZ(z); // Use the setter to include range checking
    }

    /**
     * Copy constructor for ThreeDNode
     *
     * @param other, ThreeDNode to copy.
     * @throws Exception
     */
    public ThreeDNode(ThreeDNode other) throws Exception {
    	// Using get() helps if we need to modify code so we have to change it only in one place
        super(other.getX(), other.getY()); 
        this.z = other.z;
    }

    /**
     * Method that gets the z-coordinate
     *
     * @return z-coordinate.
     */
    public int getZ() {
        return z;
    }

    /**
     * Method that sets the z-coordinate and validates it
     *
     * @param z The z-coordinate
     * @throws Exception If the coordinate is invlaid (out of range)
     */
    public void setZ(int z) throws Exception {
        if (z <LOWER_LIMIT || z > UPPER_LIMIT) {
            throw new Exception("Invalid operation: z value shoud be in the range: ["+LOWER_LIMIT+","+UPPER_LIMIT+"]");
        }
        this.z = z;
    }
    /**
     * Method that overrides toString method and provides string representation of ThreeDNode
     *
     * @return A string representation of the ThreeDNode
     */
    @Override
    public String toString() {
    	return "("+getX()+","+getY()+","+getZ()+")";
    	
    }
    /**
     * Adds ThreeDNodes to each other by combining their x, y, and z values.
     *
     * @param node The ThreeDNode to add.
     * @throws Exception If the provided node is not valid
     */
    public void add(Node node) throws Exception{
        if (!(node instanceof ThreeDNode)) {
            throw new Exception("Has to be a ThreeDNode");
        }
        ThreeDNode o = (ThreeDNode) node;
        super.add(o); 
        this.z += o.getZ(); // Now add the z component
    }
    /**
     * Method that overrides equals method to check for equality for x, y, and z values
     *
     * @param obj, the object to compare
     * @return true if the objects are equal, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (!(obj instanceof ThreeDNode)) return false;
        ThreeDNode other = (ThreeDNode) obj;
        return this.z == other.z;
    }
}
