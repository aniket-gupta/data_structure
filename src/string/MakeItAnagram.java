package string;

import java.util.Scanner;

/*
 * Alice recently started learning about cryptography and found that anagrams are very useful. Two strings are anagrams of each other if they have same character set (and frequency of characters) and same length. For example strings "bacdc" and "dcbac" are anagrams, while strings "bacdc" and "dcbad" are not.

Alice decides on an encryption scheme involving 2 large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. She need your help in finding out this number.

Given two strings (they can be of same or different length) help her in finding out the minimum number of character deletions required to make two strings anagrams. Any characters can be deleted from any of the strings.

Input Format 
Two lines each containing a string.

Constraints 
1 <= Length of A,B <= 10000 
A and B will only consist of lowercase latin letter.

Output Format 
A single integer which is the number of character deletions.

Sample Input #00:

cde
abc
Sample Output #00:

4
Explanation #00: 
We need to delete 4 characters to make both strings anagram i.e. 'd' and 'e' from first string and 'b' and 'a' from second string.
 */
public class MakeItAnagram {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String firstStr = reader.nextLine();
		String secondStr = reader.nextLine();
		int[] freqOfCharsInFirstStr = new int[26];
		int[] freqOfCharsInSecStr = new int[26];
		for (int i = 0 ; i < firstStr.length(); i++) {
			char ch = firstStr.charAt(i);
			freqOfCharsInFirstStr[ch - 'a']++;
		}
		for (int i = 0 ; i < secondStr.length(); i++) {
			char ch = secondStr.charAt(i);
			freqOfCharsInSecStr[ch - 'a']++;
		}
		int noOfCharToDel = 0;
		for (int i = 0; i < freqOfCharsInFirstStr.length; i++ ) {
			if(freqOfCharsInFirstStr[i] != freqOfCharsInSecStr[i])
				noOfCharToDel += (freqOfCharsInFirstStr[i] > freqOfCharsInSecStr[i])? (freqOfCharsInFirstStr[i] - freqOfCharsInSecStr[i]): (freqOfCharsInSecStr[i]-freqOfCharsInFirstStr[i] );
		}
		System.out.println(noOfCharToDel);
		reader.close();

	}

}
