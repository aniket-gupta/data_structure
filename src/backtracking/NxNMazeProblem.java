package backtracking;

public class NxNMazeProblem {

	public static void main(String[] args) {
		int N = 4;
		int[][] M = new int[][]{
				{1,1,0,0},
				{1,1,0,0},
				{0,1,1,0},
				{1,0,1,1}
		};
		
		int[][] sol = new int[N][N];
		solveMaze(M, 0, 0, sol);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(sol[i][j] + "\t");
			}
			System.out.println();
		}

	}

	
	public static boolean isValidNove(int M[][], int i, int j) {
		if (i >= 0 && i < M.length && j >= 0 && j < M.length && M[i][j] == 1) {
			return true;
		}
		return false;
	}
	
	public static boolean solveMaze(int M[][], int x, int y, int sol[][]) {
		if(x == M.length - 1 && y == M.length -1) {
			sol[x][y] = 1;
			return true;
		}
		if(isValidNove(M, x, y)) {
			sol[x][y] = 1;
			if(solveMaze(M, x+1, y, sol))
				return true;
			if(solveMaze(M, x, y+1, sol))
				return true;
			sol[x][y] = 0; // Backtrack
			return false;
		}
		return false;
	}
}
