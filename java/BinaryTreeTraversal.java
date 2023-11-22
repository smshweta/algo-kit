/* Time complexity = O(N) N -> no of nodes in tree
   Space complexity = O(1) */

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTreeTraversal {

    /* Post-order traversal: Left, Right, Root
       Application:
        To delete the tree.
        To get postfix of expression tree */
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    /* Pre-order traversal: Root, Left, Right
        Application:
            To copy the tree.
            To get prefix of expression tree */
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /* In-order traversal: Left, Root, Right
       Gives element in no-decreasing order */
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Post-order traversal:");
        postOrder(root);
        System.out.println();

        System.out.println("Pre-order traversal:");
        preOrder(root);
        System.out.println();

        System.out.println("In-order traversal:");
        inOrder(root);
        System.out.println();
    }
}

