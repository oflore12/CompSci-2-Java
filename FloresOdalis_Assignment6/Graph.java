import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
/**
 * Create a Graph class that implements the GraphInterface given you.  
 * For Graph<V,E>,  V is the vertex type (a Town), E is the edge type (a Road).  
 * You will need to decide how to store the graph, use an adjacent matrix or an adjacency 
 * list.  This is the class header:
 * public class Graph implements GraphInterface<Town, Road>
 * Within the Graph interface is a method shortestPath, which finds the shortest path from a 
 * given source Town to a destination Town. Since there is a unique shortest path from every vertex 
 * to the source, there is a back-pointer to the previous vertex.  The method shortestPath calls 
 * dijkstraShortestPath which finds the shortest path from the source to every other vertex in the graph.  
 * You will be coding the Dijkstra’s Shortest Path algorithm.  You will then be able to 
 * find the connections between two towns through the roads that connect them.
 * You may use the adjacency matrix approach found in the text book, 
 * or you may use a set of Towns and a set of Roads. 
 * The ShortestPath algorithm typically uses a weighted graph which means that the edges 
 * have a weight, and this is used to determine the shortest path.  For this implementation, 
 * each weight will be the distance of the road in miles.
 * @author O_Flores96
 *
 */
public class Graph implements GraphInterface<Town, Road>{
	
	
//	private Town sourceVertex;
	private Town destinationVertex;
	private Town prevTown;
//	private int weight;
//	private String description;
//	private Road edge;
	
	private Set<Town> towns = new HashSet<>();
	private Set<Road> roads = new HashSet<>();
	
	
	Road roadPath=null;
	private int adjacencyMatrix[][];
	 ArrayList<String> path = new ArrayList<>();
	 private Set<Town> prevTowns = new HashSet<>();
	 private Set<Town> desPrevTowns = new HashSet<>();
	 Iterator<Town> checkT = prevTowns.iterator();

	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	 
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {		
		Iterator<Road> r = roads.iterator();
		Road currentRoad;
		while(r.hasNext()) {
			currentRoad=r.next();
			if(currentRoad.contains(sourceVertex)&&currentRoad.contains(destinationVertex))
				return currentRoad;
			if(currentRoad.contains(destinationVertex)&&currentRoad.contains(sourceVertex))
				return currentRoad;
		}
		return null;
	}
	   /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road edgeToAdd;
		edgeToAdd = new Road(sourceVertex, destinationVertex, weight,description);
		roads.add(edgeToAdd);
		return edgeToAdd;
	}
    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		if(v==null)
			throw new NullPointerException();
		while(towns.contains(v))
			return false;
		towns.add(v);
		return true;
	}
	
    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		Iterator<Road> r = roads.iterator();
		Road currentRoad;
		while(r.hasNext()) {
			currentRoad=r.next();
			if(currentRoad.contains(sourceVertex)&&currentRoad.contains(destinationVertex))
				return true;
			if(currentRoad.contains(destinationVertex)&&currentRoad.contains(sourceVertex))
				return true;
		}
		return false;
	}
	
    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		if(towns.contains(v)) {
			return true;
		}
		if(v==null)
			return false;
		return false;
	}
    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return roads;
	}
    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	public Set<Road> edgesOf(Town vertex) {
		Iterator<Town> t = towns.iterator();
		boolean status=false;
		while(t.hasNext()){
			if(t.next()!=vertex) {
				status=true;
				}
		}
		if(status == false) {
			throw new IllegalArgumentException();
		}
		if(vertex==null) {
			throw new NullPointerException();
		}
		
		Set<Road> roadsAtVertex= new HashSet<>();
		Iterator<Road> r = roads.iterator();
		
		Road currentRoad;
		
		while(r.hasNext()) {
			currentRoad=r.next();
			if(currentRoad.contains(vertex)) {
				roadsAtVertex.add(currentRoad);
			}
		}
		
		return roadsAtVertex;
	}
	
    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(towns.contains(sourceVertex)==false || towns.contains(destinationVertex)==false)
			throw new IllegalArgumentException();
		
		Iterator<Road> r = roads.iterator();
		
		Road currentRoad;
		
		while(r.hasNext()) {
			currentRoad=r.next();
			if(currentRoad.contains(sourceVertex)&&currentRoad.contains(destinationVertex)) {
				roads.remove(currentRoad);
				return currentRoad;
			}
		}
		return null;
	}
    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		if(v==null)
			return false;
		if(towns.contains(v)) {
			towns.remove(v);
		return true;
		}
		return false;
	}
    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		return towns;
	}
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */ 
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
			
