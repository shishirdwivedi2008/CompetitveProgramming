package binarytree;

import java.util.LinkedList;
import java.util.Queue;

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
	
	/**
	 * Method to print specific level order is complete binary tree.
	 * @param root
	 */
	public void printSpecificLevelOrder(BTNode root) {
		if(root ==null)
			return ;
		//Since it is perfect binary tree hence we know that left and right child would be there hence not checking right
		if(root.left!=null) {
			System.out.println(root.left.data+ " "+root.right.data);
		}
		//Check if more children there 
		if(root.left.left==null)
			return;
		//If more childere is there enqueue 2 node is queue and process them.
		Queue<BTNode> que=new LinkedList<BTNode>();
		que.add(root.left);
		que.add(root.right);
		
		//Since whe have store two node we will need to variable.
		
		BTNode first = null,second=null;
		//now till queue is not empyt pull node and print them
		while(!que.isEmpty()) {
			first=que.peek();
			que.remove(first);
			second=que.peek();
			que.remove(second);
		}
		//Now print them
		
		System.out.println(first.left.data+ " "+second.right.data);
		System.out.println(first.right.data+ "  "+second.left.data);
		//Now check further child is available if yes add to queue.
		if(root.left.left!=null) {
			que.add(first.left);
			que.add(second.right);
			que.add(first.right);
			que.add(second.left);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeConstruct tree=new BinaryTreeConstruct(1);
		int [] level=new int[]{10, 15, 14, 25, 30}; 
		System.out.println(tree.checkLevelOrderisMinHeap(level));
	}
}
