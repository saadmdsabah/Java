package BinaryTreeJava;

public class DiameterOfTreeON {

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

    public static class TreeInfo {
        int diameter;
        int height;
        public TreeInfo(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
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

    public static int heightTree(Node root){
        if (root == null) {
            return 0;
        }
        return Math.max(heightTree(root.left), heightTree(root.right)) + 1;
    }

    public static TreeInfo diameterTree(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }
        TreeInfo leftNode = diameterTree(root.left);
        TreeInfo rightNode = diameterTree(root.right);
        int diam = Math.max(leftNode.diameter, Math.max(rightNode.diameter, leftNode.height + rightNode.height + 1));
        int hei = Math.max(leftNode.height, rightNode.height) + 1;
        return new TreeInfo(diam, hei);
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = createTree(arr);
        TreeInfo tf = diameterTree(root);
        System.out.println("Diameter of the Tree is " + tf.diameter + " and it's Height is " + tf.height);
    }
}
