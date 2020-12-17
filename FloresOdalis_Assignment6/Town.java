import java.util.Iterator;

/**
 * Create a Town class that holds the name of the town and a list of adjacent towns, 
 * and other fields as desired, and the traditional methods 
 * (constructors, getters/setters, toString, etc.).  
 * It will implement the Comparable interface.
 * This is the class header:public class Town implements Comparable<Town>
 * Two towns will be considered the same if their name is the same.
 * @author O_Flores96
 */
public class Town implements Comparable<Town>{
	private String townName=null;
	private Town templateTown;
	private Town town;

	public Town(String name) {
		this.townName=name;
	}
	public Town(Town templateTown) {
		this(templateTown.townName);
	}

	@Override
	public int compareTo(Town o) {
		if(equals(o)==true) {
		//	System.out.println(0);
			return 0;}
		else if(townName.hashCode()-o.hashCode()>0) {
		//	System.out.println(1);
			return 1;
		}
		else { 
		//	System.out.println(-1);
			return -1;
		}
	}
	
	public int hashCode() {
		return townName.hashCode();
	}
	
	public boolean equals(Object object) {
		if(townName.equals(object.toString()))
				return true;
		else return false;
	}
	public String getName() {
		return townName;
	}
	
	public String toString() {
		return getName();
		
	}
	
	protected class Road{
		private Road vertex;
		private int weight;
		
		protected Road(Road endVertex, int edgeWeight) {
			this.vertex=endVertex;
			this.weight=weight;
		}
		protected Road getEndRoad() {
			return vertex;
		}
		protected int getWeight() {
			return weight;
		}
	}
}
