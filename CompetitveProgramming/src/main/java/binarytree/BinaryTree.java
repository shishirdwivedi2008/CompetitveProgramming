package binarytree;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.text.AbstractDocument.LeafElement;

public class BinaryTree {

	public   BTNode root;
	public BinaryTree(int data) {
		root=new BTNode(data);
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
	 * @param root
	 * @return
	 */
	public int  findMaxElement(BTNode root) {
		int max_left = 0;
		int max_right = 0;
		int max,root_val = 0;
		if(root!=null) {
			root_val=root.data;
			max_left=findMaxElement(root.left);
			max_right=findMaxElement(root.right);
		}
		if(max_left>max_right)
			max=max_left;
		else
			max=max_right;
		if(root_val>max)
			return root_val;
		else
			return max;
		
		
		
	}
	
	/**
	 * Search an Element in Binary tree
	 * @param root
	 * @param element
	 * @return
	 */
	public boolean searchElement(BTNode root, int element) {
		
		if(root==null)
			return false;
		if(root.data==element)
			return true;
		else {
			boolean found=searchElement(root.left, element);
			if(found)
				return true;
			else {
			return searchElement(root.right, element);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree(1);
		tree.root.left=new BTNode(2);
		tree.root.right=new BTNode(3);
		tree.root.left.left=new  BTNode(4);
		tree.root.left.right=new BTNode(5);
		tree.root.right.left=new BTNode(6);
		tree.root.right.right=new BTNode(7);
		//tree.inorderTraversal(tree.root);
		System.out.println(tree.findMaxElement(tree.root));
		System.out.println(tree.searchElement(tree.root, 5));
	}
}
