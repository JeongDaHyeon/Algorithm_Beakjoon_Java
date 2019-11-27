package n9251;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int solution(int[][]dp, String s1, String s2) {
		for(int i = 1; i <= s1.length(); i++) {
			char c1 = s1.charAt(i-1);
			for(int j = 1; j <= s2.length(); j++) {
				char c2 = s2.charAt(j-1);
				if(c1 == c2) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[s1.length()][s2.length()];
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = in.readLine();
		String s2 = in.readLine();
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		System.out.println(solution(dp, s1, s2));
	}

}
