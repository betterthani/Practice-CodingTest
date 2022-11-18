package day10;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day10Ex03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusPq = new PriorityQueue<>();
		int oneCount = 0;
		int zeroCount = 0;
		
		for (int i = 0; i < N; i++) {
			int value = scan.nextInt();
			if(value == 0) {
				zeroCount++;
			} else if (value == 1) {
				oneCount++;
			} else if (value > 1) {
				plusPq.add(value);
			} else {
				minusPq.add(value);
			}
		}
		int sum = 0;
		while(plusPq.size() > 1) {
			int data1 = plusPq.remove();
			int data2 = plusPq.remove();
			sum += data1 * data2;
		}
		if(!plusPq.isEmpty()) {
			sum += plusPq.remove();
		}
		
		while(minusPq.size() > 1) {
			int first = minusPq.remove();
			int second = minusPq.remove();
			sum += first * second;
		}
		if(!minusPq.isEmpty()) {
			if (zeroCount == 0) {
				sum += minusPq.remove();
			}
		}
		
		sum += oneCount;
		System.out.println(sum);
		
	}

}
