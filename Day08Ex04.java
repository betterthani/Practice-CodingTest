package day08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day08Ex04 {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int start = scan.nextInt();
		
	
		A = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			A[s].add(e);
			A[e].add(s);
		}
		
		for (int i =1; i < N+1; i++) {
			Collections.sort(A[i]);
		}
		
		visited = new boolean[N+1];
		DFS(start);
		System.out.println();
		
		visited = new boolean[N+1];
		BFS(start);
		System.out.println();
	}



	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			System.out.print(nowNode + " ");
			for (int i : A[nowNode]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}



	private static void DFS(int node) {
		System.out.print(node + " ");
		visited[node] = true;
		for (int i : A[node]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
	
	

}
