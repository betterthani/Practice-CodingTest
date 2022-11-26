package day15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day15Ex01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			A.add(new ArrayList<>());
		}
		
		int indegree[] = new int[N+1];
		for (int i = 0; i < M; i++) {
			int S = scan.nextInt();
			int E = scan.nextInt();
			A.get(S).add(E);
			indegree[E]++; // 진입차수 배열 데이터 저장 부분
		}
		
		// 위상정렬 실행
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) { // 해당 노드를 바라보는 엣지가 없다
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) { //queue가 빌때까지 돈다
			int now = queue.poll();
			System.out.print(now + " ");
			for(int next : A.get(now)) {
				indegree[next]--;
				if(indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		
	}

}
