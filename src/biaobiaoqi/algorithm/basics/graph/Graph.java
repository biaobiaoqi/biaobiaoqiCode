package biaobiaoqi.algorithm.basics.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 拓扑排序的简单实现。
 * 没有模板和异常机制。
 * @author biaobiaoqi
 *
 */
public class Graph {
	public Map<Integer, Vertex> vertexMap;
	
	public Graph() {
		vertexMap = new HashMap<Integer, Graph.Vertex>();
	}
	
	public void addVertex(Integer vertex, List<Integer> list) {
		vertexMap.put(vertex, new Vertex(vertex, list));
		
	}
	

	public void calculateIndegree() {
		
		for (Entry<Integer, Vertex> entry : vertexMap.entrySet()) {
			for (Integer vertex : entry.getValue().neighbors) {
				vertexMap.get(vertex).indegree ++;
			}
		}
	}
	

	public void removeEdge(Integer vertex, Integer neighbor) {
		vertexMap.get(neighbor).indegree --;
		vertexMap.get(vertex).neighbors.remove(neighbor);
	}
	
	
	
	
//	
//	public void removeVertex(Integer vertex) {
//		for (Integer neighbor : getNeighbors(vertex)) {
//			removeEdge(vertex, neighbor);
//		}
//		vertexMap.remove(vertex);
//	}
//	
//	
//	public Set<Integer> vertexSet() {
//		return vertexMap.keySet();
//	}
//	
//	public int numberOfVertices() {
//		return vertexMap.size();
//	}    	
//	
//	
//	public int getIndegree(Integer vertex) {
//		return vertexMap.get(vertex).indegree;
//	}
//	
//	public List<Integer> getNeighbors(Integer vertex) {
//		return vertexMap.get(vertex).neighbors;
//	}
//	
//	public void setVertexVisited(Integer vertex) {
//		vertexMap.get(vertex).visited = true;
//	}
//	
//	public boolean vertexVisited(Integer vertex) {
//		return vertexMap.get(vertex).visited; 
//	}
	
	public class Vertex{
		public List<Integer> neighbors;
		public int indegree;
		public Integer vertex;
		public boolean visited;
		
		public Vertex(Integer vertex, List<Integer> list) {
			this.vertex = vertex;
			neighbors = list;
			indegree = 0;
			visited = false;
		}
	}
}


