package BinarySearchTree;

public class printInRange {

    public static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null; 
        }
    }

    public static Node createTree(Node root, int val){
        if(root == null){
            return new Node(val);
        }
        if(val > root.val){
            root.right = createTree(root.right, val);
        }else{
            root.left = createTree(root.left, val);
        }
        return root;
    }

    public static void inRange(Node root, int x, int y){
        if (root == null) {
            return;
        }
        if (root.val >= x && root.val <= y) {
            System.out.print(root.val + " ");
        }
        if(root.val > y){
            inRange(root.left, x, y);
        }else if(root.val < x){
            inRange(root.right, x, y);
        }else{
            inRange(root.left, x, y);
            inRange(root.right, x, y);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,1,3,4,2,7};
        Node root = null;
        for(int i : arr){
            root = createTree(root, i);
        }
        inRange(root, 2, 4);
    }
}
