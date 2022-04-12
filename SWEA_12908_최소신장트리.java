package SWEA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_12908_최소신장트리 {
	
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt(); //정점 수
			int E = sc.nextInt(); //간선 수
			
			int[][] tree = new int[E][3]; // 배열만들기
			
			p = new int[V+1]; 
			
			for(int i = 0; i < E; i++) {
				tree[i][0] = sc.nextInt(); // n1
				tree[i][1] = sc.nextInt(); // n2
				tree[i][2] = sc.nextInt();	//w
			}
			
			Arrays.sort(tree, new Comparator<int[]>() { // 가중치 우선으로 정렬하기
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			for(int i = 0; i < V+1; i++) { // makeset
				p[i] = i;
			}
			

			int ans = 0;
			
			//mst 만들어 보자.
			//간선을 V개 선택하면 break;
			int pick = 0;
			for(int i = 0 ; i<E; i++) {
				int px = findSet(tree[i][0]);
				int py = findSet(tree[i][1]);
//				System.out.println(px +" "+ py);
				if(px != py) {
					unionSet(px, py);
					ans += tree[i][2];//w 더하기
					pick++;
				}
				if(pick == V) break;
			}

			System.out.println("#"+tc+" "+ans);

			
		}
		
		
		
	}

	
	
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
		if(pa < pb) {
            p[pb] = pa;
        }else {
        	p[pa] = pb;
		}
		
 	}
	
//	static void union(int x, int y) {
//		p[findSet(y)]= findSet(x); //정석
//		
////		p[y] = x ;//이번 경우에서는 이와 같이 작성해도 상관 없음. 
//		//어차피 대표를 찾아서 union을 호출할거니까. 
//		//항상 왜 사용하는지를 알고 쓰기.
//	}
	
}
