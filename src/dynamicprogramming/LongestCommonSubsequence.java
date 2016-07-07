package dynamicprogramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X= "ABCDGH";
		String Y = "AEDFHR";
//		System.out.println(LCS(X.toCharArray(), X.length() - 1, Y.toCharArray(), Y.length() - 1));
		System.out.println(LCS_DP(X.toCharArray(), X.length() , Y.toCharArray(), Y.length()));
		X= "AGGTAB";
		Y = "GXTXAYB";
//		System.out.println(LCS(X.toCharArray(), X.length() - 1, Y.toCharArray(), Y.length() - 1));
		System.out.println(LCS_DP(X.toCharArray(), X.length(), Y.toCharArray(), Y.length()));
	}

	public static int LCS(char[] X, int i, char[] Y, int j) {
		
		if (i < 0 || j < 0) // Base case if we are not selecting a char from either of the string
			return 0;
		if (X[i] == Y[j])
			return 1 + LCS(X, i - 1, Y, j - 1);
		else
			return Math.max(LCS(X, i - 1, Y, j), LCS(X, i, Y, j - 1));
	}
	
	public static int LCS_DP(char[] X, int m, char[] Y, int n) {
		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i <= m; i++) {
			dp[i][0] = 0;
		}
		for(int i = 0; i <= n; i++) {
			dp[0][i] = 0;
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <=n; j++) {
				if(X[i-1] == Y[j-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
}
