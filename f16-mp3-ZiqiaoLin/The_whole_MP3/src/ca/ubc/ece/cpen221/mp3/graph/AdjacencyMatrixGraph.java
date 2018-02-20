package ca.ubc.ece.cpen221.mp3.graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyMatrixGraph implements Graph {
	
	public HashMap<Vertex, Integer> mapping = new HashMap<Vertex, Integer>();
	ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();
	int countVertex=0;
	
	public void printMap(){
		for (Map.Entry<Vertex,Integer> entry : mapping.entrySet()) {
			  Vertex key = entry.getKey();
			  Integer value = entry.getValue();
			  System.out.println(key + "->" + value);
			  System.out.println();
			}
		
		    for (ArrayList<Integer> abc : adj_list){
		    	System.out.println();
		        for (Integer s : abc){
		        	System.out.print(s);
		        }
		    }
		   System.out.println();
	}
	@Override
	public void addVertex(Vertex v) {
		// TODO Auto-generated method stub
		for(ArrayList<Integer>num: adj_list){ //Add a column to each row
			num.add(0);
		}
		adj_list.add(new ArrayList<Integer>()); //Add a new row
		
		for(int i=0; i<adj_list.size();i++)
			adj_list.get(adj_list.size()-1).add(0); //Populate new row with 0s
		
		mapping.put(v, countVertex); 
		
		
		countVertex++;
	}

	@Override
	public void addEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		if(mapping.containsKey(v1) &&mapping.containsKey(v2)){
			i = mapping.get(v1);
			j= mapping.get(v2);
			adj_list.get(i).set(j, 1);
			
		}
		
	}

	@Override
	public boolean edgeExists(Vertex v1, Vertex v2) {
		int i = 0;
		int j = 0;
		if(mapping.containsKey(v1) &&mapping.containsKey(v2)){
			i = mapping.get(v1);
			j= mapping.get(v2);
			if(adj_list.get(i).get(j) == 1)
				return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Vertex> getDownstreamNeighbors(Vertex v) {
		
		int i =0;
		ArrayList<Vertex> arr = new ArrayList<Vertex>();
		
		if(mapping.containsKey(v))
			i = mapping.get(v);
		System.out.println(i);
		for(int j=0; j<adj_list.get(i).size();j++){
			
			if(adj_list.get(i).get(j)==1){
				for (Vertex o : mapping.keySet()) {
				      if (mapping.get(o).equals(j)) {
				        arr.add(o);
				      }
				   }
					
				}
			}
			return arr;
		}
		
	

	@Override
	public List<Vertex> getUpstreamNeighbors(Vertex v) {
		// TODO Auto-generated method stub
		int i =0;
		List<Vertex>arr = new ArrayList<Vertex>();
		
		if(mapping.containsKey(v))
			i = mapping.get(v);
		
		System.out.println(i);
		for(int j = 0; j<adj_list.size(); j++){
			if(adj_list.get(j).get(i)==1){
				for (Vertex o : mapping.keySet()) {
				      if (mapping.get(o).equals(j)) {
				        arr.add(o);
				      }
				   }
			}
				
		}
		return arr;
	}

	@Override
	public List<Vertex> getVertices() {
		// TODO Auto-generated method stub
		List<Vertex>arr=new ArrayList<Vertex>();
		
			for (Vertex o : mapping.keySet()) {
			   arr.add(o);
			  }
		
		return arr;
	}
	
	public ArrayList<ArrayList<Integer>> getAdj_list(){
		return adj_list;
	}
}