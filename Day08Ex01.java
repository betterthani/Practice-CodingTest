package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day08Ex01 {
	
	static boolean visited[]; // 유일하게 사용하는거기 떄문에
	static ArrayList<Integer> [] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1]; // 0번 인덱스 말고 1번 인덱스 부터
		A = new ArrayList[n+1]; // 모든 new객체 생성한건 아님
		for (int i = 1; i < n+1; i++) {
			A[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) { // sample에서 나오는 엣지 정보들을 받아와야하기 때문(m갯수만큼 인정리스트에 넣어줘야함)
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 시작점
			int e = Integer.parseInt(st.nextToken()); // 종료점
			// 방향성이 없기때문에 양쪽으로 갈 수 있음 그래서 양쪽방향에 add해줘야함
			A[s].add(e);
			A[e].add(s);
		}
		int count = 0;
		for (int i = 1; i < n+1; i++) {
			//!visited[i] 방문하지 않은 노드의 개수
			if(!visited[i]) {
				count++;
				DFS(i); //현재 방문하지 않는 노드에 해준다.
			}
		}
		System.out.println(count);
	}

	private static void DFS(int v) { // v = 현재 들어온 노드
		if(visited[v]) {
			return;
		}
		// 방문노드가 아니였다. -> 방문할 노드가 되었다
		visited[v] = true; // true 로 방문도장 찍음
		for (int i : A[v]) { // 현재 노드에서 연결되어있는 모든 노드를 탐색
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
	
	

}
