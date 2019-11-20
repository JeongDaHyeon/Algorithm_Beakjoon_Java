package n11053;
//가장 긴 증가하는 부분수열

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	static int solution(int[] inputs) {
		int answer;
		int[] dp = 	new int[inputs.length];
		
		Arrays.fill(dp, 1);
		answer = dp[0] = 1;
		
		for(int i = 1; i < inputs.length; i++) {
			for(int j = i - 1; 0 <= j; j--) {
				if(inputs[j] < inputs[i] &&  dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					answer = answer < dp[i]? dp[i] : answer;
				}
			}
		}
		
		
		return answer;
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] inputs = new int[N];
		
		for(int i = 0; i < N; i++) {
			inputs[i] = scan.nextInt();
		}

		System.out.println(solution(inputs));
	}

}
