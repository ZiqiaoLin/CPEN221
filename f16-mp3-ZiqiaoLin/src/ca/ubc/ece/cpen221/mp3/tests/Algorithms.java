package ca.ubc.ece.cpen221.mp3.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class Algorithms {

	/**
	 * *********************** Algorithms ****************************
	 *
	 * Please see the README for the machine problem for a more detailed
	 * specification of the behavior of each method that one should implement.
	 */

	/**
	 * Implement a method to find the shortest distance between two vertices 
	 * in an unweighed graph. The distance between a vertex and itself is 0.
	 * If no path exists from s to t then -1 will be returned.
	 * 
	 * @param g the graph which contains vertex a and b
	 * @param a a vertex in the graph
	 * @param b another vertex in the graph
	 * @return the shortest distance from a to b
	 */
	public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
		List<Vertex> subVertex = new ArrayList<Vertex>();
		int count;
		
		if(a.equals(b)){
			return 0;
		}
		
		else if(graph.getDownstreamNeighbors(a).contains(b)){
			count = 1;
			return count;
		}
		
		else if(graph.getDownstreamNeighbors(a).isEmpty()){
			System.out.println("There is no way to reach" + b + "from this vertex");
			return -1;
		}
		
		else{
			for(Vertex v : graph.getDownstreamNeighbors(a)){
				if(graph.getDownstreamNeighbors(v).contains(b)){
					count = 0;
					count++;
					return count;
				}
			}
			
			for(Vertex v : graph.getDownstreamNeighbors(a)){
				return 1 + shortestDistance(graph, v, b);
			}
		}
		
		return 1;
	}

	/**
	 * Perform a complete depth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a DFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 * @param
	 * @return
	 */
	public static List<Vertex> DepthList(Graph a, Vertex root){
		
		 List<Vertex> visited = new ArrayList<Vertex>();
		 Stack <Vertex> st = new Stack<Vertex>();
		
		 st.push(root);
		 
		 while(!st.isEmpty()){
			 Vertex temp = st.pop();
			 
			 if(!visited.contains(temp)){
				 visited.add(temp);
			 
			 for(Vertex ver: a.getDownstreamNeighbors(temp)){
				 if(!visited.contains(ver)){
				 st.push(ver);
				 }
			 }
		 }
		
		
			
	 }
		 
		 return visited;
	
	}
	public static List<Vertex> BreadthList(Graph a, Vertex root){
		 Queue<Vertex> que = new LinkedList<Vertex>();
		 List<Vertex> visited = new ArrayList<Vertex>(); //visited vertexes
		 
		 que.add(root);
		 
		 while(!que.isEmpty()){
			 Vertex temp = que.remove();
			 
			 if(!visited.contains(temp)){
				 visited.add(temp);
				 
				 for(Vertex ver: a.getDownstreamNeighbors(temp)){
					 if(!visited.contains(ver)){
						 que.add(ver);
				 }
			 }
		}
	}
		 
		  return visited;
}
	

	public static Set<List<Vertex>> depthFirstSearch(Graph graph) {
		
		Set<List<Vertex>> boo = new HashSet<List<Vertex>>();
		List<Vertex>arr = graph.getVertices();
		for(Vertex foo: arr)
			boo.add(Algorithms.DepthList(graph, foo));
		
		// TODO: Implement this method
		return boo; // this should be changed

	}

	public static Set<List<Vertex>> breadthFirstSearch(Graph graph) {
		Set<List<Vertex>> boo = new HashSet<List<Vertex>>();
		List<Vertex>arr = graph.getVertices();
		for(Vertex foo: arr)
			boo.add(Algorithms.BreadthList(graph, foo));
		
		// TODO: Implement this method
		return boo; // this should be changed
	}

	/**
	 * Given a graph G and two vertices a and b in G, this method returns 
	 * a list of all vertices u such that there is an edge from u to a and  
	 * an edge from u to b. If there are no such vertices 
	 * then this method returns an empty list. 
	 * 
	 * @param g the graph which contains vertex a and vertex b
	 * @param a a vertex in graph g
	 * @param b a another vertex in graph g
	 */
	 public static List<Vertex> commonUpstreamVertices(Graph graph, Vertex a, Vertex b) {
		 List<Vertex> commonVertices = new ArrayList<Vertex>();
		 Set<Vertex> VerticesSet = new HashSet<Vertex>();
		 
		 for(int index_a = 0; index_a < graph.getUpstreamNeighbors(a).size(); index_a++){
			 for(int index_b = 0; index_b < graph.getUpstreamNeighbors(b).size(); index_b++){
				 if(graph.getUpstreamNeighbors(a).get(index_a).equals(graph.getUpstreamNeighbors(b).get(index_b))){
					 commonVertices.add(graph.getUpstreamNeighbors(a).get(index_a));
				 }
			 }
		 }
		 
		 VerticesSet.addAll(commonVertices);
		 commonVertices.clear();
		 commonVertices.addAll(VerticesSet);
		 
		 return commonVertices;
	 }

	 /**
	  * Given a graph G and two vertices a and b in G, this method 
	  * returns a list of all vertices u such that there is an edge 
	  * from u to a and an edge from u to b. If there are no such 
	  * vertices then this method returns an empty list. 
	  * 
	  * @param g the graph which contains vertex a and vertex b
	  * @param a a vertex in graph g
      * @param b a another vertex in graph g
	  */
	 public static List<Vertex> commonDownstreamVertices(Graph graph, Vertex a, Vertex b) {
 		List<Vertex> commonVertices = new ArrayList<Vertex>();
 		Set<Vertex> VerticesSet = new HashSet<Vertex>();
		 
		 for(int index_a = 0; index_a < graph.getDownstreamNeighbors(a).size(); index_a++){
			 for(int index_b = 0; index_b < graph.getDownstreamNeighbors(b).size(); index_b++){
				 if(graph.getDownstreamNeighbors(a).get(index_a).equals(graph.getDownstreamNeighbors(b).get(index_b))){
					 commonVertices.add(graph.getDownstreamNeighbors(a).get(index_a));
				 }
			 }
		 }
		 VerticesSet.addAll(commonVertices);
		 commonVertices.clear();
		 commonVertices.addAll(VerticesSet);
		 
		 return commonVertices;
 	 }


}
