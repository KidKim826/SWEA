package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6808_규영이와인영이의카드게임2 {
	
	static ArrayList<Integer> kyu; // 규영이 카드 덱
	static int[] young; // 인영이 카드 덱
	static boolean[] visited; 
	static int[] result;
	static int lose;
	static int win;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			kyu = new ArrayList<>();
			for(int i = 0; i < 9; i++) {
				kyu.add(sc.nextInt());
			}
			young = new int[9];
			for(int i = 1, cnt = 0; i <= 18; i++) { //카드 1~18까지 있나 없나 체크하면서 규영이 덱에 담아준다.
				if(!kyu.contains(i)) { //kyu에 i가 없을때 일로 들어와서 
					young[cnt++] = i; //인덱스 돌면서 값을 채워준다.
//					System.out.println(i);
				}
			}
//			System.out.println(kyu);
//			System.out.println(Arrays.toString(young));
//			
//			game(1, 0, 0, new boolean[18]);
			visited = new boolean[9];
			result = new int[9];
			win = 0;
			lose = 0;
			perm(0);
		
			System.out.println(win);
			System.out.println(lose);
//			
			
		}
	
	}
	
	public static void perm(int idx) {
		if(idx == 9) {
			int kyuscore = 0; // 규영이 점수
			int youngscore = 0; //인영이 점수
			
			for(int i = 0; i < 9; i++) {
				if(kyu.get(i)>result[i]) { // 규영이 점수 +
					kyuscore += kyu.get(i)+result[i];
					
				}else if(kyu.get(i) < result[i]) { // 인영이 점수 +
					youngscore += kyu.get(i)+result[i];
				}
			}
			if(youngscore > kyuscore) { // 인영이가 이기는 경우
				lose++;
			}else if(youngscore < kyuscore) { //규영이가 이기는 경우
				win++;
			}
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(!visited[i]) { //방문한 노드가 아니라면
				result[idx] = young[i]; // 넣어주고
				visited[i] = true;
				perm(idx+1); // 카드게임 돌려주고
				visited[i] = false; //
			}
		}
		
	}
	
	
	
//	static void game(int gameCnt, int kyuscore, int youngscore, boolean judge[]) {
//		
//		if(gameCnt > 9) {
//			if(kyuscore > youngscore) {
//				lose++;
//			}else if(kyuscore < youngscore) {
//				win++;
//			}
//			return;
//		}
//		
//		for(int i = 0; i < 9; i++) {
//			
//			if()
//		}
//		
//	}
	
	
}
