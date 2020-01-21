package AbstractFacory.FurnitureEx;

public class FurnitureApp {

	public static void main(String[] args) {

		String funitureType = "classic";

		System.out.println("Furniture Delivered");

		if ("modern".equals(funitureType)) {
			new ModernFurnitureFactory().createFurniture();
		} else if ("classic".equals(funitureType)) {
			new ClassicalFurnitureFactory().createFurniture();
		}

	}

}
