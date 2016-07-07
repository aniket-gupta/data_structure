package dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		BigInteger A = BigInteger.valueOf(scanner.nextInt());
		BigInteger B = BigInteger.valueOf(scanner.nextInt());
		int N = scanner.nextInt();
		scanner.close();
		BigInteger[] DP = new BigInteger[ N];
				
		DP[0] = A;
		DP[1] = B;
		//Tn = (Tn-1)2 + Tn -2
		
		for (int i = 2; i < N; i++) {
			
			BigInteger i_2 = DP[i-2];
			BigInteger i_1 = DP[i-1];
			
			DP[i] =  i_2.add(i_1.pow(2));
		}
		
		System.out.println(DP[N-1]);

	}
	
	

}
