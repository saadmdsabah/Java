package BinarySearchTree;

import java.util.ArrayList;

public class binarysearchtree {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            // case 1:
            if(root.left == null && root.right == null){
                return null;
            }

            // case 2:
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            
            // case 3:
            else{
                Node IS = inorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static boolean search(Node root,int val){
        if(root == null){
            return false;
        }

        if(root.data == val){
            return true;
        }
        else if(val > root.data){
            return search(root.right, val);
        }
        else{
            return search(root.left, val);
        }
    }

    public static void printinRange(Node root,int x,int y){
        if (root == null) {
            return;
        }
        if(root.data >=x && root.data <=y){
            printinRange(root.left, x, y);
            System.out.print(root.data + ' ');
            printinRange(root.right, x, y);
        }
        else if(root.data >= y){
            printinRange(root.left, x, y);
        }
        else{
            printinRange(root.right, x, y);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    // Lowest Common Ancestor
    public Node lca(Node root, Node p, Node q){
        if(root == null || root == p || root == q){
            return root;
        }
        Node left = lca(root.left,p,q);
        Node right = lca(root.right,p,q);
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return root;
        }
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if (root == null) {
            return;
        }
        path.add(root.data);
        if(root.right == null && root.left == null){
            printPath(path);
        }
        else{
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};
        Node root = null;

        for(int i : values){
            root = insert(root, i);
        }
        inorder(root);
        System.out.println();
        delete(root, 3);
        inorder(root);
    }
}
