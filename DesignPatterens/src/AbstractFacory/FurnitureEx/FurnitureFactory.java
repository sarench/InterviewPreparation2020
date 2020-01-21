package AbstractFacory.FurnitureEx;

//It can be a interface without createFurniture
public abstract class FurnitureFactory {

	abstract Chair createChair();

	abstract Sofa createSofa();
	
	void createFurniture(){
		Chair chair = createChair();
		Sofa  sofa = createSofa();
		chair.getProduct();
		sofa.getProduct();
	}

}
