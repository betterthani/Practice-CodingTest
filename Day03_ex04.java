package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Day03_ex04 {
	static int []myArr;
	static int []checkArr;
	static int checkSecret;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()); // dna 문자열 길이
		int p = Integer.parseInt(st.nextToken()); // 부분 문자열 길이(묶음)
		int result = 0;
		checkArr = new int[4]; // 필수 문자열 포함 조건 (a,c,g,t최소 개수)
		myArr = new int[4]; // 내가 카운트하는 부분 문자열 최소 개수
		char a[] = new char[s]; // dna 문자열
		checkSecret = 0; // 최종 우리가 구하고자 하는 카운트
		
		a = br.readLine().toCharArray(); // 전체 배열 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0) {
				checkSecret++; // 만족할 문자열의 수가 0일 경우 조건에 적합하므로 ++
			}
		}
		
		for (int i = 0; i < p; i++) { // 부분문자열 처음 받을 때 세팅
			Add(a[i]);  // dna문자열의 부분 문자열 길이만큼 myArr에 넣기
		}
		
		if(checkSecret == 4) {
			result++;
		}
		
		// 슬라이딩윈도우
		for (int i = p; i < s; i++) { // 슬라이딩이 옆칸으로 한 칸 이동한 상태부터 돌리기
			int j = i-p; // 슬라이드 범위 유지하면서 ++될때마다 옆칸으로 이동하기
			Add(a[i]);
			Remove(a[j]);
			if(checkSecret == 4) {
				result++;
			}
		}
		System.out.println(result);
		br.close();
		
		
	}
	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if(myArr[0] == checkArr[0]) {
				checkSecret--;
			}
			myArr[0]--;
			break;
			
		case 'C':
			if(myArr[1] == checkArr[1]) {
				checkSecret--;
			}
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2] == checkArr[2]) {
				checkSecret--;
			}
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) {
				checkSecret--;
			}
			myArr[3]--;
			break;
		}
		
	}
	private static void Add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0]) {
				checkSecret++;
			}
			break;
			
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1]) {
				checkSecret++;
			}
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2] == checkArr[2]) {
				checkSecret++;
			}
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3]) {
				checkSecret++;
			}
			break;
		}
	}
}
