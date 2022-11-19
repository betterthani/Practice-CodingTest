package day11;

import java.util.Scanner;

public class Day11Ex02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long min = scan.nextLong();
		long max = scan.nextLong();
		long [] A = new long [10000001];
		for (int i = 2; i < A.length; i++) {
			A[i] = i;
		}
		
		for (int i = 2; i <= Math.sqrt(max); i++) {
			if (A[i] == 0) {
				continue;
			}
			for (int j = i+i; j < A.length; j += i) {
				A[j] = 0;
			}
		}
		
		int count = 0;
		for (int i = 2; i < A.length; i++) {
			if(A[i] != 0) {
				long temp = A[i];
				while((double)A[i] <= (double)max / temp) {
					if((double)A[i] >= (double)min / temp) {
						count++;
					}
					temp *= A[i];
				}
			}
		}
		System.out.println(count);
	}

}
