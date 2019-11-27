package n1912;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[] inputs = new int[n];
		
		for(int i = 0; i < n; i++) {
			inputs[i] = scan.nextInt();
		}
		
		int[] dp = new int[n];
		
		for(int i = 1; i < n; i++) {
			if(inputs[i-1] + inputs[i] > inputs[i]) {
				inputs[i] = inputs[i-1] + inputs[i];
			}
		}
		
		Arrays.sort(inputs);
		System.out.println(inputs[n-1]);
	}

}
