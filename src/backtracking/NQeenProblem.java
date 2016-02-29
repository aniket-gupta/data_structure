package backtracking;

public class NQeenProblem {
	
	static final int N = 4;
	
	public static int [][] board  = new int[N][N];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveNQeen(board, 0);
		
		printSolution(board);

	}
	
	/* A utility function to print solution */
    static void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    }
    
    static boolean solveNQeen(int board[][], int col) {
    	/*base case: all queens are placed*/
    	if(col >= N)
    		return true;
    	
    	// Consider this column and try to place this queen in all rows one by one
    	for(int i = 0; i < N; i++) {
    		// check if queen can be placed at board[i][col]
    		if(isSafe(board, i, col)) {
    			// place queen at board[i][col]
    			board[i][col] = 1;
    			
    			// recur for rest of the queens
    			if(solveNQeen(board, col + 1))
    				return true;
    			/* If placing queen in board[i][col]
                doesn't lead to a solution then
                remove queen from board[i][col] */
    			board[i][col] = 0; // BACKTRACK
    		}
    	}
    	return false;
    }
	
    static boolean isSafe(int board[][], int row, int col) {
    	
    	//check row on left side
    	for(int i = 0; i < col; i ++) {
    		if(board[row][i] == 1) 
    			return false;
    	}
    	
    	// check upper diagonal on left side
    	for(int i = row, j = col; i >=0 && j>=0; i--, j--) {
    		if(board[i][j] == 1)
    			return false;
    	}
    	
    	// check lower diagonal on left
    	for(int i = row, j = col; i < N && j>=0; i++, j--) {
    		if(board[i][j] == 1)
    			return false;
    	}
    	
    	return true;
    }
    
    
	

}
