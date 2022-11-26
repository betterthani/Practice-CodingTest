package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day15Ex02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		// 건물 개수 만큼 인접 리스트 초기화
		for (int i = 0; i <= N; i++) {
			A.add(new ArrayList<>());
		}
		// 집입차수배열 초기화
		int[] indegerr = new int[N + 1];
		// 자기 자신을 짓는데 걸리는 시간 저장 배열 초기화
		int[] selfBuild = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 건물을 짓는데 걸리는 시간
			selfBuild[i] = Integer.parseInt(st.nextToken());
			
			// 인접 리스트 데이터 저장
			while (true) {
				int preTemp = Integer.parseInt(st.nextToken());
				if (preTemp == -1) {
					break;
				}
				A.get(preTemp).add(i); 
				indegerr[i]++; // 집입차수 배열 초기데이터 저장
			}
		}
		
		// 위상 정렬 수행하기
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegerr[i] == 0) { // 해당 노드를 바라보는 엣지가 없다.
				queue.offer(i); // 추출하여 위상정렬 배열에 넣기
			}
		}

		int[] result = new int[N + 1];
		while (!queue.isEmpty()) { // 큐가 빌때 까지
			int now = queue.poll(); // 현재 노드 = 큐에서 데이터 빼내기
			for (int next : A.get(now)) {
				indegerr[next]--; // 타깃 노드 진입 차수 배열 --
				
				// 결과 노드 업데이트
				result[next] = Math.max(result[next], result[now] + selfBuild[now]); // Math.max(현재 저장된 값, 현재 출발 노드 + 자기 자신 걸리는 시간)
				
				// 타깃 노드의 진입 차수가 0이라면
				if (indegerr[next] == 0) {
					queue.offer(next); // 우선순위 큐에 타킷 노드 추가
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(result[i] + selfBuild[i]);
		}
	}

}
