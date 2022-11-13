package day05;

import java.util.Arrays;
import java.util.Scanner;

public class Day05Ex01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int a [] = new int[N];
		
		for (int i =0; i < N; i++) {
			a[i] = scan.nextInt();
		}
		// (1) 버블 정렬을 구현하는 영역
		for(int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-1-i; j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for (int i =0; i <N; i++) {
			System.out.println(a[i]);
		}
		
		// 2) 정렬 함수사용하기
//		Arrays.sort(a);
//		for(int val : a) {
//			System.out.println(val);
//		}
	}
}
