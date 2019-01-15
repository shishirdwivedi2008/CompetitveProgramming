package binarytree;

public class BinaryTree {

	public BTNode root;

	public BinaryTree(int data) {
		root = new BTNode(data);
	}

	public void inorderTraversal(BTNode root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);

	}

	/**
	 * Find Maximum Element in binary Tree
	 * 
	 * @param root
	 * @return
	 */
	public int findMaxElement(BTNode root) {
		int max_left = 0;
		int max_right = 0;
		int max, root_val = 0;
		if (root != null) {
			root_val = root.data;
			max_left = findMaxElement(root.left);
			max_right = findMaxElement(root.right);
		}
		if (max_left > max_right)
			max = max_left;
		else
			max = max_right;
		if (root_val > max)
			return root_val;
		else
			return max;

	}

	/**
	 * Search an Element in Binary tree
	 * 
	 * @param root
	 * @param element
	 * @return
	 */
	public boolean searchElement(BTNode root, int element) {

		if (root == null)
			return false;
		if (root.data == element)
			return true;
		else {
			boolean found = searchElement(root.left, element);
			if (found)
				return true;
			else {
				return searchElement(root.right, element);
			}
		}

	}

	/**
	 * Find the size of binary tree. +1 is added for root element.(Total number of
	 * nodes)
	 * 
	 * @param root
	 * @return
	 */
	public int findSize(BTNode root) {
		if (root == null)
			return 0;
		else
			return (findSize(root.left) + 1 + findSize(root.right));
	}
	
	
	/**
	 * Method to insert a node in binary tree.
	 * @param root
	 * @param data
	 * @return
	 */
	public BTNode insertNode(BTNode root , int data) {
		if(root==null) {
			root=new BTNode(data);
			return root;
		}
		else if(root.data>data)
			root.left=insertNode(root.left, data);
		else
			root.right=insertNode(root.right, data);
		
		return root;
		
		
	}

	/**
	 * Method to delete complete binary tree.
	 * @param root
	 */
	public void deleteBinaryTree(BTNode root) {
		if(root ==null)
			return;
		deleteBinaryTree(root.left);
		deleteBinaryTree(root.right);
		root=null;
		
	}
	
	/**
	 * Find height of a  binary tree
	 * @param root
	 * @return
	 */
	public int getHeight(BTNode root) {
		if (root==null)
			return 0;
		int left=getHeight(root.left);
		int right=getHeight(root.right);
		if(left>right)
			return right+1;
		else return left+1;
		
	}
	/**
	 * Method to Print level order of a Tree.
	 * @param root
	 */
	public void printLevelOrder(BTNode root) {
		int height=getHeight(root);
		for(int i=1;i<=height;i++) {
			printLevel(root, i);
		}
	}
	
	/**
	 * Method to print level order.
	 * @param root
	 * @param level
	 */
	public void printLevel(BTNode root, int level) {
		if(root==null)
			return;
		if(level==1)
			System.out.println(root.data);
		printLevel(root.left, level-1);
		printLevel(root.right, level-1);
					
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(4);
		tree.root.left.right = new BTNode(5);
		tree.root.right.left = new BTNode(6);
		tree.root.right.right = new BTNode(7);
		// tree.inorderTraversal(tree.root);
		/*System.out.println(tree.findMaxElement(tree.root));
		System.out.println(tree.searchElement(tree.root, 5));
		System.out.println(tree.findSize(tree.root));
		tree.root=tree.insertNode(tree.root, 100);
		tree.inorderTraversal(tree.root);
		*/
		tree.printLevelOrder(tree.root);
	}
}
