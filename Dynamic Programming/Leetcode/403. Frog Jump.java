// https://leetcode.com/problems/frog-jump/
// method 01--> using array dp--. best explanation in notes
class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        boolean dp[][]=new boolean[n][n];
        dp[0][1]=true;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int step=stones[i]-stones[j];
                if(step<n && dp[j][step]==true){
                    if(step+1<n)  dp[i][step+1]=true; // k+1
                     if(step-1>=0)  dp[i][step-1]=true; //k-1
                      dp[i][step]=true; //k
                    
                      if(i==n-1) return true; // means frog reach at last stone
                }
            }
        }
        return false;
    }
}

// method 02--> using HashMap
class Solution {
    public boolean canCross(int[] stones) {
        if(stones.length==0) return true;
        int n=stones.length;
        HashMap<Integer,HashSet<Integer>>hm=new HashMap<>();
        // here key mapping to stones and value mapping to step
        for(int i=0;i<n;i++){
            hm.put(stones[i],new HashSet<Integer>());
        }
        hm.get(0).add(1);//1 is step
        for(int i=0;i<n-1;i++){
            int stone=stones[i];
            // now find step for respective stone
            for(int step:hm.get(stone)){
                int reach=step+stone;
                if(reach==stones[n-1]){
                    return true;
                }
                // else do operation for adding step
                if( hm.get(reach)!=null){// means stone position available
                    hm.get(reach).add(step);// for k
                    if(step-1>0) // for k-1
                    hm.get(reach).add(step-1);
                    hm.get(reach).add(step+1); // for k+1
                }
            }
        }
        return false;
    }
}
/*
Use map to represent a mapping from the stone (not index) to the steps that can be taken from this stone.
so this will be
[0,1,3,5,6,8,12,17]
{0=[1], 1=[1, 2], 3=[1, 2, 3], 5=[1, 2, 3], 6=[1, 2, 3, 4], 8=[1, 2, 3, 4], 12=[3, 4, 5],17=[4,5,6]}
Notice that no need to calculate the last stone.
On each step, we look if any other stone can be reached from it, if so, we update that stone's steps by adding step, step + 1, step - 1.
If we can reach the final stone, we return true. No need to calculate to the last stone.
*/
