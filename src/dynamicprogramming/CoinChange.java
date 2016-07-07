package dynamicprogramming;

/*Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
*/
public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
		int[] S = new int[] { 1, 2, 3 };
		System.out.println(coinChange_dp(S, N, S.length));

	}

	public static int coinChange(int[] S, int N, int m) {
		if (N == 0)
			return 1;
		if (N < 0)
			return 0;
		if (m <= 0 && N >= 1)
			return 0;
		// 1. including the mth coin
		// 2. excluding mth coin
		return coinChange(S, N, m - 1) + coinChange(S, N - S[m - 1], m);
	}

	public static int coinChange_dp(int[] S, int N, int m) {
		int[][] dp = new int[N + 1][m];
		for (int i = 0; i < m; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < m; j++) {
				// including S[j]
				int x = (i - S[j]) >= 0 ? dp[i - S[j]][j] : 0;
				// excluding s{j]
				int y = (j >= 1) ? dp[i][j - 1] : 0;
				dp[i][j] = x + y;
			}
		}
		return dp[N][m - 1];
	}

}
