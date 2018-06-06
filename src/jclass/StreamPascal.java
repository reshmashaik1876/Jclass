package jclass;

import java.util.Arrays;
import java.util.Scanner;

public class StreamPascal {
	public static int[] nthPascal(int row) {
		
		do {
		if(row == 0) {
			int[] result = {1};
			return result;
		}
		if(row == 1) {
			int[] result = {1, 1};
			return result;
		}
		int[] previous = {1, 1};
		for(int i = 2; i <= row; i++) {
			int[] next = new int[i+1];
			next[0] = 1;
			for(int j = 1; j < i; j++) {
				
				next[j] = previous[j-1] + previous[j];
				
			}
			next[i] = 1;
			previous = next;
		}
		
		
		
		row = row-1;
		return previous;
		
		}while(row!=0);
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows to print");
		int number = sc.nextInt();
		Arrays.stream(nthPascal(number)).forEach(e->System.out.print(e+" "));
	}
}
