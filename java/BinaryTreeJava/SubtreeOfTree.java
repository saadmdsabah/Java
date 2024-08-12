package BinaryTreeJava;

public class SubtreeOfTree {

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

    public static boolean checkSubTree(Node root, Node subtreeNode){
        if(root == null && subtreeNode == null){
            return true;    
        }
        if(root == null || subtreeNode == null){
            return false;
        }
        if(root.val == subtreeNode.val){
            return checkSubTree(root.left, subtreeNode.left) && checkSubTree(root.right, subtreeNode.right);
        }else{
            return false;
        }
    }

    public static boolean isSubTree(Node root, Node subtreeNode){
        if(root == null && subtreeNode == null || subtreeNode == null){
            return true;    
        }
        if(root == null){
            return false;
        }
        if(root.val == subtreeNode.val){
            return checkSubTree(root, subtreeNode);
        }
        return isSubTree(root.left, subtreeNode) || isSubTree(root.right, subtreeNode);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = createTree(arr);
        Node subTree = new Node(2);
        subTree.left = new Node(4);
        subTree.right = new Node(5);
        System.out.println(isSubTree(root, subTree));
    }
}
