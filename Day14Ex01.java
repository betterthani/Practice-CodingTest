package day14;

import java.util.Scanner;

public class Day14Ex01 {
	public static int[] parent;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		parent = new int [N+1];
		for (int i = 0; i <= N; i++) { // 대표노드 초기화
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) { // 질의 계산 부분
			int question = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();
			if (question == 0) { // 집합합쳐라 (union)
				union(a,b);
			} else { // 두 원소 같은지 보기
				boolean result = checkSame(a,b);
				if(result) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void union(int a, int b) {
		// 대표노드 찾아서 연결하기
		a = find(a);
		b = find(b);
		if(a != b) { // 두개가 다르면 연결해주기
			parent[b] = a; // 두개 연결
		}else {
			parent[a] = b;
		}
	}

	private static int find(int a) {
		if(a == parent[a]) {// a= index , 인덱스의 값과 value값이 같은지 확인
			return a; // a자체가 대표노드니깐 a반환해
		}else { // 아니라면 대표노드 찾아가
			return parent[a] = find(parent[a]); // value를 index로 바꿔서 또 찾아보기, 
			// parent[a] = : 그 찾아본걸 value값에 업데이트 해주기
		}  
	}
	
	private static boolean checkSame(int a, int b) {
		a = find(a);// 대표 노드값 찾아주기
		b = find(b);
		if(a==b) return true;
		return false;
	}

}
