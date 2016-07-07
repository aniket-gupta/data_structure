package string;

public class PatternMatching {

	public static void main(String[] args) {
		
		String string = "000010001010001";
		String pattern = "0001";
		
		naivePatternMatcher(string.toCharArray(), pattern.toCharArray());

	}

	// Complexity O((m-n)*n) = O(m*n)
	public static void naivePatternMatcher(char[] T, char[] P) {
		int m = T.length;
		int n = P.length;
		for (int i = 0; i < m - n + 1; i++) {
			int j = 0;
			for(; j < n; j++) {
				if(P[j] != T[i+j])
					break;
			}
			if(j == n)
				System.out.println("Pattern found at index " + i);
		}
	}
	
	public static void computePrefixFunction(char[] P) {
		int[] pi = new int[P.length];
		pi[0] = 0;
		int i = 0;
		int j = 1;
		while(j < P.length) {
			if(P[i] == P[j]) {
				pi[j] = i;
				i++;
				j++;
			} else {
				if(i == 0) {
					pi[j] = 0;
				} else {
					i = pi[i];
				}
			}
			
		}
		
		
	}

}
