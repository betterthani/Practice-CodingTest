package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day11Ex01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int [] A = new int[N+1];
		for (int i = 1; i <= N; i++) {
			A[i] = i;
		}
		
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (A[i] == 0) {
				continue;
			}
			for (int j = i+i; j <= N; j+=i) { // 배수지우기
					A[j] = 0;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if(A[i] != 0) {
				System.out.println(A[i]);
			}
		}
		
	}

}
