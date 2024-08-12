package BinaryTreeJava;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if(temp == null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                else{
                    queue.add(null);
                }
            }else{
                System.out.print(temp.val + " ");
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = createTree(arr);
        inorder(root);
        System.out.println();
        levelOrder(root);
    }
}
