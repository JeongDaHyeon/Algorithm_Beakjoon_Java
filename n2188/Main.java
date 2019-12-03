package n2188;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); // 소의 수
		int M = scan.nextInt(); // 축사의 수
		int[][] c = new int[N+M+2][N+M+2]; // 흐를 수 있는 양
		int[][] f = new int[N+M+2][N+M+2]; // 지금 흐르는 양
		
		int end = N + M + 1; // 마지막 index
		
		// 0은 src end 는 dest
		// 1~N은 소, N+1~ M+N은 축사
		for(int i = 1; i <= N; i++) {
			int t = scan.nextInt();
			for(int j = 0; j < t; j++) {
				c[i][scan.nextInt() + N] = 1; // 소로부터 축사로 가는 길. 
			}
		}
		
		for(int i = 1; i <= N; i++) {
			c[0][i] = 1; // src로 부터 소로 가는 길
		}
		
		// 축사로 부터 end까지 가는 길.
		for(int i = N+1; i < end; i++) {
			c[i][end] = 1;
		}
		

		int total = 0; // 총 흐르는 유량
		while(true) {
			// prev[index] -> index 로 흐름이 진행
			// prev에는 index의 바로 직전에 방문한 노드 저장
			int[] prev = new int[end+1];
			Arrays.fill(prev, -1);
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(0); // 0에서 부터 시작
			
			// queue가 비어있지 않은 동안.
			while(!queue.isEmpty()) {
				int curr = queue.poll(); // curr: 현재 위치
				if(curr == end) break; // 마지막이면 dfs를 멈춘다
				for(int i = 0; i <= end; i++) {
					if(prev[i] != -1) continue; // 이미 방문을 했을 때.
					if(c[curr][i] <= f[curr][i]) continue; // 물이 흐를 수 없을 때
					prev[i] = curr; // i번째 노드의 이전 노드로 curr을 추가
					queue.add(i); // 큐에 다음 노드로 추가
				}
			}
			
			if(prev[end] == -1) break;
			// 물을 흘려 보냄
			for(int i = end; i != 0; i = prev[i]) {
				f[prev[i]][i] += 1;
				f[i][prev[i]] -= 1;
			}
			total++;
		}
		
		System.out.println(total);
	}

}
