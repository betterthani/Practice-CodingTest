package day10;

import java.util.Scanner;

public class Day10Ex05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String example = scan.nextLine();
		String[] data = example.split("-");
		int answer = 0;
		
		for (int i = 0; i < data.length; i++) {
			int temp = mySum(data[i]);
			if(i == 0) {
				answer += temp;
			}else {
				answer -= temp;
			}
		}
		System.out.println(answer);
	}

	private static int mySum(String a) {
		
		 String [] array = a.split("[+]"); // meta error -> split 인식 잘 못해서 그런 경우이므로, 대괄호 쳐줌
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += Integer.parseInt(array[i]);
		}
		return sum;
	}

}
