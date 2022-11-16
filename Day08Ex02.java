package day08;

import java.util.Scanner;

public class Day08Ex02 {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}

	private static void DFS(int number, int jarisu) {
		if(jarisu == N) { // 자리수가 N의 자리수일때 출력
			if(isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		
		for (int i =1; i< 10; i++) { // 1 ~ 9까지 숫자 탐색 (이 중 짝수는 2의 약수이므로 pass)
			if(i % 2 == 0) { // 짝수일때 스킵(더이상 탐색 안 해도됨)
				continue;
			}
			if(isPrime(number * 10 + i)) { // 소수라면 재귀함수로 자릿수 늘림
				DFS(number * 10 + i, jarisu + 1);
			}
		}
	}

	private static boolean isPrime(int num) { // 소수 판별
		for (int i = 2; i <= num / 2; i++) { // 반만 나눠봐도 알 수 있다 소수는
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
