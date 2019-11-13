package n2252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		int[] cntOfPrev = new int[N+1];

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			graph.get(v1).add(v2);
			cntOfPrev[v2]++;
		}
		
		topologicalSort(graph, cntOfPrev);
	}

	static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] cntOfPrev) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(cntOfPrev[i] == 0) {
				queue.add(i);
			}
		}
		
		do {
			int tmp = queue.poll();
			System.out.print(tmp + " ");
			for(int i = 0; i < graph.get(tmp).size(); i++) {
				cntOfPrev[graph.get(tmp).get(i)]--;
				if(cntOfPrev[graph.get(tmp).get(i)] == 0) {
					queue.add(graph.get(tmp).get(i));
				}
			}
		} while(queue.size() != 0);
		
		
	}
	
}
