package LinkedList_2;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		System.out.print("Enter a string to check if it is a palindrome or not: ");
		Scanner inp = new Scanner(System.in);
		String value = inp.next();
		System.out.println(isPalindrome(value));
	}
	
	public static boolean isPalindrome(String value) {
		LinkedList<Character> list = new LinkedList<>();
		for(int i = 0; i<value.length(); i++) {
			list.insert(new Node(value.charAt(i)));
		}
		Node left = list.getHead();
		Node right = list.getTail();
		while(left != right) {
			if(left.getValue() != right.getValue()) {
				return false;
			}
			left = left.getNextNode();
			right = right.getPreviousNode();
		}
		return true;
	}
}

class Node <T>{
	private char value;
	private Node<T> next;
	private Node<T> previous;
	
	public Node(char value){
		this.value = value;
		next = null;
		previous = null;
	}
	
	public <T> Node getNextNode() {
		return next;
	}

	public void setNextNode(Node<T> next) {
		this.next = next;
	}

	public <T> Node getPreviousNode() {
		return previous;
	}

	public void setPreviousNode(Node<T> previous) {
		this.previous = previous;
	}
	
	public char getValue() {
		return value;
	}
}

class LinkedList<T>{
	private Node<T> head;
	private Node<T> tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public <T> Node getHead() {
		return head;
	}

	public <T> Node getTail() {
		return tail;
	}

	public void insert(Node<T> n) {
		if(head == null) {
			head = n;
			tail = n;
			return;
		}
		tail.setNextNode(n);
		n.setPreviousNode(tail);
		tail = n;
	}
	
	public void push(Node<T> headRef, char newVal) {
		Node curNode = head;
		Node curNodeNext;
		while(tail.getNextNode() != null) {
			if(curNode != headRef) {
				curNode = curNode.getNextNode();
			}
			else
				break;
		}
		if(curNode == head) {
			curNode.setPreviousNode(new Node(newVal));
			curNode.getPreviousNode().setNextNode(curNode);
			head = curNode.getPreviousNode();
			return;
		}
		if(curNode == tail) {
			curNode.setNextNode(new Node(newVal));
			curNode.getNextNode().setPreviousNode(curNode);
			tail = curNode.getNextNode();
			return;
		}
		curNodeNext = curNode.getNextNode();
		curNode.setNextNode(new Node(newVal));
		curNode.getNextNode().setPreviousNode(curNode);
		curNode = curNode.getNextNode();
		curNode.setNextNode(curNodeNext);
		curNode.getNextNode().setPreviousNode(curNode);
	}
}