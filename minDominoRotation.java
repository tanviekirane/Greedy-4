// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length == 0) return 0;
        int result = check(tops,bottoms, tops[0]);
        if(result != -1) return result;
        return check(tops, bottoms, bottoms[0]);
    }
    private int check(int[] tops, int[] bottoms, int target){
        int topRot = 0;
        int bottomRot = 0;
        
        for(int i=0; i<tops.length; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) topRot++;
            if(bottoms[i] != target) bottomRot++;
        }
        return Math.min(topRot, bottomRot);
    }
}

// *********************************************
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// surely find probable candidate
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1; int n = tops.length;
        
        for(int i=0; i< n; i++){
            int top = tops[i];
            int cnt = map.getOrDefault(top, 0);
            if(cnt+1 == n){
                target = top;
            } else{
                map.put(top, cnt+1);
            }
            int bottom = bottoms[i];
            int cnt1 = map.getOrDefault(bottom, 0);
            if(cnt1+1 == n){
                target = bottom;
            } else{
                map.put(bottom, cnt1+1);
            }
        }
        return check(tops, bottoms, target);
    }
    private int check(int[] tops, int[] bottoms, int target){
        int topRot = 0;
        int bottomRot = 0;
        
        for(int i=0; i<tops.length; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) topRot++;
            if(bottoms[i] != target) bottomRot++;
        }
        return Math.min(topRot, bottomRot);
    }
}