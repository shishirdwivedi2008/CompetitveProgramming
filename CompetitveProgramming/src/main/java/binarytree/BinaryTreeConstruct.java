package binarytree;

public class BinaryTreeConstruct {
	BTNode root;
	public BinaryTreeConstruct(int data) {
		root=new BTNode(data);
	}
	
	/**
	 * Build tree using inorder and preorder array.
	 * @param inorder
	 * @param pre
	 * @param start
	 * @param end
	 * @return
	 */
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
	
	/**
	 * Method to check whether level order is min heap. A min heap is tree where parent value is smaller  than child value.
	 * N/2-1 is a non leaf Node and Left child comes at 2*i+1 and right child 2*i+2 in array.
	 * @param levelorder
	 * @return
	 */
	public boolean checkLevelOrderisMinHeap(int [] levelorder) {
		int len=levelorder.length-1;
		
		for( int i=(len/2-1); i>=0;i--) {
			//Check left child is greater than parent
			if(levelorder[i]<levelorder[2*i+1])
				return true;
			
			//Check right child is greater than parent
			if(2*i+2<=len) {
				if(levelorder[i]<levelorder[2*i+2])
					return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		BinaryTreeConstruct tree=new BinaryTreeConstruct(1);
		int [] level=new int[]{10, 15, 14, 25, 30}; 
		System.out.println(tree.checkLevelOrderisMinHeap(level));
	}
}
