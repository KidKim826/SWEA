package SWEA;

import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 배열 크기 입력 받고
			int M = sc.nextInt(); // 파리채 크기 입력 받는다
			
			int[][] fly = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					fly[i][j] = sc.nextInt();
				}
			}
			
			//파리채 크기만큼 돌아가면서 비교하면 되니까
			int maxKill = 0; //죽인 파리 수의 max 값을 임의로 지정해주고 
			for(int k = 0; k < N-M+1; k++) { //k는 N-M 크기만큼 1씩 증가시켜 
				for(int d = 0; d < N-M+1; d++) { //d도 마찬가지로. k랑 d는 각각 파리채 크기를 배열 속에서 돌리기 위한 값.
					int sum = 0; //sum을 0이라고 지정해 준 다음
					for(int i = 0; i < M; i ++) { 		
						for(int j = 0; j < M; j++) { //MxM 크기 만큼 돌아가면서 다 더해준다
								sum += fly[i+k][j+d]; 
						}
					}	
					if(sum > maxKill) { // 그 더해준 값이 maxkill보다 크면
						maxKill = sum; //maxKill 값을 대체
					}
				}
			}
			System.out.println("#"+tc+" "+maxKill); // maxKill값 출력
		}
	}
}
