package ca.ubc.ece.cpen221.mp3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraphTest {

	@Test
	//tests about adding one vertex into the graph
	public void testAddVertex_1() {
		Vertex a = new Vertex("Daniel");
		AdjacencyListGraph g = new AdjacencyListGraph();
		
		g.addVertex(a);
		
		assertEquals(0, g.getMappingKey(a));
	}
	
	@Test
	//test about adding multiple vertices into the graph
	public void testAddVertex_2() {
		Vertex a = new Vertex("Daniel");
		Vertex b = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		
		g.addVertex(a);
		g.addVertex(b);
		
		assertEquals(1, g.getMappingKey(b));
	}
	
	@Test
	//tests about when there is no vertex in the graph
	public void testAddVertex_3() {
		Vertex a = new Vertex("Daniel");
		AdjacencyListGraph g = new AdjacencyListGraph();
		
		assertEquals(-1, g.getMappingKey(a));
	}
	
	@Test
	//tests about there is edge from a to b
	public void testAddEdge_1(){
		Vertex a = new Vertex("Daniel");
		Vertex b = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		
		g.addVertex(a);
		g.addVertex(b);
		
		assertFalse(g.edgeExists(a, b));
		
		g.addEdge(a, b);
		
		assertTrue(g.edgeExists(a, b));
	}
	
	@Test
	//tests about there is no edge from a to b
	public void testAddEdge_2(){
		Vertex a = new Vertex("Daniel");
		Vertex b = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		
		g.addVertex(a);
		g.addVertex(b);
		
		assertFalse(g.edgeExists(a, b));
		
		g.addEdge(a, b);
		
		assertFalse(g.edgeExists(b, a));
	}
	
	@Test
	//tests about the transitivity of the edge
	public void testAddEdge_3(){
		Vertex a = new Vertex("Daniel");
		Vertex b = new Vertex("Rodrigo");
		Vertex c = new Vertex("CPEN221");
		AdjacencyListGraph g = new AdjacencyListGraph();
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		
		assertFalse(g.edgeExists(a, b));
		
		g.addEdge(a, b);
		g.addEdge(a, c);
		
		assertFalse(g.edgeExists(a, c));
	}
	
	@Test
	//tests about when there is downstream of a
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
	//tests about when there is downstream of a but it only contains one vertex
	public void testDownstreamNeigbors_2(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex[] x = {b};
		List<Vertex> downstream = new ArrayList<Vertex>(Arrays.asList(x));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		
		g.addEdge(a, b);
		
		assertEquals(downstream, g.getDownstreamNeighbors(a));
	}
	
	@Test
	//tests about when there is no downstream of a
	public void testDownstreamNeigbors_3(){
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
	//tests about there are lots of vertices in the downstream of a
	public void testDownstreamNeigbors_4(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex h = new Vertex("h");
		
		List<Vertex> r = new ArrayList<Vertex>(Arrays.asList(a, b, c, d, e, f, h));
		
		AdjacencyListGraph g = new AdjacencyListGraph();
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
	//tests about when there is upstream of a
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
	//tests about when there is upstream of a but it only contains one vertex
	public void testUpstreamNeigbors_2(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex[] x = {a};
		List<Vertex> upstream = new ArrayList<Vertex>(Arrays.asList(x));
		
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		
		g.addEdge(a, b);
		
		assertEquals(upstream, g.getUpstreamNeighbors(b));
	}
	
	@Test
	//tests about when there is no upstream of a
	public void testUpstreamNeigbors_3(){
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
	//tests about there are lots of vertices in the upstream of a
	public void testUpstreamNeigbors_4(){
		Vertex a = new Vertex("CPEN221");
		Vertex b = new Vertex("Daniel");
		Vertex c = new Vertex("Rodrigo");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex h = new Vertex("h");
		
		List<Vertex> r = new ArrayList<Vertex>(Arrays.asList(a, b, c, d, e, f, h));
		
		AdjacencyListGraph g = new AdjacencyListGraph();
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
	//test about when there are vertices in the matrix
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
	//test about when there is no vertices in the matrix
	public void testGetVertices_2(){
		
		AdjacencyListGraph g = new AdjacencyListGraph();
		Vertex[] x = {};
		List<Vertex> allVertices = new ArrayList<Vertex>(Arrays.asList(x));
		Set<Vertex> vertexSet = new HashSet<Vertex>(allVertices);
		
		Set<Vertex> returnSet = new HashSet<Vertex>(g.getVertices());
		
		assertEquals(vertexSet, returnSet);
	}
}
