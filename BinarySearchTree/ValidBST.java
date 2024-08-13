package BinarySearchTree;

public class ValidBST {

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

    public static boolean validBSTree(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val){
            return false;
        }
        if(max!=null && root.val >= max.val){
            return false;
        }
        return validBSTree(root.left, min, root) && validBSTree(root.right, root, max);
    }

    public static void main(String[] args) {
        int[] arr = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i : arr){
            root = createTree(root, i);
        }
        System.out.println(validBSTree(root,null,null));
    }
}
