package n11727;
// 2xn 타일링 2

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
		}
		
		
		/*
		for(int i = 0; i < n; i++) {
			if(i + 1 <= n) {
				dp[i+1] += dp[i];
				dp[i + 1] %= 10007;
			}
			if(i + 2 <= n) {
				dp[i+2] += ((2 * dp[i])%10007);
				dp[i+1] %= 10007;
			}
		}
		*/
		
				
		System.out.println(dp[n]);

	}

}
