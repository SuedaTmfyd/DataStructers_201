package Graph_11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DijkstraAlgorithm {
	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		 
		nodeA.addConnection(nodeB, 10);
		nodeA.addConnection(nodeC, 15);
		 
		nodeB.addConnection(nodeD, 12);
		nodeB.addConnection(nodeF, 15);
		 
		nodeC.addConnection(nodeE, 10);
		 
		nodeD.addConnection(nodeE, 2);
		nodeD.addConnection(nodeF, 1);
		 
		nodeF.addConnection(nodeE, 5);
		 
		Graph graph = new Graph();
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);

	}

}

class Djikstra{
	public static Graph calculateShortestPath(Graph graph, Node source) {
		
		source.setShortestDistance(0);
		Queue unsettledNodes = new PriorityQueue<Node>(Comparator.comparingInt(n->n.getShortestDistance()));
		unsettledNodes.add(source);
		Set<Node> settledNodes = new HashSet<>();//aynı elementi tekrar eklememek için set
		
		while(!unsettledNodes.isEmpty()) {
			Node currentNode = (Node) unsettledNodes.poll();
			for(Entry<Node,Integer> entry : currentNode.getConnections().entrySet()) {
				Node adjNode = entry.getKey();
				int distance = entry.getValue();
				if(settledNodes.contains(adjNode)){
					//calc distance
					calculateDistance(currentNode,adjNode,distance);
					unsettledNodes.add(adjNode);
					
				}
			}
			settledNodes.add(currentNode);	
		}
		return graph;
	}
	
	public static void calculateDistance(Node source, Node destination, int distance) {
		int newDistance = source.getShortestDistance()+distance;
		
		
	}
}


class Graph{
	Set<Node> nodes;
	
	Graph(){
		this.nodes = new HashSet<Node>();
	}
	
	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node node) {
		nodes.add(node);
	}
}

class Node{
	String name;
	Map<Node,Integer> connections;
	int shortestDistance;
	List<Node> shortestPath;
	
	Node(String name){
		this.name = name;
		this.connections = new HashMap<Node,Integer>();
		this.shortestPath = new ArrayList<Node>();
		this.shortestDistance = Integer.MAX_VALUE;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Node, Integer> getConnections() {
		return connections;
	}

	public void setConnections(Map<Node, Integer> connections) {
		this.connections = connections;
	}

	public int getShortestDistance() {
		return shortestDistance;
	}

	public void setShortestDistance(int shortestDistance) {
		this.shortestDistance = shortestDistance;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public void addConnection(Node node, int i) {
		connections.put(node, i);
	}
}
