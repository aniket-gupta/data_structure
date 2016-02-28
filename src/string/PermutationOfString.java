package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//Permutations of a given string
public class PermutationOfString {

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		List<String> list = permutation("bcda");
		System.out.println("Time taken: " + (System.currentTimeMillis() - t1) + " ms");
		Collections.sort(list);
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("Itertavie way:");
		permutateIteratively("aaabbb".toCharArray());
	}

	public static List<String> permutation(String string) {
		return _permutate("", string);
	}

	private static List<String> _permutate(String prefix, String string) {
		
		List<String> list = new ArrayList<>();
		int len = string.length();
		if (len == 0) {
			list.add(prefix);
			return list;
		}
		for (int i = 0; i < len; i++) {
			list.addAll(_permutate(prefix + string.charAt(i), string.substring(0, i) + string.substring(i + 1, len)));
		}
		return list;
	}

	public static void permutateIteratively(char[] str) {
		/*
		 Following are the steps to print the permutations lexicographic-ally

		1. Sort the given string in non-decreasing order and print it. The first permutation is always the string sorted in non-decreasing order.
		
		2. Start generating next higher permutation. Do it until next higher permutation is not possible. If we reach a permutation where all characters are sorted in non-increasing order, then that permutation is the last permutation.
		
		Steps to generate the next higher permutation:
		1. Take the previously printed permutation and find the rightmost character in it, which is smaller than its next character. Let us call this character as ‘first character’.
		
		2. Now find the ceiling of the ‘first character’. Ceiling is the smallest character on right of ‘first character’, which is greater than ‘first character’. Let us call the ceil character as ‘second character’.
		
		3. Swap the two characters found in above 2 steps.
		
		4. Sort the substring (in non-decreasing order) after the original index of ‘first character’.
		 */
		int size = str.length;
		Arrays.sort(str);
		boolean isFinished = false;
		while (!isFinished) {
			System.out.println(join(str));
			int i;
			for(i = size - 2; i >= 0; --i) {
				if (str[i] < str[i+1])
	                break;
			}
			if (i == -1) {
				isFinished = true;
			} else {
				int ceilIndex = findCeil(str, str[i], i + 1, size - 1);
				swap(str, i, ceilIndex);
				reverse( str, i + 1, size - 1 );
			}
			
		}
	}

	public static String join(char[] arr) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			stringBuffer.append(arr[i]);
		}
		return stringBuffer.toString();

	}
	
	public static int findCeil(char str[], char first, int l, int h)
	{
	    // initialize index of ceiling element
	    int ceilIndex = l;
	 
	    // Now iterate through rest of the elements and find
	    // the smallest character greater than 'first'
	    for (int i = l+1; i <= h; i++)
	        if (str[i] > first && str[i] < str[ceilIndex])
	            ceilIndex = i;
	 
	    return ceilIndex;
	}
	
	public static void swap(char[] arr, int x, int y) {
		char tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	public static void reverse(char str[], int l, int h)
	{
	   while (l < h)
	   {
	       swap(str, l, h);
	       l++;
	       h--;
	   }
	}
}
