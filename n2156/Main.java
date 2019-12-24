package n2156;

import java.util.Scanner;

public class Main {
	
	static int solution(int[] wines) {
		
		if(wines.length == 2) {
			return wines[1];
		} else if(wines.length == 3) {
			return wines[1] + wines[2];
		}
		
		int[] dp = new int[wines.length];
		
		dp[1] = wines[1];
		dp[2] = wines[1] + wines[2];
		
		for(int i = 3; i < wines.length; i++) {
			dp[i] = Integer.max(wines[i] + wines[i-1] + dp[i-3], wines[i] + dp[i-2]);
			dp[i] = Integer.max(dp[i], dp[i-1]);
		}
		
		
		return dp[wines.length - 1];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int[] wines = new int[n+1];
		for(int i = 1; i <= n; i++) {
			wines[i] = scan.nextInt();
		}
		
		System.out.println(solution(wines));
	}

}
