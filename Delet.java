package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Delet {
	static ArrayList<Integer> [] A;
	static int visited[];
	static int n,m,k,x;
	static List<Integer> answer;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		x = scan.nextInt();
		A = new ArrayList[n+1];
		answer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			A[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			A[start].add(end);
		}
		
		visited = new int[n+1];
		for (int i = 0; i <= n; i++) {
			visited[i] =  -1;
		}
		
		BFS(x);
		for(int i = 0; i <= n; i++) {
			if(visited[i] == k) {
				answer.add(i);
			}
		}
		if(answer.isEmpty()) {
			System.out.println("-1");
		} else {
			Collections.sort(answer);
			for(int temp : answer) {
				System.out.println(temp);
			}
		}
	}

	private static void BFS(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		visited[node]++;
		while(!q.isEmpty()) {
			
			int nowNode = q.poll();
			for (int i : A[nowNode]) {
				if(visited[i] == -1) {
					visited[i] = visited[nowNode] + 1;
					q.add(i);
				}
			}
		}
	}

}
