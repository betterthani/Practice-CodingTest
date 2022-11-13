package day05;

import java.util.Scanner;

public class Day05Ex03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int arr[] = new int[str.length()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str.substring(i,i+1));
		}
		
		for (int i = 0; i < arr.length; i++) {
			int max = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j] > arr[max]) {
					max = j;
				}
				
				if(arr[i] < arr[max]) {
					int temp = arr[i];
					arr[i] = arr[max];
					arr[max] = temp;
				}
			}
			System.out.print(arr[i]);
		}
	}

}
