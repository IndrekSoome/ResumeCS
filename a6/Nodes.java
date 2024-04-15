package a6;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @Nodes class manages @INode objects and offers various operations
 * for nodes. These operations include filling with random nodes,
 * clearing, counting nodes and ThreeDNodes, sorting nodes based on their coordinates sums'
 * values, and displaying nodes as strings
 */
public class Nodes {
    private ArrayList<INode> list;

    /**
     * Basic constructor creating new object type Nodes with empty list.
     */
    public Nodes() {
    	list = new ArrayList<INode>();
    	Collections.sort(list, new Sorter());
    }
    /**
     * Fills the arraylist with random nodes and threeDNodes
     *
     * @param size, number of nodes to fill arraylist
     * @throws Exception If there is an error in node creation
     */
    public void fill(int size) throws Exception {
        clear();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
        	if (random.nextBoolean()) {
                // Randomly decides to add a Node or a ThreeDNode
                list.add(NodeFactory.getNode());
            } else {
            	list.add(NodeFactory.getThreeDNode());
            }
        }
    }
    /**
     * Method that clears all nodes from the collection.
     */
    public void clear() {
        list.clear();
    }
    /**
     * Method that counts the # of nodes in the arraylist that are instances of Node
     *
     * @return The count of nodes
     */
    public int countNodes() {
        int count = 0;
        for (INode node : list) {
            if (node instanceof Node && !(node instanceof ThreeDNode)) {
                count++;
            }
        }
        return count;
    }
    /**
     * Method that counts # of ThreeDNodes in the arraylist
     *
     * @return The count of ThreeDNodes
     */
    public int countThreeDNodes() {
        int count = 0;
        for (INode node : list) {
            if (node instanceof ThreeDNode) {
                count++;
            }
        }
        return count;
    }
    /**
     * Method that sorts the nodes based on the sums of their x, y, (and z) values
     */
    public void sort() {
        Collections.sort(list, new Sorter());
    }
    /**
     * @return a string representing the nodes
     * 
     */
    @Override
    public String toString() {
    	// Check if the list is empty and retun empty list if true
    	if (list.isEmpty()) { 
            return ""; 
        }
        StringBuilder sb = new StringBuilder();
        for (INode node : list) {
            sb.append(node.toString()).append("\n");
        }
        return sb.toString();
    }
    /**
     *
     * Sorter class, a class that implements Comparator<INode> to compare nodes based on the sums of their x, y, and z values.
     */
    class Sorter implements Comparator <INode>{

    	@Override
    	public int compare(INode o1, INode o2) {
    		int sum1;
    		int sum2;
    		if (o1.getClass()==Node.class) {
    			Node obj1 = (Node) o1; 
    			sum1 = obj1.getX()+obj1.getY();
    		}else
    		{
    			ThreeDNode obj1 = (ThreeDNode) o1; 
    			sum1 = obj1.getX()+obj1.getY()+obj1.getZ();
    		}
    		
    		if (o2.getClass()==Node.class) {
    			Node obj2 = (Node) o2; 
    			sum2 = obj2.getX()+obj2.getY();
    		}else
    		{
    			ThreeDNode obj2 = (ThreeDNode) o2; 
    			sum2 = obj2.getX()+obj2.getY()+obj2.getZ();
    		}	
    		if (sum1>sum2)
    			return 1;
    		if (sum1==sum2)
    			return 0;
    		return -1;
    	}
    	
    }
}
