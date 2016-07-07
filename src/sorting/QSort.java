package sorting;

import java.util.Random;

public class QSort {

	public static void main(String[] args) {
		Random random = new Random();
		byte[] A = new byte[11];
		random.nextBytes(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.println();
		qsort(A, 0, A.length -1);
		for (int i = 0; i < A.length; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.println();
	}
	
	public static void qsort(byte[] a, int l, int h) {
		if(l < h) {
			int p = partition(a, l, h);
			qsort(a, l, p);
			qsort(a, p+1, h);
		}
	}
	
	public static int partition(byte[] a, int l, int h) {
		int p = l;
		int i = l + 1;
		int j = h;
		while (true) {
			
			while (a[i] < a[p] && i < h) {
				i++;
			}
			while (a[j] > a[p] && j > l) {
				j--;
			}
			
			if(i >= j)
				break;
			int tmp = a[i];
			a[i] = a[j];
			a[j] = (byte) tmp;
		}
		
		int tmp = a[p];
		a[p] = a[j];
		a[j] = (byte) tmp;
		return j;
	}

}
