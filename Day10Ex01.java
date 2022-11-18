package day10;

import java.util.Scanner;

public class Day10Ex01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		int A[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		
		int count = 0;
		for(int i = A.length-1; i >= 0; i--) {
			if(A[i] < K) {
				count += K / A[i];
				K = K % A[i];
			}
		}
		System.out.println(count);
	}

}
