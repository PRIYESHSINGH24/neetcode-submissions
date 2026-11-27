class Solution {
    public int numberOfMatches(int n) {
        int sum=0;
        while(n!=1){
            int val;
            if(n%2==0){
                val=n/2;
                n=n/2;
            }else{
                val=(n-1)/2;
                n=(n-1)/2;
                sum++;
            }
            sum+=val;
        }
        return sum;
    }
}