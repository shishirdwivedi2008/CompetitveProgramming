package binarytree;

public class BinaryTreeConstruct {
	BTNode root;
	public BinaryTreeConstruct(int data) {
		root=new BTNode(data);
	}
	
	
	public BTNode buildTree(int [] inorder, int [] pre, int start, int end) {
		if(start>end)
			return null;
		//creating a root node.
		BTNode root=new BTNode(pre[start++]);
		
		//Check wether tree has only root node
		if(start==end)
			return root;
		int index=searchIndex(inorder, start, end, root.data);
		//Now build tree 
		root.left=buildTree(inorder, pre, start, index-1);
		root.right=buildTree(inorder, pre, index+1, end);
		
		return root;
		
	}
	
	public int searchIndex(int [] inorder, int start, int end, int data) {
		for(int i=start;i<end;i++) {
			if(inorder[i]==data)
				return i;
		}
		return 0;
	}
	
	public void inorderTraverse(BTNode root) {
		if(root==null)
			return;
		inorderTraverse(root.left);
		System.out.println(root.data);
		inorderTraverse(root.right);
	}
}
