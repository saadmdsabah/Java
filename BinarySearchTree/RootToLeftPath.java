package BinarySearchTree;

import java.util.ArrayList;

public class RootToLeftPath {

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

    public static void pathToLeft(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null){
            System.out.println(list);
        }
        pathToLeft(root.left, list);
        pathToLeft(root.right, list);
        list.remove(list.size() - 1);
    }
    public static void main(String[] args) {
        int[] arr = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i : arr){
            root = createTree(root, i);
        }
        pathToLeft(root, new ArrayList<Integer>());
    }
}
