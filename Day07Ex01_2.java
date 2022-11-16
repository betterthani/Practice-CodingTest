package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day07Ex01_2 {

	private static int[] A;
	private static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		A = new int [N+1];
		temp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		merget(1, N);
		
		for (int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void merget(int s, int e) {
		if(e - s < 1) {
			return;
		}
		int m = s+ (e - s) / 2;
		
		merget(s, m);
		merget(m+1, e);
		for (int i = s; i <= e; i++) {
			temp[i] = A[i];
		}
		
		int k = s;
		int i = s;
		int j = m+1;
		while (i <= m && j <= e) {
			if(temp[i] < temp[j]) {
				A[k] = temp[i];
				k++;
				i++;
			} else {
				A[k] = temp[j];
				k++;
				j++;
			}
		}
		
		while(i <= m) {
			A[k] = temp[i];
			k++;
			i++;
		}
		
		while(j <= e) {
			A[k] = temp[j];
			k++;
			j++;
		}
	}

}
