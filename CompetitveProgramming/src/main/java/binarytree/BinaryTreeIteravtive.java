package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeIteravtive {
	BTNode root=null;
	public BinaryTreeIteravtive(int  data) {
		this.root=new BTNode(data);
	}
	
	public void printLevelOrderIterative(BTNode root) {
		Queue<BTNode> queue=new LinkedList<BTNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BTNode temp=queue.poll();
			System.out.println(temp.data);
			if(temp.left!=null){
				queue.add(temp.left);
			}
			if(temp.right!=null)
				queue.add(temp.right);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeIteravtive tree_level = new BinaryTreeIteravtive(1); 
        tree_level.root = new BTNode(2); 
        tree_level.root.left = new BTNode(3); 
        tree_level.root.right = new BTNode(4); 
        tree_level.root.left.left = new BTNode(5); 
        tree_level.root.left.right = new BTNode(6);
        tree_level.printLevelOrderIterative(tree_level.root);
  
	}
}
