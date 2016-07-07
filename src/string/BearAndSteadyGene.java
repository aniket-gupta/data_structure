package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class BearAndSteadyGene {

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int n = Integer.parseInt(in.nextLine());
			int maxOccurences = n / 4;
			String gene = in.nextLine();
			String dna = "ACGT";
			int[] count = new int[4];
			for (int i = 0; i < count.length; i++)
				count[i] = 0 - maxOccurences;

			for (int i = 0; i < gene.length(); i++) {
				count[dna.indexOf(gene.charAt(i))]++;
			}
			
			int startIndex = -1;
			int endIndex = -1;
			
			if(count[0] == 0 && count[1] == 0 && count[2] == 0 && count[3] == 0)
				System.out.println(0);
			else {
//				for (int i = 0; i < count.length; i++) {
//					System.out.print(count[i] + " ");
//				}
				int[] tmp = count.clone();
				int i = 0;
				while(i < gene.length()) {
					if (count[dna.indexOf(gene.charAt(i))] > 0) {
						count[dna.indexOf(gene.charAt(i))]--;
						if(startIndex == -1) {
							startIndex = i;
						} else {
							endIndex = i;
						}
					}
					i++;
				}

			}
			

		} finally {
			in.close();
		}
	}

}
