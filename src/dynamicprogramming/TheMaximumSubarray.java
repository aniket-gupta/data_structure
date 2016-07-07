package dynamicprogramming;

import java.util.Scanner;

/*Given an array A={a1,a2,…,aN}A={a1,a2,…,aN} of NN elements, find the maximum possible sum of a

Contiguous subarray
Non-contiguous (not necessarily contiguous) subarray.
Empty subarrays/subsequences should not be considered.

Input Format

First line of the input has an integer TT. TT cases follow. 
Each test case begins with an integer NN. In the next line, NN integers follow representing the elements of array AA.

Constraints:

1≤T≤101≤T≤10
1≤N≤1051≤N≤105
−104≤ai≤104−104≤ai≤104
The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

Sample Input

2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
Explanation

In the first case: 
The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

In the second case: 
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum. 
For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
*/
public class TheMaximumSubarray {

	private static Scanner scanner;

	public static void main(String[] args) {

		long t;
		long n;
		long[] A;
		scanner = new Scanner(System.in);
		t = scanner.nextLong();
		while (t-- > 0) {
			n = scanner.nextLong();
			A = new long[(int) n];

			for (int i = 0; i < n; i++) {
				A[i] = scanner.nextLong();

				
			}
			 System.out.print(contiguousSubArrayOpt(A) + " ");
			 System.out.println(nonContigiousSubArray(A));

		}
	}

	public static long contiguousSubArrayOpt(long[] A) {
		long[] result = new long[A.length];
		result[0] = A[0];
		long max = result[0];
		
		
		for(int i = 1; i < A.length; i++) {
			result[i] = Math.max(result[i-1] + A[i], A[i]);
			max = (result[i] > max) ? result[i] : max; 
		}
		
		return max;
	}
	
	public static long contiguousSubArray(long[] A) {
		long max = -Long.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {
			int startIndex = i;
			for (int j = i + 1; j < A.length; j++) {

				int endIndex = j;
				long sum = 0;
				for (int k = startIndex; k <= endIndex; k++) {
					sum += A[k];
				}
				max = (sum > max) ? sum : max;
			}
		}

		return max;

	}

	public static long nonContigiousSubArray(long[] A) {
		long sum = 0;
		long maxNeg = 0;
		boolean posValPresent = false;

		for (int i = 0; i < A.length; i++) {

			if (!(A[i] < 0)) {
				posValPresent = true;
				sum += A[i];
			}

			if (A[i] < 0 && !posValPresent) {
				if (maxNeg == 0) {
					maxNeg = A[i];
				} else if (A[i] > maxNeg) {
					maxNeg = A[i];
				}

			}
		}

		return posValPresent ? sum : maxNeg;

	}

}
