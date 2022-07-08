import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestPaytm {

    public static void main(String[] args) {
/*
 1,2,3

 n=5

 1,1,1,1,1
 1,2,2
 1,3,1,1
 1,3,2
 3



1-> {2->{3,2->{5}}}


1->2->{
1,3->{4,5}}
2->1


 */
//        Node node = new Node(1,
//                Arrays.asList(new Node(2, Arrays.asList(new Node(3,null),new Node(4,
//                Arrays.asList(new Node(5,null)))))));

//        Node node=new Node(1,
//                Arrays.asList(new Node(2
//                        ,Arrays.asList(new Node(3,
//                        Arrays.asList(new Node(4,
//                                Arrays.asList(new Node(2,null),new Node(5,null))))),
//                        new Node(4,null)))));
//
//
//        int[] color=new int[6];
//        System.out.println(iterate(node,color));


        System.out.println(new TestPaytm().steps(4));
    }


/*


           1      ----------
            -----2----3----4
                          |
                          5
 */

/*

color 1,2,3,4
      1,1,1,1

 */

   static boolean iterate(Node node,int[] color) { //2
        if(color[node.data]==0) {
            color[node.data]=1;
            System.out.println(node.data);
            Boolean containsCycle=new Boolean(false);
            if (node.children != null) {

                for(Node child:node.children){ //2,5
                    if(containsCycle){

                        break;
                    }
                    containsCycle=containsCycle || iterate(child,color);
                }

            }

            color[node.data]=2;
            return containsCycle;
        }
        else {
            return true;
        }

    }

    int steps(int n){
      return findSteps(n,0,0);
    }
//n=5,sum=0,count=0;
    /*
    sum=1,count=0
    sum=1+1=2,
    sum=3,
    sum=4
    sum=5
    count=1;

    sum=4+2=6
    count=1
1,1,1
1,2
2,1
3

     */

    private int findSteps(int n, int sum,int count) {
       if(sum==n){
           count++;
           return count;
       }
       if(sum>n){
           return count;
       }
      count= findSteps(n,sum+1,count);
      count= findSteps(n,sum+2,count);
      count= findSteps(n,sum+3,count);

      return count;

    }
}
class  Node{

    int data;
    List<Node> children;

    public Node(int data, List<Node> children) {
        this.data = data;
        this.children = children;
    }
}

