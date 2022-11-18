package day09;

import java.util.Scanner;

import javax.sound.midi.InvalidMidiDataException;

public class Day09Ex02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int [] A = new int [N];
		int start = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			A[i] =scan.nextInt();
			if(start < A[i]) {
				start = A[i]; // 레슨 최댓값을 시작 인덱스로 저장
			}
			end = end + A[i]; // 모든 레슨의 총합을 종료 인덱스로 저장하기
		}
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if(sum + A[i] > mid) {
					count++;
					sum = 0;
				}
				sum += A[i];
			}
			if (sum != 0) { // 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요하므로 더함
				count++;
			}
			if(count > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(start);
	}

}
