package FactoryMethod.BinaryTreeEx;

//With Factory Method- Subclass will instantiate the object
public class BinaryTreeB {
	private BinaryTreeB leftNode;
	private BinaryTreeB rightNode;
	private Object data;

	public BinaryTreeB(Object data) {
		this.data = data;
	}

	public void insert(Object data) {
		if (this.data.hashCode() > data.hashCode()) {
			if (leftNode == null)
				leftNode = createBinary(data); // Factory Method
			else
				leftNode.insert(data);
		} else {
			if (rightNode == null)
				rightNode = createBinary(data); // Factory Method
			else
				rightNode.insert(data);
		}
	}

	BinaryTreeB createBinary(Object data) {
		return new BinaryTreeB(data);
	}

	public void getAllInOrder() {

		if (rightNode != null)
			rightNode.getAllInOrder();
		handleThisNode();
		if (leftNode != null)
			leftNode.getAllInOrder();
	}

	void handleThisNode() {

		System.out.println(data);

	}

	public Object getData() {
		return data;
	}

}
