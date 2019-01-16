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
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public BTNode insertNode(BTNode root, int data) {
		if (root == null) {
			root = new BTNode(data);
			return root;
		} else if (root.data > data)
			root.left = insertNode(root.left, data);
		else
			root.right = insertNode(root.right, data);

		return root;

	}

	/**
	 * Method to delete complete binary tree.
	 * 
	 * @param root
	 */
	public void deleteBinaryTree(BTNode root) {
		if (root == null)
			return;
		deleteBinaryTree(root.left);
		deleteBinaryTree(root.right);
		root = null;

	}

	/**
	 * Find height of a binary tree
	 * 
	 * @param root
	 * @return
	 */
	private int getHeight(BTNode root) {
		if (root == null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (left > right)
			return right + 1;
		else
			return left + 1;

	}

	/**
	 * Method to Print level order of a Tree.
	 * 
	 * @param root
	 */
	public void printLevelOrder(BTNode root) {
		int height = getHeight(root);
		for (int i = 1; i <= height; i++) {
			printLevel(root, i);
		}
	}

	/**
	 * Method to print level order.
	 * 
	 * @param root
	 * @param level
	 */
	private void printLevel(BTNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.println(root.data);
		printLevel(root.left, level - 1);
		printLevel(root.right, level - 1);

	}

	/**
	 * Print level order in reverse
	 * 
	 * @param root
	 */
	public void printLevelOrderReverse(BTNode root) {
		int height = getHeight(root);
		for (int i = height; i >= 1; i--) {
			printLevel(root, i);
		}
	}

	/**
	 * Printing Level order tree in zigzag or spiral form.
	 * 
	 * @param root
	 */
	public void printLevelOrderSpiralOrZigZag(BTNode root) {
		int height = getHeight(root);
		boolean flag = true;
		for (int i = 1; i <= height; i++) {
			printLevelSpiral(root, i, flag);
			flag = !flag;
		}
	}

	private void printLevelSpiral(BTNode root, int level, boolean flag) {
		if (root == null)
			return;
		if (level == 1)
			System.out.println(root.data);
		if (flag) {
			printLevelSpiral(root.left, level - 1, flag);
			printLevelSpiral(root.right, level - 1, flag);
		} else {
			printLevelSpiral(root.right, level - 1, flag);
			printLevelSpiral(root.left, level - 1, flag);
		}
	}

	/**
	 * Check parent is sum of children value or not. if not return false else true.
	 * if root is null or is left and right is null then it follow sum property
	 *
	 * @param root
	 * @return
	 */
	public boolean checkChildrenSumProperty(BTNode root) {
		int left = 0, right = 0;
		if (root == null )
			return true;
		if (root.left != null)
			left = root.left.data;
		if (root.right != null)
			right = root.right.data;
		if (root.data == left + right) 
			return true;
		else
			return false;
	}

	/**
	 * Method to check whether tree follows sum tree property. A sum tree is tree
	 * where sum of left subtree and sum of right subtree is equal to node/root
	 * value
	 * 
	 * @param root
	 * @return
	 */
	public boolean checkSumTree(BTNode root) {
		int left=0;
		int right=0;
		if((root==null)|| (root.left==null && root.right==null))
			return true;
		left=sum(root.left);
		right=sum(root.right);
		
		if((root.data==left+right)&& checkSumTree(root.left)&& checkSumTree(root.right))
			return true;
		else
			return false;
		
					
	}
	
	private int sum(BTNode root) {
		if(root==null)
			return 0;
		return (sum(root.left)+root.data+sum(root.right));
	}
	
	private int sumUncovered(BTNode root) {
		int leftSum=0;
		int rightSum=0;
		if(root.left!=null)
			leftSum+=sumUncoveredLeft(root.left);
		else
			rightSum+=sumUncoveredRight(root.right);
		
		return root.data+leftSum+rightSum;
			
	}
	
	
	private int sumUncoveredLeft(BTNode root) {
		if( (root.left==null && root.right==null))
			return root.data;
		if(root.left!=null)
			return root.data+sumUncoveredLeft(root.left);
		else
			return root.data+sumUncoveredLeft(root.right);
	}
	
	private int sumUncoveredRight(BTNode root) {
		if(root.left==null && root.right==null)
			return root.data;
		if(root.right!=null)
			return root.data+sumUncoveredRight(root.right);
		else
			return root.data+sumUncoveredRight(root.left);
	}
	
	/**
	 * Method to know wthere sum of covered nodes is equal to sum of uncovered nodes
	 * @param root
	 * @return
	 */
	public boolean sumCoveredEqualToUncovered(BTNode root) {
		int SumUncovered=sumUncovered(root);
		int totalSum=sum(root);
		
		return (SumUncovered==(totalSum-SumUncovered));
			
	}

	public static void main(String[] args) {
		/*
		 * BinaryTree tree = new BinaryTree(1); tree.root.left = new BTNode(2);
		 * tree.root.right = new BTNode(3); tree.root.left.left = new BTNode(4);
		 * tree.root.left.right = new BTNode(5); tree.root.right.left = new BTNode(6);
		 * tree.root.right.right = new BTNode(7); // tree.inorderTraversal(tree.root);
		 * System.out.println(tree.findMaxElement(tree.root));
		 * System.out.println(tree.searchElement(tree.root, 5));
		 * System.out.println(tree.findSize(tree.root));
		 * tree.root=tree.insertNode(tree.root, 100); tree.inorderTraversal(tree.root);
		 * 
		 * tree.printLevelOrder(tree.root); System.out.println("##################");
		 * tree.printLevelOrderReverse(tree.root);
		 * 
		 * tree.printLevelOrderSpiralOrZigZag(tree.root);
		 

		BinaryTree tree = new BinaryTree(10);
		tree.root.left = new BTNode(8);
		tree.root.right = new BTNode(2);
		tree.root.left.left = new BTNode(3);
		tree.root.left.right = new BTNode(5);
		tree.root.right.left = new BTNode(2);
		
		
		BinaryTree tree = new BinaryTree(26);
		tree.root.left = new BTNode(10);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(4);
		tree.root.left.right = new BTNode(6);
		tree.root.right.left = new BTNode(3);
		System.out.println(tree.checkSumTree(tree.root));
		*/
		BinaryTree tree = new BinaryTree(8); 
		  
        // Making above given diagram's binary tree 
        tree.root.left = new BTNode(3); 
        tree.root.left.left = new BTNode(1); 
        tree.root.left.right = new BTNode(38); 
        tree.root.left.right.left = new BTNode(4); 
        tree.root.left.right.right = new BTNode(7); 
  
        tree.root.right = new BTNode(10); 
        tree.root.right.right = new BTNode(14); 
        tree.root.right.right.left = new BTNode(13); 
        
        System.out.println(tree.sumCoveredEqualToUncovered(tree.root));

	}

}
