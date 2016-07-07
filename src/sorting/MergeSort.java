package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] A  = new int[] {12, 11, 13, 5, 6, 7};
		for (int i = 0; i < A.length; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.println();
		mergeSort(A, 0, A.length -1);
		for (int i = 0; i < A.length; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.println();
	}

	public static void mergeSort(int[] A, int l, int h) {
		if (l < h) {
			int mid = (l + h) / 2;
			mergeSort(A, l, mid);
			mergeSort(A, mid + 1, h);
			merge(A, l, mid, h);
		}
	}

	public static void merge(int[] A, int l, int mid, int h) {
		int[] L = new int[mid - l + 1];
		int[] R = new int[h - mid];

		for (int i = 0; i < L.length; i++) {
			L[i] = A[l + i];
		}

		for (int i = 0; i < R.length; i++) {
			R[i] = A[mid + 1 + i];
		}
		
		int i = 0;
		int j = 0;
		int k = l;
		
		while (i < L.length && j < R.length) {
			
			if(L[i] < R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
			k++;
		}
		
		while (i < L.length) {
			A[k] = L[i];
			i++;
			k++;
		}
		while (j < R.length) {
			A[k] = R[j];
			j++;
			k++;
		}
	}

}
