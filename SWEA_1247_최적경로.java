package SWEA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	//좀 많이... 복잡하게 푼것 같기도..?
	
	static int[][] house = new int[1][2]; //house 위치 받을 배열
	static int[][] company = new int[1][2]; // company위치 배열
	static int[][] customer; //고객들 위치 배열
	static int[] index; // 고객들 위치 index값 담을 배열
	static boolean[] sel; // 고객위치 index 방문처리 할 배열
	static int[] res; //그래서 그 index들 경우의수 결과값 담아줄 배열
	static int shortcut; // 지름길
	static int N; //고객 수
	static int X; //x좌표 거리
	static int Y; //y좌표 거리
	static int min;// 최적경로
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
			N = sc.nextInt();
			
			//회사 위치 받고
			company[0][0]= sc.nextInt();
			company[0][1]= sc.nextInt();
			//집 위치 받고
			house[0][0] = sc.nextInt();
			house[0][1]= sc.nextInt();
			
			//고객 배열 만들고
			customer = new int[N][2];
			//인덱스 배열도 만들고
			index = new int[N];
			//입력 받기
			for(int i = 0; i < N; i++) {
				customer[i][0] = sc.nextInt();
				customer[i][1] = sc.nextInt();
				index[i] = i;
			}
			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j <2; j++) {
//					System.out.print(customer[i][j]);
//				}
//				System.out.println();
//			}
			
			sel = new boolean[N];
			res = new int[N];
			min = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#"+tc+" "+min);
		}
		
	}
	//조합으로 고객들 1번부터 N번이라 치고 줄세워서 이걸 차례로 돌아가면서 하는 식으로,
	static void perm(int idx) { //줄 세워보고 그거 차례로 넣어서 돌려.
		
		if(idx == N) {
			//회사 - 첫번째 고객 거리
			shortcut = Math.abs(company[0][0]-customer[res[0]][0])
					+Math.abs(company[0][1]-customer[res[0]][1]);
			//고객 - 고객 간의 거리
			for(int i = 1; i < N; i++) {
				shortcut += Math.abs(customer[res[i]][0]-customer[res[i-1]][0])
						+Math.abs(customer[res[i]][1]-customer[res[i-1]][1]);
			}
			// 마지막 고객 - 집 거리
			shortcut += Math.abs(house[0][0]-customer[res[N-1]][0])
					+Math.abs(house[0][1]-customer[res[N-1]][1]);
			//그래서 지름길중에서 min값 찾기
			if(shortcut < min) {
				min = shortcut;
			}
//			System.out.println(min); // 확인용
//			System.out.println(Arrays.toString(res)); //확인용
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(sel[i]) {
				continue;
			}
			
			sel[i] =true;
			res[idx] = index[i];
			perm(idx+1);
			sel[i] = false;
		}
		
	}
	
}
