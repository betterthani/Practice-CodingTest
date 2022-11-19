package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day11Ex05 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long result = n;
		for (long p = 2; p <= Math.sqrt(n); p++) { // 제곱근까지만 진행
			if(n % p == 0) { // p가 소인수인지 확인
				result = result - result / p;
				while(n % p == 0) { // 2^7 * 11 이라면 2^7 없애고 11만 남김
					n = n / p;
				}
			}
		}
		if(n > 1) { // 아직 소인수 구성이 남아 있을때
			result = result - result / n;
		}
		System.out.println(result);
	}

}
