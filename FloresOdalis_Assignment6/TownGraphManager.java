import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * Your TownGraphManager will hold an object of your Graph. Implement the TownGraphManagerInterface. 
 * There are methods to populate the graph (reading from a text file), add a town (vertices), add a road (edge), 
 * list all towns and all roads, and list towns adjacent to a given town.
 * Your solution will find the shortest path from a start town to a destination town.  
 * It will account for the possibility of a disjoint graph (i.e., not all vertices can be reached from all other vertices.)
 * You may add any methods as needed for your design.
 * @param <E>
 */

public class TownGraphManager<E> implements TownGraphManagerInterface{
	private Graph graph = new Graph();
	Set<Town> vertex= new HashSet<>();
	Set<Road> edges= new HashSet<>();
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		graph.addEdge(new Town (town1), new Town (town2), weight, roadName);
		edges=graph.edgeSet();
		
		return containsRoadConnection( town1,  town2);
		
	}

	@Override
	public String getRoad(String town1, String town2) {
		Road current;
		if(!containsRoadConnection( town1,  town2)) {
			current= null;
		}
		else {
			current =graph.getEdge(new Town(town1), new Town(town2));
		}
		return current.getName();
	}

	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		vertex=graph.vertexSet();
		Iterator<Town> v1 = vertex.iterator();
		Object current;
		while(v1.hasNext()) {
			current=v1.next();
			if(current.toString()==name)
				return (Town) current;
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		vertex=graph.vertexSet();
		Iterator<Town> v1 = vertex.iterator();
		while(v1.hasNext()) {
			if(v1.next().toString()==v)
				return true;
		}
		return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<>();
		edges=graph.edgeSet();
		Iterator<Road> v1 = edges.iterator();
		//String roadName;
		Road edge;
		while(v1.hasNext()) {
			edge=v1.next();
			roads.add(edge.getName());
		}
		
		return roads;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		return graph.removeVertex(new Town (v));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<>();
		vertex=graph.vertexSet();
		Iterator<Town> v1 = vertex.iterator();
		//String roadName;
		Town vertex;
		while(v1.hasNext()) {
			vertex=v1.next();
			towns.add(vertex.getName());
		}
		
		return towns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
