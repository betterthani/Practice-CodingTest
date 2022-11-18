package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day08Ex05 {
	
	static int[] dx = {0,1,0,-1}; // x로는 0           / x로는 1 (오른쪽) /        / 왼쪽으로 탐색
	static int[] dy = {1,0,-1,0}; // y로는 1 (아래 탐색) / y로는 0        / 위를 탐색 / 
	static boolean [][] visited;
	static int [][] A;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); // 공백이 없이 값이 들어오므로, nextToken으로 값 받기 쉽지 않다.
			String line = st.nextToken(); // ex) line = 110110
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j+1)); // 110110의 각 한자리씩 배열에 들어가게 된다
				
			}
		}
		BFS(0,0); // 시작점에서 부터 (0,0) 돌아간다
		System.out.println(A[N-1][M-1]); // index가 0 부터 시작하므로 1 빼준다.
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j}); // i와 j의 값 넣어준다.
		visited[i][j] = true;
		
		while(!queue.isEmpty()) { // 큐가 빌때까지 돌려, 그 말인즉슨 BFS가 탐색할게 없을 때까지
			int now[] = queue.poll();
			for (int k = 0; k < 4; k++) {// index 4번도는거 (상하좌우 탐색)
				int x = now[0] + dx[k]; // 현재의 x값 + dx를 통해 상하좌우 움직임
				int y = now[1] + dy[k]; // 현재의 y값 + dy를 통해 상하좌우 움직임
				if(x >= 0 && y >=0 && x < N && y < M) { // 배열을 넘어가면 안 되고
					if(A[x][y] != 0 && !visited[x][y]) { // 0이어서 갈 수 없거나, 기방문한 곳이면 안 됨
						// 이제 갈 수 있는 곳이다.
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1; // 핵심 (1이라는 값을 2,3,4,5 로 바꿔주는 역할)
						queue.add(new int[] {x, y}); // 새롭게 데이터를 만들어줘, 다음 탐색을 위해
					}
				}
			}
		}
	}
}
