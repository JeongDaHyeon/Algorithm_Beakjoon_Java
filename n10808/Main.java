package n10808;
// ¾ËÆÄºª °³¼ö

import java.util.Scanner;

public class Main {
	static void numberOfAlpha(String str)
	{
		int[] alpha = new int[26];
		for(int i = 0; i < str.length(); i++)
		{
			alpha[((char)str.charAt(i)) - 'a']++;
		}
		
		for(int i = 0; i < 26; i++)
		{
			System.out.print(alpha[i] + " ");
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String str;
		numberOfAlpha(str = scan.nextLine());
	}
}
