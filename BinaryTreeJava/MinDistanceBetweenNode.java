package BinaryTreeJava;

public class MinDistanceBetweenNode {

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
    public static class NodeInfo {
        int distance;
        Node root;
        public NodeInfo(Node root, int distance){
            this.root = root;
            this.distance = distance;
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

    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.val == n){
            return 0;
        }
        int left = lcaDist(root.left, n);
        int right = lcaDist(root.right, n);

        if(left==-1 && right==-1){
            return -1;
        }else if(left == -1){
            return right + 1;
        }else{
            return left + 1;
        }
    }

    public static int minDistance(Node root, int val1, int val2){
        Node lca = lowestAncestor(root, val1, val2);
        int dist1 = lcaDist(lca,val1);
        int dist2 = lcaDist(lca,val2);

        return dist1 + dist2;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,7,-1,-1,6,-1,-1};
        Node root = createTree(arr);
        int dist = minDistance(root, 4, 6);
        System.out.println(dist);
    }
}
