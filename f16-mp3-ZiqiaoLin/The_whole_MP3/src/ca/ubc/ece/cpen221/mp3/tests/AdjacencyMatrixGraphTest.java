package ca.ubc.ece.cpen221.mp3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyMatrixGraphTest {

	@Test
	//This test tests if the matrix has the expected number of rows
	public void testAddVertex_1() {
		Vertex a = new Vertex("Daniel");
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph();
		ArrayList<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
		
		System.out.println(expected);
		
		g.addVertex(a);
		
		int size = 1;
		
		assertTrue(size == g.getAdj_list().size());
	}
	
	@Test
	//This test tests if the matrix has the expected number of columns
	public void testAddVertex_2() {
		Vertex a = new Vertex("Daniel");
		Vertex b = new Vertex("Rodrigo");
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph();
		ArrayList<LinkedList<Integer>> expected = new ArrayList<LinkedList<Integer>>();
		
		System.out.println(expected);
		
		g.addVertex(a);
		g.addVertex(b);
		
		int size = 2;
		
		for(int index = 0; index < size; index++){
			assertTrue(size == g.getAdj_list().get(index).size());
		}
	}
	
	@Test
	//Tests about the edge from a to b
	public void testAddEdge_1(){
		Vertex a = new Vertex("Daniel");
		Vertex b = new Vertex("Rodrigo");
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph();
		
		g.addVertex(a);
		g.addVertex(b);
		
		assertFalse(g.edgeExists(a, b));
		
		g.addEdge(a, b);
		
		assertTrue(g.edgeExists(a, b));
	}
	
	@Test
	//Tests about the edge from b to a
	public void testAddEdge_2(){
		Vertex a = new Vertex("Daniel");
		Vertex b = new Vertex("Rodrigo");
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph();
		
		g.addVertex(a);
		g.addVertex(b);
		
		assertFalse(g.edgeExists(a, b));
		
		g.addEdge(a, b);
		
		assertFalse(g.edgeExists(b, a));
	}
	
	@Test
	//Tests about the transitivity of edges
	public void testAddEdge_3(){
		Vertex a = new Vertex("Daniel");
		Vertex b = new Vertex("Rodrigo");
		Vertex c = new Vertex("CPEN221");
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph();
		
		g.addVertex(a);
		g.addVertex(b);
		
		assertFalse(g.edgeExists(a, b));
		
		g.addEdge(a, b);
		g.addEdge(b, c);
		
		assertFalse(g.edgeExists(a, c));
	}
	
	@Test
	//This test tests about when there is downstream
	public void testDownstreamNeigbors_1(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex[] x = {b, c};
		List<Vertex> downstream = new ArrayList<Vertex>(Arrays.asList(x));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		
		g.addEdge(a, b);
		g.addEdge(a, c);
		
		assertEquals(downstream, g.getDownstreamNeighbors(a));
	}
	
	@Test
	//This test tests about the output when there is no downstream
	public void testDownstreamNeigbors_2(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex[] x = {};
		List<Vertex> downstream = new ArrayList<Vertex>(Arrays.asList(x));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		
		assertEquals(downstream, g.getDownstreamNeighbors(a));
	}
	
	@Test
	//tests about when there are lots of vertices in the downstream
	public void testDownstreamNeigbors_3(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex h = new Vertex("h");
		
		List<Vertex> r = new ArrayList<Vertex>(Arrays.asList(a, b, c, d, e, f, h));
		
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph();
		Vertex[] x = {b, c, d, e, f, h};
		List<Vertex> downstream = new ArrayList<Vertex>(Arrays.asList(x));
		
		for(Vertex v : r){
			g.addVertex(v);
		}
		
		for(int index = 1; index < 7; index++){
			g.addEdge(a, r.get(index));
		}
		
		assertEquals(downstream, g.getDownstreamNeighbors(a));
	}
	
	@Test
	//Tests about there is downstream
	public void testUpstreamNeigbors_1(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex[] x = {a, c};
		List<Vertex> upstream = new ArrayList<Vertex>(Arrays.asList(x));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		
		g.addEdge(a, b);
		g.addEdge(c, b);
		
		assertEquals(upstream, g.getUpstreamNeighbors(b));
	}
	
	@Test
	//Tests about there is no upstream
	public void testUpstreamNeigbors_2(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex[] x = {};
		List<Vertex> upstream = new ArrayList<Vertex>(Arrays.asList(x));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);

		assertEquals(upstream, g.getUpstreamNeighbors(b));
	}
	

	@Test
	//tests about when there are lots of vertices in the upstream
	public void testUpstreamNeigbors_3(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex h = new Vertex("h");
		
		List<Vertex> r = new ArrayList<Vertex>(Arrays.asList(a, b, c, d, e, f, h));
		
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph();
		Vertex[] x = {a, b, c, d, e, f};
		List<Vertex> upstream = new ArrayList<Vertex>(Arrays.asList(x));
		
		for(Vertex v : r){
			g.addVertex(v);
		}
		
		for(int index = 0; index < 6; index++){
			g.addEdge(r.get(index), h);
		}
		
		assertEquals(upstream, g.getUpstreamNeighbors(h));
	}
	
	
	@Test
	//tests about there are vertices in the graph
	public void testGetVertices_1(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex[] x = {a, b, c};
		List<Vertex> allVertices = new ArrayList<Vertex>(Arrays.asList(x));
		Set<Vertex> vertexSet = new HashSet<Vertex>(allVertices);
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		
		Set<Vertex> returnSet = new HashSet<Vertex>(g.getVertices());
		
		assertEquals(vertexSet, returnSet);
	}
	
	@Test
	//tests about there is no vertex in the graph
	public void testGetVertices_2(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex[] x = {};
		List<Vertex> allVertices = new ArrayList<Vertex>(Arrays.asList(x));
		Set<Vertex> vertexSet = new HashSet<Vertex>(allVertices);
		
		Set<Vertex> returnSet = new HashSet<Vertex>(g.getVertices());
		
		assertEquals(vertexSet, returnSet);
	}
}
