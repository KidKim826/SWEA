package SWEA;

import java.util.Scanner;

public class SWEA_1226_미로2 {
	
	static char[][] map;//미로를 저장할 2차원 배열
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N = 100;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			sc.next();
			map = new char[N][N];
			ans = 0;
			
			int stR = -1;
			int stC = -1;
			for(int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '2') {
						stR = i;
						stC = j;
					}
				}
			}
			dfs(stR, stC);
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	
	public static void dfs(int r, int c) {
		//1.기본 구간
		if(map[r][c] == '3') {
			ans = 1;
			return;
		}	
		
		//2.순환 구간 
		map[r][c] = '1';
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			
			if(map[nr][nc] == '1') {
				continue;
			}
			
			dfs(nr, nc);
			
		}
		
		
	}
}
