package day08;

import java.util.ArrayList;
import java.util.Scanner;

public class Day08Ex03 {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	static boolean arrive;
	
	public static void main(String[] args) {
		int N;
		int M;
		arrive = false;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		A = new ArrayList[N]; // 0 ~ 7 리스트 1개 생성
		
		visited = new boolean[N]; // 방문배열 T,F 구분 배열
		
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>(); // 0 ~ 7 만큼 각 노드별 배열 생성
		}
		
		for (int i = 0; i < M; i++) { // 엣지 정보 받아들여지는 만큼 돌기 
			int S = scan.nextInt();
			int E = scan.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		
		for (int i = 0; i < N; i++) {
			DFS(i, 1); // 각 노드마다 DFS실행, depth 1부터 시작 (재귀 함수 호출때마다 깊이를 더해야하고, A~E까지 5깊이의 탐색이 필요
			if(arrive) { // depth가 5에 도달한 적이 있다면
				break;
			}
		}
		if (arrive) {
			System.out.println("1");
		}else { // 5의 깊이가 없다면 0 출력
			System.out.println("0");
		}
	}

	private static void DFS(int now, int depth) {
		if(depth == 5 || arrive) { // 깊이 5이거나 방문했던 노드가 있다면
			arrive = true;
			return;
		}
		// 방문할 노드가 되었다면 
		visited[now] = true; // 방문 배열에 현재 노드 방문 기록 (t로 도장 찍기)
		for (int i : A[now]) {
			if(!visited[i]) { // 방문한적이 없는 노드라면
				DFS(i, depth + 1); // 재귀호출이 될때마다 depth 1증가
			}
		}
		visited[now] = false;
	}
}
