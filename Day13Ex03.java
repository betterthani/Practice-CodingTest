package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Day13Ex03 {
	static ArrayList<Integer>A[];
	static boolean visited [];
	static int[] check;
	static boolean isEven; // 정답 체크

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) { //주어진 테스트 케이스 만큼 돌려준다
			String[] s = br.readLine().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			A = new ArrayList[V+1];
			visited = new boolean[V+1];
			check = new int[V+1];
			isEven = true;
			for (int i = 1; i <= V; i++) {
				A[i] = new ArrayList<>(); // 각방을 배열 만들어준다.
			}
			
			// 에지 데이터 저장하기
			for(int i = 0; i < E; i++) {
				s = br.readLine().split(" ");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				A[start].add(end);
				A[end].add(start);
			}
			// 모든 노드에서 DFs실행 해야함
			for(int i = 1; i <= V; i++) {
				if(isEven) { // 이분그래프라면
					DFS(1);
				} else { // 이분그래프가 아니다
					break;
				}
			}
			
			if(isEven) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

	private static void DFS(int start) {
		visited[start] = true;
		for (int i : A[start]) { // 인접리스트로 받아서 start라는 노드에 연결되어있는 모든 노드를 탐색한다.
			if(!visited[i]) {
				// 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요
				// A,B집합대신 1,0집합으로 표기
				check[i] = (check[start] + 1) % 2;
				DFS(i);
			}else if(check[start] == check[i]) {
					isEven = false;
				
			}
		}
	}

}
