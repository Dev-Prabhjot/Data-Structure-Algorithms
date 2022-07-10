package Tree;

import java.util.*;

public class TreeTraversaslIterative {

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

        System.out.print("The inOrder Traversal is : ");
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root);

        System.out.println("The preOrder Traversal is : ");

        preOrderTraversal(root);


//        System.out.println("The postOrder Traversal is : ");
//TBC
//        postOrderTraversal(root);

        System.out.println("Level Order Traversal:");
        levelOrder(root);

        System.out.println("Level Order Traversal Level Wise:");
        List<List<Integer>> levelWiseElementList = levelOrderLevelWise(root);
        printList(levelWiseElementList);

        System.out.println("Level Order Traversal Zigzag:");
        List<List<Integer>> levelZigZagList = levelOrderZigZag(root);
        printList(levelZigZagList);
    }

    private static void printList(List<List<Integer>> levelWiseElementList) {
        for (List<Integer> l1 : levelWiseElementList) {
            for (Integer n : l1) {
                System.out.print(n + " ");
            }

            System.out.println();
        }
    }

    private static void inOrderTraversal(Node root) {

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || stack.size() > 0) {
            //move till left most node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            //print
            System.out.println(curr.data);
            //Move to right node
            curr = curr.right;
        }
    }

    private static void preOrderTraversal(Node root) {

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        stack.push(curr);


        while (stack.size() > 0) {
            Node node = stack.pop();
            System.out.println(node.data);

            if (node.left != null)
                preOrderTraversal(node.left);

            if (node.right != null)
                preOrderTraversal(node.right);
        }
    }

//    private static void postOrderTraversal(Node root) {
//
//        Stack<Node> stack=new Stack<>();
//        Node curr=root;
//        stack.push(curr);
//
//
//        while (stack.size()>0)
//        {
//            Node node=stack.peek();
//
//
//            if(node.left!=null)
//                postOrderTraversal(node.left);
//
//           else if (node.right!=null)
//                postOrderTraversal(node.right);
//           else {
//               Node newNode=stack.pop();
//               System.out.println(newNode.data);}
//        }
//    }

    private static void levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }

    }

    private static List<List<Integer>> levelOrderLevelWise(Node root) {

        List<List<Integer>> wrapList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //no of elements on level n = queue size
            int levelNum = queue.size();
            //Sublist to add elements on level n
            List<Integer> subList = new ArrayList<>();
            //Iterate over each element at level n
            for (int i = 0; i < levelNum; i++) {
                Node node = queue.poll();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

                subList.add(node.data);
            }
            //add element List at level n to wrapList
            wrapList.add(subList);

        }
        return wrapList;
    }

    //Same as level order traversal
    //Only change is how to add element to sublist
    //If flag true add to back
    //If flag false add to front list.add(0,node.data)
    private static List<List<Integer>> levelOrderZigZag(Node root) {

        List<List<Integer>> wrapList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            //no of elements on level n = queue size
            int levelNum = queue.size();
            //Sublist to add elements on level n
            List<Integer> subList = new ArrayList<>();
            //Iterate over each element at level n
            for (int i = 0; i < levelNum; i++) {
                Node node = queue.poll();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

                if (flag)
                    subList.add(node.data);
                else
                    subList.add(0, node.data);
            }
            flag = !flag;
            //add element List at level n to wrapList
            wrapList.add(subList);

        }
        return wrapList;
    }
}
