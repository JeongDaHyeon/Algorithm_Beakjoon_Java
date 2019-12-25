package n6086;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int CtoI(char c) {
		if(c <= 'Z') return c - 'A';
		return c - 'a' + 26;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int c[][] = new int[52][52];
		
		int f[][] = new int[52][52];
				
		int N = Integer.parseInt(in.readLine());
		
		
		for(int i = 0; i < N; i++) {
			String[] inputs = in.readLine().split(" ");
			int u = CtoI(inputs[0].charAt(0));
			int v = CtoI(inputs[1].charAt(0));
			c[u][v] += Integer.parseInt(inputs[2]);
			c[v][u] += Integer.parseInt(inputs[2]);
		}
		
		int total = 0, START = CtoI('A'), END = CtoI('Z');
		
		// 여기를 해석.
		while(true) {
			
			int prev[] = new int[52]; // 경로를 표시 하는 것
			Arrays.fill(prev, -1); // 배열을 -1로 채운다.
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(START);
			
			while(!queue.isEmpty()) {
				int current = queue.poll();
				if(current == 25) break; // 현재 Z에 가 있으면 break
				for(int i = 1; i < 52; i++) {
					int next = i;
					if(prev[next] > -1) continue;
					if(c[current][next] == f[current][next]) continue; // 용량이 꽉 찼다면 무시.	
					prev[next] = current; // 이전 노드를 저장.
					queue.add(next);
				}
			}
			
			if(prev[END] == -1) break;
			
			int min = Integer.MAX_VALUE;
			
			for(int i = END; i != START; i = prev[i]) min = Math.min(min, c[prev[i]][i] - f[prev[i]][i]);
			for(int i = END; i != START; i = prev[i]) f[prev[i]][i] += min;
			for(int i = END; i != START; i = prev[i]) f[i][prev[i]] -= min;
			
			total += min;	
		}
		
		System.out.println(total);
	}

}
