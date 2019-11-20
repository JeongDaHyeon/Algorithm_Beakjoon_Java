package n1671;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] inputs = new int[N][3]; // 입력받은 값을 저장
		int source = 2 * N;
		int sink = 2 * N + 1;
		int[][] c = new int[2 * N + 2][2 * N + 2]; // 2 * N행은 source 2 * N+1 행은 sink
		int[][] f = new int[2 * N + 2][2 * N + 2];

		for (int i = 0; i < N; i++) {
			inputs[i][0] = scan.nextInt();
			inputs[i][1] = scan.nextInt();
			inputs[i][2] = scan.nextInt();
		}

		// c에 값을 저장.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if((inputs[j][0] == inputs[i][0]) && (inputs[j][1] == inputs[i][1]) && (inputs[j][2] == inputs[i][2])) {
					if(c[2 * j][2 * i + 1] == 1 || c[2 * i][2 * j + 1] == 1) {
						continue;
					}
				}
				if ((inputs[j][0] <= inputs[i][0]) && (inputs[j][1] <= inputs[i][1])
						&& (inputs[j][2] <= inputs[i][2])) {
					c[2 * i][2 * j + 1] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			c[source][2 * i] = 2;
			c[2 * i + 1][sink] = 1;
		}

		int eaten = 0;

		while (true) {
			int[] prev = new int[2 * N + 2];
			Arrays.fill(prev, -1);
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(source);

			while (!queue.isEmpty()) {
				int current = queue.poll();
				if (current == sink)
					break;
				for (int i = 0; i < 2 * N + 2; i++) {
					if (prev[i] != -1)
						continue;
					if (c[current][i] == f[current][i])
						continue;
					prev[i] = current;
					queue.add(i);
				}
			}

			if (prev[sink] == -1)
				break;
			
			int minflow = Integer.MAX_VALUE;
			for (int i = sink; i != source; i = prev[i])
				minflow = Math.min(minflow, c[prev[i]][i] - f[prev[i]][i]);
			for (int i = sink; i != source; i = prev[i])
				f[prev[i]][i] += minflow;
			for (int i = sink; i != source; i = prev[i])
				f[i][prev[i]] -= minflow;
			
			eaten += minflow;
		}

		System.out.println(N - eaten);
		
	}
}
