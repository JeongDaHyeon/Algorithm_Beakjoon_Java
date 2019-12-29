package n11052;
// 카드 구매하기

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] card = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			dp[i] = card[i] = scan.nextInt();
		}
		
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(dp[i] < card[j] + dp[i-j-1]) dp[i] = card[j] + dp[i-j-1];
			}
		}
		
		System.out.println(dp[N-1]);

	}

}
