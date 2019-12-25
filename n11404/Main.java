package n11404;
// 플로이드


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[][] dist = new int[n+1][n+1];
		int[][] p = new int[n+1][n+1];
		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) continue;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i < m; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			int d = scan.nextInt();
			if(d < dist[s][e]) dist[s][e] = d;
		}
		
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
						p[i][j] = dist[i][j];
					} else if(dist[i][j] != Integer.MAX_VALUE) {
						p[i][j] = dist[i][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}

	}

}
