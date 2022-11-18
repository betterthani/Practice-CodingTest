package day10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Day10Ex02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			queue.add(scan.nextInt());
		}
		
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while(queue.size() != 1) {
			data1 = queue.remove();
			data2 = queue.remove();
			sum += data1 + data2;
			queue.add(data1 + data2);
		}
		System.out.println(sum);
	}

}
