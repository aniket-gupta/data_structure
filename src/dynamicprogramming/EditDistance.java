package dynamicprogramming;

/*
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.

Insert
Remove
Replace
All of the above operations are of equal cost.

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a

*/
public class EditDistance {

	public static void main(String[] args) {
//		String X = "un";
//		String Y = "atur";
//		System.out.println(editDistance(X.toCharArray(), X.length() - 1, Y.toCharArray(), Y.length() - 1));
		String X = "cat";
		String Y = "cut";
		System.out.println(editDistance_dp(X.toCharArray(), X.length(), Y.toCharArray(), Y.length()));

	}

	public static int editDistance(char[] X, int m, char[] Y, int n) {
		if (n == 0) { // if first string is null then we have to create a string
						// by inserting m elements from Y
			return m;
		} else if (m == 0) { // if first string is null then we have to create a
								// string by inserting m elements from Y
			return n;
		} else if (X[m] == Y[n]) { // chars matched check next chars
			return editDistance(X, m - 1, Y, n - 1);
		} else {
			return 1 + min(editDistance(X, m, Y, n - 1), // insert
					editDistance(X, m - 1, Y, n), // remove
					editDistance(X, m - 1, Y, n - 1) // replace
			);
		}
	}

	public static int min(int a, int b, int c) {
		if (a < b && a < c) {
			return a;
		} else if (b < a && b < c) {
			return b;
		} else {
			return c;
		}
	}

	public static int editDistance_dp(char[] X, int m, char[] Y, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if(X[i-1] == Y[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
				}
			}
		}
		return dp[m][n];
	}
}
