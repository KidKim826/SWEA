package SWEA;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();		
			int[][] snail = new int[N][N];
			int startnum = 1; //(시작번호)
			int F = 0; // 어디서 부터 시작해서
			int L = N-1; // 어디까지 셀지
			for(int i = 0; i < N; i++) {
				
				if(i%2 == 0) { // 배열을 두구간으로 나눈다 (위&오른쪽)(아래&왼쪽)
						for(int j = F; j <= L; j++) { //1.위
						snail[F][j] = startnum; //F=0부터 / 행고정 / 열 한칸씩 이동  (N-1번째까지) // 숫자 채우고
						startnum++; // 숫자 늘려준다
						}F++; //셋으면 F하나 늘려준다. ( 다음행부터 지금까지 센거의 -1까지 센다.)
						for(int j = F; j <= L; j++) { //2. 오른쪽  //열 L로 고정해놓고 / 행을 이동 / 
						snail[j][L] = startnum; //숫자 채우고
						startnum++; // 숫자 늘려준다.
						}L--; // 다 셋으면 L은 하나더 뺴준다. (다음열부터 지금까지 센거의 -1까지 센다.)
				}else {	
						for(int j = L; j >= F-1; j--) { //3.아래
						snail[L+1][j] = startnum;
						startnum++;
						}
						for(int j = L; j>=F; j--) { //4.왼쪽
						snail[j][F-1] = startnum;
						startnum++;
						}
				}
				
			}
			System.out.println("#"+tc); //출력
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
		}		
	}	
}

