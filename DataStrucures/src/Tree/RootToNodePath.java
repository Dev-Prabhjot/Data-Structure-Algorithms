package Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    /*
           1
          / \
         2   3
        / \ / \
       4   56  7
          /   / \
         18   9  10

*/
    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(18);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        List<Integer> arr = new ArrayList<>();
        findPath(root, arr, new Node(18));
        arr.stream().forEach(System.out::println);

        System.out.println("LCA:" + lowestCommonAncestor(root, root.left.left, root.left.right.left).data);

        List<Integer> arr1 = new ArrayList<>();
        System.out.println("Path sum:");
        pathSumRootToNode(root, arr1, 26    );
        arr1.stream().forEach(System.out::println);


        Node rt=new Node(-10);
        rt.left=new Node(9);
        rt.right=new Node(20);
        rt.right.left=new Node(15);
        rt.right.right=new Node(7);

        System.out.println("MAX Path sum:");

        //Using array as Integer is immutable and hence when passed to method its value is not changed
        //Instead we pass array reference and change value at its first index
        int[] maxi={Integer.MIN_VALUE};
        maxPathSum(root,maxi);
        System.out.println(maxi[0]);
    }
   static int maxi=Integer.MIN_VALUE;
    private static boolean findPath(Node root, List<Integer> arr, Node x) {

        if (root == null)
            return false;

        arr.add(root.data);
        if (root.data == x.data)
            return true;

        if (findPath(root.left, arr, x) || findPath(root.right, arr, x))
            return true;

        arr.remove(arr.size() - 1);

        return false;

    }


    private static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q)
            return root;

        Node left = lowestCommonAncestor(root.left, p, q);

        Node right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else return root;
    }


    private static boolean pathSumRootToNode(Node root, List<Integer> arr, int x) {
        if (root == null)
            return false;

        arr.add(root.data);

        if (root.data == x)
            return true;
        /*
         * For root to leaf node path sum
         * Add check for leaf node and sum
         *   if (root.left == null && root.right == null && root.data==x)
         *
         * return true;
         *
         * */
//        if (root.left == null && root.right == null && root.data==x)
//            return true;
        if (pathSumRootToNode(root.left, arr, x - root.data) || pathSumRootToNode(root.right, arr, x - root.data))
            return true;
        arr.remove(arr.size() - 1);

        return false;
    }

    public static int maxPathSum(Node root,int[] maxi) {

        if (root == null)
        return 0;

        int left=Math.max(0,maxPathSum(root.left,maxi));
        int right=Math.max(0,maxPathSum(root.right,maxi));

        maxi[0]=Math.max(maxi[0], root.data+ left+ right);

        return root.data + Math.max(left,right);

    }
}

