package day09;

import java.util.Arrays;
import java.util.Scanner;

public class Day09Ex01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int [] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		
		Arrays.sort(A);
		int M = scan.nextInt();
		for (int i = 0; i < M; i++) {
			boolean find = false; // 처음에는 못찾은 상태에서 시작
			int target = scan.nextInt();
			int start = 0;
			int end = A.length - 1;
			while(start <= end) {
				int midIndex = (start + end) / 2;
				int midValue = A[midIndex];
				if(midValue >target) {
					end = midIndex - 1;
				} else if (midValue < target) {
					start = midIndex + 1;
				} else {
					find = true;
					break; // 탐색 종료
				}
			}
			
			if(find) System.out.println(1);
			else System.out.println(0);
			
		}

	}
}
