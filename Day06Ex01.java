package day06;

import java.util.Scanner;

public class Day06Ex01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int A[] = new int[N];
		int S[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		
		for (int i = 1; i < N; i++) {
			int insertPiont = i; // 인덱스 값
			int insertValue = A[i]; // 해당하는 값
			
			for(int j = i - 1; j >= 0; j--) {
				if(A[i] > A[j]) { // j로 도는 데이터가 가르키는 i보다 작으면
					insertPiont = j + 1; // j번째 뒤에있는 곳에 삽입
					break;
				}
				
				if(j == 0) { // 끝까지 탐색했다. i번째에 있는애가 제일 작다.
					insertPiont = 0;
				}
			}
			
			for(int j = i; j > insertPiont; j--) { // shift 연산 (기존 데이터들 한칸씩 옆으로 옮기기)
				A[j] = A[j - 1];
			}
			
			A[insertPiont] = insertValue; // temp값이랑 마찬가지 
			
		}
		
		S[0] = A[0];
		for (int i = 1; i < N; i++) {
			S[i] = S[i-1] + A[i];
		}
		
		int sum = 0; 
		for (int i = 0; i <N; i++) {
			sum += S[i];
		}
		
		System.out.println(sum);
	}

}
