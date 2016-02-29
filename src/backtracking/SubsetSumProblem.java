package backtracking;

public class SubsetSumProblem {

	public static void main(String[] args) {
		
		int[] A = new int[] {2,3,4,5};
		int[] sol = new int[A.length];
		findSubsetSum(A, 0, 0, 7, sol);

	}
	
	public static void findSubsetSum(int[] A, int currSum, int index, int sum, int[] sol) {
		
		if(currSum == sum) {
			for(int i = 0; i < sol.length; i++) {
				if(sol[i] == 1) {
					System.out.print(" " + A[i]);
				}
			}
			System.out.println();
		} else if (index == A.length) {
			return;
		} else {
			
			sol[index] = 1; // select the element
			currSum += A[index];
			findSubsetSum(A, currSum, index + 1, sum, sol);
			currSum -= A[index];
			sol[index] = 0; // do not select the element
			findSubsetSum(A, currSum, index + 1, sum, sol);
		}
	}

}
