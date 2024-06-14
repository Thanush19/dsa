public class Solution {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> answer = new ArrayList<>();

		int n = words.length;

		if (n == 1) {
			return answer;
		}

		char[][] words_ = new char[n][];

		int[] tables = new int[n];

		for (int i = 0; i < n; i++) {
			int table = 0;

			char[] word = words[i].toCharArray();

			words_[i] = word;

			for (int j = 0; j < word.length; j++) {
				table ^= 1 << (word[j] - 'a');
			}

			tables[i] = table;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}

				int bits = tables[i] ^ tables[j];

				if (bits != 0 && ((bits & (bits - 1)) != 0)) {
					continue;
				}

				if (isPalindromeConcat(words_[i], words_[j])) {
					answer.add(List.of(i, j));
				}
			}
		}

		return answer;
	}

	private boolean isPalindromeConcat(char[] s1, char[] s2) {
		char[] w1 = s1;

		char[] w2 = s2;

		int x = 0;

		int y = w2.length - 1;

		while (w1 != w2 || x <= y) {
			if (y < 0 && x == w1.length) {
				return true;
			}

			if (y < 0) {
				w2 = w1;

				y = w2.length - 1;
			}

			if (x == w1.length) {
				w1 = w2;

				x = 0;
			}

			if (w1 == s2 && w2 == s1) {
				return true;
			}

			if (w1[x] != w2[y]) {
				return false;
			}

			++x;

			--y;
		}

		return true;
	}
}