package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	
	static boolean check;
	static int D;
	static int W;
	static int K;
	static int min;
	static int[][] film;
	static int[] drugA, drugB;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			drugA = new int[W];
			drugB = new int[W];
			min = K;
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j =0; j < W; ++j) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 끝
			Arrays.fill(drugA, 0); //약물 0
			Arrays.fill(drugB, 1); //약물 1
			process(0, 0); // 검사 돌려
			System.out.println("#"+tc+" "+min);
			
		}
		
		
	}
	
	static boolean check() { //성능 검사
	
        for(int j=0; j<W; j++){
            int cnt = 1;
            int before = film[0][j];
            for(int i = 1; i<D; i++){
                int current = film[i][j];
                if(before == current){
                    cnt++;
                    if(cnt == K) //성능 통과
                        break;     
                }else{
                    before = current;
                    cnt = 1;
                }
            } // 열고정 수직 검사
            if(cnt < K)   
                return false;
        }
        return true;
		
	}
	
	public static boolean process(int row, int useCnt) {
		//각 막에 부분집합으로 약품 비투여, 약품A 투여, 약품B 투여
		
		if(row == D) {
			if(check()) {
				min = Math.min(min, useCnt);
				return min == 0; // 약품 하나도 사용 않으면 true, 사용하면 false.
			}
			return false; //성능검사 불통.
		}
		
		if(useCnt >= min) return false; //최소 약품 수 보다 같거나 큰 경우 의미 없다.
		
		int[] backup = film[row]; /// 현재 막의 상태배열 기억
		
		//약품 비투여
		if(process(row+1, useCnt)) return true;
		//약품A 투여
		film[row] = drugA;
		process(row+1, useCnt+1);
		//약품B 투여
		film[row] = drugB;
		process(row+1, useCnt+1);
		
		film[row] = backup; //기존 막의 상태로 다시 
		
		return false;
		
	}
}
