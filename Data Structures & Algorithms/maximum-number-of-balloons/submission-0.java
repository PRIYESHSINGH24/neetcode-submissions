class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map=new HashMap<>();
        for(char t:text.toCharArray()) {
            map.put(t,map.getOrDefault(t,0)+1);
        }
        int ans=Integer.MAX_VALUE;
        ans=Math.min(ans,map.getOrDefault('b',0));
        ans=Math.min(ans,map.getOrDefault('a',0));
        ans=Math.min(ans,map.getOrDefault('n',0));
        ans=Math.min(ans,(map.getOrDefault('l',0)/2));
        ans=Math.min(ans,(map.getOrDefault('o',0)/2));

        return ans;
    }
}