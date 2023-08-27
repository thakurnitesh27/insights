package algo.misc;

import java.util.Arrays;

public class FriendsOfAppropriateAges {
    /*
    age[y] <= 0.5 * age[x] + 7
    age[y] > age[x]
    age[y] > 100 && age[x] < 100

     */
    public static void main(String[] args) {
//        System.out.println(numFriendRequests(new int[]{16, 16}));
//        System.out.println(numFriendRequests(new int[]{16, 17,18}));
//        System.out.println(numFriendRequests(new int[]{20,30,100,110,120}));
        System.out.println(numFriendRequests(new int[]{49,110,13,39,45,104,9,114,86,72,13,24,10,77,103,85,9,21,66,25}));

    }

    public static int numFriendRequests(int[] ages){
        return 0;
    }

    //works but TLE comes

    public static int numFriendRequestsOld(int[] ages) {

        Arrays.sort(ages);
        int ans = 0;

        for (int i = 0; i < ages.length; i++) {
            int x = ages[i];
            Double agelimit = ((double) (0.5 * (double) x)) + 7;

            innerloop:
            for (int j = i - 1; j >= 0; j--) {
                int y = ages[j];

                if (y <= agelimit.intValue() || (x < 100 && y > 100) ||y>x) {
                    break innerloop;
                } else {
                    ans++;
                }
            }

           innerloop: for(int j=i+1;j<ages.length;j++){
              int y=ages[j];

              if(y<=agelimit.intValue() || (x<100 && y>100) || y>x){
                  break innerloop;
              }
              else {
                  ans++;
              }
            }
        }

        return ans;

    }
}
