package ca.ubc.ece.cpen221.mp3.tests;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraph implements Graph {

	ArrayList<LinkedList<Vertex>> adjacencyList = new ArrayList<LinkedList<Vertex>>();
	HashMap<Vertex, Integer> mapping = new HashMap<Vertex, Integer>();
	int count = 0;
	
	public AdjacencyListGraph(){
		
	}
	
	@Override
	public void addVertex(Vertex v) {
		mapping.put(v, count);
		LinkedList<Vertex> temp = new LinkedList<Vertex>();
		adjacencyList.add(temp);
		count++;
	}

	@Override
	public void addEdge(Vertex v1, Vertex v2) {
		if(mapping.containsKey(v1)){
			adjacencyList.get(mapping.get(v1)).add(v2);
		}else{
			System.out.println(v1 + " is not a vertex");
		}
	}

	@Override
	public boolean edgeExists(Vertex v1, Vertex v2) {
		if(mapping.containsKey(v1) && mapping.containsKey(v2)){
			if(adjacencyList.get(mapping.get(v1)).contains(v2)){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Vertex> getDownstreamNeighbors(Vertex v) {
		List<Vertex> downstreamNeighbors = new ArrayList<Vertex>();
		
		if(mapping.containsKey(v)){
			int index = mapping.get(v);
			downstreamNeighbors = adjacencyList.get(index);
		}
		return downstreamNeighbors;
	}

	@Override
	public List<Vertex> getUpstreamNeighbors(Vertex v) {
		List<Vertex> UpstreamNeighbors = new  ArrayList<Vertex>();
		
		if(mapping.containsKey(v)){
			for(int index = 0; index < adjacencyList.size(); index++){
				if(adjacencyList.get(index).contains(v)){
					for(Vertex a : mapping.keySet()){
						if(mapping.get(a) == index){
							UpstreamNeighbors.add(a);
						}
					}
				}
			}
		}
		
		return UpstreamNeighbors;
	}

	@Override
	public List<Vertex> getVertices() {
		List<Vertex> allVertex = new ArrayList<Vertex>();
		
		
		allVertex.addAll(mapping.keySet());
		
		return allVertex;
	}
	
	/*public ArrayList<LinkedList<Vertex>> getAdjacencyList(){
		return adjacencyList;
	}*/
	
	public int getMappingKey(Vertex v){
		if(mapping.containsKey(v)){
			return mapping.get(v);
		}else{
			return -1;
		}
	}
// TODO: Implement this class
}
