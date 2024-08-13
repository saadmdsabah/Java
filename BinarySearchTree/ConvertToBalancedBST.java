package BinarySearchTree;

import java.util.ArrayList;

public class ConvertToBalancedBST {

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

    public static Node createBalancesBST(ArrayList<Integer> list, int first, int last){
        if(first == last){
            return new Node(list.get(first));
        }
        int mid = (last - first)/2 + first;
        Node root = new Node(list.get(mid));
        root.left = createBalancesBST(list, first, mid-1);
        root.right = createBalancesBST(list, mid+1, last);
        return root;
    }

    public static void inorder(Node root, ArrayList<Integer> list){
        if (root == null) {
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public static void main(String[] args) {
        int[] arr = {8,6,5,3,10,11,12};
        Node root = null;
        for(int i : arr){
            root = createTree(root, i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        for(int i : list){
            System.out.print(i + " ");
        }
        root = createBalancesBST(list, 0, list.size()-1);
        System.out.println();
        list.clear();
        inorder(root, list);
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}
