package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_14320_햄토리희망편4 {
	
	static ArrayList<Integer> ans; // 답출력
	static ArrayList<sunflower> temp; //임시
	static int[][] seed;
	static boolean[] sel;
	static int N;
	static int K;
	static int B;
	static int sum;
	static int max;
	static int dist;
	static int distMin;
	
	public static class sunflower {
		int idx;
		int weight;
		
		sunflower(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			seed = new int[N][2];
			for(int i = 0; i < N; i++) {
				seed[i][0] = i;
				seed[i][1] = Integer.parseInt(st.nextToken());;
			}
			
			//출력확인
//			for(int i = 0; i < N; i++) {
//				System.out.println(seed[i]);
//			}
			temp = new ArrayList<>();
			ans = new ArrayList<>();
			sel = new boolean[N];
			max = Integer.MIN_VALUE;
			distMin = Integer.MAX_VALUE;
			gather(0,0,0);
			if(ans.size() > 0) {
				Collections.sort(ans);
				System.out.print("#"+tc+" ");
				for(int i = 0; i < ans.size(); i++) {
					System.out.print(ans.get(i)+" ");
				}
				System.out.println();
			}else {
				System.out.println("#"+tc+" "+(-1));
			}
		}
		
	}
	
	public static void gather(int idx, int cnt, int ssum) { //powerset
		
		if(idx == sel.length) {
//			ans = new ArrayList<>();
			temp = new ArrayList<>();
			for(int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					temp.add(new sunflower(seed[i][0], seed[i][1]));
				}
			}
			if(temp.size() <= K) {
				sum = 0;
				dist = 0;
				for(int i = 0; i < temp.size(); i++) {
					sum += temp.get(i).weight;
				}
				if(sum == B) {
					dist = N-temp.get(0).idx;
					if(dist < distMin) {
						ans = new ArrayList<>();
						for(int i = 0; i < temp.size(); i++) {
							ans.add(temp.get(i).weight);
						}
					}
				}
			}
			return;
		}
		
		
		sel[idx] = true;
		if(cnt <= K && ssum+seed[idx][1] <= B)
				gather(idx+1, cnt+1, ssum+seed[idx][1]);
		
		sel[idx] = false;
		gather(idx+1, cnt, ssum);
		
	}
}
