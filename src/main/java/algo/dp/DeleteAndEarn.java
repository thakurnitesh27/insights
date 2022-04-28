package algo.dp;

//https://leetcode.com/problems/delete-and-earn/


import java.util.Arrays;
import java.util.HashMap;

public class DeleteAndEarn {
    //
    public static void main(String[] args) {

       //   System.out.println(findMaximumEarningNew(new int[]{3, 7, 10, 5, 2, 4, 8, 9, 9, 4, 9, 2, 6, 4, 6, 5, 4, 7, 6, 10}));//66
     //   System.out.println(findMaximumEarningNew(new int[]{3, 1}));//66
      //  System.out.println(findMaximumEarningNew(new int[]{3}));//66
        ///2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,7,7,8,9,9,9,10,10
        /*4,12,16,20,18,14,8,27,20
        i==2
        a=4;b=12
        temp=max(a+16,12)
        a=b=12;
        b=temp=20
        --
        i=3
        temp=max(a+20,20)
        a=20,
        b=12+20=32
        --
        i=4
        temp=max(a+18,32)
        a=32



         */
        System.out.println(findMaximumEarningNew(new int[]{8, 7, 3, 8, 1, 4, 10, 10, 10, 2})); //52
        // System.out.println(findMaximumEarning(new int[]{3, 4, 2}));
        System.out.println(findMaximumEarningNew(new int[]{2, 2, 3, 3, 3, 4}));

    }

    static int findMaximumEarningNew(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int data = arr[i];
            if (data < min) {
                min = data;
            }
            if (data > max) {
                max = data;
            }
            int count = map.getOrDefault(data, 0);
            count++;
            map.put(data, count);
        }

        int ans = find(map, min, max, new HashMap<>());
        return ans;

    }

    static int find(HashMap<Integer, Integer> map, int num, int max, HashMap<Integer, Integer> response) {
        if (num <= max) {
            int numPlus2Val = 0;
            if (response.get(num + 2) == null) {
                numPlus2Val = find(map, num + 2, max, response);
                response.put(num + 2, numPlus2Val);
            }
            else {
                numPlus2Val=response.get(num+2);
            }


            int temp = num * map.getOrDefault(num, 0) + numPlus2Val;
            int numPlus1Val = 0;
            if (response.get(num + 1) == null) {
                numPlus1Val =  find(map, num + 1, max, response);
                response.put(num + 1, numPlus1Val);
            }
            else {
                numPlus1Val=response.get(num+1);
            }


            int ans = Math.max(temp,numPlus1Val);
            return ans;
        }
        return 0;
    }

    static int findMaximumEarning(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            int data = arr[i];
            int count = map.getOrDefault(data, 0);
            count++;
            map.put(data, count);
        }

        // Arrays.sort(arr);
        int ans = 0;
        // int maximumProfit = 0;
        while (map.size() > 0) {

            int minimumLoss = Integer.MAX_VALUE;
            int maxProfit = Integer.MIN_VALUE;
            int elementToRemove = -1;
            for (Integer currentNum : map.keySet()) {
                //  int currentNum = arr[i];
                int loss = 0;
                if (map.containsKey(currentNum - 1)) {
                    loss += (currentNum - 1) * map.get(currentNum - 1);
                }
                if (map.containsKey(currentNum + 1)) {
                    loss += (currentNum + 1) * map.get(currentNum + 1);
                }
                int profit = currentNum * (map.get(currentNum)) - loss;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    elementToRemove = currentNum;
                } else if (profit == maxProfit && currentNum > elementToRemove) {
                    maxProfit = profit;
                    elementToRemove = currentNum;
                }
//                if (loss < minimumLoss) {
//                    minimumLoss = loss;
//                    elementToRemove = currentNum;
//                }
//                else if(loss==minimumLoss && currentNum>elementToRemove){
//                    minimumLoss = loss;
//                    elementToRemove = currentNum;
//                }

            }
            ans += elementToRemove * map.get(elementToRemove);
//            if(map.get(elementToRemove)==1){
//                map.remove(elementToRemove);
//            }else{
//                map.put(elementToRemove, map.get(elementToRemove) - 1);
//            }
            map.remove(elementToRemove);
            map.remove(elementToRemove - 1);
            map.remove(elementToRemove + 1);

        }
        return ans;

    }
}
