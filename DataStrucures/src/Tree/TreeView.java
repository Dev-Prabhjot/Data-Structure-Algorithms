package Tree;

import java.util.*;

public class TreeView {
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


        System.out.println("Left View of tree:");
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> leftView = leftViewOfTree(root, list);
        leftView.forEach(System.out::println);

        System.out.println("Right View of tree:");
        ArrayList<Integer> list2 = new ArrayList<>();
        List<Integer> rightView = rightViewOfTree(root, list2);
        rightView.forEach(System.out::println);

        System.out.println("Top View of tree:");
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> topView = topViewOfTree(root, list3);
        topView.forEach(System.out::println);


        System.out.println("Bottom View of tree:");
        ArrayList<Integer> list4 = new ArrayList<>();
        List<Integer> bottomView = bottomViewOfTree(root, list4);
        bottomView.forEach(System.out::println);

        System.out.println("Diagnol Traversal of tree:");
        ArrayList<Integer> list5 = new ArrayList<>();
        List<Integer> diagnolTraversal = diagonalViewOfTree(root, list5);


    }

    private static List<Integer> leftViewOfTree(Node root, ArrayList<Integer> list) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelNum = queue.size();

            for (int i = 0; i < levelNum; i++) {
                Node node = queue.poll();
                if (i == 0)
                    list.add(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

            }
        }

        return list;
    }

    private static List<Integer> rightViewOfTree(Node root, ArrayList<Integer> list) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelNum = queue.size();

            for (int i = 0; i < levelNum; i++) {
                Node node = queue.poll();
                if (i == levelNum - 1)
                    list.add(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

            }
        }

        return list;
    }


    private static List<Integer> topViewOfTree(Node root, ArrayList<Integer> res) {

        Queue<Node> queue = new LinkedList<>();
        root.height = 0;
        queue.add(root);
        //Sorted keys needed level wise hence used treemap
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {


            Node node = queue.poll();
            int hd = node.height;

            if (map.get(hd) == null) map.put(hd, node.data);

            //Left = hd-1
            if (node.left != null) {
                node.left.height = hd - 1;
                queue.add(node.left);
            }

            //right = hd+1
            if (node.right != null) {
                node.right.height = hd + 1;
                queue.add(node.right);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }


        return res;
    }

    private static List<Integer> bottomViewOfTree(Node root, ArrayList<Integer> res) {

        Queue<Node> queue = new LinkedList<>();
        root.height = 0;
        queue.add(root);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {


            Node node = queue.remove();
            int hd = node.height;

            map.put(hd, node.data);

            //Left = hd-1
            if (node.left != null) {
                node.left.height = hd - 1;
                queue.add(node.left);
            }

            //right = hd+1
            if (node.right != null) {
                node.right.height = hd + 1;
                queue.add(node.right);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }


        return res;
    }

    private static List<Integer> diagonalViewOfTree(Node root, ArrayList<Integer> res) {

        Queue<Node> queue = new LinkedList<>();
        root.height = 0;
        queue.add(root);

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        while (!queue.isEmpty()) {


            Node node = queue.remove();
            int hd = node.height;

            map.putIfAbsent(node.height, new ArrayList<>());
            map.get(node.height).add(node.data);

   /* For diagnol View comment above condition and add this one

   if(!map.containsKey(hd))
            {
                map.put(hd,new ArrayList<>());
                map.get(hd).add(node.data);
            }
   */

            //Left = hd+1
            if (node.left != null) {
                node.left.height = hd + 1;
                queue.add(node.left);
            }

            //right = hd
            if (node.right != null) {
                node.right.height = hd;
                queue.add(node.right);
            }

        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println("Level " + entry.getKey());
            entry.getValue().forEach(x -> {
                System.out.print(x + " ");
            });
            System.out.println();
        }


        return res;
    }

}

