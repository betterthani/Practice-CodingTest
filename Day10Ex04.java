package day10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day10Ex04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][]A = new int[N][2];
		for (int i = 0; i < N; i++) {
			A[i][0] = scan.nextInt(); // 시작하는 시간
			A[i][1] = scan.nextInt(); // 끝나는 시간
		}
		Arrays.sort(A,new Comparator<int[]>() {

			@Override
			public int compare(int[] s, int[] e) {
				// 종료시간이 같을 경우 시작 시간이 빠른순으로 정렬해야한다.
				if(s[1] == e[1]) { // 종료 시간이 같을 때
					return s[0] - e[0]; // 시작하는 시간으로 정렬
				}
				return s[1] - e[1]; // 아니라면 끝나는 시간으로 정렬
			}
		});
		
		int count = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시간 시작보다 작거나 같다면 갱신
			if (A[i][0] >= end) { // 직전 종료시간이 다음 회의 시작시간보다 작거나 같다면 갱신
				end = A[i][1]; // 종료시간 업데이트하기
				count++;
			}
		}
		System.out.println(count);
	}

}
