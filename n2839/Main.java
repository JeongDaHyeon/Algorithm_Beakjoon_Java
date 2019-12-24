package n2839;
// 설탕 배달

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int solution(int N) {
		
		int[] dp = new int[N+1]; // last index is N
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i = 0; i < N; i++) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			
			if(i+3 <= N && dp[i] + 1 < dp[i + 3]) {
				dp[i+3] = dp[i] + 1;
			}
			
			if(i+5 <= N && dp[i] + 1 < dp[i + 5]) {
				dp[i+5] = dp[i] + 1;
			}
		}
		
		if(dp[N] == Integer.MAX_VALUE) return -1;
		
		return dp[N];
		
		 
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		
		System.out.println(solution(N));
	}

}
