package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mergesort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			int[] tmp = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			mergeSort(arr, tmp, 0, N-1);
			System.out.print("#"+tc+" ");
			for(int i = 0; i < N; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if(start < end) { //시작점이 끝점보다 작으면
			int mid = (start+end)/2; // 중간값을 찾아주고 // 구간을 두개로
			mergeSort(arr, tmp, start, mid); // 병합정렬 해준다.
			mergeSort(arr, tmp, mid+1, end); //병합정렬 해준다.
			merge(arr, tmp, start, mid, end);
		}
	}
	
	public static void merge(int[] arr, int[]tmp, int start, int mid, int end) {
		
		int left = start; //분할된 왼쪽 배열 시작점
		int right = mid+1; //분할된 오른쪽 배열 시작점
		
		int idx = start; //정렬될 값들 저장하는 인덱스
		
		while(left <= mid && right <= end) { // idx값이 
			if(arr[left] <= arr[right]) { // 값이 작다면
				tmp[idx] = arr[left]; // 
				idx++;
				left++;
			}else {
				tmp[idx] = arr[right];
				idx++;
				right++;
			}
		}
		
		//왼쪽이 다 정렬되면 오른 쪽 부분들을 옮겨줘
		if(left>mid) {
			for(int i = right; i <= end; i++) {
				tmp[idx] = arr[i];
				idx++;
			}
		} else {
			for(int i = left; i <= mid; i++) {
				tmp[idx] = arr[i];
				idx++;
			}
		}
		
		//원래 배열에 정렬된 데이터 넣어주기
		for(int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
		
	}
}
