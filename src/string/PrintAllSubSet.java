package string;

public class PrintAllSubSet {

	public static void main(String[] args) {
		
		String s = "ABCD";
		int[] A  = new int[s.length()];
		printSubset(A, s, 0);

	}
	
	public static void printSubset(int[] A, String s, int k) {
		
		if(k == A.length) {
			print(A, s);
			return;
		}
		A[k] = 0;
		printSubset(A, s, k + 1);
		A[k] = 1;
		printSubset(A, s, k + 1);		
	}
	
	public static void print(int[] A, String s) {
		for(int i = 0; i < s.length(); i++) {
			if(A[i] == 1) {
				System.out.print(s.charAt(i) + " ");
			}
		}
		System.out.println();
	}
	

}
