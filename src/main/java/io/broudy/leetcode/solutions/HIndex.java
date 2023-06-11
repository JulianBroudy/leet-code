package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/h-index">274. H-Index</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class HIndex {
	public static void main(String[] args) {
		int[] citations = new int[]{3, 0, 6, 1, 5};
		System.out.println(hIndex(citations));
	}

	private static int hIndex(int[] citations) {
		if (citations.length == 1) {
			return citations[0] == 0 ? 0 : 1;
		}
		final int[] citationOccurrences = new int[1001];
		int highestNumber = 0;
		for (Integer citation : citations) {
			citationOccurrences[citation]++;
			if (citation > highestNumber) highestNumber = citation;
		}
		for (int i = highestNumber; i > 0; i--) {
			citationOccurrences[i - 1] += citationOccurrences[i];
			if (citationOccurrences[i] >= i) return i;
		}
		return 0;
	}

}
