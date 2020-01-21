package FactoryMethod.BinaryTreeEx;

//Without Fatory method
public class BinaryTreeA {

	private BinaryTreeA leftNode;
	private BinaryTreeA rightNode;
	private Object data;

	public BinaryTreeA(Object data) {
		this.data = data;
	}

	public void insert(Object data) {
		if (this.data.hashCode() > data.hashCode()) {
			if (leftNode == null)
				leftNode = new BinaryTreeA(data);
			else
				leftNode.insert(data);
		} else {
			if (rightNode == null)
				rightNode = new BinaryTreeA(data);
			else
				rightNode.insert(data);
		}
	}

	public void getAll() {

		if (rightNode != null)
			rightNode.getAll();
		handleThisNode();
		if (leftNode != null)
			leftNode.getAll();
	}

	private void handleThisNode() {

		System.out.println(data);

	}

}
