package n7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Integer> r1 = new LinkedList<Integer>();
	static Queue<Integer> c1 = new LinkedList<Integer>();
	static Queue<Integer> r2 = new LinkedList<Integer>();
	static Queue<Integer> c2 = new LinkedList<Integer>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int columns;
	static int rows;

	
	static int solution(int[][] tomatoes) {
		int days = 0;
		boolean rm = false;
		
		while (!r1.isEmpty() || !r2.isEmpty()) {
			if (!r1.isEmpty()) {
				while (!r1.isEmpty()) {
					int rr = r1.poll();
					int cc = c1.poll();
					for (int i = 0; i < 4; i++) {
						int nr = rr + dr[i]; // next row
						int nc = cc + dc[i]; // next column
						if (nr < 0 || nr >= rows || nc < 0 || nc >= columns) continue;
						
						if (tomatoes[nr][nc] == 0) {
							r2.add(nr);
							c2.add(nc);
							tomatoes[nr][nc] = 1;
							rm = true;
						}
					}
				}
			} else {
				while (!r2.isEmpty()) {
					int rr = r2.poll();
					int cc = c2.poll();
					for (int i = 0; i < 4; i++) {
						int nr = rr + dr[i]; // next row
						int nc = cc + dc[i]; // next column
						if (nr < 0 || nr >= rows || nc < 0 || nc >= columns)
							continue;
						if (tomatoes[nr][nc] == 0) {
							r1.add(nr);
							c1.add(nc);
							tomatoes[nr][nc] = 1;
							rm = true;
						}
					}
				}
			}
			if(rm == true)
			{
				days++;
				rm = false;
			}

		}
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				if(tomatoes[i][j] == 0) return -1;
			}
		}
		return days;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		columns = scan.nextInt();
		rows = scan.nextInt();
		int[][] tomatoes = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				tomatoes[i][j] = scan.nextInt();
				if (tomatoes[i][j] == 1) {
					r1.add(i);
					c1.add(j);
				}
			}
		}
		System.out.println(solution(tomatoes));
	}

}
