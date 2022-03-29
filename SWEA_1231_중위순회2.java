package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1231_중위순회2 {
	static char[] imTree;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			imTree = new char[N+1];		
			
			for(int i = 1; i <= N; i++) {
				//char 배열로 받고 
				char[] find = br.readLine().toCharArray();
				
				//알파벳이나 '_' 인경우만 imTree 배열에 담아준다.
				for(int j = 0; j < find.length; j++) {
					if(find[j] >= 65 && find[j] <= 90 || find[j] == 95) {
						imTree[i] = find[j];
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			inOrder(1);
			System.out.println();
		}
	}
	//중위 순회
	public static void inOrder(int idx) {
		
		if(idx > N) {
			return;
		}
		//왼쪽
		inOrder(idx*2);
		System.out.print(imTree[idx]);
		//오른쪽
		inOrder(idx*2+1);
	}
}
