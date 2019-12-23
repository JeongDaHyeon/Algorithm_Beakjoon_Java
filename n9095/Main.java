package n9095;

import java.util.Scanner;

public class Main {
	
	public static int solution(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			if(i + 1 <= n) dp[i+1] += dp[i];
			if(i + 2 <= n) dp[i+2] += dp[i];
			if(i + 3 <= n) dp[i+3] += dp[i];
		}		
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 0; i < t; i++) {
			System.out.println(solution(scan.nextInt()));
		}

	}
}