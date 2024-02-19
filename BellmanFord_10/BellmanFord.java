package BellmanFord_10;

public class BellmanFord {

	public static void main(String[] args) {


	}

}

class Graph{
	private int nodeId;
	private int[] times;
	private int[] nextHops;
	
	Graph(int nodeId, int numNodes){
		this.nodeId = nodeId;
		this.times = new int[numNodes+1];
		this.nextHops = new int[numNodes+1];
		initRoutes();
	}
	
	private void initRoutes() {
		for(int i = 1; i<times.length;i++) {
			times[i] = (i==nodeId) ? 0 : Integer.MAX_VALUE;
			nextHops[i] = -1;
		}
	}
	
	public void introduce(Node newNode,int delayTime) {
		int newNodeId = newNode.nodeId;
		times[newNodeId] = delayTime;
		nextHops[nodeId] = nodeId;
		
		times[nodeId] = delayTime;
		nextHops[nodeId] = nodeId;
	}
	
	public void updateRoutes(Node[] allNodes) {
		//Bellman Ford
		
		
	}
	
	public void printRoutes() {
		System.out.println("Routing table for Node" + nodeId + ": ");
		for(int destNode = 1; destNode<times.length;destNode++) {
			System.out.println("To node " + destNode + " -> Time: " + times[destNode] + "ms, Next Hop: "+ nextHops[destNode]);
		}
	}	
}

class Node {
	private char value;
	private Node next;
	private Node previous;
	int nodeId;
	
	public Node(char value){
		this.value = value;
		next = null;
		previous = null;
	}
	
	public Node(char value,int nodeId){
		this.value = value;
		this.nodeId = nodeId;
		next = null;
		previous = null;
	}
	
	public  Node getNextNode() {
		return next;
	}

	public void setNextNode(Node next) {
		this.next = next;
	}

	public Node getPreviousNode() {
		return previous;
	}

	public void setPreviousNode(Node previous) {
		this.previous = previous;
	}
	
	public char getValue() {
		return value;
	}
}
