package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day03_ex05 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long L = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new LinkedList<>();
		
		for (int i= 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken()); // 데이터 값
			
			// 새로운 값이 들어올 떄마다 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도 줄임
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(now,i));
			
			// 범위에서 벗어난 값은 덱에서 제거
			if(mydeque.getFirst().index <= i-L) {
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value+" ");
		}
		bw.flush();
		bw.close();
		
	}
	static class Node{
		public int value;
		public int index;
		
		Node (int value, int index){
			this.value = value;
			this.index = index;
		}
	}

}
