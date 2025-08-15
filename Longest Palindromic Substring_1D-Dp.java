
// TC: O(n^2) — two nested loops over (i, j) and each check is O(1).
// SC: O(n) — the 1D dp array.

// Approach (5 sentences):
// Use dynamic programming where dp[j] indicates whether the substring s[j..i] (ending at current i) is a palindrome.
// For each i from left to right, scan j from i down to 0 so that when you read dp[j+1] it still represents the previous inner state (s[j+1..i-1]) and hasn’t been overwritten.
// If s[j] == s[i] and either the window length is ≤ 2 (i - j <= 1) or the inner substring is a palindrome (dp[j+1]), set dp[j] = true; otherwise set it to false.
// Whenever dp[j] is true, update the best window (start, end, max) if this palindrome is longer than the current best.
// Return s.substring(start, end + 1) at the end.


class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        int start = 0, end = 0;
        
        boolean[] dp = new boolean[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i-j <= 1 || dp[j+1]){
                        dp[j] = true;
                        if(max < i-j+1){
                            max = i-j+1;
                            start = j;
                            end = i;
                        }
                    }else{
                        dp[j] = false;
                    }
                }else{
                    dp[j] = false;
                }
            }
        }

        return s.substring(start, end+1);
    }
}
