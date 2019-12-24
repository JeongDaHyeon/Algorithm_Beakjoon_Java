package n10844;

import java.util.Scanner;

public class Main {
	
	static int solution(int n) {
		int[][] dp = new int[n][10];
		
		for(int i = 1; i <= 9; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][1] % 1000000000;
				} else if(j == 9) {
					dp[i][j] = dp[i-1][8] % 1000000000;
				} else {
					dp[i][j] = (dp[i-1][j-1] % 1000000000 + dp[i-1][j+1] % 1000000000) % 1000000000;
				}
			}
			
		}
		
		int answer = 0;
		
		for(int i = 0; i <= 9; i++) {
			answer += dp[n-1][i];
			answer %= 1000000000;
		}
		
		
		return answer;
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		System.out.println(solution(n));
		
	}

}
