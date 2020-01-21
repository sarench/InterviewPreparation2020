package FactoryMethod.BinaryTreeEx;

public class FactoryMethod_BinaryTree {

	public static void main(String[] args) {
		
		/*BinaryTreeA treeA = new BinaryTreeA(10);
		treeA.insert(11);
		treeA.insert(9);
		treeA.insert(12);
		treeA.insert(13);
		treeA.getAll();*/
		
		BinaryTreeB1 treeB1 = new BinaryTreeB1(10);
		treeB1.insert(11);
		treeB1.insert(9);
		treeB1.insert(12);
		treeB1.insert(8);
		treeB1.getAllInOrder();

	}

}
