class Solution {
    public boolean validPalindrome(String s) {
        boolean a = false;
        int i=0,j=s.length()-1;
        int previ=-1;
        int prevj=-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                if (!a) {
                    a = true;
                    previ = i;      
                    prevj = j-1;
                    i++;        
                }else if(previ != -1) {
                    i = previ;
                    j = prevj;
                    previ=-1;
                } else {
                    return false;
                }
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}