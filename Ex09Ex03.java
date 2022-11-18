package day09;

import java.util.Scanner;

public class Ex09Ex03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		long start = 1;
		long end = K;
		long ans = 0;
		
		while(start <= end) {
			long middle = (start + end) / 2;
			long count = 0;
			
			for (int i = 1; i <= N; i++) {
				count += Math.min(middle / i, N);
			}
			if (count < K) {
				start = middle + 1;
			} else {
				ans = middle;
				end = middle - 1;
			}
		}
		System.out.println(ans);
	}
}
