package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day07Ex01 {

	private static int[] temp; // 필드에서 변수 선언시 클래스 내 모든 메소드 사용 가능
	private static int[] A; // 정렬 배열은 반드시 전역변수로 선언해야한다.(불필요한 메모리 줄일수 있다.) / 정렬 수행할때 기존 배열 뿐 아니라 추가적인 배열도 필요하므로
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		A = new int[N+1]; 
		temp = new int[N+1];
		 
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		merget_sort(1,N);
		
		for (int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	private static void merget_sort(int s, int e) {// s시작점 , e끝점, m 중간점
		if(e - s < 1) { // 시작배열이 다 돌았는데 더이상 교체 이뤄지지않을 경우 (오름 차순 원래 부터 되어있는 경우)
			return; // 재귀함수 종료조건 
		}
		int m = s + (e - s) / 2; // 가운데 조건 원래 e-s / 2인데 1부터 시작하므로
		
		// 재귀함수 호출
		merget_sort(s,m); // start 배열
		merget_sort(m+1,e); // end 배열
		for (int i = s; i <= e; i++) {
			temp[i]  = A[i];
		}
		
		int k = s; // 새로운 배열 포인터는 시작점과 같음
		int index1 = s;
		int index2 = m+1; // end배열 첫 포인터
		while(index1 <= m && index2 <= e) { 
			// 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장, 선택된 데이터의 index값을 오른쪽으로 한 칸 이동
			if(temp[index1] > temp[index2]) { // start의 값보다 end값이 큰경우
				A[k] = temp[index2]; // a배열에 임시배열값인 end 값 삽입
				k++; // a배열 다음 칸으로 이동하기 위해 k증가
				index2++; // index2 삽입되었기 때문에 옆으로 칸 이동
			} else {
				A[k] = temp[index1];
				k++;
				index1++;
			}
		}
		// 한쪽 그룹이 모두 선택된 후 남아있는 값 정리하기
		while (index1 <= m) {  // start배열이 남아있는 경우 (end배열이 먼저 끝난 경우)
			A[k] = temp[index1]; // 남아있는 i의 값(start) 넣어주기
			k++;
			index1++;
		}
		while(index2 <= e) { // end배열이 남아있는 경우 (start가 끝나 있는 경우)
			A[k] = temp[index2]; // 남아있는 j의 값(end) 넣어주기
			k++;
			index2++;
		}
	}

}
