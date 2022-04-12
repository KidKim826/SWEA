package SWEA;

import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반 {
	
	static int N; //직원
	static int B; //비교 탑 높이
	static int[] employee; //직원 배열
	static int min; //최소 차이
	static boolean[] sel; //박문철이
	static int top; //사실상 필요없더라 //만들수 있는 탑 최대높이 S //
	static int sum;	//경우의 수 따져서 더한 탑의 높이
	static int ans; //탑 - 비교탑 (탑차)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			B = sc.nextInt();
			top = 0;
			employee = new int[N];
			for(int i = 0; i < N; i++) {
				employee[i] = sc.nextInt();
				top += employee[i]; 
			}
			//입력받기 종료
			
			min = Integer.MAX_VALUE;
			sel = new boolean[N];
			perm(0);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	
		static void perm(int idx) { //powerset
			
			if(idx == sel.length && sel.length >= 2) {
				sum = 0;
				ans = 0;
				for(int i = 0; i < sel.length; i++) {
					if(sel[i]) {
						sum+=employee[i];
//						System.out.print(employee[i]);
					}
				}
				
				if(sum >= B) {
					ans = Math.abs(sum - B); //탑차	
					if(ans <= min) {
						min = ans;
					}
				}else {
					return;
				}
				
				return;
			}
			
				//뽑고가고
				sel[idx] =true;
				perm(idx+1);
				
				//안뽑고가고
				sel[idx] = false;
				perm(idx+1);
			
			
		}
	
	
}
