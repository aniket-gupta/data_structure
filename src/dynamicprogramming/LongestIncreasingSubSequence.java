package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int[] A = new int[]{3,4,-1,0,6,2,3};
		System.out.println(LIS(A));
		
		A = new int[]{2,5,1,8,3};
		System.out.println(LIS(A));
	}
	
	public static int LIS(int[] A) {
		int[] sol = new int[A.length];
		Arrays.fill(sol, 1);
		int n = A.length -1;
		int max = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				if(A[i] > A[j]) {
					sol[i] = Math.max(sol[i], sol[j] + 1);
					max = Math.max(sol[i], max);
				}
			}
		}
		for(int k = 0; k < sol.length; k++) {
			System.out.print(" " + sol[k]);
		}
		System.out.println();
		return max;
	}

}
