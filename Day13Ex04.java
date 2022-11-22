package day13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day13Ex04 {
	static int[] sender = {0,0,1,1,2,2};
	static int[] Receiver = {1,2,0,2,0,1};
	static boolean visited[][]; // A,B무게가 있으면 C무게 고정
	static boolean answer[];
	static int now[];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		now = new int[3];
		now[0] = scan.nextInt();
		now[1] = scan.nextInt();
		now[2] = scan.nextInt();
		visited = new boolean[201][201];
		answer = new boolean[201];
		BFS();
		for(int i = 0; i < answer.length; i++) {
			if(answer[i]) {
				System.out.print(i + " ");
			}
		}
		
		
	}

	private static void BFS() {
		Queue<AB> queue = new LinkedList<>();
		queue.add(new AB(0, 0));
		visited[0][0] = true;
		answer[now[2]] = true;
		while(!queue.isEmpty()) {
			AB p = queue.poll();
			int A = p.A;
			int B = p.B;
			int C = now[2] - A- B;
			for(int k = 0; k < 6; k++) {
				int []next = {A,B,C};
				next[Receiver[k]] += next[Sender[k]];
				next[Sender[k]] = 0;
				if(nex)
			}
		}
	}

}
class AB{
	int A;
	int B;
	public AB(int A, int B) {
		this.A = A;
		this.B = B;
	}
}