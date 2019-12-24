package n2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int bfs(int N, int M, int[][] maze) {
		Queue<Integer> nr = new LinkedList<Integer>();
		Queue<Integer> nc = new LinkedList<Integer>();
		
		nr.add(1);
		nc.add(1);
		
		int[][] result = new int[N+2][M+2];
		boolean[][] visited = new boolean[N+2][M+2];
		for(int i = 0; i <= N+1; i++) {
			for(int j = 0; j <= M+1; j++) {
				result[i][j] = Integer.MAX_VALUE;
			}
		}
		
		result[1][1] = 1;
		
		while(!nr.isEmpty()) {
			int r = nr.poll();
			int c = nc.poll();
			
			for(int i = 0; i < 4; i++) {
				if(maze[r+dr[i]][c+dc[i]] == 1 && result[r][c] + 1 < result[r+dr[i]][c+dc[i]]) {
					result[r+dr[i]][c+dc[i]] = result[r][c] + 1;
					
					if(visited[r+dr[i]][c+dc[i]] == false) {
						nr.add(r+dr[i]);
						nc.add(c+dc[i]);
						visited[r+dr[i]][c+dc[i]] = true;
					}
				}
			}
		}
		
		return result[N][M];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		
		int[][] maze = new int[N+2][M+2];
		
		for(int i = 1; i <= N; i++) {
			String line = in.readLine();
			
			for(int j = 0; j < M; j++) {
				maze[i][j + 1] = line.charAt(j) - '0';
 			}
		}
		
		
		System.out.println(bfs(N, M, maze));
		
		
	}
	
}
