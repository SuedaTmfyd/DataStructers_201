package Algorithm_9;

import java.util.Comparator;
//import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Freq {

	public static void main(String[] args) {
		String a = "Hello, World!";
//		System.out.println(findFrequency(a));
		System.out.println(compress(a));

	}
	
	public static HashMap<Character, Integer> findFrequency(String str){
		HashMap<Character,Integer> frequencyMap = new HashMap<>();
		str = str.toLowerCase();
		char[] chars = str.toCharArray();
		for(int i = 0;i<chars.length;i++) {
			if(chars[i]<65)
				continue;
			if(!frequencyMap.containsKey(chars[i]))
				frequencyMap.put(chars[i], 0);
			frequencyMap.put(chars[i], frequencyMap.get(chars[i])+1);	
		}
		return frequencyMap;
	}
	
	public static String compress(String str) {
		//call the method find freqs
		//create a priorityqueue based on freqs
		//select 2 elements that have least freq
		// create a new node using these 2 elements
		//cuntinue until only 1 node left in the priority
		
		HashMap<Character, Integer> map = findFrequency(str);
		PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(Comparator.comparingInt(n->n.getFrequency()));
		for (Entry<Character,Integer> n : map.entrySet()) {
			queue.add(new HuffmanNode(n.getKey(),n.getValue()));
		}
		while(queue.size() != 1) {
			HuffmanNode left = queue.poll();
			HuffmanNode right = queue.poll();
			HuffmanNode newNode = new HuffmanNode('\0', left.getFrequency()+right.getFrequency()); //value is null
			newNode.setLeft(left);
			newNode.setRight(right);
			queue.add(newNode);	
		}
		HuffmanNode root = queue.poll();
		
	
		Map<HuffmanNode,String> encodedMap = new HashMap<HuffmanNode,String>();
		//create encoded string
		encodedMap = encode(root,encodedMap);
		String a = "";
		for(Entry<HuffmanNode,String> entry : encodedMap.entrySet()) {
			if(entry.getKey().getValue()!='\0')
				a+= entry.getKey().getValue() + " " + entry.getValue() + "\n";
		}
		return a;
	}
	
	public static HashMap<HuffmanNode,String> encode(HuffmanNode curr,Map<HuffmanNode,String> map) {		
		if((curr.getLeft() == null) && (curr.getRight() == null)) {
			return (HashMap<HuffmanNode, String>) map;
		}
//		if(!map.containsKey(curr) && curr.getValue()==0) {
//			map.put(curr, "0");
//			return (HashMap<HuffmanNode, String>) map;
//		}
		if(!map.containsKey(curr))
				map.put(curr, "");
		
		map.put(curr.getLeft(), map.get(curr)+0);
		map.put(curr.getRight(), map.get(curr)+1);
		encode(curr.getLeft(),map);
		encode(curr.getRight(),map);
		return (HashMap<HuffmanNode, String>) map;
	}
}

class HuffmanNode implements Comparable{
	char value;
	int frequency;
	HuffmanNode left, right;
	
	HuffmanNode(char value, int frequency){
		this.value = value;
		this.frequency = frequency;
	}
	
	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public HuffmanNode getLeft() {
		return left;
	}

	public void setLeft(HuffmanNode left) {
		this.left = left;
	}

	public HuffmanNode getRight() {
		return right;
	}

	public void setRight(HuffmanNode right) {
		this.right = right;
	}

	public int compareTo(HuffmanNode o) {
		return this.getFrequency() - o.getFrequency();
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
