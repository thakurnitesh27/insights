package tree;

public class MergeTwoTree {
    public static void main(String[] args) {

        TreeNode a=new TreeNode(2,new TreeNode(1,new TreeNode(5),null),new TreeNode(4));
        TreeNode b=new TreeNode(3,
                new TreeNode(6,null,new TreeNode(2)),
                new TreeNode(1,null,new TreeNode(7)));

        TreeNode merged=new MergeTwoTree().merge(a,b);

        System.out.println(merged);

    }

    TreeNode merge(TreeNode a,TreeNode b){

        if(a!=null && b!=null){

            a.val=a.val+b.val;

            a.left=merge(a.left,b.left);
            a.right=merge(a.right,b.right);
            return a;
        }
        if(a==null && b!=null){
            return b;
        }
        if(a!=null && b==null){
            return a;
        }

        return null;

    }
}
