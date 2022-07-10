package Tree;

class Node {
    int data;
    Node left, right;

    int height;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}