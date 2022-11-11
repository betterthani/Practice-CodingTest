package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day02_ex03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int suNo = Integer.parseInt(st.nextToken()); // .nextToken() = String 으로 형변환 해줘야함
		int quizNo = Integer.parseInt(st.nextToken());
		long[] S = new long[suNo + 1]; // 0번째 인덱스 무시하고 1번째 인덱스부터 시작
		
		st = new StringTokenizer(br.readLine()); // 한줄로 값 쭉 받아오기
		for (int i = 1; i <= suNo; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int q = 0; q < quizNo; q++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(S[j] - S[i-1]);
		}
		
	}

}
