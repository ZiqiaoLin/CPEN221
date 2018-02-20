package ca.ubc.ece.cpen221.mp3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AlgorithmsTest {

	@Test
	//test about when there is an edge from Vertex a to b
	public void testShortestDistance_1() {
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		
		g.addVertex(a);
		g.addVertex(b);
		
		g.addEdge(a, b);
		
		assertEquals(1, Algorithms.shortestDistance(g, a, b));
	}

	@Test
	//test about when there is not an edge from Vertex b to a
	public void testShortestDistance_2() {
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		
		g.addVertex(a);
		g.addVertex(b);
		
		g.addEdge(a, b);
		
		assertEquals(-1, Algorithms.shortestDistance(g, b, a));
	}
	
	@Test
	//test the distance from Vertex a to a 
	public void testShortestDistance_3(){
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		
		g.addVertex(a);
		g.addVertex(b);
		
		g.addEdge(a, b);
		
		assertEquals(0, Algorithms.shortestDistance(g, a, a));
	}
	
	@Test
	//test about when there is one vertex in that is the common upstream of vertex a and b
	public void commonUpstreamVertices_1(){
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		
		Vertex[] v = {a};
		List<Vertex> expected = new ArrayList<Vertex>(Arrays.asList(v));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		
		g.addEdge(a, c);
		g.addEdge(b, c);
		g.addEdge(a, b);
		
		assertEquals(expected, Algorithms.commonUpstreamVertices(g, c, b));
	}
	
	@Test
	//test about when there is multiple vertices in that is the common upstream of vertex a and b
	public void commonUpstreamVertices_2(){
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		
		Vertex[] v = {a, b};
		List<Vertex> expected = new ArrayList<Vertex>(Arrays.asList(v));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		
		g.addEdge(a, c);
		g.addEdge(b, c);
		g.addEdge(a, d);
		g.addEdge(b, d);
		
		assertEquals(expected, Algorithms.commonUpstreamVertices(g, c, d));
	}
	
	@Test
	//test about when there is no vertex in that is the common upstream of vertex a and b
	public void commonUpstreamVertices_3(){
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		
		Vertex[] v = {};
		List<Vertex> expected = new ArrayList<Vertex>(Arrays.asList(v));
		
		g.addVertex(a);
		g.addVertex(b);
		
		assertEquals(expected, Algorithms.commonUpstreamVertices(g, a, b));
	}
	
	@Test
	//test about when there is one vertex that is the common down stream of vertex a and b
	public void commonDownstreamVertices_1(){
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex[] v = {c};
		List<Vertex> expected = new ArrayList<Vertex>(Arrays.asList(v));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		
		g.addEdge(a, c);
		g.addEdge(a, b);
		g.addEdge(b, c);
		
		assertEquals(expected, Algorithms.commonDownstreamVertices(g, a, b));
	}
	

	@Test
	//test about when there is multiple vertices that are the common down stream of vertex a and b
	public void commonDownstreamVertices_2(){
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex[] v = {c, d};
		List<Vertex> expected = new ArrayList<Vertex>(Arrays.asList(v));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		
		g.addEdge(a, c);
		g.addEdge(a, d);
		g.addEdge(b, c);
		g.addEdge(b, d);
		
		assertEquals(expected, Algorithms.commonDownstreamVertices(g, a, b));
	}
	
	@Test
	//test about when there is no vertex that is the common down stream of vertex a and b
	public void commonDownstreamVertices_3(){
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex[] v = {};
		List<Vertex> expected = new ArrayList<Vertex>(Arrays.asList(v));
		
		g.addVertex(a);
		g.addVertex(b);
		
		assertEquals(expected, Algorithms.commonDownstreamVertices(g, a, b));
	}
	
	//Testing DFS with 1 vertex
		@Test
		public void testDepthFrist_1() {
			Vertex a = new Vertex("Rodrigo");
			AdjacencyListGraph currentGraph = new AdjacencyListGraph();
			currentGraph.addVertex(a);
			Set<List<Vertex>>boo = Algorithms.depthFirstSearch(currentGraph);
			
			ArrayList<Vertex>temp = new ArrayList<Vertex>();
			temp.add(a);
			Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
			arr.add(temp);
			
			assertEquals(arr, boo);
		}
		
		//Testing DFS with no vertex
			@Test
			public void testDepthFrist_0() {
				
				AdjacencyListGraph currentGraph = new AdjacencyListGraph();
				Set<List<Vertex>>boo = Algorithms.depthFirstSearch(currentGraph);
				
				Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
			
				
				assertEquals(arr, boo);
			}
		// Testing DFS with a balanced 3 Vertex graph
		@Test
		public void testDepthFirst_2() {
			Vertex a = new Vertex("Rodrigo");
			Vertex b = new Vertex("Pedro");
			Vertex c = new Vertex("João");
			AdjacencyListGraph currentGraph = new AdjacencyListGraph();
			currentGraph.addVertex(a);
			currentGraph.addVertex(b);
			currentGraph.addVertex(c);
			
			currentGraph.addEdge(a, b);
			currentGraph.addEdge(a, c);
			
			Set<List<Vertex>>boo = Algorithms.depthFirstSearch(currentGraph);
			
			ArrayList<Vertex>temp1 = new ArrayList<Vertex>();
			temp1.add(a);
			temp1.add(c);
			temp1.add(b);
			
			ArrayList<Vertex>temp2 = new ArrayList<Vertex>();
			temp2.add(b);
			
			ArrayList<Vertex>temp3 = new ArrayList<Vertex>();
			temp3.add(c);
			
			Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
			arr.add(temp1);
			arr.add(temp2);
			arr.add(temp3);
			
			assertEquals(arr, boo);
		}
		
		//Testing a skewed graph with 3 vertex
		@Test
		public void testDepthFrist_3() {
			Vertex a = new Vertex("Rodrigo");
			Vertex b = new Vertex("Pedro");
			Vertex c = new Vertex("João");
			AdjacencyListGraph currentGraph = new AdjacencyListGraph();
			currentGraph.addVertex(a);
			currentGraph.addVertex(b);
			currentGraph.addVertex(c);
			
			currentGraph.addEdge(a, b);
			currentGraph.addEdge(b, c);
			
			Set<List<Vertex>>boo = Algorithms.depthFirstSearch(currentGraph);
			
			ArrayList<Vertex>temp1 = new ArrayList<Vertex>();
			temp1.add(a);
			temp1.add(b);
			temp1.add(c);
			
			ArrayList<Vertex>temp2 = new ArrayList<Vertex>();
			temp2.add(b);
			temp2.add(c);
			
			ArrayList<Vertex>temp3 = new ArrayList<Vertex>();
			temp3.add(c);
			
			Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
			arr.add(temp1);
			arr.add(temp2);
			arr.add(temp3);
			
			assertEquals(arr, boo);
		}
		
		//Testing a unbalanced graph with 5 vertexes
		@Test
		public void testDepthFrist_4() {
			Vertex a = new Vertex("Rodrigo");
			Vertex b = new Vertex("Pedro");
			Vertex c = new Vertex("João");
			Vertex d = new Vertex("Gabriel");
			Vertex e = new Vertex("Lucas");
			AdjacencyListGraph currentGraph = new AdjacencyListGraph();
			currentGraph.addVertex(a);
			currentGraph.addVertex(b);
			currentGraph.addVertex(c);
			currentGraph.addVertex(d);
			currentGraph.addVertex(e);
			
			currentGraph.addEdge(a, b);
			currentGraph.addEdge(a, c);
			currentGraph.addEdge(b, d);
			currentGraph.addEdge(d, e);
			
			Set<List<Vertex>>boo = Algorithms.depthFirstSearch(currentGraph);
			
			ArrayList<Vertex>temp1 = new ArrayList<Vertex>();
			temp1.add(c);
			
			
			ArrayList<Vertex>temp2 = new ArrayList<Vertex>();
			temp2.add(a);
			temp2.add(c);
			temp2.add(b);
			temp2.add(d);
			temp2.add(e);
			
			
			ArrayList<Vertex>temp3 = new ArrayList<Vertex>();
			temp3.add(b);
			temp3.add(d);
			temp3.add(e);
			
			ArrayList<Vertex>temp4 = new ArrayList<Vertex>();
			temp4.add(d);
			temp4.add(e);
			
			ArrayList<Vertex>temp5 = new ArrayList<Vertex>();
			temp5.add(e);
			
			Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
			arr.add(temp1);
			arr.add(temp2);
			arr.add(temp3);
			arr.add(temp4);
			arr.add(temp5);
			
			
			assertEquals(arr, boo);
		}

		
		
			//Testing BFS with no vertex
				@Test
				public void testBreadthFrist_0() {
					
					AdjacencyListGraph currentGraph = new AdjacencyListGraph();
					Set<List<Vertex>>boo = Algorithms.breadthFirstSearch(currentGraph);
					
					Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
				
					
					assertEquals(arr, boo);
				}
				

			//Testing BFS with 1 vertex
				@Test
				public void testBreadthFrist_1() {
					Vertex a = new Vertex("Rodrigo");
					AdjacencyListGraph currentGraph = new AdjacencyListGraph();
					currentGraph.addVertex(a);
					Set<List<Vertex>>boo = Algorithms.breadthFirstSearch(currentGraph);
					
					ArrayList<Vertex>temp = new ArrayList<Vertex>();
					temp.add(a);
					Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
					arr.add(temp);
					
					assertEquals(arr, boo);
				}
			// Testing BFS with a balanced 3 Vertex graph
				@Test
				public void testBreadthFirst_2() {
					Vertex a = new Vertex("Rodrigo");
					Vertex b = new Vertex("Pedro");
					Vertex c = new Vertex("João");
					AdjacencyListGraph currentGraph = new AdjacencyListGraph();
					currentGraph.addVertex(a);
					currentGraph.addVertex(b);
					currentGraph.addVertex(c);
					
					currentGraph.addEdge(a, b);
					currentGraph.addEdge(a, c);
					
					Set<List<Vertex>>boo = Algorithms.breadthFirstSearch(currentGraph);
					
					ArrayList<Vertex>temp1 = new ArrayList<Vertex>();
					temp1.add(a);
					temp1.add(b);
					temp1.add(c);
					
					ArrayList<Vertex>temp2 = new ArrayList<Vertex>();
					temp2.add(b);
					
					ArrayList<Vertex>temp3 = new ArrayList<Vertex>();
					temp3.add(c);
					
					Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
					arr.add(temp1);
					arr.add(temp2);
					arr.add(temp3);
					
					assertEquals(arr, boo);
				}
			//Testing a skewed graph with 3 vertex
				@Test
				public void testBreadthFrist_3() {
					Vertex a = new Vertex("Rodrigo");
					Vertex b = new Vertex("Pedro");
					Vertex c = new Vertex("João");
					AdjacencyListGraph currentGraph = new AdjacencyListGraph();
					currentGraph.addVertex(a);
					currentGraph.addVertex(b);
					currentGraph.addVertex(c);
					
					currentGraph.addEdge(a, b);
					currentGraph.addEdge(b, c);
					
					Set<List<Vertex>>boo = Algorithms.breadthFirstSearch(currentGraph);
					
					ArrayList<Vertex>temp1 = new ArrayList<Vertex>();
					temp1.add(a);
					temp1.add(b);
					temp1.add(c);
					
					ArrayList<Vertex>temp2 = new ArrayList<Vertex>();
					temp2.add(b);
					temp2.add(c);
					
					ArrayList<Vertex>temp3 = new ArrayList<Vertex>();
					temp3.add(c);
					
					Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
					arr.add(temp1);
					arr.add(temp2);
					arr.add(temp3);
					
					assertEquals(arr, boo);
				}
				//Testing a unbalanced graph with 5 vertexes
				@Test
				public void testBreadthFirst_4() {
					Vertex a = new Vertex("Rodrigo");
					Vertex b = new Vertex("Pedro");
					Vertex c = new Vertex("João");
					Vertex d = new Vertex("Gabriel");
					Vertex e = new Vertex("Lucas");
					AdjacencyListGraph currentGraph = new AdjacencyListGraph();
					currentGraph.addVertex(a);
					currentGraph.addVertex(b);
					currentGraph.addVertex(c);
					currentGraph.addVertex(d);
					currentGraph.addVertex(e);
					
					currentGraph.addEdge(a, b);
					currentGraph.addEdge(a, c);
					currentGraph.addEdge(b, d);
					currentGraph.addEdge(d, e);
					
					Set<List<Vertex>>boo = Algorithms.breadthFirstSearch(currentGraph);
					
					ArrayList<Vertex>temp1 = new ArrayList<Vertex>();
					temp1.add(c);
					
					
					ArrayList<Vertex>temp2 = new ArrayList<Vertex>();
					temp2.add(a);
					temp2.add(b);
					temp2.add(c);
					temp2.add(d);
					temp2.add(e);
					
					
					ArrayList<Vertex>temp3 = new ArrayList<Vertex>();
					temp3.add(b);
					temp3.add(d);
					temp3.add(e);
					
					ArrayList<Vertex>temp4 = new ArrayList<Vertex>();
					temp4.add(d);
					temp4.add(e);
					
					ArrayList<Vertex>temp5 = new ArrayList<Vertex>();
					temp5.add(e);
					
					Set<ArrayList<Vertex>>arr = new HashSet<ArrayList<Vertex>>();
					arr.add(temp1);
					arr.add(temp2);
					arr.add(temp3);
					arr.add(temp4);
					arr.add(temp5);
					
					
					assertEquals(arr, boo);
				}

				
}
