package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Day04Ex02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a[] = new int[N]; // 수열 배열
		int ans[] = new int[N]; // 결과 배열
		String str[] = br.readLine().split(" "); // 입력 받은 값 spilt으로 쪼개기
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(str[i]); // a배열에 인덱스별로 값 넣기 
		}
		Stack<Integer> stack = new Stack<>(); // 스택 선언
		stack.push(0); // 처음엔 항상 스택 비어있음. 초기화
		
		for (int i = 0; i < N; i++) {
			while (!stack.empty() && a[stack.peek()] < a[i]) { // 스택이 비어있지 않고, top에 해당되는 수열보다 현재 수열의 값이 클때까지
				ans[stack.pop()] = a[i]; // 정답배열에 오큰수를 현재 배열로 저장하기
			}
			stack.push(i); // 신규 데이터 push
		}
		while(!stack.empty()) { // 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌때까지
			ans[stack.pop()] = -1;
			// 정답배열 스택에 쌓인 index에 -1을 넣고
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i =0; i < N; i++) {
			bw.write(ans[i] + " "); // 출력
		}
		bw.write("\n");
		bw.flush();

	}

}
