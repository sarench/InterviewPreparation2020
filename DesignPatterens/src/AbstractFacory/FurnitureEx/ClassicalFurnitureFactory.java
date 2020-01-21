package AbstractFacory.FurnitureEx;

public class ClassicalFurnitureFactory extends FurnitureFactory{

	@Override
	public Chair createChair() {
		return new ClassicalChair();
	}

	@Override
	public Sofa createSofa() {
		return new ClassicalSofa();
	}

}
