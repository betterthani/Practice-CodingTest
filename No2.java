package day01;

import java.util.Scanner;

public class No2 {

	public static void main(String[] args) {
		//TODO 배열에서 주어진 범위의 합을 구하는 프로그램을 구하시오
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		long A[] = new long[100001];
		long S[] = new long[100001];
		for (int i = 1; i < 100000; i++) {
			A[i] = (long) (Math.random() * Integer.MAX_VALUE);
			S[i] = S[i - 1] + A[i];
		}
		
		for (int t = 1; t < testcase; t++) {
			int answer = 0;
			long query = sc.nextInt();
			for (int i = 0; i < query; i++) {
				long start = sc.nextInt();
				long end = sc.nextInt();
				answer += S[(int) end] - S[(int) (start - 1)];
				System.out.println(t + " " + answer);
			}
		}
				
	}

}
