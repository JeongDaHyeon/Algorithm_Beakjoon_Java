package n2579;

import java.util.Scanner;

public class Main {
	
	public static int solution(int[] scores) {
		int[] dp = new int[scores.length];
		
		dp[1] = scores[1];
		dp[2] = scores[1] + scores[2];
		
		for(int i = 3; i < scores.length; i++) {
			dp[i] = Integer.max(scores[i] + dp[i-2], scores[i] + scores[i-1] + dp[i-3]);
		}
		
		return dp[scores.length - 1];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int[] scores = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			scores[i] = scan.nextInt();
		}
		
		System.out.println(solution(scores));
	}

}
