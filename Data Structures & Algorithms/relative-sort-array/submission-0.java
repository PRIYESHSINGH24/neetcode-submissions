class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] hash = new int[1001];
        for(int i = 0;i<arr1.length;i++) {
            hash[arr1[i]]++;
        }
        int[] res = new int[arr1.length];
        int j = 0;
        for(int i = 0;i<arr2.length;i++) {
            int el = arr2[i];
            while(hash[el] > 0){
                res[j] = el;
                j++;
                hash[el]--;
            }
        }
        for(int i = 0;i<hash.length;i++) {
            while(hash[i] > 0 && j<arr1.length) {
                res[j] = i;
                hash[i]--;
                j++;
            }
        }
        return res;
    }
}