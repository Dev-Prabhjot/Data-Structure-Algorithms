package Tree;

import java.util.ArrayList;

public class TreeTraversalRecursive {

    /*
          1
         / \
        2   3
       / \ / \
      4   56  7
         /   / \
        8   9  10

*/
    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrderTraversal(root, preOrder);

        System.out.print("The preOrder Traversal is : ");
        print(preOrder);

        ////////////////
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);

        System.out.print("The inOrder Traversal is : ");
        print(inOrder);

        //////////////////
        ArrayList<Integer> postOrder = new ArrayList<>();
        postOrderTraversal(root, postOrder);

        System.out.print("The postOrder Traversal is : ");
        print(postOrder);

    }

    static void print(ArrayList<Integer> preOrder) {
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i) + " ");
        }
        System.out.println();
    }

    //Root,Left,Right
    private static void preOrderTraversal(Node root, ArrayList<Integer> preOrder) {
        if (root == null)
            return;

        preOrder.add(root.data);
        preOrderTraversal(root.left, preOrder);
        preOrderTraversal(root.right, preOrder);
    }

    //Left,Root,Right
    private static void inOrderTraversal(Node root, ArrayList<Integer> inorder) {
        if (root == null)
            return;

        inOrderTraversal(root.left, inorder);
        inorder.add(root.data);
        inOrderTraversal(root.right, inorder);
    }

    //Left,Right,Root
    private static void postOrderTraversal(Node root, ArrayList<Integer> postorder) {
        if (root == null)
            return;

        postOrderTraversal(root.left, postorder);
        postOrderTraversal(root.right, postorder);
        postorder.add(root.data);
    }
}
