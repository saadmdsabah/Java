package BinarySearchTree;

public class DeleteNodeFromBST {

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

    public static void inorder(Node root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static Node successor(Node root){
        while (root.left!=null) {
            root = root.left;
        }
        return root;
    }

    public static Node deleteNode(Node root, int data){ 
        if(root.val > data){
            root.left = deleteNode(root.left, data);
        }else if(root.val < data){
            root.right = deleteNode(root.right, data);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            Node ls = successor(root.right);
            root.val = ls.val;
            root.right = deleteNode(root.right, ls.val);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,3,4,2,7};
        Node root = null;
        for(int i : arr){
            root = createTree(root, i);
        }
        inorder(root);
        root = deleteNode(root, 3);
        System.out.println();
        inorder(root);
    }
}
