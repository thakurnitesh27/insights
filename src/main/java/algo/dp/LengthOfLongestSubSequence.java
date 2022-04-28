package algo.dp;

public class LengthOfLongestSubSequence {


   int findLongest(int [] arr)
    {
        if(arr==null||arr.length==0)
            return 0;
//int largest=0;
        int res[]=new int[arr.length];
        int res1[]=new int[arr.length];

       // int mid=(int)Math.ceil((arr.length-1)/2);
        res[0]=1;
        for(int i=1;i<arr.length;i++)
        {
            res[i]=1;
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j]&&res[i]<=res[j])
                {
                    res[i]=res[j]+1;

                }
            }
        }





//        res1[0]=1;
//        for(int i=1;i<arr.length;i++)
//        {
//            res1[i]=1;
//            for (int j=0;j<i;j++)
//            {
//                if(arr[j]>arr[i]&&res1[i]<=res1[j])
//                {
//                    res1[i]=res1[j]+1;
//                }
//
//            }
//        }

        res1[0]=1;
        for(int i=arr.length-1;i>=0;i--)
        {
            res1[i]=1;
            for (int j=arr.length-1;j>i;j--)
            {
                if(arr[j]<arr[i]&&res1[i]<=res1[j])
                {
                    res1[i]=res1[j]+1;
                }

            }
        }
//        for(int i=mid+1;i<arr.length;i++)
//        {
//            if(arr[i]<=lastNum)
//            {
//                lastNum=arr[i];
//                decCount++;
//            }
//        }
//        if(decCount==0)
//            return 0;
       // return res[arr.length-1];
        int ans=0;

        for(int i=0;i<res.length;i++)
        {
            if(res[i]+res1[i]>ans)
                ans=res[i]+res1[i];
        }
        return ans-1;
    }


    public static void main(String[] args) {

       LengthOfLongestSubSequence lengthOfLongestSubSequence=new LengthOfLongestSubSequence();
     //  int []arr=new int[]{1,2,3,4,5,6,7,8,9,10};
     //  int []arr=new int[]{1,3,5,6,4,8};
       //int []arr=new int[]{};
       //int []arr=new int[]{1, 11,2,10,4,5,2,1,1 };
       //int []arr=new int[]{8, 6, 3, 4, 2, 1 };
//       int []arr=new int[]{6,5,4,3,2,2 };
       int []arr=new int[]{1,2,3,3,3,4,5,6,6,5  };
        System.out.println(lengthOfLongestSubSequence.findLongest(arr));
    }
}
