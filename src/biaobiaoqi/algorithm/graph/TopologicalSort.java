package biaobiaoqi.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * TODO 改进：用Template实现
 * @author biaobiaoqi
 *
 */
public class TopologicalSort {
    /**
     * This method is expensive.
     * @param graph
     * @return
     */
    public static List<Integer> topologicalSortDamn(Graph graph) {
    	ArrayList<Integer> resultList = new ArrayList<Integer>(20);
    	
    	int count = graph.vertexMap.size();
    	
    	for (int i = 0; i < count; i ++) {
    		boolean circle = true;
    		for(Integer vertex : graph.vertexMap.keySet()) {
    			if (graph.vertexMap.get(vertex).indegree == 0 && !graph.vertexMap.get(vertex).visited) {	
    				resultList.add(vertex);
    				
    				LinkedList<Integer> neighbors = new LinkedList<Integer>(graph.vertexMap.get(vertex).neighbors);
    				for (Integer neighbor : neighbors ) {
    					graph.removeEdge(vertex, neighbor);
    				}
    				graph.vertexMap.get(vertex).visited = true;
    				circle = false;
    				break;	
				}
    		}
    		
    		if (circle) {
				throw new IllegalStateException("有环！");
			}
    	}

    	return resultList;
    }
    
    /**
     * 用一个容器做缓冲。
     * @param graph
     * @return
     */
    public static List<Integer> topologicalSort(Graph graph) {
    	ArrayList<Integer> resultList = new ArrayList<Integer>();
    	Queue<Integer> tmpQueue = new LinkedList<Integer>();
    	Set<Integer> vSet = graph.vertexMap.keySet(); 
    	Integer vertex  = null;
    	
    	for (Integer v : vSet) {
    		if (graph.vertexMap.get(v).indegree == 0) {
				tmpQueue.add(v);
				resultList.add(v);
			}
    	}

    	while (!tmpQueue.isEmpty()) {
    		vertex = tmpQueue.poll();
    		
    		LinkedList<Integer> neighbors = new LinkedList<Integer>(graph.vertexMap.get(vertex).neighbors);
    		for (Integer neighbor : neighbors) {
    			graph.removeEdge(vertex, neighbor);
    			if (graph.vertexMap.get(neighbor).indegree == 0) {
					 tmpQueue.add(neighbor);
					 resultList.add(neighbor);
				}
    		}
    	}
    	
    	if (resultList.size() != vSet.size()) {
    		throw new IllegalStateException("有环！ ");
		}
    	
    	return resultList;
    }
    
    
    
    public static void main(String[] args) {
    	//test case : 方向是从上向下指，水平的<指向左边
    	/*
    	 2     1  
    	 | \ /  \  \          
    	 5  4    3  9       
    	    |    /\
    	    8 < 7  6         
    	 */
    	
    	Graph graph = new Graph();
    	List<Integer> tmpList = new LinkedList<Integer>();
    	tmpList.add(3);
    	tmpList.add(4);
    	tmpList.add(9);
    	graph.addVertex(1, tmpList);
    	
    	tmpList = new LinkedList<Integer>();
    	tmpList.add(5);
    	tmpList.add(4);
    	graph.addVertex(2, tmpList);
    	
    	tmpList = new LinkedList<Integer>();
    	tmpList.add(6);
    	tmpList.add(7);
    	graph.addVertex(3, tmpList);
    	
    	tmpList = new LinkedList<Integer>();
    	tmpList.add(8);
    	graph.addVertex(4, tmpList);
    	
    	tmpList = new LinkedList<Integer>();
    	graph.addVertex(5, tmpList);
    	
    	tmpList = new LinkedList<Integer>();
    	graph.addVertex(6, tmpList);
    	
    	tmpList = new LinkedList<Integer>();
    	graph.addVertex(8, tmpList);
    	
    	tmpList = new LinkedList<Integer>();
    	tmpList.add(8);
    	graph.addVertex(7, tmpList);
    	

    	tmpList = new LinkedList<Integer>();
    	graph.addVertex(9, tmpList);
    	
    	graph.calculateIndegree();
    	

    	List<Integer> vList = TopologicalSort.topologicalSort(graph);  
    	System.out.println(Arrays.toString(vList.toArray()));

    }
}
