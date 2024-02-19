package Tree_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TreeImplementation {

	public static void main(String[] args) {
		Tree tree = new Tree();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		List<Node> n1child = new ArrayList<Node>();
		n1child.add(n2);
		n1child.add(n5);
		n1.setChildren(n1child);
		List<Node> n2child = new ArrayList<Node>();
		n1child.add(n3);
//		n1child.add(n5);
//		n1child.add(n6);
		tree.setRoot(n1);
//		tree.breadthFirst();
		tree.depthFirst(n1);
		
	}
}

class Tree{
	private Node root;
	
	Tree(){}
	
	Tree(Node root){
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
//	public void depthFirstSearch(Node node) {
//		if(node.getChildren() == null)
//			return;
//		System.out.println(depthFirstSearch(node.getChildren()));
//		
//	}
	
	public void breadthFirst() { // 1 2 5 3
		Queue<Node> que = new LinkedList<>();
		que.add(this.root);
		while(!que.isEmpty()) {
			Node p = que.poll();
			System.out.println(p.getValue());
			for(Node c : p.getChildren())
				que.add(c);
		}
	}
	
	public void depthFirst(Node node) {
		if(node == null)
			return;
		System.out.println(node.getValue());
		for(Node c : node.getChildren()) {
			depthFirst(c);
		}
	}
	
}

class Node{
	private int value;
	private List<Node> children;
	
	Node(int value){
		this.value = value;
		children = new ArrayList<Node>();
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	public boolean isLeaf(Node node) {
		if(this.children.contains(node))
			return true;
		return false;
	}
	
}