package n1932;
// 정수 삼각형

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int[][] triangle = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				triangle[i][j] = scan.nextInt();
			}
		}
		
		for(int i = n - 2; 0 <= i; i--) {
			for(int j = i; 0 <= j; j--) {
				triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
			}
		}
		System.out.println(triangle[0][0]);

	}

}
