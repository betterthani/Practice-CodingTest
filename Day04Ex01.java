package day04;

import java.util.Scanner;
import java.util.Stack;

public class Day04Ex01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[]= new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		boolean result = true;
		StringBuffer br = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			int su = a[i];
			if (su >= num) {
				while(su >= num) {
					stack.push(num++);
					br.append("+\n"); // +출력
				}
				stack.pop();
				br.append("-\n");
			}else {
				int n1 = stack.pop();
				if(n1 > su) {
					System.out.println("No");
					result = false;
					break;
				} else {
					br.append("-\n");
				}
			}
		}
		if (result) {
			System.out.println(br.toString());
		}
	}

}
