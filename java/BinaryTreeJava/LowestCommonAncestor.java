package BinaryTreeJava;

public class LowestCommonAncestor {

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

    public static Node lowestAncestor(Node root, int val1, int val2){
        if(root == null || root.val == val1 || root.val == val2){
            return root;
        }
        Node leftNode = lowestAncestor(root.left, val1, val2);
        Node rightNode = lowestAncestor(root.right, val1, val2);

        if(leftNode == null){
            return rightNode;
        }else if(rightNode == null){
            return leftNode;
        }else{
            return root;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = createTree(arr);
        Node node = lowestAncestor(root, 4, 5);
        System.out.println(node.val);
    }
}
