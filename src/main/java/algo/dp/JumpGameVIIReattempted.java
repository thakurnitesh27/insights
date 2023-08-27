package algo.dp;
//https://leetcode.com/problems/jump-game-vii/description/

public class JumpGameVIIReattempted {

    public static void main(String[] args) {

        System.out.println(new JumpGameVIIReattempted().canReach("011010",2,3));
    }

    boolean canReach(String s, int minJump, int maxJump){

        char[] chars=s.toCharArray();
        boolean [] canReachFromEachIndex=new boolean[chars.length];

        if(chars[chars.length-1]=='0'){
            canReachFromEachIndex[chars.length-1]=true;
        }
        else {
            return false;
        }
        for(int i=chars.length-2;i>=0;i--){
            if(chars[i]=='1'){
                continue;
            }
            for(int j=i+minJump;j<=Math.min(chars.length-1,i+maxJump);j++){
                if(chars[j]=='0' && canReachFromEachIndex[j]){
                   canReachFromEachIndex[i]=true;
                   break;
                }
            }
        }

        return canReachFromEachIndex[0];
    }
}
