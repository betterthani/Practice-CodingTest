package day01;

import java.util.Arrays;
import java.util.Scanner;

public class NO1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		for (int arrInt : arr) {
			System.out.println(arrInt);
		}
		
	}

}
