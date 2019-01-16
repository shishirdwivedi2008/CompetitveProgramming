package binarytree;

public class BinaryTreeCheckingAndPrinting {
	
	public static int leafLevel=0;
	BTNode root;
	public BinaryTreeCheckingAndPrinting(int data) {
		root=new BTNode(data);
	}
	
	private boolean isSibling(BTNode root, BTNode a, BTNode b) {
		if (root == null)
			return false;

		return ((root.left == a && root.right == b) || (root.left == b && root.right == a) || isSibling(root.left, a, b)
				|| isSibling(root.right, a, b));
	}
	
	private  int level(BTNode root, BTNode a, int level) {
		if(root==null)
			return 0;
		if(root==a)
			return 1;
		
		int l=level(root.left,a,level+1);
		if(l!=0)
			return l;
		else
			return level(root.right,a,level+1);
	}

	public boolean isCousin(BTNode root, BTNode a, BTNode b) {
		return ((level(root, a, 1)==level(root, b, 1)) && !isSibling(root, a, b));
	}
	
	public boolean checkLeafLevelIsSame(BTNode root, int level, int leafLevel) {
		if(root==null)
			return true;
		//Go it leaf node 
		if(root.left==null && root.right==null) {
			if(BinaryTreeCheckingAndPrinting.leafLevel==0) {
				BinaryTreeCheckingAndPrinting.leafLevel=level;
				return true;
			}
			return (level==BinaryTreeCheckingAndPrinting.leafLevel);
				
		}
		return (checkLeafLevelIsSame(root.left, level+1, leafLevel) && checkLeafLevelIsSame(root.right, level+1, leafLevel));
	}
	
	
	private int countTotalNodes(BTNode root) {
		if(root==null)
			return 0;
		
		return (countTotalNodes(root.left)+countTotalNodes(root.right)+1);
	}
	
	public boolean checkTreeCanBeDividedInTwoHalfes(BTNode root , int count) {
		if(root==null)
			return false;
		
		if(countTotalNodes(root)==count-countTotalNodes(root))
			return true;

		return (checkTreeCanBeDividedInTwoHalfes(root.left, count)|| checkTreeCanBeDividedInTwoHalfes(root.right, count)) ;
	}
	
	
	
	
	public static void main(String[] args) {
		BinaryTreeCheckingAndPrinting tree = new BinaryTreeCheckingAndPrinting(12); 
        
       /* tree.root.left = new BTNode(2); 
        tree.root.right = new BTNode(3); 
        tree.root.left.left = new BTNode(4); 
        tree.root.left.right = new BTNode(5); 
        tree.root.left.right.right = new BTNode(15); 
        tree.root.right.left = new BTNode(6); 
        tree.root.right.right = new BTNode(7); 
        tree.root.right.left.right = new BTNode(8); 
        BTNode a=tree.root.left.left; 
        BTNode b=tree.root;
         System.out.println(tree.isCousin(tree.root, a, b));
        
        */
		
		 
        tree.root.left = new BTNode(5); 
        tree.root.left.left = new BTNode(3); 
        tree.root.left.right = new BTNode(9); 
        tree.root.left.left.left = new BTNode(1); 
        tree.root.left.right.left = new BTNode(1); 
        tree.root.left.left.left.left=new BTNode(23);
        //System.out.println(tree.checkLeafLevelIsSame(tree.root, 0, leafLevel));
        int count=tree.countTotalNodes(tree.root);
       System.out.println( tree.checkTreeCanBeDividedInTwoHalfes(tree.root, count));
        
        
       
	}

}
