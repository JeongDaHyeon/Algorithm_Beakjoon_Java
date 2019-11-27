package n12852;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[] dp = new int[N+1];
		int[] trace = new int[N+1];
		
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[1] = 0;
		trace[1] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			trace[i] = i-1;
			
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
				if(dp[i] == dp[i / 2] + 1) {
					trace[i] = i / 2;
				}
			}
			
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
				if(dp[i] == dp[i / 3] + 1) {
					trace[i] = i / 3;
				}
			}
		}
		
		System.out.println(dp[N]);
		
		for(int i = N; i != 1; i = trace[i]) {
			System.out.print(i + " ");
		}
		System.out.println(1);
	}

}
