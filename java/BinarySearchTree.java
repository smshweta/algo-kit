/* 
Binary Search Tree is a binary tree with following properties for each node in the tree:
    1. The left subtree has keys less than the current node
    2. The right subtree has keys more than the current node
    3. There are no duplicate nodes.

In worst case(skewed tree) height of bst is N.
In balanced tree height is O(log N)

Time Complexity
    inserting, searching and deleting node : O(h) h-> height of bst
Space Complexity
    inserting, searching and deleting node : O(h) -> auxiliary space to store recursion stack.
*/

// class TreeNode{
//     int val;
//     TreeNode left,right;

//     public TreeNode(int val){
//         this.val = val;
//         this.left = this.right = null;

//     }
// }
public class BinarySearchTree{
    TreeNode root;
    public BinarySearchTree(){
        this.root = null;
    }

    // Insertion
    public TreeNode insertNode(TreeNode root, int val){
        if(root == null)
            return new TreeNode(val);
        else if(val < root.val)
            root.left = insertNode(root.left, val);
        else if(val > root.val)
            root.right = insertNode(root.right, val);  
        return root;           
    }
    // Search 
    public boolean searchNode(TreeNode root, int val){
        if(root== null)
            return false;
        if(root.val == val)
            return true;
        else if(val < root.val)
            return searchNode(root.left, val);     
        else 
            return searchNode(root.right, val);            
    }
    // Delete

    public TreeNode deleteNode(TreeNode root, int val){
        if(root == null)
            return null;
        if(val < root.val)
            root.left = deleteNode(root.left, val);
        else if(val > root.val)  
            root.right = deleteNode(root.right, val);
        else{
            // value to be deleted is found
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                root.val = findSuccessor(root.right); // replace node by successor
                root.right = deleteNode(root.right, root.val);
            }

        }
        return root;         
    }
    private int findSuccessor(TreeNode root){
        int min = root.val;
        while(root.left != null){
          min = root.left.val;
          root = root.left;
        }
        return min;
    }
    public void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        int[] nodesToInsert = {50, 30, 70, 20, 40, 60, 80};
        for (int node : nodesToInsert) {
            bst.root = bst.insertNode(bst.root, node);
        }
        int searchValue = 40;
        System.out.println("Search for " + searchValue + ": " + bst.searchNode(bst.root, searchValue));

        // Delete a node
        int deleteValue = 30;
        bst.root = bst.deleteNode(bst.root, deleteValue);
        bst.printInOrder(bst.root);
    }
}
