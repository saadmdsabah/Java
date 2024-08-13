package Pratice;

public class temp {

    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node builderTree(int val, Node root){
        if(root == null){
            return new Node(val);
        }
        if(root.val == val){
            return root;
        }
        if(val > root.val){
            root.right = builderTree(val, root.right);
        }else{
            root.left = builderTree(val, root.left);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val +  " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        int[] val = {1,3,2,5,2,5,5,5,3,3,1};
        for(int i : val){
            root = builderTree(i, root);
        }
        inorder(root);
    } 
}
