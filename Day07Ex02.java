package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day07Ex02 {

	private static int[] A;
	private static int[] temp;
	private static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		A = new int[N+1];
		temp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		result = 0; // result 초기화
		merget(1, N);
		System.out.println(result);
		
	}
	
	public static void merget(int s, int e) {
		if(e - s < 1) {
			return;
		}
		
		int m = s + (e - s) / 2;
		merget(s, m);
		merget(m+1, e);
		
		for(int i = s; i <= e; i++) {
			temp[i] = A[i];
		}
		
		int k = s;
		int i = s;
		int j = m+1;
		
		while(i <= m && j <= e) {
			
			if (temp[i] < temp[j]) {
				A[k] = temp[i];
				i++;
				k++;
				
			} else {
				A[k] = temp[j];
				result += j - k; // 뒤쪽 데이터 값이 작은 경우 result 업데이트 (앞에 데이터 교체는 상관없다)
				j++;
				k++;
			}
		}
		
		while(i <= m) { // i배열이 남아있을 경우 나머지 i배열 넣어주기
			A[k] = temp[i];
			k++;
			i++;
		}
		
		while(j <= e) {
			A[k] = temp[j];
			k++;
			j++;
		}
		
		
	}

}
