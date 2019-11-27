package n1919;
// 애너그램 만들기

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] alpha = new int[26];
		String s1 = scan.nextLine();
		String s2 = scan.nextLine();
		
		for(int i = 0; i < s1.length(); i++) {
			alpha[s1.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			alpha[s2.charAt(i) - 'a']--;
		}
		
		int result = 0;
		for(int i = 0; i < alpha.length; i++)
		{
			result += Math.abs(alpha[i]);
		}
		System.out.println(result);
	}

}
