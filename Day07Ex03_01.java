package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day07Ex03_01 {
	
	private static int A[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		radixSort(A, 5);
		for (int i = 0; i < A.length; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void radixSort (int[]A, int maxSize) {
		int [] output = new int[A.length];
		int jarisu = 1;
		int count = 0;
		
		while(count != maxSize) {
			int [] numbers = new int[10];
			for (int i = 0; i < A.length; i++) {
				numbers[(A[i] / jarisu) % 10]++;
			}
			
			for (int i = 1; i <= 9; i ++) {
				numbers[i] += numbers[i-1];
			}
			
			for (int i = A.length - 1; i >= 0; i--) {
				output[numbers[(A[i] / jarisu) % 10] - 1] = A[i];
				numbers[(A[i] / jarisu) % 10]--;
			}
			
			for (int i = 0; i < A.length; i++) {
				A[i] = output[i];
			}
			
			jarisu *= 10;
			count++;
		}
				
	}

}
