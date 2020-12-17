import java.util.LinkedList;

/**
 * Create a class Road that can represent the edges of a Graph of Towns.  
 * The class must implement Comparable. 
 * The class stores references to the two vertices(Town endpoints), 
 * the distance between vertices, and a name, and the traditional methods 
 * (constructors, getters/setters, toString, etc.), and a compareTo, which 
 * compares two Road objects. Since this is a undirected graph, 
 * an edge from A to B is equal to an edge from B to A. This is the class header:
 * public class Road implements Comparable<Road>
 * @author O_Flores96
 *
 */
public class Road implements Comparable<Road> {
	private Town source;
	private Town destination;
	private int degrees;
	private String roadName;
	
	LinkedList<Road> roadNames = new LinkedList<>();
	
	/**
	 * Constructor
	 * @param source One town on the road
	 * @param destination Another town on the road
	 * @param degrees the weight of the edge
	 * @param name Name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name) {
//		this.source= new Town (source);
//		this.destination= new Town (destination);
		this.source=source;
		this.destination=destination;
		this.degrees=degrees;
		this.roadName=name;
		
		roadNames.add(this);
	}
	/**
	 * Constructor without weight
	 * @param source One town on the road
	 * @param destination Another town on the road
	 * @param name Name of the road
	 */
	public Road(Town source, Town destination, String name) {
//		this.source= new Town (source);
//		this.destination= new Town (destination);
		this.source=source;
		this.destination=destination;
		this.degrees=1;
		this.roadName=name;
		
		roadNames.add(this);
	}
	/**
	 * Returns true only if the edge contains the given town
	 * @param town a vertex of the graph
	 * @return true if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		boolean sourceAndTown = false;
		if(source.equals(town))
				sourceAndTown=true;
		boolean destinationAndTown = false;
		if(destination.equals(town))
			destinationAndTown=true;
		if((sourceAndTown&&destinationAndTown)==true) {
			return false;
		}
		
		return ( sourceAndTown|| destinationAndTown) ;
	}
	/**
	 * returns string of ___
	 */
	public String toString() {
//		String message= "\nThe name of the first town is "+ source.toString()+
//				"\nThe name of the second town is " +destination.toString()
//				+"\nThe distance of these two roads is "+degrees
//				+"\nThe name that connects these roads is "+roadName;
//		return message; 
		return roadName;
	}
	/**
	 * 
	 * @return the name of the road
	 */
	public String getName() {
		return roadName;
	}
	/**
	 * Returns the second town on the road
	 * @return a town on the road
	 */
	public Town getDestination() {
		return destination;
	}
	/**
	 * the first town on the road
	 * @return A town on the road
	 */
	public Town getSource() {
		return source;
	}
	/**
	 * compares the roads
	 * @return 0 if the names are the same, pos/neg if the roads names are diff
	 */
	public int compareTo(Road road) {
		if(roadName.equals(road.getName()))
				return 0;
		else if(roadName.hashCode()-road.hashCode()>0) {
			return 1;
		}
		else return -1;
	}
	/**
	 * gets the distance of this road
	 * @return the distance of the road
	 */
	public int getWeight() {
		return degrees;
	}
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this 
	 * road. Remember that a road that goes from point A to point B is the same as a 
	 * road that goes from point B to point A.
	 * @param r the road object to compare
	 */
	@Override
	public boolean equals(Object r) {
		String rName= ((Road) r).getName();
		if(roadName.equals(rName))
			return true;
		return false;
	}
	
	public int hashCode() {
		return roadName.hashCode();
	}
	
	public LinkedList<Road> roads(){
		return roadNames;
	}
	
//	public void displayLinkedList(){
//		while(roadNames.p)
//	}

	
	
}
