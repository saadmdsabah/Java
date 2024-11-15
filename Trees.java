import java.util.LinkedList;
import java.util.Queue;

public class Trees {

  static class Node {

    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode createTree(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (root.val < val) {
      root.right = createTree(root.right, val);
    } else if (root.val > val) {
      root.left = createTree(root.left, val);
    }
    return root;
  }

  public static void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
  }

  public static void postorder(TreeNode root) {
    if (root == null) {
      return;
    }
    postorder(root.right);
    postorder(root.left);
    System.out.print(root.val + " ");
  }

  public static void preorder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static TreeNode create() {
    int[] arr = { 3, 6, 1, 8, 0, 2, 7 };
    TreeNode root = null;
    for (int i : arr) {
      root = createTree(root, i);
    }
    return root;
  }

  public static void levelOrderTraversal(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while (!q.isEmpty()) {
      TreeNode curr = q.remove();
      if (curr == null) {
        if (q.isEmpty()) {
          break;
        } else {
          System.out.println();
          q.add(null);
        }
      } else {
        System.out.print(curr.val + " ");
        if (curr.left != null) {
          q.add(curr.left);
        }
        if (curr.right != null) {
          q.add(curr.right);
        }
      }
    }
  }

  public static int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }

  public static int noOfNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftNo = noOfNodes(root.left);
    int rightNo = noOfNodes(root.right);
    return leftNo + rightNo + 1;
  }

  public static TreeNode lca(TreeNode root, int a, int b) {
    if (root == null || root.val == a || root.val == b) {
      return root;
    }

    TreeNode leftRoot = lca(root.left, a, b);
    TreeNode rightRoot = lca(root.right, a, b);
    if (leftRoot == null) {
      return rightRoot;
    } else if (rightRoot == null) {
      return leftRoot;
    } else {
      return root;
    }
  }

  public static int minDistance(TreeNode root, int a, int curr) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    if (root.val == a) {
      return curr;
    }
    int leftvalue = minDistance(root.left, a, curr + 1);
    int rightvalue = minDistance(root.right, a, curr + 1);

    return Math.min(leftvalue, rightvalue);
  }

  public static void main(String[] args) {
    TreeNode root = create();
    //          3
    //         / \
    //        1   6
    //       / \   \
    //      0  2    8
    //             /
    //            7
    TreeNode lca = lca(root, 0, 6);
    System.out.println(lca.val);
    int mina = minDistance(lca, 6, 0);
    int minb = minDistance(lca, 8, 0);
    System.out.println(mina + minb);
  }
}
