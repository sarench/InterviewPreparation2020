package FactoryMethod.BinaryTreeEx;

public class BinaryTreeB1 extends BinaryTreeB {

	public BinaryTreeB1(Object data) {
		super(data);
	}

	@Override
	void handleThisNode() {
		System.out.println(getData() + "!!!");
	}

	/*@Override
	BinaryTreeB createBinary(Object data) {
		return new BinaryTreeB1(data);
	}*/

}
