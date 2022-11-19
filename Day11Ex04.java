package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day11Ex04 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		// 최댓값과 최솟값의 차이만큼 배열 선언하기 (제곱수 판별 배열)
		boolean [] check = new boolean[(int)(max- min + 1)];
		// 2의 제곱수인 4부터 max보다 작거나 같은 값까지 반복하기
		for (int i = 2; i + i <= max; i++) { // i <= Math.sqrt(max); = i + i <= max
			long pow = i * i; // 제곱수
			long startIndex = min / pow; 
			if(min % pow != 0) {
				startIndex++; // 나머지가 있으면 1을 더해야 min보다 더 큰 제곱수에서 시작됨
			}
			
			for(long j = startIndex; pow * j <= max; j++) {
				//제곱수를 true로 변경하기
				check[(int)((j * pow) - min)] = true;
			}
		}
		
		int count = 0;
		for (int i = 0; i <= max - min; i++) {
			if(!check[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

}
