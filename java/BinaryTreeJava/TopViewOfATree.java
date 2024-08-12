package BinaryTreeJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfATree {

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
        int index;
        Node node;
        public NodeInfo(Node node, int index){
            this.index = index;
            this.node = node;
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

    public static TreeMap<Integer,Node> treeFromTop(Node root){
        if (root == null) {
            return new TreeMap<>();
        }
        // Creating a HashMap to track the index and the node occuping that index
        TreeMap<Integer, Node> map = new TreeMap<>();

        // Creating a Queue to get the level type of indexing
        Queue<NodeInfo> queue = new LinkedList<>();
        NodeInfo rootInfo = new NodeInfo(root, 0);
        queue.add(rootInfo);
        queue.add(new NodeInfo(null, 0));

        while (!queue.isEmpty()) {
            NodeInfo temp = queue.remove();
            if(!map.containsKey(temp.index)){
                map.put(temp.index, temp.node);
            }
            if(temp.node == null){
                if(queue.isEmpty()){
                    return map;
                }
                else{
                    queue.add(new NodeInfo(null,0));
                }
            }else{
                if(temp.node.left != null){
                    queue.add(new NodeInfo(temp.node.left, temp.index - 1));
                }
                if(temp.node.right != null){
                    queue.add(new NodeInfo(temp.node.right, temp.index + 1));
                }
            }
        }
        return map;
    }
    public static void main(String[] args) {

        // DID IT BY MY SELF WITHOUT ANY HELP ALHAMDULILAH!!!

        // int[] arr = {1,2,4,-1,-1,5,-1,-1,3,4,-1,-1,6,-1,-1};
        int[] arr = {1,2,-1,4,-1,5,-1,6,-1,-1,3,-1,-1};
        Node root = createTree(arr);
        TreeMap<Integer, Node> map = treeFromTop(root);
        for(int i : map.keySet()){
            System.out.print(map.get(i).val + " ");
        }
    }
}