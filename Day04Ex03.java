package day04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day04Ex03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = scan.nextInt();
		for (int i = 1; i <= N; i++) {//카드가 1 ~ N까지
			myQueue.add(i); // 1부터 쌓임
		}
		while(myQueue.size() > 1) { // 카드가 한장 남을때까지 돈다.
			myQueue.poll(); // 맨 위 카드 버림
			int temp = myQueue.poll();
			myQueue.add(temp);
		}
		System.out.println(myQueue.poll());
	}

}
