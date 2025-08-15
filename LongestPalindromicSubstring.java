**Time Complexity (TC)**

* **O(n²)**: We iterate over all possible substrings in two nested loops (outer loop for substring length difference `diff`, inner loop for start index `i`), and each DP state is computed in O(1).

**Space Complexity (SC)**

* **O(n²)**: The `dp` table stores whether every substring `s[i...j]` is a palindrome, which requires `n × n` boolean space.

**Approach (5 sentences)**

1. We use a **Dynamic Programming** table `dp[i][j]` to store whether the substring from index `i` to `j` is a palindrome.
2. Initialize base cases: all single characters are palindromes (`dp[i][i] = true`), and check all substrings of length 2 for equality.
3. Then, for substrings of length ≥ 3, `dp[i][j]` is true if the first and last characters match and the substring between them (`dp[i+1][j-1]`) is also a palindrome.
4. While filling `dp`, we keep track of the `start` and `end` indices of the longest palindrome found so far.
5. Finally, return the substring between `start` and `end` as the longest palindromic substring.

  class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
            if (i != n - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    start = i;
                    end = i + 1;
                }
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
