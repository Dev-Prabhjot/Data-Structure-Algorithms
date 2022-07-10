package Tree;

public class HeightIdenticalBalancedTree {
    /*
              1
             / \
            2   3
           / \ / \
          4   56  7D
             /   / \
            8   9  10

           height: 4
           isBalanced: True

              1
             / \
            2   3
           / \ / \
          4   56  7
             /   / \
            8   9  10
           /
         12

         height:5
         isBalanced: false

   */

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        // root.left.right.left.left = new Node(12);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        System.out.println("Height of tree:");
        System.out.println(height(root));
        System.out.println("Is height balanced:");
        isBalanced(root);
        System.out.println(flag);


        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        System.out.println("Is Identical tree:");
        System.out.println(identicalTrees(root, root));
        System.out.println(identicalTrees(root2, root));
    }

    public static int height(Node root) {
        if (root == null) return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);

        int totalHeight = Math.max(lheight, rheight) + 1;

        return totalHeight;

    }

    static boolean flag = true;

    public static int isBalanced(Node root) {
        if (root == null) return 0;

        int lheight = isBalanced(root.left);
        int rheight = isBalanced(root.right);

        int diff = Math.abs(lheight - rheight);
        if (diff > 1) {
            flag = false;
        }

        int totalHeight = Math.max(lheight, rheight) + 1;
        return totalHeight;
    }

    public static boolean identicalTrees(Node root1, Node root2) {
        if (root1 == null || root2 == null) return root1 == root2;

        return root1.data == root2.data && identicalTrees(root1.left, root2.left) && identicalTrees(root1.right, root2.right);

    }
}
