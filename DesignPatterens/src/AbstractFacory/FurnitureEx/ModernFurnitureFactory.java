package AbstractFacory.FurnitureEx;

public class ModernFurnitureFactory extends FurnitureFactory {

	@Override
	public Chair createChair() {
		return new ModernChair();
	}

	@Override
	public Sofa createSofa() {
		return new ModernSofa();
	}

}
