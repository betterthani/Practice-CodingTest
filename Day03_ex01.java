package day03;

import java.util.Scanner;

public class Day03_ex01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 1;
		int sum = 1; 
		int startIndex = 1;
		int endIndex = 1;
		
		while(endIndex != n) {
			if(sum == n) {
				endIndex++;
				count++;
				sum += endIndex;
			}else if (sum > n) {
				sum -= startIndex;
				startIndex++;
			}else if (sum < n) {
				endIndex++;
				sum += endIndex;
			}
		}
		System.out.println(count);
	}

}
