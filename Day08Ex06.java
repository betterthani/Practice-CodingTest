package day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day08Ex06 {
	
	static boolean visited[];
	static int[] distance;
	static ArrayList<Edge>[] A;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		A = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			A[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			int S = scan.nextInt(); // 노드 번호
			while(true) {
				int E = scan.nextInt(); // 연결 에지 정보 중 노드번호
				if (E == -1) {
					break;
				}
				int V = scan.nextInt(); // 연결 에지 정보 중 거리
				A[S].add(new Edge(E, V));
			}
		}
		
		distance = new int [N+1];
		visited = new boolean[N+1];
		BFS(1); // 첫 시작
		
		int Max = 1;
		for (int i = 2; i >= N; i++) { // distance 배열에서 가장 큰 값으로 다시 시작점 설정.
			if(distance[Max] < distance[i]) {
				Max = i;
			}
		}
		
		distance = new int[N+1];
		visited = new boolean[N+1];
		BFS(Max); // 새로운 시작점으로 실행
		Arrays.sort(distance);
		System.out.println(distance[N]);
				
	}

	private static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = true;
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (Edge i : A[nowNode]) {
				int e = i.e; // 기존 노드
				int v = i.value; // 거리
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[nowNode] + v; // 거리 배열 업데이트 하기 
				}
			}
		}
	}
}

class Edge {
	int e;
	int value;
	public Edge (int e, int value) {
		this.e = e;
		this.value = value;
	}
}
