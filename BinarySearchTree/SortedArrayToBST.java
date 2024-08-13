package BinarySearchTree;

public class SortedArrayToBST {

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

    public static Node createBalancesBST(int[] arr, int first, int last){
        if(first == last){
            return new Node(arr[first]);
        }
        int mid = (last - first)/2 + first;
        Node root = new Node(arr[mid]);
        root.left = createBalancesBST(arr, first, mid-1);
        root.right = createBalancesBST(arr, mid+1, last);
        return root;
    }

    public static void inorder(Node root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,8,10,11,12};
        Node root = createBalancesBST(arr, 0, arr.length-1);
        inorder(root);
    }
}
