package binarytree;

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
	
	
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree(1);
		tree.root.left=new BTNode(2);
		tree.root.right=new BTNode(3);
		tree.root.left.left=new  BTNode(4);
		tree.root.left.right=new BTNode(5);
		tree.root.right.left=new BTNode(6);
		tree.root.right.right=new BTNode(7);
		tree.inorderTraversal(tree.root);
	}
}
