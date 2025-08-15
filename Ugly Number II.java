// TC : O(N)
// SC : O(N) dp table.

class Solution {
    public int nthUglyNumber(int n) {
        int []ans = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        ans[0]=1;
        for(int i=1;i<n;++i){
            int min = Math.min(n2, n3 > n5 ? n5 : n3);
            ans[i] = min;
            if(n2 == min){
                p2++;
                n2 = 2 * ans[p2];
            }
            if(n3 == min){
                p3++;
                n3 = 3 * ans[p3];
            }
            if(n5 == min){
                p5++;
                n5 = 5 * ans[p5];
            }
        }
        return ans[n-1];
    }
}
