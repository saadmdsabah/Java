package BinaryTreeJava;

public class CreateTree {

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

    static int index = -1;
    public static Node createTree(int array[]){
        index++;
        if(array[index] == -1){
            return null;
        }
        Node newNode = new Node(array[index]);
        newNode.left = createTree(array);
        newNode.right = createTree(array);
        return newNode;
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
        int[] arr = {4,2,-1,7,-1,-1,3,5,-1,-1,9,-1,-1};
        Node root = createTree(arr);
        inorder(root);
    }
}
