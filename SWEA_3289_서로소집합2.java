package SWEA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3289_서로소집합2 {
	
	static int n;
	static int m;
	static int[] p;
	static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			p = new int[n+1];
			rank = new int[n+1];
			
			makeSet();
			
			System.out.print("#"+tc+" ");
			for(int i = 0; i < m; i++) {
				int CASE = sc.nextInt(); //합할지 찾을지
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				switch(CASE) {
				case 0: //합치기
					
					unionSet(a, b);
					break;
				case 1:
					if(findSet(a)==findSet(b)) {
						System.out.print(1);
					}else {
						System.out.print(0);
					}
					break;
				}
				
			}
			System.out.println();
		}

	}
	
	public static void makeSet() {
		// 셋 만들기
		for(int i = 1; i <= n; i++) {
			p[i] = i;
		}
	}
	
	//
	public static int findSet(int a) {
		if(p[a] == a) {
			return a;
		}
		p[a] = findSet(p[a]);
		return p[a];
	}
	
	
	public static void unionSet(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		if(pa == pb) {
			return;
		}
		if(rank[pa] > rank[pb]) {
            p[pb] = pa;
        }else if(rank[pb]==rank[pa]) {
        	rank[pb]++;
		}
		if(rank[pa] < rank[pb]){
			p[pa] = pb;
		}
		
 	}
	
//	public static void union(int x, int y) {
//		p[findSet(y)]= findSet(x); //정석
//	}
}
