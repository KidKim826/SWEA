package SWEA;

import java.util.Scanner;

public class SWEA_1974_스도쿠 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[][] sudocu = new int[9][9];
		
		for(int tc = 1; tc <= T; tc++) {
			//스도쿠 배열을 받는다.
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sudocu[i][j] = sc.nextInt();
				}
			}			
			//스도쿠 배열 검사할것이다. 3가지 케이스로 나눠서 검사 할건데
			int ans = 0;
			int twins = sudocu[0][0];
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j<9; j++) {
//					if(sudocu[i][j] == sudocu[i][j+1]) {
//						ans++;
//					}
					if(twins != sudocu[i][j]) {
						twins = sudocu[i][j];
					} else if(twins == sudocu[i][j]){
						ans++;
					}
				}
			}System.out.println(ans);
			
			twins = sudocu[0][0];
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j<9; j++) {
//					if(sudocu[i][j] == sudocu[i+1][j]) {
//						ans++;
//					}
					if(twins != sudocu[j][i]) {
						twins = sudocu[j][i];
					} else {
						ans++;
					}
				}
			}
			
			int r = 1;
			int c = 1;
			int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
			int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1};
			//8방 탐색을 해줄거야.
			// 그 기준점은 1.1  / 4.1 / 7.1 / ~ 7.7 까지라 행 / 열 3씩 등차
			for(int i = 0; i < 3; i++) {
				int cnt = 0;
				for(int j = 0; j < 3; j++) {
					for (int d = 0; d < 8; d++) {
						twins = sudocu[r+i*3][c+j*3];
						int sum = sudocu[r+i*3][c+j*3];
						int nr = r+i*3 + dr[d];
						int nc = c+j*3 + dc[d];
						if (nr >= 0 && nr < 9 && nc >= 0 && nc < 9) { // 사실 얘도 해줄 필요가 딱히 없다 행열을 지정해줬어서..							
							sum += sudocu[nr][nc];
							if(sudocu[nr][nc] != twins) {
								twins = sudocu[nr][nc];
//								cnt++;
							}else {
								ans++;
							}
						}
//						if(cnt < 9 && sum == 45) {
//							ans++;
//						}
//						if (nr < 0 || nr >= 9 || nc < 0 || nc >= 9) {//어차피 행/열을 지정해줘서 굳이 필요 없음.
//							continue;
//						}
					}
					if(cnt < 8) {
						ans++;
					}
					
				}
			}System.out.println("#"+tc+" "+ans);
			
			
		}
	}
}
