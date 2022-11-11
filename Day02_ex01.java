package day02;

import java.util.Scanner;

public class Day02_ex01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String sNum = scan.next();
		char[] cNum = sNum.toCharArray();
		int sum = 0;
		for(int i = 0; i < cNum.length; i++) {
			sum += cNum[i] - '0';
		}
		
		System.out.println(sum);
	}

}
