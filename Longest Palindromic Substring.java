// **TC:** `O(n^2)` — each index can be the center for odd and even expansions, and each expansion can scan outward up to `O(n)`.
// **SC:** `O(1)` — constant extra space (a few integers), no DP table.

// **Approach (5 sentences):**
// You expand around every possible center to find the longest palindromic substring.
// For each index `i`, expand once with `(i, i)` for odd-length palindromes and (optionally) with `(i, i+1)` for even-length palindromes.
// During each expansion, move two pointers outward while the characters match, then compute the palindrome bounds when the match breaks.
// Track the best window using `start`, `end`, and `max` whenever a longer palindrome is found.
// Finally, return `s.substring(start, end + 1)` as the longest palindrome.


class Solution {
    int max;
    int start, end;

    public String longestPalindrome(String s) {
        int  n = s.length();
        this.max = 0;
        start = 0; end = 0;

        for(int i=0; i<n; i++){
            //odd length
            extendsAround(s, i, i);
            //even length
            if(i < n-1 && s.charAt(i) == s.charAt(i+1)){
                extendsAround(s, i, i+1);
            }
        }

        return s.substring(start, end+1);
    }

    private void extendsAround(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        left++;   
        right--;

        if(max < right-left+1){
            max = right - left + 1;
            start = left;
            end = right;
        }
    }
}
