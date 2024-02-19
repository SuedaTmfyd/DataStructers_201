package PriorityQueue_8;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PQ {

	public static void main(String[] args) {
		

	}

}

class Solution{
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> taskNum =  new HashMap<Character, Integer>();
		long time0 = System.currentTimeMillis();
		for(int i = 0; i<tasks.length;i++) {
			taskNum.put(tasks[i], taskNum.getOrDefault(tasks[i],0)+1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.addAll(taskNum.values());
		Queue<KeyPair> helper = new PriorityQueue<>();
		int time = 0;
		while(!pq.isEmpty() || !helper.isEmpty()) {
			time++;
			
		}
		
		return 0;
	}
	
}
