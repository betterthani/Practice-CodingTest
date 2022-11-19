package day11;

import java.util.Scanner;

public class Day11Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] A = new int[1000001];
		
		for (int i = 2; i < A.length; i++) {
			A[i] = i;
		}
		
		for (int i = 2; i < Math.sqrt(A.length); i++) {
			if(A[i] == 0) {
				continue;
			}
			for (int j = i+i; j < A.length; j+=i) {
				A[j] = 0;
			}
		}
		// 소수 구함.
		
		int i = n;
		while(true) {
			if(A[i] != 0) {// i++후 값비교
				int result = A[i];
				if(isPalinderome(result)) { // (1)false 일경우
					System.out.println(result);
					break;
				}
			}
			i++; // (1)일경우 실행
		}
		
		
	}

	private static boolean isPalinderome(int target) {
		char temp[] = String.valueOf(target).toCharArray();
		int s = 0;
		int e = temp.length-1;
		while(s < e) { // 포인터가 같지 않을경우 return true;실행
			if(temp[s] != temp[e]) {
				return false;
			}
			// s,e포인터 두 값이 같을 경우 두 포인터 이동
			s++;
			e--;
		}
		return true;
	}

}