//		this.destinationVertex = destinationVertex;
//		buildMatrix();
//		
//		Set<Road> sourceVertexEdges = edgesOf(sourceVertex);
//		
//		
//		Iterator<Road> svIterator = sourceVertexEdges.iterator();
//		
//		Road currentRoad;
//		int index=sourceVertexEdges.size();
//		
//	//	path.clear();
//		prevTowns.clear();
//		dijkstraShortestPath(sourceVertex);
//		for ( String id : path)
//			System.out.println(id);
//		
//		this.destinationVertex=destinationVertex;
//
//	//	path.clear();
//		prevTowns.clear();
		dijkstraShortestPath(sourceVertex);
//		for ( String id : path)
//			System.out.println(id);
		
		return null;
	
	}
    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
		ArrayList<Town> visitedV = new ArrayList<>();
		ArrayList<Town> notVistedV = new ArrayList<>();
		
		//ArrayList<String> currentPaths = new ArrayList<>();
		notVistedV.addAll(towns);
		notVistedV.remove(sourceVertex);
		
		Town current = sourceVertex;
		if(edgesOf(sourceVertex).size()==0) {
			return;
		}
		
		
		Road currE;
		Town currEV;
		
		if(edgesOf(sourceVertex).size()==1) {
			Set<Road> currVE=edgesOf(sourceVertex);
			Iterator<Road> e = currVE.iterator();
			currE=e.next();
			currEV=currE.getDestination();
			
			visitedV.add(currEV);
			notVistedV.remove(currEV);
			roadPath=currE;
			path.add(getPathToString());
			System.out.println(currVE);
			//updated source
			sourceVertex=currEV;
			}
		
		
		if(edgesOf(sourceVertex).size()>1) {
				whileLoop(sourceVertex, visitedV,notVistedV);
			}
			return;
			
		}
		

	
	
	public void whileLoop(Town sourceVertex, ArrayList<Town> visitedV, ArrayList<Town> notVistedV ){
		if(edgesOf(sourceVertex).size()>1) {
			
			Set<Road> edge=edgesOf(sourceVertex);
			Iterator<Road> e = edge.iterator();
			
			while(e.hasNext()) {
				Road currentEdge;
				Town currentVertex;
				currentEdge=e.next();
				//nextCurr=e.next();
				currentVertex=currentEdge.getDestination();
				//nextT=nextCurr.getDestination();
				System.out.println(currentVertex);
				System.out.println(currentVertex.toString());//+" "+nextT.toString());
				if(visitedV.contains(currentEdge.getDestination())) {
					if(e.hasNext()) {
						currentEdge=e.next();
						//System.out.println("this is true");
					}
					else {//System.out.println("not true");
					}
				}
			}
	
	}
	
	
//		ArrayList<Integer> list = new ArrayList<>();
//		int distance=0;
//		int minDist=maxWeight();
//		Set<Road> sourceVertexEdges = edgesOf(sourceVertex);
//		Iterator<Road> svIterator = sourceVertexEdges.iterator();
//		
//		Road currentRoad;
//		int index=sourceVertexEdges.size();
//		
//		while(svIterator.hasNext()) {
//			currentRoad=svIterator.next();
//			distance=currentRoad.getWeight();
//			if(distance<minDist) {
//				minDist=distance;
//				}
//			}
//		
//			Iterator<Road> reIterate = sourceVertexEdges.iterator();
//			Road findRoad;
//			while(reIterate.hasNext()) {
//				findRoad=reIterate.next();
//				if(findRoad.getWeight()==minDist) {
//					setPath(findRoad);
//					}
//			}
//		path.add(getPathToString());
//		
//		
//		Set<Road> source = edgesOf(sourceVertex);
//		Iterator<Road> sI = sourceVertexEdges.iterator();
//		
//		Road currRoad;
//		
//		while(svIterator.hasNext()) {
//			currRoad=svIterator.next();
//			list.add(currRoad.getWeight());
//		}
		//System.out.println(minDist);
		//System.out.println(edgesOf(sourceVertex));
		
//		Set<Road> source = edgesOf(sourceVertex);
//		Iterator<Road> sI = source.iterator();
//		
//		sI = source.iterator();
//		Set<Town> townOfSouce = new HashSet<>();
//		while(sI.hasNext()) {
//			townOfSouce.add(sI.next().getDestination());
//		}
//		Iterator<Town> t = townOfSouce.iterator();
//		while(t.hasNext()) {
//		checkVE(t.next());
//		}
		
		
		
//		System.out.println(prevTowns);
//		checkVE(destinationVertex);
	
	}
    /** 
     * Builds the adjacency matrix 
     */
	public void buildMatrix() {
		Iterator<Town> row = towns.iterator();
		Iterator<Town> col = towns.iterator();
		Town currTownRow=null;
		Town currTownCol=null;
		
		adjacencyMatrix= new int[towns.size()][towns.size()];
		while(row.hasNext()) {
			for(int i=0; i<towns.size();i++) {
				currTownRow=row.next();
				col = towns.iterator();
				while(col.hasNext()) {
					for(int j=0; j<towns.size();j++) {
						currTownCol=col.next();
						if(currTownRow==currTownCol)
							adjacencyMatrix[i][j]= 0;
						else if(containsEdge(currTownRow, currTownCol)) {
							//System.out.println(getEdge(currTownRow,currTownCol).toString());
							adjacencyMatrix[i][j]= getEdge(currTownRow,currTownCol).getWeight();
						}
						else adjacencyMatrix[i][j]= 0;
						}
					}
				}
			}
		checkRowSum();
	}
	
	/**
	 * checks sum of each row, if row is 0 its not connected to towns
	 */
	public void checkRowSum() {
		//buildMatrix();
		int checkRow=0;
		for(int i=0; i<towns.size();i++) {
			 checkRow=0;
			for(int j=0; j<towns.size();j++) {
		//		System.out.print(adjacencyMatrix[i][j]+" ");
				checkRow+=adjacencyMatrix[i][j];
			}
		//	System.out.println();
			
		//	System.out.println(checkRow);
			}
	}
	
	public Set<Town> checkVE(Town source) {
		Set<Road> checkTowns=edgesOf(source);
		
		//System.out.println(checkTowns);
		
		Iterator<Road> sourceRoads = checkTowns.iterator();
		
		Set<Town> townOfSouce= new HashSet<>();
		Iterator<Town> newSource = townOfSouce.iterator();
		
		while(sourceRoads.hasNext()) {
			Road curr=sourceRoads.next();
			if(source == curr.getDestination() && !(prevTowns.contains(source)))
				townOfSouce.add(curr.getSource());
			if(source == curr.getSource() && !(prevTowns.contains(source)))
				townOfSouce.add(curr.getDestination());
		
		}
		
	//	System.out.println(townOfSouce);
		prevTown=source;
		prevTowns.add(prevTown);
		//System.out.println(prevTown);
		return townOfSouce;
	}
	
	public Set<Town> backCheckVE(Town source) {
		Set<Road> checkTowns=edgesOf(source);
		
		//System.out.println(checkTowns);
		
		Iterator<Road> sourceRoads = checkTowns.iterator();
		
		Set<Town> townOfSouce= new HashSet<>();
		Iterator<Town> newSource = townOfSouce.iterator();
		
		while(sourceRoads.hasNext()) {
			Road curr=sourceRoads.next();
			if(source == curr.getDestination() && !(desPrevTowns.contains(source)))
				townOfSouce.add(curr.getSource());
			if(source == curr.getSource() && !(desPrevTowns.contains(source)))
				townOfSouce.add(curr.getDestination());
		
		}
		
		//System.out.println(townOfSouce);
		prevTown=source;
		desPrevTowns.add(prevTown);
	//	System.out.println(desPrevTowns);
		return townOfSouce;
	}
	
	public void setPath(Road min) {
		this.roadPath= min;
	}
	
	public Road getPath() {
		return roadPath;
	}
	
	public String getPathToString() {
	//	town_8 via Road_9 to Town_10 2 mi
		return getPath().getSource().toString()+ " via "+ getPath().toString()+
				" to "+getPath().getDestination()+ " " + getPath().getWeight()+" mi";
	}
	
	public int maxWeight() {
	Iterator<Road> svIterator = roads.iterator();
		int maxWeight=0;
		Road currentRoad;
		
		while(svIterator.hasNext()) {
			currentRoad=svIterator.next();
			maxWeight+=currentRoad.getWeight();	
		}
		return maxWeight;
	}
	
}
